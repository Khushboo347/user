package com.example.user;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Db extends SQLiteOpenHelper {

    public static final String DbName = "Maint.db";

    public Db(Context context) {
        super(context, "Maint.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create Table input(main_query TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop Table if exists input");
    }

    public Boolean insertData(String query){
        SQLiteDatabase Db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("query", query);
        long results = Db.insert("input", null, contentValues);
        if(results == -1)
           return false;
        else
            return true;
    }
}
