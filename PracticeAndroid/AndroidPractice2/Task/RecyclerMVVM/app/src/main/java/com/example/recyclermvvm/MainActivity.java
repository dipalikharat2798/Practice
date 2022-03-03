package com.example.recyclermvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclermvvm.Model.NameModel;
import com.example.recyclermvvm.ViewModel.NameViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DataLoadListener{

    private RecyclerView recyclerView;
    private  MyAdapter myAdapter;
    private NameViewModel nameViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        nameViewModel= new ViewModelProvider(this).get(NameViewModel.class);
        nameViewModel.init(MainActivity.this);
        myAdapter=new MyAdapter(nameViewModel.getNames().getValue());
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void OnNameLoaded() {
        nameViewModel.getNames().observe(this, new Observer<ArrayList<NameModel>>() {
            @Override
            public void onChanged(ArrayList<NameModel> nameModels) {
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}