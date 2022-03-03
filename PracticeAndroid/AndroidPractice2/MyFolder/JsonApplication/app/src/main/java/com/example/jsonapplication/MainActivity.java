package com.example.jsonapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        button = findViewById(R.id.button);

        RequestQueue requestQueue = VolleySingletone.getInstance(this).getRequestQueue();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MovieActivity.class));
            }
        });

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = "https://www.json-generator.com/api/json/get/ceicfFazyq?indent=2";
//                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONArray jsonArray = response.getJSONArray("Student");
//
//                            for (int i = 0 ; i<jsonArray.length();i++){
//                                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                                String name = jsonObject.getString("name");
//                                String email = jsonObject.getString("email");
//                                int age = jsonObject.getInt("age");
//
//                                textView.append(name + " " +email+ " " +age+"\n");
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                requestQueue.add(jsonObjectRequest);
//            }
//        });
        //     Gson gson=new Gson();
//        Student student = new Student("Dipali","dipali@gmail.com",22);
//
//        //serialization
//        String json = gson.toJson(student);
//        Log.d(TAG, "Serialization"+json);

        //deserialization
//        String data = "{\"age\":22,\"email\":\"dipali@gmail.com\",\"name\":\"Dipali\"}";
//        Student student = gson.fromJson(data,Student.class);
//        Log.d(TAG, "Deserialize"+student);
    }
}