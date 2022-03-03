package com.example.recyclermvvm.ViewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recyclermvvm.Model.NameModel;
import com.example.recyclermvvm.Repository.Repo;

import java.util.ArrayList;

public class NameViewModel extends ViewModel {
    MutableLiveData<ArrayList<NameModel>> name;

    public  void init (Context context){
        if(name != null){
            return;
        }
        name = Repo.getInstance(context).getNames();
    }
    public LiveData<ArrayList<NameModel>> getNames(){
        return  name;
    }
}
