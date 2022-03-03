package com.example.recyclermvvm.Repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.recyclermvvm.DataLoadListener;
import com.example.recyclermvvm.Model.NameModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Repo {
    static  Repo instance;
    private ArrayList<NameModel> nameModels = new ArrayList<>();
    static Context mContext;
    static DataLoadListener dataLoadListener;
    public  static  Repo getInstance(Context context){
        mContext = context;
        if(instance == null){
            instance=new Repo();
        }
        dataLoadListener =(DataLoadListener) mContext;
        return  instance;
    }
    public MutableLiveData<ArrayList<NameModel>> getNames(){
        loadNames();
        MutableLiveData<ArrayList<NameModel>> name = new MutableLiveData<>();
        name.setValue(nameModels);
        return name;
    }

    private  void  loadNames(){
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
        Query query=reference.child("Data");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    nameModels.add(snapshot1.getValue(NameModel.class));
                }
                dataLoadListener.OnNameLoaded();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
