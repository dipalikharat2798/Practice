package com.example.notesapp.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notesapp.Model.Notes;

import java.util.List;

@androidx.room.Dao
public interface NotesDao {

    @Query("select * from Notes_Database")
    LiveData<List<Notes>> getallNotes();

    @Insert
    void inserNotes(Notes... notes);

    @Query("Delete from Notes_Database where id=:id")
    void deleteNotes(int id);

    @Update
    void updateNotes(Notes notes);
}
