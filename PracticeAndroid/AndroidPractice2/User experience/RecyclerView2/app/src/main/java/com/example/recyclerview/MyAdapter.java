package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Item> itemList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView hero,heroin;
        public ImageView icon;
        private RelativeLayout main;
        public MyViewHolder(final View parent) {
            super(parent);
            hero = (TextView) parent.findViewById(R.id.hero);
            heroin = (TextView) parent.findViewById(R.id.heroin);
            icon = (ImageView) parent.findViewById(R.id.image);
            main = (RelativeLayout) parent.findViewById(R.id.main);
            main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Position:" + Integer.toString(getPosition()), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public MyAdapter(List<Item>itemList){
        this.itemList=itemList;
    }
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item row=itemList.get(position);
        holder.hero.setText(row.getHero());
        holder.heroin.setText(row.getHeroin());
        holder.icon.setImageResource(row.getImageId());
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
