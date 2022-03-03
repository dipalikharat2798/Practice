package com.example.locomo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.util.Timer;
import java.util.TimerTask;

public class BoundService extends Service {
    public static final String SERVICE_MESSAGE = "Timer Update";
    Timer timer;
    TimerTask timerTask;
    Double time = 0.0;
    private final IBinder myBinder = new MyLocalBinder();

    public BoundService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        timer = new Timer();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public void startTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                time++;
                Log.d("Time increment", "run: " + time);
                sendMessageToUi(getTimerText());
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    public void stopTimer() {
        timerTask.cancel();
    }

    public void resetTimer() {
        if (timerTask != null) {
            timerTask.cancel();
            time = 0.0;
        }
    }

    private void sendMessageToUi(String timer) {
        Intent intent = new Intent(SERVICE_MESSAGE);
        intent.putExtra("Timer", timer);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
    }

    private String getTimerText() {
        int rounded = (int) Math.round(time);

        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);

        return formatTime(seconds, minutes, hours);
    }

    private String formatTime(int seconds, int minutes, int hours) {
        return String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds);
    }

    public class MyLocalBinder extends Binder {
        public BoundService getService() {
            return BoundService.this;
        }
    }

}
