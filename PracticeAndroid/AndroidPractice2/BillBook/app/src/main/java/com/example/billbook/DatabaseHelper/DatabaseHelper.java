package com.example.billbook.DatabaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.billbook.Model.BillModel;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    private static final String DATABASE_NAME = "Bill_DATABASE";
    private static final String TABLE_NAME="Bill_TABLE";
    private static final String COL_1="id";
    private static final String COL_2="category";
    private static final String COL_3="billnumber";
    private static final String COL_4="billname";
    private static final String COL_5="date";
    private static final String COL_6="time";
    private static final String COL_7="amountpaid";
    private static final String COL_8="status";
    private static final String COL_9="photo";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not EXISTS "+ TABLE_NAME
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,category TEXT,billnumber TEXT,billname TEXT,date TEXT,time TEXT,amountpaid INTEGER,status TEXT,photo TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void insertTask(BillModel model){
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2,model.getCategary());
        values.put(COL_3,model.getBillNumber());
        values.put(COL_4,model.getBillName());
        values.put(COL_5,model.getDate());
        values.put(COL_6,model.getTime());
        values.put(COL_7,model.getAmountpaid());
        values.put(COL_8,model.getSatus());
        values.put(COL_9,model.getPhoto());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public List<BillModel> getAllTAsks(){
        db=this.getWritableDatabase();
        Cursor cursor=null;
        List<BillModel> modelList= new ArrayList<>();
        db.beginTransaction();
        try {
            cursor=db.query(TABLE_NAME,null,null,null,null,null,null);
            if (cursor != null){
                if (cursor.moveToFirst()){
                    do {
                        BillModel t1=new BillModel();
                        t1.setId(cursor.getInt(cursor.getColumnIndex(COL_1)));
                        t1.setCategary(cursor.getString(cursor.getColumnIndex(COL_2)));
                        t1.setBillNumber(cursor.getString(cursor.getColumnIndex(COL_3)));
                        t1.setBillName(cursor.getString(cursor.getColumnIndex(COL_4)));
                        t1.setDate(cursor.getString(cursor.getColumnIndex(COL_5)));
                        t1.setTime(cursor.getString(cursor.getColumnIndex(COL_6)));
                        t1.setAmountpaid(cursor.getInt(cursor.getColumnIndex(COL_7)));
                        t1.setSatus(cursor.getString(cursor.getColumnIndex(COL_8)));
                        t1.setPhoto(cursor.getString(cursor.getColumnIndex(COL_9)));
                        modelList.add(t1);
                    }while (cursor.moveToNext());
                }
            }
        }finally {
            db.endTransaction();
        }
        return modelList;
    }
}
