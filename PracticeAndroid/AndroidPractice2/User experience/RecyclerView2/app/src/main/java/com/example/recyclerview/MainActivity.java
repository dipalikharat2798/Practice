package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
private List<Item> itemList = new ArrayList<>();
    private RecyclerView recyclerview;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview=(RecyclerView)findViewById(R.id.recycler_view);
        mAdapter = new MyAdapter(itemList);
        RecyclerView.LayoutManager mLayoutManger = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(mLayoutManger);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(mAdapter);
        prepareItem();
    }
    private void prepareItem() {
        Item item = new Item(R.drawable.m1,"Hero: Akshay Kumar","Heroin: Katrina Kaif");
        itemList.add(item);
        item = new Item(R.drawable.m2,"Hero: Manav Kaul","Heroin: Parineeti");
        itemList.add(item);
        item = new Item(R.drawable.m3,"Hero: Abhishekh Bachhan","Heroin: Ileana Dcruz ");
        itemList.add(item);
        item = new Item(R.drawable.m1,"Hero: Akshay Kumar","Heroin: Katrina Kaif");
        itemList.add(item);
        item = new Item(R.drawable.m2,"Hero: Manav Kaul","Heroin: Parineeti");
        itemList.add(item);
        item = new Item(R.drawable.m3,"Hero: Abhishekh Bachhan","Heroin: Ileana Dcruz ");
        itemList.add(item);
        mAdapter.notifyDataSetChanged();
        recyclerview.setAdapter(mAdapter);
    }

}