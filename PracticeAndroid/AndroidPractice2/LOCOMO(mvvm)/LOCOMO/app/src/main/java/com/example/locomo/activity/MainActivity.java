package com.example.locomo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.example.locomo.R;
import com.example.locomo.fragment.StartFragment;
import com.example.locomo.utility.Utility;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView todays_date_tv, showtime_tv;
    String start_date = "";
    String end_date = "";
    TimerTask timerTask;
    int timestatus=0;
    public long time=0;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todays_date_tv = findViewById(R.id.todays_date_tv);
        showtime_tv = findViewById(R.id.showtime_tv);

        String date_value = getCurrentDate();
        todays_date_tv.setText(date_value);
        if (Utility.checkPref(this)) {
            start_date =Utility.getTimeFromPref(this);
            end_date =  Utility.getLocaleTime();
            Log.d("TAG", "onCreate: "+ Utility.findDifference(start_date, end_date));
            setTime(Utility.findDifference(start_date, end_date));
        }
    }

    public String getCurrentDate() {
        Date currentTime = Calendar.getInstance().getTime();
        String formatDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);
        String[] splitDate = formatDate.split(",");
        return (splitDate[0].trim() + " , " + splitDate[1].trim());
    }

    public void startTimer() {
        showtime_tv.setTextColor(getResources().getColor(R.color.black));
        Timer timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                setTime(getTime() + 1);
                Log.d("Time increment", "run: " + getTime() + " timeText " + getTimerText(getTime()));
                showtime_tv.setText(getTimerText(getTime()));
                timestatus=1;
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    public void stopTimer() {
        if(timestatus==1){
           showtime_tv.setTextColor(getResources().getColor(R.color.red));
            timestatus=0;
        timerTask.cancel();
        }
    }

    public String getTimerText(long time) {
        int rounded = (int) Math.round(time);

        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);

        return formatTime(seconds, minutes, hours);
    }

    private String formatTime(int seconds, int minutes, int hours) {
        return String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        stopTimer();
        Log.d("TAG", "onDestroy: ");
        super.onDestroy();
    }
}