package com.example.crudapp;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// below line is for setting table name.
@Entity(tableName = "course_table")
public class PersonModal {
    // below line is to auto increment
    // id for each course.
    @PrimaryKey(autoGenerate = true)

    // variable for our id.
    private int id;

    // below line is a variable
    // for course name.
    private String personName;

    // below line is use for
    // course description.
    private String personLastname;

    // below line is use
    // for course duration.
    private String adharId;
    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically
    public PersonModal(String personName, String personLastname, String adharId) {
        this.personName=personName;
        this.personLastname=personLastname;
        this.adharId=adharId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonLastname() {
        return personLastname;
    }

    public void setPersonLastname(String personLastname) {
        this.personLastname = personLastname;
    }

    public String getAdharId() {
        return adharId;
    }

    public void setAdharId(String adharId) {
        this.adharId = adharId;
    }

    // on below line we are creating
    // getter and setter methods.

}
