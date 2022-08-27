package com.noman.dialogues;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="students_db";
    private static final String TABLE_NAME="students";
    private static final String id="id";
    private static final String reg_no="reg_no";
    private static final String name="name";
    private static final String created_at="created_at";


    public DatabaseHelper(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table_query = "CREATE TABLE if not EXISTS "+TABLE_NAME+
                "("+id+" INTEGER PRIMARY KEY,"+
                reg_no+" TEXT,"+
                name+" TEXT,"+
                created_at+" TEXT"+
                ")";
        db.execSQL(table_query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public void AddStudent(StudentModel studentModel) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(reg_no, studentModel.getReg_no());
        contentValues.put(name, studentModel.getName());
        contentValues.put(created_at, studentModel.getCreated_at());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public ArrayList<StudentModel> getALLStudents() {
        ArrayList<StudentModel> studentsList = new ArrayList<StudentModel>();
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()) {
            do {
                StudentModel studentModel = new StudentModel(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                studentsList.add(studentModel);
            } while(cursor.moveToNext());
        }
        db.close();
        return studentsList;
    }

    public int getTotalCount() {
        String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount();
    }
}
