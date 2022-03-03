package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView textView;
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView= findViewById(R.id.text_message);
        Intent intent=getIntent();
        String msg=intent.getStringExtra(MainActivity.Extra_message);
        textView.setText(msg);
        editText = findViewById(R.id.editText_Second);
    }

    public void returnReply(View view) {
        Intent replyIntent=new Intent();
        String msg = editText.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY,msg);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}