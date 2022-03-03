package com.example.reflect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.reflect.databinding.ActivityUpdateBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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

public class UpdateActivity extends AppCompatActivity {
ActivityUpdateBinding binding;
String title,subtitle,notes;
FirebaseAuth firebaseAuth;
FirebaseUser firebaseUser;
FirebaseFirestore firebaseFirestore;
FloatingActionButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
                    Toast.makeText(UpdateActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }else{
                    Date c = Calendar.getInstance().getTime();
                    System.out.println("Current time => " + c);
                    int year = c.getYear();
                    SimpleDateFormat df = new SimpleDateFormat("dd MMM,yyyy", Locale.getDefault());
                    String formattedDate = df.format(c);

                    DocumentReference documentReference=firebaseFirestore.collection("notes").document(firebaseUser.getUid()).collection("myNotes").document();
                    Map<String,Object> note = new HashMap<>();
                    note.put("title",title);
                    note.put("subtitle",subtitle);
                    note.put("notes",notes);
                    note.put("date",formattedDate);

                    documentReference.set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(UpdateActivity.this, "Note added Successfully", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(UpdateActivity.this,NotesActivity.class));
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(UpdateActivity.this, "Sorry Failed to add Note", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}