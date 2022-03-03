package com.androdevdk.designpatterns.creationalpatterns.prototypepattern;

import java.util.Hashtable;

public class ShapeCache {

    private static Hashtable<String, Shape1> Shape1Map  = new Hashtable<String, Shape1>();

    public static Shape1 getShape(String Shape1Id) {
        Shape1 cachedShape1 = Shape1Map.get(Shape1Id);
        return (Shape1) cachedShape1.clone();
    }

    // for each Shape1 run database query and create Shape1
    // Shape1Map.put(Shape1Key, Shape1);
    // for example, we are adding three Shape1s

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        Shape1Map.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        Shape1Map.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        Shape1Map.put(rectangle.getId(), rectangle);
    }
}