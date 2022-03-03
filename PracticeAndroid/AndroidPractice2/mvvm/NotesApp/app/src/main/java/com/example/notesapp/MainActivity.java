package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Insert;
import androidx.room.Update;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.notesapp.Activity.InsertNoteActivity;
import com.example.notesapp.Adapter.NotesAdapter;
import com.example.notesapp.ViewModel.NotesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton btn;
    NotesViewModel notesViewModel;
    RecyclerView recyclerView;
    NotesAdapter notesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.add_data);
        notesViewModel= new ViewModelProvider(this).get(NotesViewModel.class);
        recyclerView=findViewById(R.id.recycler);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertNoteActivity.class));
            }
        });

         notesViewModel.getAllNotes.observe(this,notes -> {
         recyclerView.setLayoutManager(new GridLayoutManager(this,2));
         notesAdapter =new NotesAdapter(MainActivity.this,notes);
         recyclerView.setAdapter(notesAdapter);
        });
    }
}