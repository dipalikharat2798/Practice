package com.example.practice.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.practice.Dao.WordDao;
import com.example.practice.Database.WordRoomDatabase_Impl;
import com.example.practice.Entity.Word;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase_Impl db = (WordRoomDatabase_Impl) WordRoomDatabase_Impl.getDatabase(application);
       // mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }
}