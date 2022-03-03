package com.androdevdk.designpatterns.structuralpattern.adapterpattern;

import android.util.Log;

public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        Log.d("TAG", "playVlc: "+"Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //do nothing
    }
}
