package com.example.reflect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.reflect.databinding.ActivityEditBinding;
import com.example.reflect.databinding.ActivityUpdateBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class EditActivity extends AppCompatActivity {
    ActivityEditBinding binding;
    String title,subtitle,notes,id;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseFirestore firebaseFirestore;
    FloatingActionButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        title=getIntent().getStringExtra("title");
        subtitle=getIntent().getStringExtra("subtitle");
        notes=getIntent().getStringExtra("notes");
        id=getIntent().getStringExtra("id");
        binding.title.setText(title);
        binding.subtitle.setText(subtitle);
        binding.notes.setText(notes);

        button=findViewById(R.id.donenotes);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                title=binding.title.getText().toString();
                subtitle=binding.subtitle.getText().toString();
                notes=binding.notes.getText().toString();

                if(title.isEmpty()||subtitle.isEmpty()||notes.isEmpty()){
                    Toast.makeText(EditActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }else{
                    Date c = Calendar.getInstance().getTime();
                    System.out.println("Current time => " + c);
                    SimpleDateFormat df = new SimpleDateFormat("dd MMM,yyyy", Locale.getDefault());
                    String formattedDate = df.format(c);

                    DocumentReference documentReference=firebaseFirestore.collection("notes").document(firebaseUser.getUid()).collection("myNotes").document(id);
                    Map<String,Object> note = new HashMap<>();
                    note.put("title",title);
                    note.put("subtitle",subtitle);
                    note.put("notes",notes);
                    note.put("date",formattedDate);

                    documentReference.set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(EditActivity.this, "Note Updated Successfully", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(EditActivity.this,NotesActivity.class));
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(EditActivity.this, "Sorry Failed to add Note", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
    private void deleteProduct(){
        DocumentReference documentReference=firebaseFirestore.collection("notes").document(firebaseUser.getUid()).collection("myNotes").document(id);
          documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
              @Override
              public void onComplete(@NonNull Task<Void> task) {
                  if(task.isSuccessful()){
                      Toast.makeText(EditActivity.this, "Note deleted successfully", Toast.LENGTH_SHORT).show();
                      finish();
                      startActivity(new Intent(EditActivity.this,NotesActivity.class));
                  }
              }
          });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Are you sure to delete the note?");
                builder.setMessage("Deletion is permanent...");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteProduct();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog ad = builder.create();
                ad.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}