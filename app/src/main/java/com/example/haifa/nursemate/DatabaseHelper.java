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
    public static final String RECORDS_TABLE_NAME = "records" ;


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
        sqLiteDatabase.execSQL("create table "+RECORDS_TABLE_NAME+"(recordid INTEGER PRIMARY KEY AUTOINCREMENT , patientid TEXT, spo2val REAL, prval REAL, pival REAL, spo2alert INTEGER, pralert INTEGER, pialert INTEGER, recordtime INTEGER)");
        insertData();
        insertRecords();
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
        sqLiteDatabase.execSQL("drop table if exists "+RECORDS_TABLE_NAME);
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

    public boolean insertRecords(){
        long result;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //////RECORDS INFO
        contentValues.put("patientid","101011");
        contentValues.put("spo2val",98.5);
        contentValues.put("prval",110);
        contentValues.put("pival",10);
        contentValues.put("spo2alert",0);
        contentValues.put("pralert",1);
        contentValues.put("pialert",0);
        contentValues.put("recordtime",0010);
        result= sqLiteDatabase.insert(RECORDS_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

        contentValues.put("patientid","101011");
        contentValues.put("spo2val",95.0);
        contentValues.put("prval",115);
        contentValues.put("pival",20);
        contentValues.put("spo2alert",0);
        contentValues.put("pralert",1);
        contentValues.put("pialert",0);
        contentValues.put("recordtime",0550);
        result= sqLiteDatabase.insert(RECORDS_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

        contentValues.put("patientid","101011");
        contentValues.put("spo2val",99.1);
        contentValues.put("prval",100);
        contentValues.put("pival",5);
        contentValues.put("spo2alert",0);
        contentValues.put("pralert",1);
        contentValues.put("pialert",0);
        contentValues.put("recordtime",900);
        result= sqLiteDatabase.insert(RECORDS_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

        contentValues.put("patientid","101011");
        contentValues.put("spo2val",97.5);
        contentValues.put("prval",140);
        contentValues.put("pival",15);
        contentValues.put("spo2alert",0);
        contentValues.put("pralert",1);
        contentValues.put("pialert",0);
        contentValues.put("recordtime",1111);
        result= sqLiteDatabase.insert(RECORDS_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

        contentValues.put("patientid","101012");
        contentValues.put("spo2val",98.5);
        contentValues.put("prval",110);
        contentValues.put("pival",10);
        contentValues.put("spo2alert",0);
        contentValues.put("pralert",1);
        contentValues.put("pialert",0);
        contentValues.put("recordtime",1350);
        result= sqLiteDatabase.insert(RECORDS_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

        contentValues.put("patientid","101012");
        contentValues.put("spo2val",98.5);
        contentValues.put("prval",110);
        contentValues.put("pival",10);
        contentValues.put("spo2alert",0);
        contentValues.put("pralert",1);
        contentValues.put("pialert",0);
        contentValues.put("recordtime",1740);
        result= sqLiteDatabase.insert(RECORDS_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

        contentValues.put("patientid","101012");
        contentValues.put("spo2val",98.5);
        contentValues.put("prval",110);
        contentValues.put("pival",10);
        contentValues.put("spo2alert",0);
        contentValues.put("pralert",1);
        contentValues.put("pialert",0);
        contentValues.put("recordtime",2020);
        result= sqLiteDatabase.insert(RECORDS_TABLE_NAME,null,contentValues);
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

    public Cursor queryRecords(String patientid){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+RECORDS_TABLE_NAME+" where patientid LIKE  "+ patientid,null);
        while(res.moveToNext()){
            System.out.println("record id:"+res.getString(0));
            System.out.println("patient id:"+res.getString(1));
            System.out.println("some data: "+res.getString(4));
        }
        return res;
    }

    public boolean insertRecord(Record newRecord, Patient p){
        long result;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //////RECORDS INFO
        contentValues.put("patientid",p.id);
        contentValues.put("spo2val",newRecord.getSpo2());
        contentValues.put("prval",newRecord.getPr());
        contentValues.put("pival",newRecord.getPi());
        contentValues.put("spo2alert",0);
        contentValues.put("pralert",1);
        contentValues.put("pialert",0);
        contentValues.put("recordtime",newRecord.getRecordTime());
        result= sqLiteDatabase.insert(RECORDS_TABLE_NAME,null,contentValues);
        if(result == -1 )  return  false;

        System.out.println("the new record: "+newRecord+" was inserted successfully =)");
        return true;
    }
}
