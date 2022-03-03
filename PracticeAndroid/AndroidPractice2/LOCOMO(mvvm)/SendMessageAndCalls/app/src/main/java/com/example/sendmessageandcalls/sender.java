package com.example.sendmessageandcalls;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class sender extends AppCompatActivity {

    private static final int SMS_REQUEST_CODE = 101;
    public static final String EXTRA_SMS_Number="EXTRA_SMS_NO";
    public static final String EXTRA_SMS_Message="EXTRA_SMS_Msg";
    TextView smsfrom_tv,smscontent_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        smsfrom_tv=findViewById(R.id.smsfrom_tv);
        smscontent_tv=findViewById(R.id.smscontent_tv);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},SMS_REQUEST_CODE);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (!intent.hasExtra(EXTRA_SMS_Number)&&!intent.hasExtra(EXTRA_SMS_Message)){
            return;
        }
        String smsSender = intent.getExtras().getString(EXTRA_SMS_Number);
        String setContent = intent.getExtras().getString(EXTRA_SMS_Message);
        smsfrom_tv.setText(smsSender);
        smscontent_tv.setText(setContent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==SMS_REQUEST_CODE){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}