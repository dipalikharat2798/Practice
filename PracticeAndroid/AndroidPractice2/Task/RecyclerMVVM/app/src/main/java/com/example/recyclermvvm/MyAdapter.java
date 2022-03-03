package com.example.recyclermvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclermvvm.Model.NameModel;

import java.util.ArrayList;

public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.ViewHolder> {
ArrayList<NameModel> nameModels;

    public MyAdapter(ArrayList<NameModel> nameModels) {
        this.nameModels = nameModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(nameModels.get(position));
        holder.userName.setText(nameModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return nameModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView userName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName=itemView.findViewById(R.id.userName);
        }
    }
}
