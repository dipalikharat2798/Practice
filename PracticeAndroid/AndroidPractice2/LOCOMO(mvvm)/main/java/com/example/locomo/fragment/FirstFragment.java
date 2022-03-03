package com.example.locomo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.locomo.R;
import com.example.locomo.activity.MainActivity;
import com.example.locomo.utility.Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class FirstFragment extends Fragment {
    Button checkout_btn, ADExpress_btn;
    private NavController navController;
    String start_date = "10-01-2018 01:10:20";

    String end_date = "10-06-2020 06:30:50";
    long time = 19230;
    TextView textview;

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        checkout_btn = view.findViewById(R.id.checkout_btn);
        ADExpress_btn = view.findViewById(R.id.AdExpress_btn);
        Log.d("TAG", "onCreateView: " + Utility.getLocaleTime());
        findDifference(start_date, end_date);
        textview = (TextView) getActivity().findViewById(R.id.showtime_tv);

        checkout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
//                fr.replace(R.id.main_frame, new SecondFragment());
//                fr.commit();
                call();
            }
        });
        return view;
    }

    public void
    findDifference(String start_date,
                   String end_date) {

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

            long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));

            long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

            // Print the date difference
            Log.d("TAG", "findDifference: " + "Difference " + "between two dates is: ");
            Log.d("TAG", "findDifference: " + difference_In_Years + " years, "
                    + difference_In_Days + " days, "
                    + difference_In_Hours + " hours, "
                    + difference_In_Minutes + " minutes, "
                    + difference_In_Seconds + " seconds");
            long t1 = calculateTimeForTimer(difference_In_Hours, difference_In_Minutes, difference_In_Seconds);
            Log.d("TAG", "findDifference: " + t1 + " getTimeText " + getTimerText(t1));
            ((MainActivity) getActivity()).startTimer();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public long calculateTimeForTimer(long difference_In_Hours, long difference_In_Minutes, long difference_In_Seconds) {
        long totalSeconds = (difference_In_Hours * 3600) + (difference_In_Minutes * 60) + difference_In_Seconds;
        return totalSeconds;
    }

    private String getTimerText(long time) {
        int rounded = (int) Math.round(time);

        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);

        return formatTime(seconds, minutes, hours);
    }

    private String formatTime(int seconds, int minutes, int hours) {
        return String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds);
    }

    public void startTimer() {
        Timer timer = new Timer();
        TimerTask timerTask;
        timerTask = new TimerTask() {
            @Override
            public void run() {
                time++;
                Log.d("Time increment", "run: " + time);
                textview.setText(getTimerText(time));
                Log.d("Time increment", "run: " + getTimerText(time));
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
    private void call() {
        navController.navigate(R.id.action_firstFragment2_to_secondFragment2);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }
}