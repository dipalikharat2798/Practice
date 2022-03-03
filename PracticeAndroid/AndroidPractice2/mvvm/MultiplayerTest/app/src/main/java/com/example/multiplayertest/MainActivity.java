package com.example.multiplayertest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    String playerName="";

    //db
    FirebaseDatabase firebaseDatabase;
    DatabaseReference playerRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);

        firebaseDatabase=FirebaseDatabase.getInstance();
        //check if player is exist and get Reference
        SharedPreferences preferences=getSharedPreferences("PREF",0);
        playerName=preferences.getString("playerName","");
        if(!playerName.equals("")){
            playerRef = firebaseDatabase.getReference("players/"+playerName);
            addEventListner();
            playerRef.setValue("");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logging the player in
                playerName=editText.getText().toString();
                editText.setText("");
                if(!playerName.equals("")){
                    button.setText("Loging In");
                    button.setEnabled(false);
                    playerRef=firebaseDatabase.getReference("players"+playerName);
                    addEventListner();
                    playerRef.setValue("");
                }
            }
        });
    }
    private void addEventListner(){
        playerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(!playerName.equals("")){
                    SharedPreferences preferences = getSharedPreferences("PREF",0);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("playerName",playerName);
                    editor.apply();

                    startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                    finish();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                button.setText("Log In");
                button.setEnabled(true);
                Toast.makeText(MainActivity.this,"Error!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}