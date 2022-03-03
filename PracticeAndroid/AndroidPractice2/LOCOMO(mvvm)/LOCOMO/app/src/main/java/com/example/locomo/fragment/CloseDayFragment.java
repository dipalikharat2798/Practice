package com.example.locomo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.locomo.R;
import com.example.locomo.activity.MainActivity;
import com.example.locomo.utility.Utility;

public class CloseDayFragment extends Fragment {
    TextView textview;
    String start_date = "";
    String end_date = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_close_day, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textview = (TextView) getActivity().findViewById(R.id.showtime_tv);
        textview.setText("");
        String val = call();
        textview.setTextColor(getResources().getColor(R.color.green));
        textview.setText(val);
    }

    private String call() {
        String val = "";
        start_date = Utility.getTimeFromPref(getActivity());
        end_date = Utility.getEndOfDayDateFromPref(getActivity());
        if (!(start_date.equals(null) && end_date.equals(null))) {
            long time = Utility.findDifference(start_date, end_date);
            val = ((MainActivity) getActivity()).getTimerText(time);
        }
        return val;
    }
}