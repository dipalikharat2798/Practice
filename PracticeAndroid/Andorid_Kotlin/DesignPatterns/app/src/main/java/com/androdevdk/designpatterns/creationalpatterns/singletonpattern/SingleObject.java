package com.androdevdk.designpatterns.creationalpatterns.singletonpattern;

import android.util.Log;

public class SingleObject {
    private static SingleObject instance = new SingleObject();

    private SingleObject(){}

    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        Log.d("TAG", "showMessage: SingleObject");
    }
}
