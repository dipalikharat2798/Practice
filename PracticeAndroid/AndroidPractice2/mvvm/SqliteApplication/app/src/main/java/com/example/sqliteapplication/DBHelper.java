package com.example.sqliteapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table UserDetails(name TEXT primary key,contact TEXT,dob TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("drop Table if exists UserDetails");
    }

    public Boolean insertuserdata(String name,String contact,String dob){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("contact",contact);
        contentValues.put("dob",dob);
        long results = db.insert("UserDetails",null,contentValues);
        if (results==-1)
            return false;
        else
            return true;
    }

    public Boolean updateuserdata(String name,String contact,String dob){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("contact",contact);
        contentValues.put("dob",dob);
        Cursor cursor = db.rawQuery("Select * from UserDetails where name=?",new String[]{name});
        if (cursor.getCount()>0) {
            long results = db.update("UserDetails", contentValues,"name=?",new String[]{name});
            if (results == -1)
                return false;
            else
                return true;
        }else {
            return false;
        }
    }
    public Boolean deleteuserdata(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from UserDetails where name=?",new String[]{name});
        if (cursor.getCount()>0) {
            long results = db.delete("UserDetails","name=?",new String[]{name});
            if (results == -1)
                return false;
            else
                return true;
        }else {
            return false;
        }
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from UserDetails",null);
        return cursor;
    }
}
