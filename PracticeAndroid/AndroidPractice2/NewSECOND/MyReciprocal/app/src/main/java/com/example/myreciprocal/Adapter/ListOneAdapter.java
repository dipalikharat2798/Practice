package com.example.myreciprocal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myreciprocal.Modal.ListOneModal;
import com.example.myreciprocal.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListOneAdapter extends RecyclerView.Adapter<ListOneAdapter.ListoneViewHolder> {
    Context context;
    ArrayList<ListOneModal> modal;

    public ListOneAdapter(Context context, ArrayList<ListOneModal> modal) {
        this.context = context;
        this.modal = modal;
    }

    @NonNull
    @Override
    public ListoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListOneAdapter.ListoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListoneViewHolder holder, int position) {
        ListOneModal listOneModal=modal.get(position);
        Picasso.get().load(listOneModal.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modal.size();
    }

    public static class ListoneViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ListoneViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.list_image);
        }
    }
}
