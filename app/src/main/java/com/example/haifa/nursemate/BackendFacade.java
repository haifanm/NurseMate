package com.example.haifa.nursemate;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

public class BackendFacade implements Parcelable {
    DBconnection dbconnection; //TODO

    final public String afacadestring= "HELLOTHEREEE";
//    Context context;
    private Nurse nurse;
    private Patient patient;
    Record record;
    RecordBuilder recordBuilder;



    DatabaseHelper myDb;


    public BackendFacade() {

    }

    protected BackendFacade(Parcel in) {
    }

    public static final Creator<BackendFacade> CREATOR = new Creator<BackendFacade>() {
        @Override
        public BackendFacade createFromParcel(Parcel in) {
            return new BackendFacade(in);
        }

        @Override
        public BackendFacade[] newArray(int size) {
            return new BackendFacade[size];
        }
    };

    void setPatient(int id){ //TODO
        //create the patient from the info taken from the database
        //patient = new Patient(........);
    }

    void setNurse(String name, int id){ //PLEASE DONT CHANGE THIS METHOD
        //create the nurse according to the login info
        nurse = new Nurse(name,id);
    }

    void setRecord(){ // TODO: send the record builder a connection to the database/info from the database for the analysis
        recordBuilder = new RecordBuilder();
        record = recordBuilder.buildRecord();
    }

    public Nurse getNurse() {
        return nurse;
    }

    public Patient getPatient() {
        return patient;
    }

    public Record getRecord() {
        return record;
    }


    public boolean usernamevalid(Context context, String loginusername, String loginpassword){
        myDb = DatabaseHelper.getDatabaseHelper(context);
        myDb.resetDatabase();
        myDb.insertData();

        Cursor res = myDb.getData();
//        res.getCount()>0
        System.out.println("blaaahh");
        while(res.moveToNext()){
            System.out.println(res.getString(1));
            System.out.println(res.getString(2));
            if(loginusername.contains(res.getString(1)) && loginpassword.contains(res.getString(2))){
                return true;
            }
        }
        return false;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(33);
    }
}
