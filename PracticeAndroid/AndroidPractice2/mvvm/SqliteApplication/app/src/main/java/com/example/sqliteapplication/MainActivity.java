package com.example.sqliteapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sqliteapplication.databinding.ActivityMainBinding;
import com.karumi.dexter.Dexter;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db=new DBHelper(this);

        binding.insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=binding.name.getText().toString();
                String contact=binding.contact.getText().toString();
                String dob = binding.dob.getText().toString();
                Boolean chechInsert = db.insertuserdata(name,contact,dob);
                if(chechInsert){
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Data is failed to insert", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=binding.name.getText().toString();
                String contact=binding.contact.getText().toString();
                String dob = binding.dob.getText().toString();
                Boolean chechInsert = db.updateuserdata(name,contact,dob);
                if(chechInsert){
                    Toast.makeText(MainActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Data is failed to update", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=binding.name.getText().toString();
                Boolean chechInsert = db.deleteuserdata(name);
                if(chechInsert){
                    Toast.makeText(MainActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Data is failed to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getData();
                if (res.getCount()==0){
                    Toast.makeText(MainActivity.this, "No entery exist", Toast.LENGTH_SHORT).show();
                     return;
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Name : "+res.getString(0)+"\n");
                    buffer.append("Contact : "+res.getString(1)+"\n");
                    buffer.append("Date of Birth : "+res.getString(2)+"\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Enteries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}