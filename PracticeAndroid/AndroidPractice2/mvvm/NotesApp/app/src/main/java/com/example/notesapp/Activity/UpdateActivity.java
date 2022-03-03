package com.example.notesapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.notesapp.Model.Notes;
import com.example.notesapp.R;
import com.example.notesapp.ViewModel.NotesViewModel;
import com.example.notesapp.databinding.ActivityInsertNoteBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class UpdateActivity extends AppCompatActivity {
    ActivityInsertNoteBinding binding;
    String priority="1";
    Button btn;
    int iid;
    String title,subtitle,notes,spriority;
    NotesViewModel notesViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityInsertNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        notesViewModel= new ViewModelProvider(this).get(NotesViewModel.class);
        btn=findViewById(R.id.update_notes);
        iid=getIntent().getIntExtra("id",0);
        title=getIntent().getStringExtra("title");
        subtitle=getIntent().getStringExtra("subtitle");
        notes=getIntent().getStringExtra("notes");
        spriority=getIntent().getStringExtra("priority");

        binding.title.setText(title);
        binding.subtitle.setText(subtitle);
        binding.notes.setText(notes);

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
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title1 = binding.title.getText().toString();
                String subtitle1=binding.subtitle.getText().toString();
                String notes1=binding.notes.getText().toString();
                updateNote(title1,subtitle1,notes1);
            }
        });
    }

    private void updateNote(String title, String subtitle, String notes) {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        Notes notes1=new Notes();
        notes1.id=iid;
        notes1.notesTitle=title;
        notes1.notesSubtitle=subtitle;
        notes1.notes=notes;
        notes1.notesPriority=priority;
        notes1.notesDate=formattedDate;
        notesViewModel.insertNote(notes1);
        Toast.makeText(UpdateActivity.this,"note updated succesfully",Toast.LENGTH_SHORT).show();
        finish();
    }
}