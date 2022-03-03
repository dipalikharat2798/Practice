package com.example.jsonapplication;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingletone {
    private RequestQueue requestQueue;
    private static VolleySingletone mInstance;

    private VolleySingletone(Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleySingletone getInstance(Context context) {
        if (mInstance == null) {
            mInstance=new VolleySingletone(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        return requestQueue ;
    }
}
