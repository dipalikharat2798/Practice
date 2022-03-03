package com.example.retrofitapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    Context context;
    List<ItemModel> itemModels;

    public ItemAdapter(Context context, List<ItemModel> itemModels) {
        this.context = context;
        this.itemModels = itemModels;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemModel itemModel = itemModels.get(position);
        holder.id.setText(itemModel.getId());
        holder.body.setText(itemModel.getBody());
        holder.title.setText(itemModel.getTitle());
        holder.userId.setText(itemModel.userId);
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView userId, id, title, body;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            userId=itemView.findViewById(R.id.user_id_tv);
            id=itemView.findViewById(R.id.id_tv);
            title=itemView.findViewById(R.id.title_tv);
            body=itemView.findViewById(R.id.body_tv);
        }
    }
}
