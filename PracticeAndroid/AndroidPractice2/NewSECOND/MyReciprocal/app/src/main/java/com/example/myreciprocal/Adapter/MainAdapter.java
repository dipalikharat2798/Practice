package com.example.myreciprocal.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myreciprocal.ListFourthActivity;
import com.example.myreciprocal.ListOneActivity;
import com.example.myreciprocal.ListSecActivity;
import com.example.myreciprocal.ListThirdActivity;
import com.example.myreciprocal.MainActivity;
import com.example.myreciprocal.Modal.MainModal;
import com.example.myreciprocal.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyMainViewHolder> {
   ArrayList<MainModal> modals;
   MainActivity activity;

    public MainAdapter(ArrayList<MainModal> modals, MainActivity activity) {
        this.modals = modals;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyMainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item,parent,false);
        return new MainAdapter.MyMainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMainViewHolder holder, int position) {
        MainModal mainModal=modals.get(position);
        holder.title.setText(mainModal.getTitle());
        holder.desc.setText(mainModal.getDesc());
        Picasso.get().load(mainModal.getImage()).into(holder.image);
        String id = mainModal.getId();

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if (id.equals("one")){
                Intent intent=new Intent(activity, ListOneActivity.class);
                intent.putExtra("id",id);
                activity.startActivity(intent);
               }else if(id.equals("two")) {
                   Intent intent=new Intent(activity, ListSecActivity.class);
                   intent.putExtra("id",id);
                   activity.startActivity(intent);
               }else if(id.equals("three")) {
                   Intent intent=new Intent(activity, ListThirdActivity.class);
                   intent.putExtra("id",id);
                   activity.startActivity(intent);
               }else{
                   Intent intent=new Intent(activity, ListFourthActivity.class);
                   intent.putExtra("id",id);
                   activity.startActivity(intent);
               }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modals.size();
    }


    public static class MyMainViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title,desc;
        Button view;
        public MyMainViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.list_image);
            title=itemView.findViewById(R.id.list_title);
            desc=itemView.findViewById(R.id.list_desc);
            view=itemView.findViewById(R.id.list_btn);
        }
    }
}
