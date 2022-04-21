package com.example.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactsManager";
    private static final String TABLE_CONTACTS = "contacts";

    // Table column / Fields
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "pass";
    private static final String NAME = "name";

    public database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE "
                + TABLE_CONTACTS + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + EMAIL + " TEXT,"
                + PASSWORD + " TEXT,"
                + NAME + " TEXT"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
    }

    void addContact(String name, String email, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(EMAIL, email); // Contact Name
        values.put(PASSWORD, pass); // Contact Pass
       // Contact Name
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public ArrayList<usermodal> getAllContacts()
    {
        ArrayList<usermodal> contactList = new ArrayList<>();
        String selectQuery = " SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                usermodal m = new usermodal();
                m.setId(Integer.parseInt(cursor.getString(0)));
                m.setName(cursor.getString(1));
                m.setEmail(cursor.getString(2));
//                m.setPass(cursor.getString(3));
//                m.setUsername(cursor.getString(4));
                // Adding contact to list
                contactList.add(m);
            } while (cursor.moveToNext());
        }
        return contactList;
    }
}

