package com.geico.adexpress.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.geico.adexpress.R;
import com.geico.adexpress.adapter.FormsMainAdapter;
import com.geico.adexpress.databinding.ActivityFormsSecondBinding;
import com.geico.adexpress.databinding.ActivityMainBinding;
import com.geico.adexpress.model.FirebaseUserDetailsPojo;
import com.geico.adexpress.model.FormsMainListModel;
import com.geico.adexpress.utility.FirebaseContract;
import com.geico.adexpress.utility.FirebaseUtility;
import com.geico.adexpress.utility.IFirebaseSnapshotHandler;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

public class FormsSecondActivity extends AppCompatActivity {
    private static final String TAG = "FormsSecondActivity";
    private String name;
    ArrayList<FormsMainListModel> usersList;
    ActivityFormsSecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormsSecondBinding.inflate(getLayoutInflater());
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
                getUsersFromFirebase1();
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
        FirebaseUtility.getFirebaseUserFormData(name, new IFirebaseSnapshotHandler() {
            @Override
            public void onResultReceived(DataSnapshot dataSnapshot) {
                Log.d(TAG, dataSnapshot.getKey() + "\n " + dataSnapshot.getValue() + " \n" + dataSnapshot.getChildren() + " \n"
                        + dataSnapshot.getChildrenCount());
                String Description = null;
                String Form_Name = null;
                for (DataSnapshot userSnapShot : dataSnapshot.getChildren()) {
                    if (userSnapShot.getKey().equals("Description")) {
                        Description = userSnapShot.getValue().toString();
                    } else if (userSnapShot.getKey().equals("Form Name")) {
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

    private void getUsersFromFirebase1() {
        FirebaseUtility.getFirebaseUserFormDataIterate(name, new IFirebaseSnapshotHandler() {
            @Override
            public void onResultReceived(DataSnapshot snapshot) {
                int posq1 = 0, negq1 = 0, posq2 = 0, negq2 = 0;
                for (DataSnapshot userSnapShot : snapshot.getChildren()) {
                    //  Log.d(TAG, "onResultReceived:1 "+userSnapShot.getValue().toString()+" key:"+userSnapShot.getKey());
                    for (DataSnapshot userDetailsSnapShot : userSnapShot.getChildren()) {
                        //  Log.d(TAG, "onResultReceived:2 " + userDetailsSnapShot.getValue().toString() + " key:" + userDetailsSnapShot.getKey());
                        //   Log.d(TAG, "UserID : " + userDetailsSnapShot.getKey() + " \n Feedback : " + userDetailsSnapShot.getValue().toString());
                        if (userDetailsSnapShot.getKey().equals("question1")) {
                            if (userDetailsSnapShot.getValue().toString().equals("1"))
                                posq1 = posq1 + 1;
                            else
                                negq1 = negq1 + 1;
                        }
                        if (userDetailsSnapShot.getKey().equals("question2")) {
                            if (userDetailsSnapShot.getValue().toString().equals("1"))
                                posq2 = posq2 + 1;
                            else
                                negq2 = negq2 + 1;
                        }

                    }
                    Log.d(TAG, "onResultReceived: " + posq1 + posq2 + negq1 + negq2);
                }
                binding.tv1.setText("Good(" + posq1 + ")");
                binding.tv2.setText("Bad(" + negq1 + ")");
                binding.tv11.setText("Good(" + posq2 + ")");
                binding.tv12.setText("Bad(" + negq2 + ")");
            }

            @Override
            public void onErrorReceived(DatabaseError databaseError) {

            }
        });
    }
}