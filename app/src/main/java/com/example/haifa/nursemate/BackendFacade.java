package com.example.haifa.nursemate;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

public class BackendFacade {
    DBconnection dbconnection;
    Nurse nurse;
    Patient patient;

    public BackendFacade() {

        System.out.println("new facade was created!");

//        dbconnection= new DBconnection();
//
//        if(dbconnection.singinsuccess()){
//            nurse = new Nurse("nursename",1000);
//        }
//        else{
//            nurse = new Nurse("",0);
//        }
//
//        patient = dbconnection.getPatient(70);

    }


}
