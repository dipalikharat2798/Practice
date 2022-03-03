package com.example.fragmentsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button first,second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first=findViewById(R.id.first);
        second=findViewById(R.id.second);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               FirstFragment firstFragment=new FirstFragment();
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearfrag,firstFragment);
                transaction.commit();
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment=new SecondFragment();
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearfrag,secondFragment);
                transaction.commit();
            }
        });
    }
}