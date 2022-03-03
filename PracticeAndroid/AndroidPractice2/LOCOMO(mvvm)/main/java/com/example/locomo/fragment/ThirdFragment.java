package com.example.locomo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.locomo.R;
import com.example.locomo.activity.MainActivity;

public class ThirdFragment extends Fragment {
    Button closeOutDay_btn;
    private NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_third, container, false);
        navController = Navigation.findNavController(view);
        ((MainActivity) getActivity()).stopTimer();
//        ((DashBoardActivity) getActivity()).stopTimer();
        closeOutDay_btn=view.findViewById(R.id.closeOutDay_btn);
        closeOutDay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_thirdFragment2_to_secondFragment2);
            }
        });
        return view;
    }
}