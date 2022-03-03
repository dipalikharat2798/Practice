package com.example.logcat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {
    private static final String TAG = "com.example.logcat";
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        button=findViewById(R.id.button);
        Log.d(TAG, "onCreate: " + "MainActivity4 log");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity4.this,MainActivity5.class));
            }
        });
    }
}