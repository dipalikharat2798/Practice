package com.example.myfirstapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.CustomViewHolder>{
  private List<PostPojo> dataList;
  private Context context;

    public ApiAdapter(List<PostPojo> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.design,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.title.setText(dataList.get(position).getTitle());
        holder.body.setText(dataList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView title,body;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title1);
            body=itemView.findViewById(R.id.body);
        }
    }
}
