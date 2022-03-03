package com.example.jsonapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder>{
    Context context;
    List<Item> postList;

    public ItemAdapter(Context context, List<Item> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mview= LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ItemHolder(mview);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item item=postList.get(position);
        holder.setImageUrl(item.getImageUrl());
        holder.setTags(item.getTags());
        holder.setLikes(item.getLikes()+"");
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        ImageView url_img;
        TextView tags_tv,likes_tv;
        View view;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            //url_img=itemView.findViewById(R.id.animal_img);
//            tags_tv=itemView.findViewById(R.id.tags_tv);
//            likes_tv=itemView.findViewById(R.id.likes_tv);
        }

        public void setImageUrl(String url){
            url_img=view.findViewById(R.id.animal_img);
            Glide.with(context).load(url).into(url_img);
        }
        public void setTags(String tags){
            tags_tv=itemView.findViewById(R.id.tags_tv);
            tags_tv.setText(tags+" tags");
        }
        public void setLikes(String likes){
            likes_tv=itemView.findViewById(R.id.likes_tv);
            likes_tv.setText(likes+" Likes");
        }
    }
}
