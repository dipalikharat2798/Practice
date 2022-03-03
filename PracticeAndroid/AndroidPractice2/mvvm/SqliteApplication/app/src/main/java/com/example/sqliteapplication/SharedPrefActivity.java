package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPrefActivity extends AppCompatActivity {
EditText name,email;
Button save,show;
SharedPreferences sp;
String sname,semail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        save=findViewById(R.id.save);
        show=findViewById(R.id.show);
        sp=getSharedPreferences("MyUserPref", Context.MODE_PRIVATE);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sname=name.getText().toString();
                semail=email.getText().toString();

                SharedPreferences.Editor editor=sp.edit();
                editor.putString("email",semail);
                editor.putString("name",sname);
                editor.commit();
                Toast.makeText(SharedPrefActivity.this, "Information Saved", Toast.LENGTH_SHORT).show();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SharedPrefActivity.this,OtherActivity.class));
            }
        });
    }
}