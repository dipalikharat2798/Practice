package com.androdevdk.designpatterns.structuralpattern.bridgepattern;

import android.util.Log;

public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        Log.d("TAG", "drawCircle: "+"Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}