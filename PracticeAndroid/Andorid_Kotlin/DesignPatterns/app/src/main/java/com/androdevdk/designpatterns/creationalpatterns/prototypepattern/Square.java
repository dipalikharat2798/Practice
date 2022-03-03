package com.androdevdk.designpatterns.creationalpatterns.prototypepattern;

import android.util.Log;

public class Square extends Shape1 {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        Log.d("TAG", "Inside Square::draw() method.");
    }
}
