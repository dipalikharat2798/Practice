package com.example.recyclermvvm.Model;

public class NameModel {
    private  String Name;

    public NameModel(){

    }
    public NameModel(String nameModel) {
        Name = nameModel;
    }

    public String getName() {
        return Name;
    }

    public void setName(String nameModel) {
        Name = nameModel;
    }
}
