package com.example.haifa.nursemate;
/*
PLEASE DONT CHANGE ANYTHING IN THIS CLASS
 */
import java.util.Date;

public class Patient {

    String name;
    int id;
    int age;
    String gender;
    Date dateOfAdmission;
    String medications;
    String additionalInfo;

    public Patient(String name, int id, int age, String gender, Date dateOfAdmission, String medications, String additionalInfo){
        this.name= name;
        this.id= id;
        this.age= age;
        this.gender= gender;
        this.dateOfAdmission= dateOfAdmission;
        this.medications= medications;
        this.additionalInfo= additionalInfo;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public String getMedications() {
        return medications;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }
}
