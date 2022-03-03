package com.geico.adexpress.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.geico.adexpress.R;
import com.geico.adexpress.adapter.FormsMainAdapter;
import com.geico.adexpress.adapter.UsersListAdapter;
import com.geico.adexpress.model.FormsMainListModel;
import com.geico.adexpress.utility.FirebaseUtility;
import com.geico.adexpress.utility.IFirebaseSnapshotHandler;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

public class FormsActivity extends AppCompatActivity {
    private static final String TAG = "FormsActivity";
    private LinearLayoutManager layoutManager;
    private ArrayList<FormsMainListModel> usersList;
    FormsMainAdapter formsMainAdapter;
    RecyclerView mainformlist_rv;
    private ImageButton firebase_titleback_btn;
    private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);
        mainformlist_rv = findViewById(R.id.mainform_list);

        usersList = new ArrayList();
        firebase_titleback_btn = (ImageButton) findViewById(R.id.firebase_titleback_btn);
        spinner = (ProgressBar) findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);

        firebase_titleback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        getUsersFromFirebase();
    }

    private void getUsersFromFirebase() {
        spinner.setVisibility(View.VISIBLE);
        FirebaseUtility.getFirebaseFormsMainData(new IFirebaseSnapshotHandler() {
            @Override
            public void onResultReceived(DataSnapshot snapshot) {
                for (DataSnapshot userSnapShot : snapshot.getChildren()) {
                    String userId = userSnapShot.getKey();
                    FormsMainListModel formsMainListModel = new FormsMainListModel(userId);
                    Log.d(TAG, "onResultReceived: " + userId);
                    usersList.add(formsMainListModel);
                }

                layoutManager = new LinearLayoutManager(getApplicationContext());
                mainformlist_rv.setLayoutManager(layoutManager);
                formsMainAdapter = new FormsMainAdapter(FormsActivity.this,FormsSecondActivity.class, usersList);
                mainformlist_rv.setAdapter(formsMainAdapter);
                spinner.setVisibility(View.GONE);
            }

            @Override
            public void onErrorReceived(DatabaseError databaseError) {

            }
        });
    }
}