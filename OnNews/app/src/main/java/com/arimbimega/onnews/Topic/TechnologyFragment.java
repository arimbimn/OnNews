package com.arimbimega.onnews.Topic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arimbimega.onnews.Adapter.EntertaimentAdapter;
import com.arimbimega.onnews.Adapter.TechnologyAdapter;
import com.arimbimega.onnews.Model.Articles;
import com.arimbimega.onnews.Model.TechModel;
import com.arimbimega.onnews.R;
import com.arimbimega.onnews.Retrofit.APIService;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TechnologyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TechnologyFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private TechnologyAdapter technologyAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TechnologyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TechnologyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TechnologyFragment newInstance(String param1, String param2) {
        TechnologyFragment fragment = new TechnologyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        mRecyclerView = view.findViewById(R.id.rv_tech);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getTechModel();
    }

    private void getTechModel(){

        APIService.endPoint().getTechModel()
                .enqueue(new Callback<TechModel>() {
                    @Override
                    public void onResponse(Call<TechModel> call, Response<TechModel> response) {
                        if (response.isSuccessful()){
                            ArrayList<Articles> articlesArrayList = response.body().getArticlesArrayList();
                            technologyAdapter = new TechnologyAdapter(articlesArrayList);
                            technologyAdapter.notifyDataSetChanged();
                            mRecyclerView.setAdapter(technologyAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<TechModel> call, Throwable t) {

                    }
                });

    }
}