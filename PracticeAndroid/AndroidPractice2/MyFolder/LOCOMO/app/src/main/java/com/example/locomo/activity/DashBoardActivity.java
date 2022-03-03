package com.example.locomo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.locomo.R;
import com.example.locomo.fragment.FirstFragment;
import com.example.locomo.fragment.StartFragment;
import com.example.locomo.service.BoundService;

public class DashBoardActivity extends AppCompatActivity {
    TextView showtime_tv, todays_date_tv, timer_tv;
    private static String TAG = "DashBoardActivity";
    BoundService myService;
    boolean isBound = false;
    String timer;
    boolean timerStarted = false;
    private FirstFragment firstFragment;
    private StartFragment startFragment;

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            timer = intent.getStringExtra("Timer");
            Log.d(TAG, "onReceive: " + timer);
            showtime_tv.setText(timer);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        showtime_tv = findViewById(R.id.showtime_tv);
        todays_date_tv = findViewById(R.id.todays_date_tv);
        timer_tv = findViewById(R.id.timer_tv);
        firstFragment = new FirstFragment();
        startFragment = new StartFragment();

        Intent intent = getIntent();
        String date = intent.getStringExtra("TodaysDate");
        Log.d(TAG, "onCreate: " + date);
        todays_date_tv.setText(date + "");
//        if (!isLocationServiceRunning()) {
//            startFragment(startFragment);
//        } else {
//            startFragment(firstFragment);
//        }
        bindService();
    }

    private void startFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            BoundService.MyLocalBinder binder = (BoundService.MyLocalBinder) service;
            myService = binder.getService();
            isBound = true;
            Log.d(TAG, "onCreate: connection");
             showtime();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
            Log.d(TAG, "onCreate: notconnection");
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        startFragment(firstFragment);
    }

    public void showtime() {
        if (timerStarted == false) {
            timerStarted = true;
            myService.startTimer();
        }
    }

    public void stopTimer() {
        if (timerStarted == true) {
            timerStarted = false;
            myService.stopTimer();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(mReceiver, new IntentFilter(BoundService.SERVICE_MESSAGE));
        Log.d(TAG, "onCreate: strat");
    }

    @Override
    public void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(mReceiver);        //<-- Unregister to avoid memoryleak
        Log.d(TAG, "onCreate: stop");
    }

    public void resetTimer() {
        myService.resetTimer();
    }

    private void bindService() {
        Intent serviceIntent = new Intent(DashBoardActivity.this, BoundService.class);
        bindService(serviceIntent, myConnection, Context.BIND_AUTO_CREATE);
        Log.d(TAG, "onCreate:bind ");
    }

    public boolean isLocationServiceRunning() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager != null) {
            for (ActivityManager.RunningServiceInfo service :
                    activityManager.getRunningServices(Integer.MAX_VALUE)) {
                if (BoundService.class.getName().equals(service.service.getClassName())) {
                    Log.d(TAG, "isLocationServiceRunning: true");
                    return true;
                }
            }
            Log.d(TAG, "isLocationServiceRunning: false");
            return false;
        }
        Log.d(TAG, "isLocationServiceRunning: false");
        return false;
    }

}