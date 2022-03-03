package com.example.locomo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
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
    TextView todays_date_tv,showtime_tv;
    TimerTask timerTask;
    long time = 19230;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todays_date_tv=findViewById(R.id.todays_date_tv);
        showtime_tv=findViewById(R.id.showtime_tv);

        String date_value=getCurrentDate();
        todays_date_tv.setText(date_value);

       // startFragment(new StartFragment());
    }

    private void startFragment(Fragment fragment) {
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.main_frame, fragment);
//        fragmentTransaction.commit();
    }

    public String getCurrentDate() {
        Date currentTime = Calendar.getInstance().getTime();
        String formatDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);
        String[] splitDate = formatDate.split(",");
        return (splitDate[0].trim()+" , "+splitDate[1].trim());
    }

    public void startTimer() {
        Timer timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                time++;
                Log.d("Time increment", "run: " + time);
                showtime_tv.setText(getTimerText(time));
                Log.d("Time increment", "run: " + getTimerText(time));
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    public void stopTimer() {
        timerTask.cancel();
    }

    private String getTimerText(long time) {
        int rounded = (int) Math.round(time);

        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);

        return formatTime(seconds, minutes, hours);
    }

    private String formatTime(int seconds, int minutes, int hours) {
        return String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds);
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        if (getFragmentManager().getBackStackEntryCount() > 0) {
//            getFragmentManager().popBackStack();
//        } else {
//            super.onBackPressed();
//        }
//    }
}