package com.example.myliabraryproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.toastlibrary.Toaster;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toaster.showToast(this,"Hello Programmers");
    }
}