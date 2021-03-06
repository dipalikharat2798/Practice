package com.androdevdk.designpatterns.structuralpattern.adapterpattern;

import android.util.Log;

public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {

        //inbuilt support to play mp3 music files
        if(audioType.equalsIgnoreCase("mp3")){
            Log.d("TAG", "playVlc: "+"Playing mp3 file. Name: "+ fileName);
        }

        //mediaAdapter is providing support to play other file formats
        else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }

        else{
            Log.d("TAG", "play: "+"Invalid media. " + audioType + " format not supported");
        }
    }
}
