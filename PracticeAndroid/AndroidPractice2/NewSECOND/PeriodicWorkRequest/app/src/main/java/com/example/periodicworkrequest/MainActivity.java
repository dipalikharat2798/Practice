package com.example.periodicworkrequest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar currentDate = Calendar.getInstance();
        Calendar dueDate = Calendar.getInstance();

        // Set Execution around 05:00:00 AM
        dueDate.set(Calendar.HOUR_OF_DAY, 8);
        dueDate.set(Calendar.MINUTE, 0);
        dueDate.set(Calendar.SECOND, 0);

        if (dueDate.before(currentDate)) {
            dueDate.add(Calendar.HOUR_OF_DAY, 24);
        }
        long timeDiff = dueDate.getTimeInMillis() - currentDate.getTimeInMillis();

        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();

        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(
                MyPeriodicWork.class, 16, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .addTag(TAG)
                .build();
           // WorkManager workManager =  WorkManager.getInstance(this);
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(TAG,
                ExistingPeriodicWorkPolicy.KEEP,
               periodicWorkRequest);

//                workManager.enqueue(periodicWorkRequest);

//        PeriodicWorkRequest sendLogsWorkRequest = new
//                PeriodicWorkRequest.Builder(MyPeriodicWork.class, 24, TimeUnit.HOURS)
//                .setConstraints(constraints)
//                .build();
//        WorkManager.getInstance(this).enqueueUniquePeriodicWork(TAG,
//                ExistingPeriodicWorkPolicy.KEEP,
//                sendLogsWorkRequest);

//        WorkManager workManager =  WorkManager.getInstance(this);
//            workManager.enqueue(sendLogsWorkRequest);

    }

}