package com.geico.adexpress.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.geico.adexpress.R;
import com.geico.adexpress.databinding.ActivityFormsSecondBinding;
import com.geico.adexpress.databinding.ActivityNotificationSecondBinding;
import com.geico.adexpress.model.FormsMainListModel;
import com.geico.adexpress.utility.FirebaseUtility;
import com.geico.adexpress.utility.IFirebaseSnapshotHandler;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

public class NotificationSecondActivity extends AppCompatActivity {
    private static final String TAG = "NotifySecActivity";
    private String name;
    ArrayList<FormsMainListModel> usersList;
    ActivityNotificationSecondBinding binding;
    DataSnapshot dataSnapshot1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotificationSecondBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        name = intent.getStringExtra("FormsMainNode");
        Log.d(TAG, "onCreate: " + name);
        binding.firebaseTitlebackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.cardClickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countResponses();
            }
        });
    }

    private void countResponses() {
        FirebaseUtility.getFirebaseUserNotifyData1(name, new IFirebaseSnapshotHandler() {
            @Override
            public void onResultReceived(DataSnapshot snapshot) {
                int posq1 = 0;
                for (DataSnapshot userSnapShot : snapshot.getChildren()) {
                      Log.d(TAG, "onResultReceived:1 "+userSnapShot.getValue().toString()+" key:"+userSnapShot.getKey());
                    for (DataSnapshot userDetailsSnapShot : userSnapShot.getChildren()) {
                        //  Log.d(TAG, "onResultReceived:2 " + userDetailsSnapShot.getValue().toString() + " key:" + userDetailsSnapShot.getKey());
                        //   Log.d(TAG, "UserID : " + userDetailsSnapShot.getKey() + " \n Feedback : " + userDetailsSnapShot.getValue().toString());
                        if (userDetailsSnapShot.getKey().equals("NotificationSeen")) {
                            if (userDetailsSnapShot.getValue().toString().equalsIgnoreCase("True"))
                                posq1 = posq1 + 1;
                        }

                    }
                }
                binding.countTv.setText("Total users seen the "+name+" are : "+posq1);
            }

            @Override
            public void onErrorReceived(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getUsersFromFirebase();
    }

    private void getUsersFromFirebase() {
        // showLoading(progressBarCancelListener);
        FirebaseUtility.getFirebaseUserNotifyData(name, new IFirebaseSnapshotHandler() {
            @Override
            public void onResultReceived(DataSnapshot dataSnapshot) {
                dataSnapshot1 = dataSnapshot;
                Log.d(TAG, dataSnapshot.getKey() + "\n " + dataSnapshot.getValue() + " \n" + dataSnapshot.getChildren() + " \n"
                        + dataSnapshot.getChildrenCount());
                String Description = null;
                String Form_Name = null;
                for (DataSnapshot userSnapShot : dataSnapshot.getChildren()) {
                    if (userSnapShot.getKey().equals("Notification Description")) {
                        Description = userSnapShot.getValue().toString();
                    } else if (userSnapShot.getKey().equals("Notification Name")) {
                        Form_Name = userSnapShot.getValue().toString();
                    }
                }
                binding.descriptionTv.setText(Description);
                binding.FormNameTv.setText(Form_Name);
            }

            @Override
            public void onErrorReceived(DatabaseError databaseError) {

            }
        });
    }

}