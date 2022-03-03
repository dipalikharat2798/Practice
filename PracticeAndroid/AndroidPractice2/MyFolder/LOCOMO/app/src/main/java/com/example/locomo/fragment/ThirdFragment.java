package com.example.locomo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.locomo.R;
import com.example.locomo.activity.DashBoardActivity;

public class ThirdFragment extends Fragment {
    Button closeOutDay_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_third, container, false);
//        ((DashBoardActivity) getActivity()).stopTimer();
        closeOutDay_btn=view.findViewById(R.id.closeOutDay_btn);
        closeOutDay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean val= ((DashBoardActivity) getActivity()).isLocationServiceRunning();
               if (val){
                   ((DashBoardActivity) getActivity()).stopTimer();
               }
            }
        });
        return view;
    }
}