package com.androdevdk.designpatterns.creationalpatterns.prototypepattern;

import android.util.Log;

public class Rectangle extends Shape1 {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        Log.d("TAG", "Inside Rectangle::draw() method.");
    }
}
