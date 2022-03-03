package com.example.locomo.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.locomo.R;
import com.example.locomo.activity.MainActivity;
import com.example.locomo.utility.Utility;

import static android.content.Context.MODE_PRIVATE;

public class StartFragment extends Fragment implements View.OnClickListener {

    TextView startmyday;
    private static final String START_TAG = "START_LOG";
    Context context;
    private NavController navController;
    String dayStatus, breakStatus;

    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        context = getContext();
        startmyday = view.findViewById(R.id.startmyday_btn);
        startmyday.setOnClickListener(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Utility.checkPref(context)) {
                    dayStatus = Utility.getDayStatusFromPref(context);
                    breakStatus = Utility.getBreakStatusFromPref(context);
                    if ((breakStatus.equals("STOP")) && (dayStatus.equals("START"))) {
                        navController.navigate(R.id.action_startFragment_to_firstFragment);
                        ((MainActivity) getActivity()).startTimer();
                    } else if ((breakStatus.equals("START")) && (dayStatus.equals("START"))) {
                        navController.navigate(R.id.action_startFragment_to_thirdFragment);
                    } else if (dayStatus.equals("STOP")) {
                        navController.navigate(R.id.action_startFragment_to_closeDayFragment);
                    }
                }
            }
        }, 100);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.startmyday_btn:
                call();
                break;
        }
    }

    private void call() {
        ((MainActivity) getActivity()).startTimer();
        Utility.saveDataToPreferences(getActivity());
        Utility.saveDayStatus(context, "START");
        Utility.saveBreakStatus(context, "STOP");
        Utility.saveStartMealBreak(getActivity(), "");
        navController.navigate(R.id.action_startFragment_to_firstFragment);
    }

}