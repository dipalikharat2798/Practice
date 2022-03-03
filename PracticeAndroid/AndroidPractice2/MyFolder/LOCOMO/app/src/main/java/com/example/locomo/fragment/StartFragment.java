package com.example.locomo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.locomo.R;
import com.example.locomo.activity.DashBoardActivity;

public class StartFragment extends Fragment {
    TextView startmyday_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        startmyday_btn=view.findViewById(R.id.startmyday_btn);
        startmyday_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                ((DashBoardActivity) getActivity()).showtime();
                fr.replace(R.id.main_frame,new FirstFragment());
                fr.commit();
            }
        });
        return view;
    }
}