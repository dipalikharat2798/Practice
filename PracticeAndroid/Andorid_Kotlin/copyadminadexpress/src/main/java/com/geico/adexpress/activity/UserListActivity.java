package com.geico.adexpress.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.geico.adexpress.R;
import com.geico.adexpress.adapter.UsersListAdapter;
import com.geico.adexpress.model.FirebaseUserDetailsPojo;
import com.geico.adexpress.model.model;
import com.geico.adexpress.utility.FirebaseContract;
import com.geico.adexpress.utility.FirebaseUtility;
import com.geico.adexpress.utility.IFirebaseSnapshotHandler;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView1;
    private static final String TAG = "UsersListActivity1";
    private RecyclerView users_list_rv;
    private LinearLayoutManager layoutManager;
    private ArrayList<FirebaseUserDetailsPojo> usersList;
    private ImageButton firebase_titleback_btn;
    UsersListAdapter usersListAdapter;
    ImageView bg;
    String name;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        users_list_rv = (RecyclerView) findViewById(R.id.users_list_rv);
        users_list_rv.setHasFixedSize(true);
        usersList = new ArrayList();
        bg = findViewById(R.id.bg);
        bg.setVisibility(View.VISIBLE);
        firebase_titleback_btn = (ImageButton) findViewById(R.id.firebase_titleback_btn);
        spinner = (ProgressBar) findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);

        firebase_titleback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        users_list_rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    Toast.makeText(UserListActivity.this, "Looks like you reach to the end", Toast.LENGTH_SHORT).show();

                }
            }
        });
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);

        String[] mArray = getResources().getStringArray(R.array.main_arr);
        String[] mArray1 = getResources().getStringArray(R.array.APP_Version);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.dropdown_item, mArray);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.dropdown_item, mArray1);

        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView1.setAdapter(arrayAdapter1);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                usersList.clear();
                autoCompleteTextView1.clearListSelection();
                autoCompleteTextView1.setText("Choose AppVersion", false);
                name = parent.getItemAtPosition(position) + "";
                Toast.makeText(getApplicationContext(), "Selected Item: " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                getUsersFromFirebase(name);
            }
        });

        autoCompleteTextView1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String searchKey = editable.toString().toUpperCase();
                ArrayList<FirebaseUserDetailsPojo> searchUsersList = new ArrayList<>();
                if (!usersList.isEmpty()) {
                    for (int i = 0; i < usersList.size(); i++) {
                        if (usersList.get(i).APP_VERSION.toUpperCase().contains(searchKey.toUpperCase()) || usersList.get(i).USER_NAME.toUpperCase().contains(searchKey.toUpperCase()))
                            searchUsersList.add(usersList.get(i));

                    }
                    Toast.makeText(UserListActivity.this, "" + searchUsersList.size(), Toast.LENGTH_SHORT).show();
                    usersListAdapter.updateListData(searchUsersList);
                } else {
                    Toast.makeText(UserListActivity.this, "Please Select BuildVarient", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getUsersFromFirebase(String name) {
        bg.setVisibility(View.GONE);
        spinner.setVisibility(View.VISIBLE);
        FirebaseUtility.getFirebaseUserProfileData(name, new IFirebaseSnapshotHandler() {
            @Override
            public void onResultReceived(DataSnapshot snapshot) {
                for (DataSnapshot userSnapShot : snapshot.getChildren()) {
                    String userId = userSnapShot.getKey();
                    String appVersion = "";
                    String deviceBrandModel = "";
                    String lastAction = "";
                    String lastLogin = "";
                    String osVersion = "";
                    String userName = "";
                    for (DataSnapshot userDetailsSnapShot : userSnapShot.getChildren()) {
                        if (userDetailsSnapShot.getKey().equals(FirebaseContract.UserProfile.APP_VERSION)) {
                            appVersion = userDetailsSnapShot.getValue().toString();
                        } else if (userDetailsSnapShot.getKey().equals(FirebaseContract.UserProfile.DEVICE_BRAND_MODEL)) {
                            deviceBrandModel = userDetailsSnapShot.getValue().toString();
                        } else if (userDetailsSnapShot.getKey().equals(FirebaseContract.LastActivities.LAST_ACTION)) {
                            lastAction = userDetailsSnapShot.getValue().toString();
                        } else if (userDetailsSnapShot.getKey().equals(FirebaseContract.LastActivities.LAST_LOGIN)) {
                            lastLogin = userDetailsSnapShot.getValue().toString();
                        } else if (userDetailsSnapShot.getKey().equals(FirebaseContract.UserProfile.OS_VERSION)) {
                            osVersion = userDetailsSnapShot.getValue().toString();
                        } else if (userDetailsSnapShot.getKey().equals(FirebaseContract.UserProfile.USER_NAME)) {
                            userName = userDetailsSnapShot.getValue().toString();
                        }

                        // post = userDetailsSnapShot.getValue(model.class);
                    }
                    FirebaseUserDetailsPojo firebaseUsersDetailsPojo = new FirebaseUserDetailsPojo(deviceBrandModel, osVersion, userName, userId, lastLogin, lastAction, appVersion);
                    usersList.add(firebaseUsersDetailsPojo);
                    //usersList.add(post);
                }

                layoutManager = new LinearLayoutManager(UserListActivity.this);
                users_list_rv.setLayoutManager(layoutManager);
                usersListAdapter = new UsersListAdapter(UserListActivity.this, usersList);
                users_list_rv.setAdapter(usersListAdapter);
                spinner.setVisibility(View.GONE);
            }

            @Override
            public void onErrorReceived(DatabaseError databaseError) {
                Toast.makeText(UserListActivity.this, "Unable to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }

}