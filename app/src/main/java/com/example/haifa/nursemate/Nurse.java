package com.example.haifa.nursemate;

public class Nurse {

    String name;
    int id;

    public Nurse(){
        System.out.println("new nurse was created!");
    }

    public Nurse(String name, int id){
        this.name = name;
        this.id= id;
    }
}
