package com.androdevdk.designpatterns.structuralpattern.adapterpattern;

import android.util.Log;

public class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        //do nothing
    }

    @Override
    public void playMp4(String fileName) {
        Log.d("TAG", "playVlc: "+"Playing mp4 file. Name: "+ fileName);
    }
}