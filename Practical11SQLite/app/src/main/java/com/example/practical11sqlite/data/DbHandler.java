package com.example.practical11sqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.practical11sqlite.model.StudentDetails;
import com.example.practical11sqlite.params.Params;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    public DbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE "+ Params.TABLE_NAME + "(" + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_NAME +" TEXT, " + Params.KEY_ENROLMENT + " TEXT, " + Params.KEY_SEM + " INTEGER, "+ Params.KEY_BRANCH + " TEXT, " + Params.KEY_PHONE + " TEXT, " + Params.KEY_EMAIL + " TEXT)";
        Log.d("dbtest", "Query being run is :"+ create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addStudentDetails(StudentDetails studentDetails){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, studentDetails.getName());
        values.put(Params.KEY_ENROLMENT, studentDetails.getEnrolment());
        values.put(Params.KEY_SEM, studentDetails.getSem());
        values.put(Params.KEY_BRANCH, studentDetails.getBranch());
        values.put(Params.KEY_EMAIL, studentDetails.getEmail());
        values.put(Params.KEY_PHONE, studentDetails.getMobile());

        db.insert(Params.TABLE_NAME, null, values);
        Log.d("dbtest", "Successfully inserted!!!");
        db.close();
    }
}

public List<StudentDetails> getAllStudentDetails(){
        List<StudentDetails> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM "+ Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

        if (cursor.moveToFirst()){
        do {
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setId(Integer.parseInt(cursor.getString(0)));
        studentDetails.setName(cursor.getString(1));
        studentDetails.setEnrolment(cursor.getString(2));
        studentDetails.setSem(Integer.parseInt((cursor.getString(3))));
        studentDetails.setBranch(cursor.getString(4));
        studentDetails.setEmail(cursor.getString(5));
        studentDetails.setMobile(cursor.getString(6));
        contactList.add(studentDetails);
        }while (cursor.moveToNext());
        }
        return contactList;
    }
