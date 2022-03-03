package com.example.locomo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.locomo.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView startmyday_btn;
    TextView todays_date_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       startmyday_btn=findViewById(R.id.startmyday_btn);
       todays_date_tv=findViewById(R.id.todays_date_tv);
       String date_value=getCurrentDate();
       todays_date_tv.setText(date_value);

       startmyday_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(MainActivity.this, DashBoardActivity.class);
               intent.putExtra("TodaysDate",date_value+"");
               startActivity(intent);
               finish();
           }
       });
    }

    public String getCurrentDate() {
        Date currentTime = Calendar.getInstance().getTime();
        String formatDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);
        String[] splitDate = formatDate.split(",");
        return (splitDate[0].trim()+" , "+splitDate[1].trim());
    }
}