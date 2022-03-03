package com.example.versionnotification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.versionnotification.model.data;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView current_version, currentReleaseDate, previous_version, version_summary;
    Button fetch;
    FirebaseDatabase database;
    FirebaseFirestore db;
    DatabaseReference myRef;
    ArrayList<data> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("VersionHistory");
        current_version = findViewById(R.id.current_version);
        currentReleaseDate = findViewById(R.id.currentReleaseDate);
        previous_version = findViewById(R.id.previous_version);
        version_summary = findViewById(R.id.version_summary);
        fetch = findViewById(R.id.fetch);
        arrayList = new ArrayList<>();
        // getVersionData("Prod");
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVersionData("Prod");
            }
        });
        FirebaseFirestore db = FirebaseFirestore.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void getVersionData(String type) {

        myRef.child(type).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
//                    String CurrentReleaseDate = snapshot.child("CurrentReleaseDate").getValue(String.class);
//                    String VersionSummary = snapshot.child("VersionSummary").getValue(String.class);
//                    int CurrentVersion = snapshot.child("CurrentVersion").getValue(Integer.class);
//                    int PreviousVersion = snapshot.child("PreviousVersion").getValue(Integer.class);
//                    Log.d("TAG", "onDataChange: "+CurrentReleaseDate+" "+VersionSummary+" "+CurrentVersion+" "+PreviousVersion);
//                    currentReleaseDate.setText(CurrentReleaseDate);
//                    version_summary.setText(VersionSummary);
//                    current_version.setText(CurrentVersion+"");
//                    previous_version.setText(PreviousVersion+"");
                    data data1 = snapshot.getValue(data.class);
                    Log.d("TAG", "onDataChange: " + data1.getCurrentReleaseDate() + data1.getVersionSummary() + data1.getCurrentVersion()
                            + data1.getPreviousVersion());
                    currentReleaseDate.setText(data1.getCurrentReleaseDate());
                    version_summary.setText(data1.getVersionSummary());
                    current_version.setText(data1.getCurrentVersion() + "");
                    previous_version.setText(data1.getPreviousVersion() + "");

                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Error" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}