package com.example.sqlitetesting.localdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anonymous on 5/6/2018.
 */
public class DBHelper extends SQLiteOpenHelper {

    Context context;

    private static final String DB_NAME = "notes";
    private static final String TABLE_NAME = "note_table";
    private static final String TITLE_COLUMN = "title_column";
    private static final String DETAILS_COLUMN = "details_column";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE `" + TABLE_NAME + "` (" +
                "Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , "+
                "`" + TITLE_COLUMN + "` TEXT , " +
                "`" + DETAILS_COLUMN + "` TEXT " +
                ");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertDataIntoDB(String title, String details){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TITLE_COLUMN, title);
        contentValues.put(DETAILS_COLUMN, details);

        database.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getDataFromDB(){

        SQLiteDatabase database = this.getReadableDatabase();

        String[] dataColumns = {TITLE_COLUMN, DETAILS_COLUMN};

        return database.query(TABLE_NAME, dataColumns, null, null, null, null, null);
    }
}
