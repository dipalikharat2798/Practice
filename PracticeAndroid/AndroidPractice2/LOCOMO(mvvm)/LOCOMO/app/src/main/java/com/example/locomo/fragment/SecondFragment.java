package com.example.locomo.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.locomo.R;
import com.example.locomo.activity.MainActivity;
import com.example.locomo.utility.Utility;

import java.util.Timer;
import java.util.TimerTask;

public class SecondFragment extends Fragment implements View.OnClickListener {
    Button meal_btn, extendedBreak_btn, endOfDay_btn;
    private NavController navController;
    long seconds = 0;


    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        //find views
        meal_btn = view.findViewById(R.id.meal_btn);
        extendedBreak_btn = view.findViewById(R.id.extendedBreak_btn);
        endOfDay_btn = view.findViewById(R.id.endOfDay_btn);

        //onclickListners
        meal_btn.setOnClickListener(this);
        extendedBreak_btn.setOnClickListener(this);
        endOfDay_btn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.meal_btn:
                breakDialog("Meal Break - Cancel", "Meal Break - Confirm");
                break;
            case R.id.extendedBreak_btn:
                breakDialog("ExtendedBreak - Cancel", "ExtendedBreak - Confirm");
                break;
            case R.id.endOfDay_btn:
                closeDialog();
                break;
        }
    }


    public void breakDialog(String cancelText, String confirmText) {
        AlertDialog.Builder myDialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View myView = inflater.inflate(R.layout.time_select, null);
        myDialog.setView(myView);

        final AlertDialog dialog = myDialog.create();
        dialog.setCancelable(false);

        final Button cancel = myView.findViewById(R.id.breakCancel_btn);
        final Button confirm = myView.findViewById(R.id.breakConfirm_btn);
        cancel.setText(cancelText);
        confirm.setText(confirmText);
        TimePicker picker = (TimePicker) myView.findViewById(R.id.breakTimePeaker);
        picker.setIs24HourView(true);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Utility.saveStartMealBreak(getActivity(), Utility.getLocaleTime());
                seconds = calculateTimePicker(picker);
                Utility.saveMealBreakDuration(getActivity(), seconds);
                Utility.saveBreakStatus(getActivity(), "START");
                ((MainActivity) getActivity()).stopTimer();
                navController.navigate(R.id.action_secondFragment_to_thirdFragment);

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private long calculateTimePicker(TimePicker picker) {
        int hour, minute;
        if (Build.VERSION.SDK_INT >= 23) {
            hour = picker.getHour();
            minute = picker.getMinute();
        } else {
            hour = picker.getCurrentHour();
            minute = picker.getCurrentMinute();
        }
        long seconds = (hour * 3600) + (minute * 60);
        Log.d("TAG", "calculateTimePicker: " + seconds + "Selected Time: " + hour + ":" + minute);
        return seconds;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        // This callback will only be called when MyFragment is at least Started.
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                navController.navigate(R.id.action_secondFragment_to_firstFragment);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);
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
                ((MainActivity) getActivity()).stopTimer();
                Utility.saveDayStatus(getActivity(), "STOP");
                Utility.saveEndOfDayDate(getActivity());
                navController.navigate(R.id.action_secondFragment_to_closeDayFragment);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


}