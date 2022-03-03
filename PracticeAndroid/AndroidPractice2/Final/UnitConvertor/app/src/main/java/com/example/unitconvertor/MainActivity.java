package com.example.unitconvertor;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view)
    {
        Intent i;
        if(view.getId()==R.id.button1)
        {
            i=new Intent(this, StandardCal.class);
            startActivity(i);
        }
        else if(view.getId()==R.id.button)
        {
            i=new Intent(this,SciActivity.class);
            startActivity(i);
        }
        else if(view.getId()==R.id.button2)
        {
            i=new Intent(this,UnitCoverter.class);
            startActivity(i);
        }
        else if(view.getId()==R.id.button4)
        {
            i=new Intent(this,BMIActivity.class);
            startActivity(i);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}