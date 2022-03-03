package com.example.locomo.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.locomo.activity.MainActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class Utility {
    public static void saveDataToPreferences(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(getTimeID(), MODE_PRIVATE).edit();
        editor.putString("Time", getLocaleTime());
        Log.d("TAG", "saveDataToPreferences: "+getLocaleTime());
        editor.apply();
    }

    public static String getTimeFromPref(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(getTimeID(), MODE_PRIVATE);
        String timeID = prefs.getString("Time", null);
        Log.d("TAG", "getTimeFromPref: "+timeID);
        return timeID;
    }

    public static void saveDayStatus(Context context, String val) {
        SharedPreferences.Editor editor = context.getSharedPreferences(getTimeID(), MODE_PRIVATE).edit();
        editor.putString("Day", val);
        Log.d("TAG", "saveDataToPreferences: " + val);
        editor.apply();
    }

    public static void saveBreakStatus(Context context, String val) {
        SharedPreferences.Editor editor = context.getSharedPreferences(getTimeID(), MODE_PRIVATE).edit();
        editor.putString("Break", val);
        Log.d("TAG", "saveDataToPreferences: " + val);
        editor.apply();
    }

    public static String getDayStatusFromPref(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(getTimeID(), MODE_PRIVATE);
        String timeID = prefs.getString("Day", null);
        Log.d("TAG", "getTimeFromPref: " + timeID);
        return timeID;
    }

    public static String getBreakStatusFromPref(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(getTimeID(), MODE_PRIVATE);
        String timeID = prefs.getString("Break", null);
        Log.d("TAG", "getTimeFromPref: " + timeID);
        return timeID;
    }

    public static void saveStartMealBreak(Context context,String date) {
        SharedPreferences.Editor editor = context.getSharedPreferences(getTimeID(), MODE_PRIVATE).edit();
        editor.putString("MealBreakStart", date);
        Log.d("TAG", "saveDataToPreferences: "+date);
        editor.apply();
    }
    public static void saveMealBreakDuration(Context context,long time) {
        SharedPreferences.Editor editor = context.getSharedPreferences(getTimeID(), MODE_PRIVATE).edit();
        editor.putLong("BreakDuration", time);
        Log.d("TAG", "saveDataToPreferences: "+time);
        editor.apply();
    }

    public static String getStartMealBreakDateFromPref(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(getTimeID(), MODE_PRIVATE);
       String timeID = prefs.getString("MealBreakStart", null);
        Log.d("TAG", "getTimeFromPref: "+timeID);
        return timeID;
    }
    public static String getmealBreakTimeFromPref(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(getTimeID(), MODE_PRIVATE);
        String timeID = prefs.getString("BreakDuration", null);
        Log.d("TAG", "getTimeFromPref: "+timeID);
        return timeID;
    }

    public static void saveEndMealBreak(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(getTimeID(), MODE_PRIVATE).edit();
        editor.putString("MealBreakEnd", getLocaleTime());
        Log.d("TAG", "saveDataToPreferences: "+getLocaleTime());
        editor.apply();
    }
    public static String getEndMealBreakDateFromPref(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(getTimeID(), MODE_PRIVATE);
        String timeID = prefs.getString("MealBreakEnd", null);
        Log.d("TAG", "getTimeFromPref: "+timeID);
        return timeID;
    }
    public static void saveEndOfDayDate(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(getTimeID(), MODE_PRIVATE).edit();
        editor.putString("EndOfDayDate", getLocaleTime());
        Log.d("TAG", "saveDataToPreferences: "+getLocaleTime());
        editor.apply();
    }
    public static String getEndOfDayDateFromPref(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(getTimeID(), MODE_PRIVATE);
        String timeID = prefs.getString("EndOfDayDate", null);
        Log.d("TAG", "getTimeFromPref: "+timeID);
        return timeID;
    }

    public static boolean checkPref(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(getTimeID(), MODE_PRIVATE);
        if (prefs.contains("Day"))
            return true;
        else
            return false;
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

    public static long findDifference(String start_date, String end_date) {
        long t1 = 0;
        // SimpleDateFormat converts the
        // string format to date object
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try {
            //parse string to date formate
            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);

            // Calucalte time difference in milliseconds
            long difference_In_Time = d2.getTime() - d1.getTime();

            // Calucalte time difference in seconds, minutes, hours, years, and days
            long difference_In_Seconds = (difference_In_Time / 1000) % 60;

            long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;

            long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;

            // Print the date difference
            Log.d("TAG", "findDifference: " + "Difference " + "between two dates is: ");
            Log.d("TAG", "findDifference: " + difference_In_Hours + " hours, " + difference_In_Minutes + " minutes, "
                    + difference_In_Seconds + " seconds");
            t1 = calculateTimeForTimer(difference_In_Hours, difference_In_Minutes, difference_In_Seconds);
            Log.d("TAG", "findDifference: " + t1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return t1;
    }

    public static long calculateTimeForTimer(long difference_In_Hours, long difference_In_Minutes, long difference_In_Seconds) {
        long totalSeconds = (difference_In_Hours * 3600) + (difference_In_Minutes * 60) + difference_In_Seconds;
        return totalSeconds;
    }

}
