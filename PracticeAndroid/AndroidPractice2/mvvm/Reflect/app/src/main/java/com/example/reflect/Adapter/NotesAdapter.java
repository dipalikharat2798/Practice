package com.example.reflect.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reflect.EditActivity;
import com.example.reflect.Model.NotesModel;
import com.example.reflect.R;
import com.example.reflect.WelcomeActivity;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.myviewholder> {

    ArrayList<NotesModel> datalist;
    View view;
    private Context context;
    public NotesAdapter(ArrayList<NotesModel> datalist,Context context) {
        this.datalist = datalist;
        this.context=context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_item,parent,false);
        return new myviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        holder.title.setText(datalist.get(position).getTitle());
        holder.subtitle.setText(datalist.get(position).getSubtitle());
        holder.dates.setText(datalist.get(position).getDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, EditActivity.class);
                intent.putExtra("title",datalist.get(position).getTitle());
                intent.putExtra("subtitle",datalist.get(position).getSubtitle());
                intent.putExtra("notes",datalist.get(position).getNotes());
                intent.putExtra("id",datalist.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }


    class myviewholder extends RecyclerView.ViewHolder{
        TextView title,subtitle,notes,dates;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

           dates=itemView.findViewById(R.id.notesDate);
            title=itemView.findViewById(R.id.notesTitle);
            subtitle=itemView.findViewById(R.id.notesSubtitle);
        }
    }
}
