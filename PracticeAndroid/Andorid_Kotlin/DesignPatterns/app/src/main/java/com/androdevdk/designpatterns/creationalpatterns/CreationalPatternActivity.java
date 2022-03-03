package com.androdevdk.designpatterns.creationalpatterns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.androdevdk.designpatterns.R;
import com.androdevdk.designpatterns.creationalpatterns.abstfactorypattern.AbstractFactory;
import com.androdevdk.designpatterns.creationalpatterns.abstfactorypattern.FactoryProducer;
import com.androdevdk.designpatterns.creationalpatterns.abstfactorypattern.Shape;
import com.androdevdk.designpatterns.creationalpatterns.builderpattern.Meal;
import com.androdevdk.designpatterns.creationalpatterns.builderpattern.MealBuilder;
import com.androdevdk.designpatterns.creationalpatterns.factorypattern.ShapeFactory;
import com.androdevdk.designpatterns.creationalpatterns.prototypepattern.Shape1;
import com.androdevdk.designpatterns.creationalpatterns.prototypepattern.ShapeCache;
import com.androdevdk.designpatterns.creationalpatterns.singletonpattern.SingleObject;

public class CreationalPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creational_pattern);

       // creationalFactoryPattern();
       // creationalAbstFactoryPattern();***
        //creationalSingleObject();
      //  creationalBuilderPattern();
        creationalProtypePattern();
    }

    private void creationalProtypePattern() {
        ShapeCache.loadCache();

        Shape1 clonedShape = (Shape1) ShapeCache.getShape("1");
        Log.d("TAG", "Shape : "+clonedShape.getType() +" "+clonedShape.getId());

        Shape1 clonedShape2 = (Shape1) ShapeCache.getShape("2");
        Log.d("TAG", "Shape : "+clonedShape2.getType() +" "+clonedShape2.getId());

        Shape1 clonedShape3 = ShapeCache.getShape("3");
        Log.d("TAG", "Shape : "+clonedShape3.getType() +" "+clonedShape3.getId());
    }

    private void creationalBuilderPattern() {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        Log.d("TAG", "Veg Meal , Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        nonVegMeal.showItems();
        Log.d("TAG", "Non-Veg Meal , Total Cost: " + nonVegMeal.getCost());
    }

    private void creationalSingleObject() {

        //Get the only object available
        SingleObject object = SingleObject.getInstance();

        //show the message
        object.showMessage();
    }

    private void creationalAbstFactoryPattern() {
        //get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
        //get an object of Shape Rectangle
        Shape shape1 = shapeFactory.getShape("RECTANGLE");
        //call draw method of Shape Rectangle
        shape1.draw();
        //get an object of Shape Square
        Shape shape2 = shapeFactory.getShape("SQUARE");
        //call draw method of Shape Square
        shape2.draw();
        //get shape factory
        AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);
        //get an object of Shape Rectangle
        Shape shape3 = shapeFactory1.getShape("RECTANGLE");
        //call draw method of Shape Rectangle
        shape3.draw();
        //get an object of Shape Square
        Shape shape4 = shapeFactory1.getShape("SQUARE");
        //call draw method of Shape Square
        shape4.draw();
    }

   /* private void creationalFactoryPattern() {
        ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Rectangle
        shape2.draw();

        //get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //call draw method of square
        shape3.draw();
    }

*/
}