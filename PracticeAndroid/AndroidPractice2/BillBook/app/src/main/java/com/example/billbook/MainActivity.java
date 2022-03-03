package com.example.billbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.billbook.Adapter.BillAdapter;
import com.example.billbook.DatabaseHelper.DatabaseHelper;
import com.example.billbook.Model.BillModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerview;
    private FloatingActionButton fab;
    private DatabaseHelper myDB;

    private List<BillModel> mlist;
    private BillAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerview=findViewById(R.id.recycler);
        fab=findViewById(R.id.fab);
        myDB=new DatabaseHelper(this);
        mlist=new ArrayList<>();

        mlist=myDB.getAllTAsks();
        adapter=new BillAdapter(mlist,MainActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        mRecyclerview.setAdapter(adapter);
//        adapter=new BillAdapter(MainActivity.this,myDB);
//
//        mRecyclerview.setHasFixedSize(true);
//        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerview.setAdapter(adapter);
//
//        mlist=myDB.getAllTAsks();
//        Collections.reverse(mlist);
//        adapter.setTask(mlist);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(MainActivity.this,AddBillActivity.class));
            }
        });

    }

}