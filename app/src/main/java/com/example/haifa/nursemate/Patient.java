package com.example.haifa.nursemate;

import java.util.Date;

public class Patient {

    String name;
    int id;
    int age;
    String gender;
    Date dateOfAdmission;
    String medications;
    String additionalInfo;

    public Patient(){
        System.out.println("new patient was created!");
    }

    public Patient(String name, int id, int age, String gender, Date dateOfAdmission, String medications, String additionalInfo){
        this.name= name;
        this.id= id;
        this.age= age;
        this.gender= gender;
        this.dateOfAdmission= dateOfAdmission;
        this.medications= medications;
        this.additionalInfo= additionalInfo;
    }
}
