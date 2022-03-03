package com.example.locomo.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
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

import java.util.Timer;
import java.util.TimerTask;

public class ThirdFragment extends Fragment {
    Button closeOutDay_btn, returnFromBreak_btn;
    TextView breakTimer_tv;
    private NavController navController;
    String start_date = "";
    String end_date = "";
    TimerTask timerTask;
    int timestatus = 0;
    public long time = 0;
    TextView textview;
    String start_date1 = "";
    String end_date1 = "";


    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);


        closeOutDay_btn = view.findViewById(R.id.closeOutDay_btn);
        returnFromBreak_btn = view.findViewById(R.id.returnFromBrek);
        breakTimer_tv = view.findViewById(R.id.breakTimer_tv);
        call();
        returnFromBreak_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.saveBreakStatus(getActivity(), "STOP");
                ((MainActivity) getActivity()).startTimer();
                navController.navigate(R.id.action_thirdFragment_to_firstFragment2);
                stopTimer();
            }
        });
        closeOutDay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDialog();
            }
        });
        return view;
    }

    private void closeDialog() {
        AlertDialog.Builder myDialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View myView = inflater.inflate(R.layout.thanksdia, null);
        myDialog.setView(myView);
        final AlertDialog dialog = myDialog.create();
        dialog.setCancelable(false);
        dialog.show();
        final Button cancel = myView.findViewById(R.id.closecancel_btn);
        final Button confirm = myView.findViewById(R.id.closeconfirm_btn);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Utility.saveDayStatus(getActivity(), "STOP");
                navController.navigate(R.id.action_thirdFragment_to_closeDayFragment2);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                stopTimer();
            }
        });

        dialog.show();
    }

    private void call() {
        start_date = Utility.getStartMealBreakDateFromPref(getActivity());
        end_date = Utility.getLocaleTime();
        Log.d("TAG", "onCreate: " + Utility.findDifference(start_date, end_date));
        long timeTimer = Utility.findDifference(start_date, end_date);
        setTime(timeTimer);
        startTimer();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        textview = (TextView) getActivity().findViewById(R.id.showtime_tv);
    }

    private String call1() {
        String val = "";
        start_date1 = Utility.getTimeFromPref(getActivity());
        end_date1 = Utility.getStartMealBreakDateFromPref(getActivity());
        if (!(start_date.equals(null) && end_date.equals(null))) {
            long time = Utility.findDifference(start_date, end_date);
            val = ((MainActivity) getActivity()).getTimerText(time);
        }
        return val;
    }

    public void startTimer() {
        breakTimer_tv.setTextColor(getResources().getColor(R.color.black));
        Timer timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                setTime(getTime() + 1);
                Log.d("Time increment", "run: " + getTime() + " timeText " + getTimerText(getTime()));
                breakTimer_tv.setText(getTimerText(getTime()));
                timestatus = 1;
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    public void stopTimer() {
        if (timestatus == 1) {
            breakTimer_tv.setTextColor(getResources().getColor(R.color.red));
            timestatus = 0;
            timerTask.cancel();
        }
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
}