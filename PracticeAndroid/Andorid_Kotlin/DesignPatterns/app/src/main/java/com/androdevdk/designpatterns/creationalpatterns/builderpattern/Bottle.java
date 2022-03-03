package com.androdevdk.designpatterns.creationalpatterns.builderpattern;


public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
