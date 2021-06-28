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

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.ListViewHolder> {

    private ArrayList<Articles> articlesArrayList;

    public HealthAdapter(ArrayList<Articles> articlesArrayList) {
        this.articlesArrayList = articlesArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public HealthAdapter.ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new  ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HealthAdapter.ListViewHolder holder, int position) {

        holder.tvHealthTitle.setText(articlesArrayList.get(position).getTitle());
        holder.tvHealthPub.setText(articlesArrayList.get(position).getSource().getName());
        holder.tvHealthDesc.setText(articlesArrayList.get(position).getDescription());
        Glide.with(holder.itemView.getContext())
                .load(articlesArrayList.get(position).getUrlToImage())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgItem);

    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView tvHealthTitle, tvHealthPub, tvHealthDesc;
        ImageView imgItem;

        public ListViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            tvHealthTitle = itemView.findViewById(R.id.tv_item_title);
            tvHealthPub = itemView.findViewById(R.id.tv_item_pub);
            tvHealthDesc = itemView.findViewById(R.id.tv_item_desc);
            imgItem = itemView.findViewById(R.id.img_item);

        }
    }
}
