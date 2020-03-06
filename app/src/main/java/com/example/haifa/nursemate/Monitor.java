package com.example.haifa.nursemate;

/*
This class represents the HW machine/ Monitor that should be measuring the patient's SpO2, PE and Pi
static Monitor to generate random double values as the SpO2, PE, Pi measurements

 */
public class Monitor {


    static double generateSpo2(){ // > 95 %
        //Randomly generate SpO2 values [DOUBLE]
        int max = 95;
        int min = 99;
        int range = max - min + 1;
        double rand = (Math.random() * range) + min;

        return Math.round(rand * 10) / 10.0;
    }

    static double generatePr(){ //60 to 100
        //Randomly generate Pr values [DOUBLE]
        int max = 90;
        int min = 150;
        int range = max - min + 1;
        double rand = (Math.random() * range) + min;

        return Math.round(rand * 10) / 10.0;
    }

    static double generatePi(){ //0.02 to 20 %
        //Randomly generate Pi values [DOUBLE]
        int max = 5;
        int min = 20;
        int range = max - min + 1;
        double rand = (Math.random() * range) + min;

        return Math.round(rand * 10) / 10.0;
    }

    static void foo(){
        System.out.println("random SpO2: "+generateSpo2());
        System.out.println("random PR: "+generatePr());
        System.out.println("random Pi: "+generatePi());
    }

}
