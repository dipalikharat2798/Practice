package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    TextView textView;
    List<Item> items;
    Item item = new Item();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textView = findViewById(R.id.text1);
        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();
        ItemDAO itemDAO = database.getItemDAO();
        Item item = new Item();
        item.setName("Dipali");
        item.setDescription("Item 001");
        item.setQuantity(1000);

        itemDAO.insert(item);
        List<Item> items = itemDAO.getItems();
//
//        System.out.println(items);
//        itemDAO.deleteAll();
//        System.out.println(items);
        LinearLayout LinearLayoutView = new LinearLayout(this);
        TextView DisplayStringArray = new TextView(this);
        DisplayStringArray.setTextSize(25);
        LinearLayoutView.addView(DisplayStringArray);
        for (int i=0; i<items.size();i++){
            DisplayStringArray.append(item.getName());
            DisplayStringArray.append(item.getDescription());
            DisplayStringArray.append("\n");
        }
        Log.d(TAG, "onCreate: "+item.getName());
        setContentView(LinearLayoutView);
        itemDAO.deleteAll();

        Log.d(TAG, "onCreate: "+item.getName());
//        ListView listView = (ListView) findViewById(R.id.list1);
//        listView.setAdapter(adapter);
    }

}