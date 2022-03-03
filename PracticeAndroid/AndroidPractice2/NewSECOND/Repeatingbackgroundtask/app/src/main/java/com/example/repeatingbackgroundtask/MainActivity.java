package com.example.repeatingbackgroundtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlarmHandler alarmHandler=new AlarmHandler(this);
        //cancel the previous schedule task
        alarmHandler.cancelAlarmManager();
        //set the new alarm after time
        alarmHandler.setAlarmManager();
        Toast.makeText(this, "Alarm Set!!", Toast.LENGTH_SHORT).show();
    }
}