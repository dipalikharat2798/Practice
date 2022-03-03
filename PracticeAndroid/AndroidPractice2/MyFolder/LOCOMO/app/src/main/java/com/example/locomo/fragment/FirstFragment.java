package com.example.locomo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.locomo.R;
import com.example.locomo.activity.DashBoardActivity;

public class FirstFragment extends Fragment implements View.OnClickListener {
    Button checkout_btn,ADExpress_btn;
    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_first, container, false);
        checkout_btn=view.findViewById(R.id.checkout_btn);
        ADExpress_btn=view.findViewById(R.id.AdExpress_btn);
        checkout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.main_frame,new SecondFragment());
                fr.commit();
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}