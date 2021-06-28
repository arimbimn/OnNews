package com.arimbimega.onnews.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arimbimega.onnews.Model.Articles;
import com.arimbimega.onnews.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ListViewHolder> {

    private ArrayList<Articles> articlesArrayList;

    public SportAdapter(ArrayList<Articles> articlesArrayList) {
        this.articlesArrayList = articlesArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public SportAdapter.ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SportAdapter.ListViewHolder holder, int position) {

        holder.tvSportTitle.setText(articlesArrayList.get(position).getTitle());
        holder.tvSportPub.setText(articlesArrayList.get(position).getSource().getName());
        holder.tvSportDesc.setText(articlesArrayList.get(position).getDescription());
        Glide.with(holder.itemView.getContext())
                .load(articlesArrayList.get(position).getUrlToImage())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgItemSport);


    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView tvSportTitle, tvSportPub, tvSportDesc;
        ImageView imgItemSport;

        public ListViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvSportTitle = itemView.findViewById(R.id.tv_item_title);
            tvSportPub = itemView.findViewById(R.id.tv_item_pub);
            tvSportDesc = itemView.findViewById(R.id.tv_item_desc);
            imgItemSport = itemView.findViewById(R.id.img_item);

        }
    }
}
