package com.example.haifa.nursemate;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

public class BackendFacade {
    DBconnection dbconnection; //TODO

    private Nurse nurse;
    private Patient patient;
    Record record;
    RecordBuilder recordBuilder;

    public BackendFacade() {

    }

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


}
