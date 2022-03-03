package com.androdevdk.locationtracker.locationtracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.androdevdk.locationtracker.locationtracker.Database.LocationDBHelper;
import com.androdevdk.locationtracker.locationtracker.Model.RouteIdListModel;
import com.androdevdk.locationtracker.locationtracker.R;
import com.androdevdk.locationtracker.locationtracker.adapter.LocationListAdapter;

import java.util.ArrayList;
import java.util.List;

public class RouteListActivity extends AppCompatActivity {
    private List<RouteIdListModel> routeIdModalArrayList;
    RecyclerView recyclerView;
    LocationDBHelper locationDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_list);
        locationDBHelper = LocationDBHelper.getInstance(RouteListActivity.this);
        prepareData();
        recyclerView = findViewById(R.id.recycler1);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        LocationListAdapter locationListAdapter = new LocationListAdapter(routeIdModalArrayList, RouteListActivity.this,locationDBHelper);
        recyclerView.setAdapter(locationListAdapter);

    }

    private void prepareData() {
        routeIdModalArrayList = new ArrayList<>();
        List<String[]> distinctRoutes = locationDBHelper.getDistinctRoutes();
        for (int i = 0; i < distinctRoutes.size(); i++) {
            routeIdModalArrayList.add(new RouteIdListModel(distinctRoutes.get(i)[0]));
        }
    }
}