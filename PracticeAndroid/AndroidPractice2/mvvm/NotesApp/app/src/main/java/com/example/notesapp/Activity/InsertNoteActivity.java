package com.example.notesapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.notesapp.Model.Notes;
import com.example.notesapp.R;
import com.example.notesapp.ViewModel.NotesViewModel;
import com.example.notesapp.databinding.ActivityInsertNoteBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class InsertNoteActivity extends AppCompatActivity {
    ActivityInsertNoteBinding binding;
    String title,subtitle,notes;
    NotesViewModel notesViewModel;
    String priority="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityInsertNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        notesViewModel= new ViewModelProvider(this).get(NotesViewModel.class);

        binding.green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.green.setImageResource(R.drawable.ic_done);
                binding.yellow.setImageResource(0);
                binding.red.setImageResource(0);
                priority="1";
            }
        });
        binding.yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.green.setImageResource(0);
                binding.yellow.setImageResource(R.drawable.ic_done);
                binding.red.setImageResource(0);
                priority="2";
            }
        });
        binding.red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.green.setImageResource(0);
                binding.yellow.setImageResource(0);
                binding.red.setImageResource(R.drawable.ic_done);
                priority="3";
            }
        });

        binding.doneNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title=binding.title.getText().toString();
                subtitle=binding.subtitle.getText().toString();
                notes=binding.notes.getText().toString();
                creatNote(title,subtitle,notes);
            }
        });
    }

    private void creatNote(String title, String subtitle, String notes) {

       // Date date =new Date();
       // CharSequence s  = DateFormat.getDateInstance().format("MMMM d, yyyy ");
       // CharSequence sequence= DateFormat.getDateInstance("mm d,yyyy",date.getTime());
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        Notes notes1=new Notes();
        notes1.notesTitle=title;
        notes1.notesSubtitle=subtitle;
        notes1.notes=notes;
        notes1.notesPriority=priority;
        notes1.notesDate=formattedDate;
        notesViewModel.insertNote(notes1);
        Toast.makeText(InsertNoteActivity.this,"note created succesfully",Toast.LENGTH_SHORT).show();
       finish();
    }

}