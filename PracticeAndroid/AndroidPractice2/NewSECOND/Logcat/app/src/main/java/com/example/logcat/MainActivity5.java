package com.example.logcat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity5 extends AppCompatActivity {
    private static final String TAG = "com.example.logcat";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Log.d(TAG, "onCreate: " + "MainActivity5 log");
    }
}