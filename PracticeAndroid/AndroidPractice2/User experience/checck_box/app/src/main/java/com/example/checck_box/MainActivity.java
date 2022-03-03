package com.example.checck_box;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CheckBox c1,c2,c3,c4,c5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         c1= (CheckBox) findViewById(R.id.checkBox1);
        c2= (CheckBox) findViewById(R.id.checkBox2);
        c3= (CheckBox) findViewById(R.id.checkBox3);
        c4= (CheckBox) findViewById(R.id.checkBox4);
        c5= (CheckBox) findViewById(R.id.checkBox5);
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void onSubmit(View view) {
        String strMessage = "Toppings: ";

        if(c1.isChecked())
        {
            strMessage+="Chocolate Syrup ";
        }
        if(c2.isChecked())
        {
            strMessage+=" sprinkles";
        }
        if(c3.isChecked())
        {
            strMessage+=" crushed nuts";
        }
        if(c4.isChecked())
        {
            strMessage+=" cherries";
        }
        if(c5.isChecked())
        {
            strMessage+=" orio";
        }
        displayToast(strMessage);
    }

}