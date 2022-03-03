package com.example.automationapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.automationapp.databinding.ActivityMain2Binding;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding binding;
    static final int RESULT_ENABLE = 1;
    DevicePolicyManager deviceManger;
    TimePicker timePicker;
    MaterialTimePicker picker;
    ComponentName compName;
    Calendar calendar;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    WifiManager wifi;
    private static final String TAG = "MainActivity2";
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int PERMISSION_ALL = 1;
        deviceManger = (DevicePolicyManager)
                getSystemService(Context.DEVICE_POLICY_SERVICE);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        calendar = Calendar.getInstance();
        if (sharedpreferences.contains("Time")) {
            String time = sharedpreferences.getString("Time", null);
            if (time != null) {
                binding.timeTv.setText(time);
                binding.displayimg.setImageResource(R.drawable.sleepmode);
            } else {
                binding.timeTv.setText("Your Selected Time");
            }
        } else {
            binding.timeTv.setText("Your Selected Time");
            editor.putString("Time", null);
            editor.commit();
        }

        compName = new ComponentName(this, DeviceAdmin.class);
        boolean active = deviceManger.isAdminActive(compName);
        if (active) {
            binding.imglinear.setVisibility(View.GONE);
            binding.btnEnable.setVisibility(View.GONE);
            binding.lineardis.setVisibility(View.VISIBLE);
        } else {
            binding.imglinear.setVisibility(View.VISIBLE);
            binding.btnEnable.setVisibility(View.VISIBLE);
            binding.lineardis.setVisibility(View.GONE);
        }
        createNotificationChannel();
        //   Log.d("TAG1", "onCreate: " + getMobileDataState());
        binding.setTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = sharedpreferences.getString("Time", null);
                if (time == null) {
                    setT();
                } else {
                    Toast.makeText(MainActivity2.this, "Please cancel previous task first", Toast.LENGTH_SHORT).show();

                }
                //moveTaskToBack(true);
                //openTimePickerDialog(false);
            }
        });

        binding.cancelAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlarm();
            }
        });
        binding.disableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (active) {
                    closeDialog();
                } else {
                    Toast.makeText(MainActivity2.this, "Device admin not active", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void setAlarm() {
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);
        Toast.makeText(this, "Alarm set Successfully", Toast.LENGTH_SHORT).show();
    }

    private void cancelAlarm() {
        String val = sharedpreferences.getString("Time", null);
        if (sharedpreferences.contains("Time") && (!val.equals(null))) {
            Intent intent = new Intent(this, AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
            if (alarmManager == null) {
                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            }
            alarmManager.cancel(pendingIntent);
            editor.putString("Time", null);
            editor.commit();
            binding.timeTv.setText("Your Select Time");
            binding.displayimg.setImageResource(R.drawable.sm1);
            Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show();
        }
    }
private void set1(){
    Calendar calendar = Calendar.getInstance();

}
    private void setT() {
        MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                .setTitleText("Select Time")
                .setHour(23)
                .setMinute(10)
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build();

        materialTimePicker.show(getSupportFragmentManager(), "Automate");

        materialTimePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hr = materialTimePicker.getHour();
                int min = materialTimePicker.getMinute();

                if (hr > 12) {
                    binding.timeTv.setText((materialTimePicker.getHour() - 12) + " : " + materialTimePicker.getMinute() + "PM");
                    editor.putString("Time", (materialTimePicker.getHour() - 12) + " : " + materialTimePicker.getMinute() + "PM" + "");
                } else if (hr == 12) {
                    binding.timeTv.setText((materialTimePicker.getHour()) + " : " + materialTimePicker.getMinute() + "PM");
                    editor.putString("Time", (materialTimePicker.getHour()) + " : " + materialTimePicker.getMinute() + "PM" + "");
                } else if (hr > 12) {
                    binding.timeTv.setText((materialTimePicker.getHour() + 12) + " : " + materialTimePicker.getMinute() + "AM");
                    editor.putString("Time", (materialTimePicker.getHour() + 12) + " : " + materialTimePicker.getMinute() + "AM" + "");
                } else {
                    binding.timeTv.setText((materialTimePicker.getHour()) + " : " + materialTimePicker.getMinute() + "AM");
                    editor.putString("Time", (materialTimePicker.getHour()) + " : " + materialTimePicker.getMinute() + "AM" + "");
                }
                editor.commit();


//                calendar.set(Calendar.HOUR_OF_DAY, materialTimePicker.getHour());
//                calendar.set(Calendar.MINUTE, materialTimePicker.getMinute());
//                calendar.set(Calendar.SECOND, 0);
//                calendar.set(Calendar.MILLISECOND, 0);


                calendar.set(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH),
                        materialTimePicker.getHour(),
                        materialTimePicker.getMinute(),
                        0
                );

                setAlarm();
                binding.displayimg.setImageResource(R.drawable.sleepmode);
            }
        });
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

    public void enablePhone(View view) {
        boolean active = deviceManger.isAdminActive(compName);
        if (active) {
            binding.enableTv.setText("Enable");
        } else {
            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, compName);
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "You should enable the app!");
            startActivityForResult(intent, RESULT_ENABLE);
        }
    }

    public void disable() {
        boolean active = deviceManger.isAdminActive(compName);
        if (active) {
            deviceManger.removeActiveAdmin(compName);
            binding.imglinear.setVisibility(View.VISIBLE);
            binding.btnEnable.setVisibility(View.VISIBLE);
            binding.lineardis.setVisibility(View.GONE);
        }
    }

    private void closeDialog() {
        new AlertDialog.Builder(MainActivity2.this)
                .setTitle("Disable Device Admin")
                .setMessage("Are you sure to diable device admin setting?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        disable();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_ENABLE:
                if (resultCode == Activity.RESULT_OK) {
                    binding.enableTv.setText("Disable");
                    binding.imglinear.setVisibility(View.GONE);
                    binding.btnEnable.setVisibility(View.GONE);
                    binding.lineardis.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(getApplicationContext(), "Failed!", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

//    public void setMobileDataState(boolean mobileDataEnabled) {
//        try {
//            TelephonyManager telephonyService = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//            Method setMobileDataEnabledMethod = Objects.requireNonNull(telephonyService).getClass().getDeclaredMethod("setDataEnabled", boolean.class);
//            setMobileDataEnabledMethod.invoke(telephonyService, mobileDataEnabled);
//        } catch (Exception ex) {
//            Log.e("MainActivity", "Error setting mobile data state", ex);
//        }
//    }

//    public boolean getMobileDataState() {
//        try {
//            TelephonyManager telephonyService = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//            Method getMobileDataEnabledMethod = Objects.requireNonNull(telephonyService).getClass().getDeclaredMethod("getDataEnabled");
//            return (boolean) (Boolean) getMobileDataEnabledMethod.invoke(telephonyService);
//        } catch (Exception ex) {
//            Log.e("MainActivity", "Error getting mobile data state", ex);
//        }
//        return false;
//    }
}