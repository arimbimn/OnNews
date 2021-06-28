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


import com.arimbimega.onnews.Adapter.SportAdapter;
import com.arimbimega.onnews.Model.Articles;
import com.arimbimega.onnews.Model.SportModel;
import com.arimbimega.onnews.R;
import com.arimbimega.onnews.Retrofit.APIService;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SportFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private SportAdapter sportAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SportFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SportFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SportFragment newInstance(String param1, String param2) {
        SportFragment fragment = new SportFragment();
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
        View view = inflater.inflate(R.layout.fragment_sport, container, false);
        mRecyclerView = view.findViewById(R.id.rv_sport);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getSportModel();
    }

    private void getSportModel(){
        APIService.endPoint().getSportModel()
                .enqueue(new Callback<SportModel>() {
                    @Override
                    public void onResponse(Call<SportModel> call, Response<SportModel> response) {
                        if (response.isSuccessful()){
                            ArrayList<Articles> articlesArrayList = response.body().getArticlesArrayList();
                            sportAdapter = new SportAdapter(articlesArrayList);
                            sportAdapter.notifyDataSetChanged();
                            mRecyclerView.setAdapter(sportAdapter);
                        }

                    }

                    @Override
                    public void onFailure(Call<SportModel> call, Throwable t) {

                    }
                });
    }
}