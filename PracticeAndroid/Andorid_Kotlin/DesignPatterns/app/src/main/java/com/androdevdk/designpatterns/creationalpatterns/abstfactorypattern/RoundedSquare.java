package com.androdevdk.designpatterns.creationalpatterns.abstfactorypattern;

import android.util.Log;

public class RoundedSquare implements Shape {
    @Override
    public void draw() {
        Log.d("TAG", "draw: RoundedSquare");
    }
}
