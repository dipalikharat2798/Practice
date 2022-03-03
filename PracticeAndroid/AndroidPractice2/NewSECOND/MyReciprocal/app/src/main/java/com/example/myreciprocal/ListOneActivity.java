package com.example.myreciprocal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.myreciprocal.Adapter.ListOneAdapter;
import com.example.myreciprocal.Adapter.MainAdapter;
import com.example.myreciprocal.Modal.ListOneModal;
import com.example.myreciprocal.Modal.MainModal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

public class ListOneActivity extends AppCompatActivity {

    FirebaseStorage firebaseStorage;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myref;
    ListOneAdapter adapter;
    ArrayList<ListOneModal> model= new ArrayList<>();
    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_one);

        recyclerView=findViewById(R.id.list_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        firebaseDatabase=FirebaseDatabase.getInstance();
        firebaseStorage=FirebaseStorage.getInstance();
        myref=firebaseDatabase.getReference();
//        String id=getIntent().getExtras().getString("id");
        progressDialog = new ProgressDialog(ListOneActivity.this);
        progressDialog.setMessage("Happiest Birthday Raskaaa..."); // Setting Message
        progressDialog.setTitle("Loading Wishes"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
        Query query=myref.child("first");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    ListOneModal modal=snapshot1.getValue(ListOneModal.class);
                    model.add(modal);
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        adapter=new ListOneAdapter(ListOneActivity.this,model);
        recyclerView.setAdapter(adapter);
    }
}