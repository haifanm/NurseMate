package com.example.haifa.nursemate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.api.services.sqladmin.model.Database;

import org.apache.http.impl.client.NoopUserTokenHandler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "nursemate.db" ;
    public static final String NURSES_TABLE_NAME = "nurses" ;
    public static final String COL_NURSES_ID = "nurseid" ;
    public static final String COL_NURSES_NAME = "nursename" ;
    public static final String COL_NURSES_PASS = "nursepass" ;
    public static final String PATIENTS_TABLE_NAME = "patients" ;


    public static DatabaseHelper databaseHelper;

    private DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);


    }

    //SINGLETON DESIGN PATTERN
    public static DatabaseHelper getDatabaseHelper(Context context){
        if(databaseHelper==null){
            databaseHelper = new DatabaseHelper(context);
        }
        return databaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+NURSES_TABLE_NAME+"(nurseid INTEGER PRIMARY KEY AUTOINCREMENT,nursename TEXT,nursepass TEXT)");
        sqLiteDatabase.execSQL("create table "+PATIENTS_TABLE_NAME+"(patientid TEXT PRIMARY KEY ,pname TEXT, page INTEGER, pgender TEXT, pdate TEXT, pmedications TEXT, pinfo TEXT)");
        insertData();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+NURSES_TABLE_NAME);
        sqLiteDatabase.execSQL("drop table if exists "+PATIENTS_TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public void resetDatabase() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("drop table if exists "+NURSES_TABLE_NAME);
        sqLiteDatabase.execSQL("drop table if exists "+PATIENTS_TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public boolean insertData(){
        long result;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


    ///////NURSES INFO
        contentValues.put(COL_NURSES_NAME,"");
        contentValues.put(COL_NURSES_PASS,"");
        result= sqLiteDatabase.insert(NURSES_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

        contentValues.put(COL_NURSES_NAME,"username1");
        contentValues.put(COL_NURSES_PASS,"pass1");
        result= sqLiteDatabase.insert(NURSES_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

        contentValues.put(COL_NURSES_NAME,"username2");
        contentValues.put(COL_NURSES_PASS,"pass2");
        result= sqLiteDatabase.insert(NURSES_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

        contentValues.put(COL_NURSES_NAME,"username3");
        contentValues.put(COL_NURSES_PASS,"pass3");
        result= sqLiteDatabase.insert(NURSES_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

        contentValues.put(COL_NURSES_NAME,"username4");
        contentValues.put(COL_NURSES_PASS,"pass4");
        result= sqLiteDatabase.insert(NURSES_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

    //////PATIENT INFO
        contentValues.clear();
        contentValues.put("patientid","101011");
        contentValues.put("pname","Asta Maja Beatty");
        contentValues.put("page",33);
        contentValues.put("pgender","female");
        contentValues.put("pdate","01/01/2020");
        contentValues.put("pmedications","sompladib, dilaldolaolone, arteporfin");
        contentValues.put("pinfo","This patient has Diabetes and ASTHMA ");
        result= sqLiteDatabase.insert(PATIENTS_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

        contentValues.put("patientid","101012");
        contentValues.put("pname","Asta Maja Beatty");
        contentValues.put("page",33);
        contentValues.put("pgender","female");
        contentValues.put("pdate","01/01/2020");
        contentValues.put("pmedications","sompladib, dilaldolaolone, arteporfin");
        contentValues.put("pinfo","This patient has Diabetes and ASTHMA ");
        result= sqLiteDatabase.insert(PATIENTS_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

        contentValues.put("patientid","101013");
        contentValues.put("pname","Asta Maja Beatty");
        contentValues.put("page",33);
        contentValues.put("pgender","female");
        contentValues.put("pdate","01/01/2020");
        contentValues.put("pmedications","sompladib, dilaldolaolone, arteporfin");
        contentValues.put("pinfo","This patient has Diabetes and ASTHMA ");
        result= sqLiteDatabase.insert(PATIENTS_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

        return true;
    }

    public Cursor getNurses(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+NURSES_TABLE_NAME,null);
        return res;
    }

    public Cursor getPatients(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+PATIENTS_TABLE_NAME ,null);
        return res;
    }

    public Cursor getPatientById(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+PATIENTS_TABLE_NAME+" where patientid LIKE  "+ id,null);
        return res;
    }
}
