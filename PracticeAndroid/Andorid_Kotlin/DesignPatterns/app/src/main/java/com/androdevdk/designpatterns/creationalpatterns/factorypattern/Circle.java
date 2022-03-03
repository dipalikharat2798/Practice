package com.androdevdk.designpatterns.creationalpatterns.factorypattern;

import android.util.Log;

public class Circle implements Shape{
    @Override
    public void draw() {
        Log.d("TAG", "draw: "+"Circle");
    }
}
