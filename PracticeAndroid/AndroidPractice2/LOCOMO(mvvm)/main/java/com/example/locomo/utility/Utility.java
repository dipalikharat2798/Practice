package com.example.locomo.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class Utility {

    public static void saveDataToPreferences(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(getTimeID(), MODE_PRIVATE).edit();
        editor.putString("Time", getLocaleTime());
        editor.apply();
        Log.d("TAG", "saveDataToPreferences: "+getLocaleTime());
    }

    public static String getTimeFromPref(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(getTimeID(), MODE_PRIVATE);
        String timeID = prefs.getString("Time", "NA");
        Log.d("TAG", "saveDataToPreferences: "+timeID);
        return timeID;
    }

    public static String getTimeID() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String mTimeId = sdf.format(cal.getTime());
        return mTimeId;
    }

    public static String getLocaleTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String str = sdf.format(new Date());
        return str;
    }
}
