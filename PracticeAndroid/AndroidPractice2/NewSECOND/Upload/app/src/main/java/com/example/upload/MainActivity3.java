package com.example.upload;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity3.class.getSimpleName();

    private Button buttonStart, buttonStop;
    private TextView textViewthreadCount;

    WorkManager workManager;

    private boolean mStopLoop;
    private WorkRequest workRequest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Log.i(getString(R.string.service_demo_tag), "MainActivity thread id: " + Thread.currentThread().getId());

        buttonStart = (Button) findViewById(R.id.buttonThreadStarter);
        buttonStop = (Button) findViewById(R.id.buttonStopthread);

        textViewthreadCount = (TextView) findViewById(R.id.textViewthreadCount);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);

        workManager = WorkManager.getInstance(getApplicationContext());

        //workRequest = OneTimeWorkRequest.from(RandomNumberGeneratorWorker.class);

        workRequest = new PeriodicWorkRequest.Builder(RandomNumberGeneratorWorker.class, 15, TimeUnit.MINUTES).build();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonThreadStarter:
                mStopLoop = true;
                workManager.enqueue(workRequest);
                break;
            case R.id.buttonStopthread:
                workManager.cancelWorkById(workRequest.getId());
                break;
        }
    }
}