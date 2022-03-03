package com.example.automationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.automationapp.databinding.ActivityAlarmBinding;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;
import java.util.Locale;

public class AlarmActivity extends AppCompatActivity {
    ActivityAlarmBinding binding;
    Calendar calendar;
    int hour, minute;
    MaterialTimePicker timePicker;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlarmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createNotificationChannel();
        binding.setTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker();
            }
        });
        binding.cancelAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlarm();
            }
        });

    }

    private void showTimePicker() {
        calendar = Calendar.getInstance();
        timePicker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select Alarm Time")
                .build();
        timePicker.show(getSupportFragmentManager(), "Automate");

        timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timePicker.getHour() > 12) {
                    binding.timeTv.setText(
                            String.format("%2s", (timePicker.getHour() - 12) + " : " + String.format("%2s", timePicker.getMinute()) + " PM")
                    );
                } else {
                    binding.timeTv.setText(timePicker.getHour() + " : " + timePicker.getMinute() + " AM");
                }

                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                calendar.set(Calendar.MINUTE, timePicker.getMinute());
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                setTime();
            }
        });
    }

    private void setTime() {
        long time;
        time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
        if (System.currentTimeMillis() > time) {
            // setting time as AM and PM
            if (calendar.AM_PM == 0)
                time = time + (1000 * 60 * 60 * 12);
            else
                time = time + (1000 * 60 * 60 * 24);
        }
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiverMain.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, time,
                AlarmManager.INTERVAL_DAY, pendingIntent);
        Toast.makeText(this, "Alarm set Successfully", Toast.LENGTH_SHORT).show();
    }

    private void cancelAlarm() {
        Intent intent = new Intent(this, AlarmReceiverMain.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        if (alarmManager == null) {
            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        }
        alarmManager.cancel(pendingIntent);

        binding.timeTv.setText("Your Select Time");
        binding.displayimg.setImageResource(R.drawable.sm1);
        Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show();

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Automate screen off";
            String description = "Channel for automate";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("AB", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

//    public void popTimePicker(View view) {
//        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
//                hour = selectedHour;
//                minute = selectedMinute;
//                binding.timeTv.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
//            }
//        };
//
//        // int style = AlertDialog.THEME_HOLO_DARK;
//
//        TimePickerDialog timePickerDialog = new TimePickerDialog(this, /*style,*/ onTimeSetListener, hour, minute, true);
//
//        timePickerDialog.setTitle("Select Time");
//        timePickerDialog.show();
//    }
}