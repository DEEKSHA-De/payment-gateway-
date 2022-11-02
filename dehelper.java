package com.example.menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class dehelper extends SQLiteOpenHelper {
    public static final String DBNAME="payfi";

    public dehelper(Context context){
        super(context,"payfi.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase payfi) {
        payfi.execSQL("create Table users(id INTEGER PRIMARY KEY AUTOINCREMENT,firstname TEXT,lastname TEXT,email TEXT,pass TEXT,retype TEXT,bal INTEGER,upi Text) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase payfi, int i, int i1) {
        payfi.execSQL("drop Table if exists users");
    }
    public Boolean insertData(String firstname,String lastname,String email,String pass,String retype,Integer bal,String upi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstname", firstname);
        contentValues.put("lastname", lastname);
        contentValues.put("email", email);
        contentValues.put("pass", pass);
        contentValues.put("retype", retype);
        contentValues.put("bal",bal);
        contentValues.put("upi",upi);
        long result = db.insert("users", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean checkusername(String email){
        SQLiteDatabase payfi=this.getWritableDatabase();
        Cursor cursor=payfi.rawQuery("select * from users where email=?",new String[] {email});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkusernamepassword(String firstname,String pass)
    {
        SQLiteDatabase payfi=this.getWritableDatabase();
        Cursor cursor=payfi.rawQuery("select * from users where firstname= ? and pass = ?",new String[]{firstname,pass});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean updatepassword(String email,String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pass", pass);
        long result = db.update("users",contentValues,"email=?",new String[]{email});
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}

