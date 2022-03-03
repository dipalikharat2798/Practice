package com.example.equivalent.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.equivalent.R;

import java.util.ArrayList;

public class MessagesActivity extends AppCompatActivity {
TextView textView;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        ListView lViewSMS = (ListView) findViewById(R.id.listViewSMS);

        if(fetchInbox()!=null)
        {
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, fetchInbox());
            lViewSMS.setAdapter(adapter);
        }
    }

    public ArrayList fetchInbox()
    {
        ArrayList sms = new ArrayList();

        Uri uriSms = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(uriSms, new String[]{"_id", "address", "date", "body"},
                null,
                null,
                null);

        cursor.moveToFirst();
        while  (cursor.moveToNext())
        {
            String address = cursor.getString(1);
            String body = cursor.getString(3);
            sms.add("Address=&gt; "+address+"\n SMS =&gt; "+body);
        }
        return sms;

    }
}