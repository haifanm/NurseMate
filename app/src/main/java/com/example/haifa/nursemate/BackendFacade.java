package com.example.haifa.nursemate;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackendFacade implements Parcelable {
    final public String afacadestring= "HELLOTHEREEE";

    DBconnection dbconnection; //TODO
    Context context;
    DatabaseHelper myDb;

    private Nurse nurse;
    private Patient patient;
    Record record;
    RecordBuilder recordBuilder;


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
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(33);
    }


    void setPatient(String id){
        //create the patient from the info taken from the database
        //patient = new Patient(........);
        myDb = DatabaseHelper.getDatabaseHelper(context);
//        myDb.resetDatabase();
//        myDb.insertData();

        Cursor res = myDb.getPatientById(id);

        while(res.moveToNext()){
            System.out.println(res.getString(0));
            System.out.println(res.getString(1));
            if(id.contains(res.getString(0)) ){
                String sDate1=res.getString(4);
                Date date1=new Date();
                try {
                    date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                patient = new Patient(res.getString(1),res.getString(0), Integer.parseInt(res.getString(2)), res.getString(3), date1, res.getString(5), res.getString(6));
                System.out.println("PATIENT FOUND:"+id);
            }
        }

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
        this.context=context;
        myDb = DatabaseHelper.getDatabaseHelper(context);

        Cursor res = myDb.getNurses();
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

    public boolean patientExist(String scannedId){
        myDb = DatabaseHelper.getDatabaseHelper(context);
        Cursor res = myDb.getPatients();
        System.out.println("blaaahhPATIENT");
        while(res.moveToNext()){
            System.out.println("patientID:"+res.getString(0));

            if(scannedId.contains(res.getString(1)) ){
                return true;
            }
        }
        return false;
    }


}
