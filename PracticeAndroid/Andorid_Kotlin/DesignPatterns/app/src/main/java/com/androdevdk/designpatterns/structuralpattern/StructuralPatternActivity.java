package com.androdevdk.designpatterns.structuralpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.androdevdk.designpatterns.R;
import com.androdevdk.designpatterns.structuralpattern.adapterpattern.AudioPlayer;
import com.androdevdk.designpatterns.structuralpattern.bridgepattern.Circle;
import com.androdevdk.designpatterns.structuralpattern.bridgepattern.GreenCircle;
import com.androdevdk.designpatterns.structuralpattern.bridgepattern.RedCircle;
import com.androdevdk.designpatterns.structuralpattern.bridgepattern.Shape2;
import com.androdevdk.designpatterns.structuralpattern.compositepattern.Employee;
import com.androdevdk.designpatterns.structuralpattern.filterpattern.AndCriteria;
import com.androdevdk.designpatterns.structuralpattern.filterpattern.Criteria;
import com.androdevdk.designpatterns.structuralpattern.filterpattern.CriteriaFemale;
import com.androdevdk.designpatterns.structuralpattern.filterpattern.CriteriaMale;
import com.androdevdk.designpatterns.structuralpattern.filterpattern.CriteriaSingle;
import com.androdevdk.designpatterns.structuralpattern.filterpattern.OrCriteria;
import com.androdevdk.designpatterns.structuralpattern.filterpattern.Person;

import java.util.ArrayList;
import java.util.List;

public class StructuralPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structural_pattern);
        // adapterPatternDemo();
       // bridgePattern();
       // filterPattern();
        compositePattern();
    }

    private void compositePattern() {
        Employee CEO = new Employee("John","CEO", 30000);

        Employee headSales = new Employee("Robert","Head Sales", 20000);

        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        //print all employees of the organization
        Log.d("TAG", "compositePattern: "+CEO);

        for (Employee headEmployee : CEO.getSubordinates()) {
            Log.d("TAG", "compositePattern: "+ headEmployee);

            for (Employee employee : headEmployee.getSubordinates()) {
                Log.d("TAG", "compositePattern: "+employee);
            }
        }
    }

    private void filterPattern() {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);

        Log.d("TAG", "Males: ");
        printPersons(male.meetCriteria(persons));

        Log.d("TAG","\nFemales: ");
        printPersons(female.meetCriteria(persons));

        Log.d("TAG","\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));

        Log.d("TAG","\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));
    }

    public static void printPersons(List<Person> persons){

        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName() + ", Gender : " + person.getGender() + ", Marital Status : " + person.getMaritalStatus() + " ]");
        }
    }


    private void bridgePattern() {
        Shape2 redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape2 greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }

    private void adapterPatternDemo() {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}