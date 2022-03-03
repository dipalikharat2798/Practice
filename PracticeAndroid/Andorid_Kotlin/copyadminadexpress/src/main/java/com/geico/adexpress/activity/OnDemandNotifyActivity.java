package com.geico.adexpress.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.geico.adexpress.R;
import com.geico.adexpress.adapter.FormsMainAdapter;
import com.geico.adexpress.databinding.ActivityMainBinding;
import com.geico.adexpress.databinding.ActivityOnDemandNotifyBinding;
import com.geico.adexpress.model.FormsMainListModel;
import com.geico.adexpress.utility.FirebaseUtility;
import com.geico.adexpress.utility.IFirebaseSnapshotHandler;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

public class OnDemandNotifyActivity extends AppCompatActivity {
    ActivityOnDemandNotifyBinding binding;
    private static final String TAG = "OnDemandNotifyActivity";
    private LinearLayoutManager layoutManager;
    private ArrayList<FormsMainListModel> usersList;
    FormsMainAdapter formsMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnDemandNotifyBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        usersList = new ArrayList();
        binding.progressBar.setVisibility(View.GONE);

        binding.firebaseTitlebackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        getUsersFromFirebase();
    }

    private void getUsersFromFirebase() {
        binding.progressBar.setVisibility(View.VISIBLE);
        FirebaseUtility.getFirebaseNotifyData(new IFirebaseSnapshotHandler() {
            @Override
            public void onResultReceived(DataSnapshot snapshot) {
                for (DataSnapshot userSnapShot : snapshot.getChildren()) {
                    String userId = userSnapShot.getKey();
                    FormsMainListModel formsMainListModel = new FormsMainListModel(userId);
                    Log.d(TAG, "onResultReceived: " + userId);
                    usersList.add(formsMainListModel);
                }

                layoutManager = new LinearLayoutManager(getApplicationContext());
                binding.mainformList.setLayoutManager(layoutManager);
                formsMainAdapter = new FormsMainAdapter(OnDemandNotifyActivity.this, NotificationSecondActivity.class, usersList);
                binding.mainformList.setAdapter(formsMainAdapter);
                binding.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onErrorReceived(DatabaseError databaseError) {

            }
        });
    }
}