package com.example.accessing_content_provider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Tools.setSystemBarLight(this);
        Tools.setSystemBarColor(this,R.color.white);
        getSupportActionBar().hide();
    }
}