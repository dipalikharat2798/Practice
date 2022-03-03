package com.example.reflect.ViewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.reflect.Model.NotesModel;
import com.example.reflect.Repository.Repo;

import java.util.ArrayList;

public class NotesViewModel extends ViewModel {
    MutableLiveData<ArrayList<NotesModel>> notes;

    public  void init (Context context){
        if(notes != null){
            return;
        }
       notes = Repo.getInstance(context).getNotes();
    }
    public LiveData<ArrayList<NotesModel>> getNotes(){
        return  notes;
    }
}