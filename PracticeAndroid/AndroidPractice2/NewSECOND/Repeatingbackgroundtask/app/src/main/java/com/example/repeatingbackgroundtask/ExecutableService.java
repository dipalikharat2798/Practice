package com.example.repeatingbackgroundtask;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

public class ExecutableService extends BroadcastReceiver {
    public static final String TAG ="ExecutableService";
    @Override
    public void onReceive(Context context, Intent intent) {
        //this will execute at selected interval
        File file = new File("/storage/emulated/0/MyPersonalAppFolder/log/");
        String[] myFiles;
        myFiles = file.list();
        if (myFiles.length != 0) {
            File myFile = new File(file, myFiles[0]);
            myFile.delete();
        }
       // boolean isSuccess = file.delete();
        Toast.makeText(context, "Awesome", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onReceive: "+ "Awesome");
    }
}
