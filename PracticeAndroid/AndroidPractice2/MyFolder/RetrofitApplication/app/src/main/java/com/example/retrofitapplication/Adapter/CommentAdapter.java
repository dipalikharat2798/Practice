package com.example.retrofitapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapplication.Model.Comment;
import com.example.retrofitapplication.R;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    Context context;
    List<Comment> commentList;

    public CommentAdapter(Context context, List<Comment> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comment,parent,false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment=commentList.get(position);
        holder.postId.setText(comment.getPostId());
        holder.id.setText(comment.getId());
        holder.email.setText(comment.getEmail());
        holder.name.setText(comment.getName());
        holder.commentText.setText(comment.getCommentText());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder{
        TextView postId, id, name, email,commentText;
        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            postId=itemView.findViewById(R.id.cpostId_tv);
            id=itemView.findViewById(R.id.cid_tv);
            name=itemView.findViewById(R.id.cname_tv);
            email=itemView.findViewById(R.id.cemail_tv);
            commentText=itemView.findViewById(R.id.cbody_tv);
        }
    }
}
