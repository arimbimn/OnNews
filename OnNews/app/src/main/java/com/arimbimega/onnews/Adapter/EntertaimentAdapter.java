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

public class EntertaimentAdapter extends RecyclerView.Adapter<EntertaimentAdapter.ListViewHolder>  {

    private ArrayList<Articles> articlesArrayList;

    public EntertaimentAdapter(ArrayList<Articles> articlesArrayList) {
        this.articlesArrayList = articlesArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public EntertaimentAdapter.ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull EntertaimentAdapter.ListViewHolder holder, int position) {

        holder.tvEntTitle.setText(articlesArrayList.get(position).getTitle());
        holder.tvEntPub.setText(articlesArrayList.get(position).getSource().getName());
        holder.tvEntDesc.setText(articlesArrayList.get(position).getDescription());
        Glide.with(holder.itemView.getContext())
                .load(articlesArrayList.get(position).getUrlToImage())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgItemEnt);

    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView tvEntTitle, tvEntPub, tvEntDesc;
        ImageView imgItemEnt;

        public ListViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            tvEntTitle = itemView.findViewById(R.id.tv_item_title);
            tvEntPub = itemView.findViewById(R.id.tv_item_pub);
            tvEntDesc = itemView.findViewById(R.id.tv_item_desc);
            imgItemEnt = itemView.findViewById(R.id.img_item);
        }
    }
}
