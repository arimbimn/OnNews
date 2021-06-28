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
import android.widget.TextView;

import com.arimbimega.onnews.Adapter.HealthAdapter;
import com.arimbimega.onnews.Model.Articles;
import com.arimbimega.onnews.Model.HealthModel;
import com.arimbimega.onnews.R;
import com.arimbimega.onnews.Retrofit.APIService;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HealthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HealthFragment extends Fragment {

    //TextView tvStatus, tvPenerbit, tvJudul, tvDesc, tvUrl, tvTgl, tvIsi;
    private RecyclerView mRecyclerView;
    private HealthAdapter healthAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HealthFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HealthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HealthFragment newInstance(String param1, String param2) {
        HealthFragment fragment = new HealthFragment();
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
        View view = inflater.inflate(R.layout.fragment_health, container, false);
        mRecyclerView = view.findViewById(R.id.rv_health);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        tvStatus = view.findViewById(R.id.healthStatus);
//        tvPenerbit = view.findViewById(R.id.nameHealth);
//        tvJudul = view.findViewById(R.id.healthTitle);
//        tvDesc = view.findViewById(R.id.healthDesc);
//        tvUrl = view.findViewById(R.id.healthUrl);
//        tvTgl = view.findViewById(R.id.healthPub);
//        tvIsi = view.findViewById(R.id.healthContent);

        getHealthModel();
    }

    private void getHealthModel(){

        APIService.endPoint().getHealthModel()
                .enqueue(new Callback<HealthModel>() {
                    @Override
                    public void onResponse(Call<HealthModel> call, Response<HealthModel> response) {
                        if (response.isSuccessful()){

//                            tvStatus.setText(response.body().getStatus());
//                            tvPenerbit.setText(response.body().getArticlesArrayList().get(0).getSource().getName());
//                            tvJudul.setText(response.body().getArticlesArrayList().get(0).getTitle());
//                            tvDesc.setText(response.body().getArticlesArrayList().get(0).getDescription());
//                            tvUrl.setText(response.body().getArticlesArrayList().get(0).getUrl());
//                            tvTgl.setText(response.body().getArticlesArrayList().get(0).getPublishedAt());
//                            tvIsi.setText(response.body().getArticlesArrayList().get(0).getContent());

                            ArrayList<Articles> articlesArrayList = response.body().getArticlesArrayList();

                            healthAdapter = new HealthAdapter(articlesArrayList);
                            healthAdapter.notifyDataSetChanged();
                            mRecyclerView.setAdapter(healthAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<HealthModel> call, Throwable t) {

                    }
                });

    }
}