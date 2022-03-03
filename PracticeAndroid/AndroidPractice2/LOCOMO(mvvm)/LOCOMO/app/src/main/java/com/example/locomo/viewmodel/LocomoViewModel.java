package com.example.locomo.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.locomo.model.LOCOMOModel;
import com.example.locomo.repository.LOCOMORepository;

import java.util.HashMap;
import java.util.List;

public class LocomoViewModel  extends ViewModel implements LOCOMORepository.OnQuestionLoad, LOCOMORepository.OnResultAdded, LOCOMORepository.OnResultLoad {

    private MutableLiveData<List<LOCOMOModel>> questionMutableLiveData;
    private LOCOMORepository repository;
    private MutableLiveData<HashMap<String, String>> resultMutableLiveData;

    public MutableLiveData<HashMap<String, String>> getResultMutableLiveData() {
        return resultMutableLiveData;
    }

    public void getResults() {
        repository.getResults();
    }

    public MutableLiveData<List<LOCOMOModel>> getQuestionMutableLiveData() {
        return questionMutableLiveData;
    }

    public LocomoViewModel() {
        questionMutableLiveData = new MutableLiveData<>();
        resultMutableLiveData = new MutableLiveData<>();
        repository = new LOCOMORepository();
    }


    @Override
    public void onLoad(List<LOCOMOModel> LOCOMOModels) {
        questionMutableLiveData.setValue(LOCOMOModels);
    }

    @Override
    public boolean onSubmit() {
        return true;
    }


    @Override
    public void onResultLoad(HashMap<String, String> resultMap) {
        resultMutableLiveData.setValue(resultMap);
    }

    @Override
    public void onError(Exception e) {
        Log.d("QuizError", "onError: " + e.getMessage());
    }
}