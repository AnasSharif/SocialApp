package com.example.anas.socialapp.Databases;

import android.provider.BaseColumns;

/**
 * Created by anas on 3/7/17.
 */

public class DataBaseCreatorClass {
    public DataBaseCreatorClass() {
    }
    class DataEntry implements BaseColumns {
        protected static final String TABLE_NAME = "userdata";
        protected static final String COLUMN_USER_NAME = "username";
        protected static final String COLUMN_USER_EMAIL = "email";
        protected static final String COLUMN_USER_PASSWORD = "password";
    }
    protected static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DataEntry.TABLE_NAME + " (" +
                    DataEntry._ID + " INTEGER PRIMARY KEY," +
                    DataEntry.COLUMN_USER_NAME + " TEXT," +
                    DataEntry.COLUMN_USER_EMAIL + " TEXT," +
                    DataEntry.COLUMN_USER_PASSWORD + " TEXT)";
    protected static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DataEntry.TABLE_NAME;
}
