package com.example.dynamicfeatures;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;

public class MainActivity extends AppCompatActivity {

    Button on_install,on_Demand;

    SplitInstallManager splitInstallManager;
    private  int mySessionId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splitInstallManager = SplitInstallManagerFactory.create(this);

        on_Demand=findViewById(R.id.on_demand);
        on_install=findViewById(R.id.on_install);

        Intent intent = new Intent();
        on_install.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClassName(BuildConfig.APPLICATION_ID,"com.example.dynamicfeatures.MainActivity");
                startActivity(intent);
                Log.d("download","already installed");
            }
        });
        on_Demand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDownloading();
            }
        });

    }

    private void startDownloading() {
        SplitInstallRequest request= SplitInstallRequest.newBuilder().addModule("dynamicfeature").build();
        SplitInstallStateUpdatedListener listener= splitInstallSessionState -> {
            if (splitInstallSessionState.sessionId()==mySessionId){
                switch (splitInstallSessionState.status()){
                    case SplitInstallSessionStatus.DOWNLOADING:
                        Log.d("download","downloading");
//                        progressDialog.setMessage("Downloading");
//                        progressDialog.show();
                        //downloading started
                        break;
                    case SplitInstallSessionStatus.INSTALLED:
                        //module installed successfully
                        Intent intent = new Intent();
                        intent.setClassName(BuildConfig.APPLICATION_ID,"com.example.dynamicfeatures.MainActivity");
                        startActivity(intent);
                        Log.d("download","installed");
                        break;
                    case SplitInstallSessionStatus.CANCELING:
//                        progressDialog.setMessage("CANCELLING");
//                        progressDialog.show();
                        Log.d("download","cancelling");
                        break;
                    case SplitInstallSessionStatus.INSTALLING:
//                        progressDialog.setMessage("Installing");
//                        progressDialog.show();
                        Log.d("download","installing");
                        break;
                    case SplitInstallSessionStatus.PENDING:
//                        progressDialog.setMessage("Pending");
//                        progressDialog.show();
                        Log.d("download","pending");
                        break;
                    case SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION:
                        break;
                    case SplitInstallSessionStatus.UNKNOWN:
                        break;
                }
            }
        };

        splitInstallManager.registerListener(listener);
        splitInstallManager.startInstall(request)
                .addOnFailureListener(e->
                        Log.d("GotException","Exception" + e))
                .addOnSuccessListener(sessionId-> mySessionId =sessionId);
    }
}