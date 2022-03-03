package com.androdevdk.designpatterns.structuralpattern.bridgepattern;

import android.util.Log;

public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        Log.d("TAG", "drawCircle: "+"Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}