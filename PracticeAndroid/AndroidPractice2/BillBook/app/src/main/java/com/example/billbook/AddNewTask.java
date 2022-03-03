package com.example.billbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddNewTask extends AppCompatActivity {
    public static final String TAG = "AddNewTask";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);
    }
}