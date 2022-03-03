package com.example.automationapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.automationapp.databinding.ActivityMainBinding;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    static final int RESULT_ENABLE = 1;
    DevicePolicyManager deviceManger;
    MaterialTimePicker picker;
    ComponentName compName;
    Button btnEnable, btnLock;
    Calendar calendar;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    WifiManager wifi;
    TimePickerDialog timePickerDialog;
    final static int RQS_1 = 1;
    private static final String TAG = "MainActivity";
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btnEnable = findViewById(R.id.btnEnable);
        btnLock = findViewById(R.id.btnLock);
        wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        deviceManger = (DevicePolicyManager)
                getSystemService(Context.DEVICE_POLICY_SERVICE);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        compName = new ComponentName(this, DeviceAdmin.class);
        boolean active = deviceManger.isAdminActive(compName);
        if (active) {
            btnEnable.setText("Disable");
            btnLock.setVisibility(View.VISIBLE);
        } else {
            btnEnable.setText("Enable");
            btnLock.setVisibility(View.GONE);
        }
        createNotificationChannel();
        binding.setTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setT();
                //moveTaskToBack(true);
                //  openTimePickerDialog(false);
            }
        });
        binding.setAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlarm();
            }
        });
        binding.cancelAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlarm();
            }
        });
    }

    private void openTimePickerDialog(boolean is24r) {
        Calendar calendar = Calendar.getInstance();
        timePickerDialog = new TimePickerDialog(
                MainActivity.this,
                onTimeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                is24r);
        timePickerDialog.setTitle("Set Alarm Time");
        timePickerDialog.show();
    }

    TimePickerDialog.OnTimeSetListener onTimeSetListener
            = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Calendar calNow = Calendar.getInstance();
            Calendar calSet = (Calendar) calNow.clone();
            calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calSet.set(Calendar.MINUTE, minute);
            calSet.set(Calendar.SECOND, 0);
            calSet.set(Calendar.MILLISECOND, 0);
            if (calSet.compareTo(calNow) <= 0) {
                calSet.add(Calendar.DATE, 1);
            }
            setAlarm(calSet);
        }
    };

    private void setAlarm(Calendar targetCal) {
        binding.timeTv.setText(
                "\n\n\n"
                        + "AlarmSet  " + targetCal.getTime() + "\n"
                        + "\n");
//        SharedPreferences.Editor editor = sharedpreferences.edit();
//        editor.putString("Time", targetCal.getTime() + "");
//        editor.commit();
        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
    }

    private void cancelAlarm() {
        Intent intent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        if (alarmManager == null) {
            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        }
        alarmManager.cancel(pendingIntent);
        Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show();
    }

    private void setAlarm() {
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);
        Toast.makeText(this, "Alarm set Successfully", Toast.LENGTH_SHORT).show();
    }

    private void setT() {
        MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                .setTitleText("Select Time")
                .setHour(12)
                .setMinute(10)
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .build();

        materialTimePicker.show(getSupportFragmentManager(), "Automate");

        materialTimePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hr = materialTimePicker.getHour();
                int min = materialTimePicker.getMinute();
                if (hr > 12) {
                    binding.timeTv.setText((materialTimePicker.getHour() - 12) + " : " + materialTimePicker.getMinute() + "PM");
                } else if (hr == 12) {
                    binding.timeTv.setText((materialTimePicker.getHour()) + " : " + materialTimePicker.getMinute() + "PM");
                } else if (hr > 12) {
                    binding.timeTv.setText((materialTimePicker.getHour() + 12) + " : " + materialTimePicker.getMinute() + "AM");
                } else {
                    binding.timeTv.setText((materialTimePicker.getHour()) + " : " + materialTimePicker.getMinute() + "AM");
                }
                calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, materialTimePicker.getHour());
                calendar.set(Calendar.MINUTE, materialTimePicker.getMinute());
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Automate screen off";
            String description = "Channel for automate";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("automate", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void enablePhone(View view) {
        boolean active = deviceManger.isAdminActive(compName);
        if (active) {
            deviceManger.removeActiveAdmin(compName);
            btnEnable.setText("Enable");
            btnLock.setVisibility(View.GONE);
        } else {
            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, compName);
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "You should enable the app!");
            startActivityForResult(intent, RESULT_ENABLE);
        }
    }

    public void lockPhone(View view) {
        deviceManger.lockNow();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_ENABLE:
                if (resultCode == Activity.RESULT_OK) {
                    btnEnable.setText("Disable");
                    btnLock.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(getApplicationContext(), "Failed!",
                            Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

}