package com.example.locomo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.locomo.R;

public class SecondFragment extends Fragment implements View.OnClickListener {
    Button meal_btn,extendedBreak_btn,endOfDay_btn;
    private NavController navController;
    public SecondFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_second, container, false);
        meal_btn=view.findViewById(R.id.meal_btn);
        extendedBreak_btn=view.findViewById(R.id.extendedBreak_btn);
        endOfDay_btn=view.findViewById(R.id.endOfDay_btn);

        meal_btn.setOnClickListener(this);
        extendedBreak_btn.setOnClickListener(this);
        endOfDay_btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.meal_btn:
                mealBreak();
                break;
            case R.id.extendedBreak_btn:
                break;
            case R.id.endOfDay_btn:
                break;
        }
    }


    public void mealBreak() {
        AlertDialog.Builder myDialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View myView = inflater.inflate(R.layout.time_select, null);
        myDialog.setView(myView);

        final AlertDialog dialog = myDialog.create();
        dialog.setCancelable(false);

        final Button cancel = myView.findViewById(R.id.mealbreakCancel_btn);
        final Button confirm = myView.findViewById(R.id.mealbreakConfirm_btn);
        TimePicker picker=(TimePicker) myView.findViewById(R.id.datePicker1);
        picker.setIs24HourView(true);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
//                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
//                fr.replace(R.id.main_frame,new ThirdFragment());
//                fr.commit();
                call();
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
    private void call() {
        navController.navigate(R.id.action_secondFragment2_to_thirdFragment2);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

}