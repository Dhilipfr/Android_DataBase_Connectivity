package com.example.dhilipkumaran.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dhilipkumaran on 27-04-2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DemoApp.db";
    private static final String TABLE_NAME = "Password";
    private static final String COLUMN_ID = "Id";
    private static final String COLUMN_GMAIL = "Gmail";
    private static final String COLUMN_FACEBOOK = "FaceBook";
    private static final String COLUMN_OUTLOOK = "Outlook";
    private static final String COLUMN_YMAIL = "YMail";
    private static final String COLUMN_DESCRIPTION = "Description";


    private static final String TABLE_CREATE = "CREATE TABLE "+TABLE_NAME+" ("+COLUMN_ID+" INTEGER PRIMARY KEY NOT NULL,"+COLUMN_GMAIL+" TEXT,"+COLUMN_FACEBOOK+" TEXT,"+COLUMN_OUTLOOK+" TEXT,"+COLUMN_YMAIL+" TEXT,"+COLUMN_DESCRIPTION+" TEXT)";

    SQLiteDatabase db;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void InsertPassowrds(SummaryDetails details)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "SELECT * FROM "+TABLE_NAME+"";
        Cursor c = db.rawQuery(query,null);
        int count = c.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_GMAIL,details.Gmail);
        values.put(COLUMN_FACEBOOK,details.FaceBook);
        values.put(COLUMN_OUTLOOK,details.OutLook);
        values.put(COLUMN_YMAIL,details.YMail);
        values.put(COLUMN_DESCRIPTION,details.Description);

        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    public int GetCount()
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "SELECT * FROM "+TABLE_NAME+"";
        Cursor c = db.rawQuery(query,null);
        int count = c.getCount();
        db.close();
        return count;
    }

    public SummaryDetails getDetailById()
    {
        db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+TABLE_NAME+"";
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor!=null)
            cursor.moveToFirst();

        SummaryDetails detail = new SummaryDetails();
        detail.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
        detail.setGmail(cursor.getString(cursor.getColumnIndex(COLUMN_GMAIL)));
        detail.setFaceBook(cursor.getString(cursor.getColumnIndex(COLUMN_FACEBOOK)));
        detail.setOutLook(cursor.getString(cursor.getColumnIndex(COLUMN_OUTLOOK)));
        detail.setYMail(cursor.getString(cursor.getColumnIndex(COLUMN_YMAIL)));
        detail.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
        return detail;
    }

    public int UpdateDetailById(SummaryDetails detail)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_GMAIL, detail.Gmail);
        values.put(COLUMN_FACEBOOK, detail.FaceBook);
        values.put(COLUMN_OUTLOOK, detail.OutLook);
        values.put(COLUMN_YMAIL, detail.YMail);
        values.put(COLUMN_DESCRIPTION, detail.Description);

        int id = db.update(TABLE_NAME,values,"Id=?",new String[]{String .valueOf(detail.getId())});
        db.close();
        return id;
    }
}
