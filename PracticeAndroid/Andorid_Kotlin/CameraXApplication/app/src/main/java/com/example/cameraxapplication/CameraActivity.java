package com.example.cameraxapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.toastlibrary.CameraXActivity;
import com.example.toastlibrary.ShowToast;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        Intent intent=new Intent(CameraActivity.this, CameraXActivity.class);
        startActivity(intent);
    }
}