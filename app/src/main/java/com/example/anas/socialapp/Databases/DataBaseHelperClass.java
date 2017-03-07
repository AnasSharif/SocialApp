package com.example.anas.socialapp.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.anas.socialapp.ModalClasses.UserData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anas on 3/7/17.
 */

public class DataBaseHelperClass extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "userLoginData.db";
    public DataBaseHelperClass(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL(DataBaseCreatorClass.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL(DataBaseCreatorClass.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void InsertInfo(UserData userData){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DataBaseCreatorClass.DataEntry.COLUMN_USER_NAME, (String) userData.getUsername());
        cv.put(DataBaseCreatorClass.DataEntry.COLUMN_USER_EMAIL, (String) userData.getEmail());
        cv.put(DataBaseCreatorClass.DataEntry.COLUMN_USER_PASSWORD, (String) userData.getPassword());
        sqLiteDatabase.insert(DataBaseCreatorClass.DataEntry.TABLE_NAME,null,cv);
    }
    public List<UserData> getAllData(){
        ArrayList<UserData> list  = new ArrayList<>();
        String projection []= {
                DataBaseCreatorClass.DataEntry.COLUMN_USER_NAME,
                DataBaseCreatorClass.DataEntry.COLUMN_USER_EMAIL
        };

        SQLiteDatabase sdb = getReadableDatabase();
        Cursor cursor = sdb.query(DataBaseCreatorClass.DataEntry.TABLE_NAME,
                         projection,
                         null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            UserData userData = UserDataCursor(cursor);
            list.add(userData);
             cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public UserData UserDataCursor(Cursor cursor){
         UserData userData = new UserData();
        userData.setUsername(cursor.getString(0));
        userData.setEmail(cursor.getString(1));
        return userData;
    }
}
