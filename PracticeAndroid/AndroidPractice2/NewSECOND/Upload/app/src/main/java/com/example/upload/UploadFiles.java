package com.example.upload;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.List;
import java.util.Random;

public class UploadFiles extends Worker {
    Context context;
    WorkerParameters workerParameters;
    List<String> files;

    private int mRandomNumber;
    private boolean mIsRandomGeneratorOn;

    private final int MIN = 0;
    private final int MAX = 100;


    public UploadFiles(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
        this.workerParameters = workerParams;
        mIsRandomGeneratorOn = true;
    }

    @NonNull
    @Override
    public Result doWork() {
       uploadToserver();
        return Result.success();
    }

    private void uploadToserver() {

    }

    @Override
    public void onStopped() {
        super.onStopped();
        Log.i(context.getString(R.string.service_demo_tag), "Worker has been cancelled");
    }

    private void startRandomNumberGenerator() {
        int i = 0;
        while (i < 5 && !isStopped()) {
            try {
                Thread.sleep(1000);
//                if (mIsRandomGeneratorOn) {
//                    mRandomNumber = new Random().nextInt(MAX) + MIN;
//                    Log.i(context.getString(R.string.service_demo_tag), "Thread id: " + Thread.currentThread().getId() + ", Random Number: " + mRandomNumber);
//                    i++;
//                }
            } catch (InterruptedException e) {
                Log.i(context.getString(R.string.service_demo_tag), "Thread Interrupted");
            }
        }
    }
}
