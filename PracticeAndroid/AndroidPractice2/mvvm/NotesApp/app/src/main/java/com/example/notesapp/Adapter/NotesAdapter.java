package com.example.notesapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.Activity.UpdateActivity;
import com.example.notesapp.MainActivity;
import com.example.notesapp.Model.Notes;
import com.example.notesapp.R;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewholder> {
   Context context;
    Intent intent;
    List<Notes> notes;
//    private View itemView;

    public NotesAdapter(Context context, List<Notes> notes) {
        this.context=context;
        this.notes=notes;
    }

    @Override
    public NotesViewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new NotesViewholder(LayoutInflater.from(context).inflate(R.layout.notes_item,parent,false));
    }

    @Override
    public void onBindViewHolder( NotesViewholder holder, int position) {
        Notes note = notes.get(position);

        if(note.notesPriority.equals("1")){
            holder.notesPriority.setBackgroundResource(R.drawable.green);
        }else if(note.notesPriority.equals("2")){
            holder.notesPriority.setBackgroundResource(R.drawable.yellow);
        }else if(note.notesPriority.equals("3")) {
            holder.notesPriority.setBackgroundResource(R.drawable.red);
        }
        holder.title.setText(note.notesTitle);
        holder.subtitle.setText(note.notesSubtitle);
        holder.notesDate.setText(note.notesDate);
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context,"note clicked succesfully",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(context, UpdateActivity.class);
            intent.putExtra("id",note.id);
            intent.putExtra("title",note.notesTitle);
            intent.putExtra("subtitle",note.notesSubtitle);
            intent.putExtra("priority",note.notesPriority);
            intent.putExtra("notes",note.notes);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

   static class NotesViewholder extends RecyclerView.ViewHolder{
        View notesPriority;
        TextView title,subtitle,notesDate;
        public NotesViewholder(View itemView) {
            super(itemView);
           // itemView=itemView;
            title=itemView.findViewById(R.id.notesTitle);
            subtitle=itemView.findViewById(R.id.notesSubtitle);
            notesDate=itemView.findViewById(R.id.notesDate);
            notesPriority=itemView.findViewById(R.id.notesPriority);
        }
    }
}
