package com.example.reflect.Model;

import com.google.firebase.database.Exclude;

public class NotesModel {
    @Exclude private String id;
    String title,subtitle,notes,date;
    public NotesModel(){

    }

    public NotesModel(String title, String subtitle, String notes, String dates) {
        this.title = title;
        this.subtitle = subtitle;
        this.notes = notes;
        this.date = dates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String dates) {
        this.date = dates;
    }
}
