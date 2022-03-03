package com.androdevdk.designpatterns.creationalpatterns.prototypepattern;

import android.util.Log;

public class Circle extends Shape1 {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        Log.d("TAG", "Inside Circle::draw() method.");
    }
}
