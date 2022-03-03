package com.androdevdk.designpatterns.creationalpatterns.builderpattern;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;

        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){

        for (Item item : items) {
            Log.d("TAG", "Item : " + item.name());
            Log.d("TAG", ", Packing : " + item.packing().pack());
            Log.d("TAG", ", Price : " + item.price());
        }
    }
}
