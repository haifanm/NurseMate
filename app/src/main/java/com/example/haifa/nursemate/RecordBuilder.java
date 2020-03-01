package com.example.haifa.nursemate;
/*
BUILDER DESIGN PATTERN

this builder creates an instance on 'record' builds it, and returns it to the 'client'  (BackEndFacade)

TODO: analyzeSpo2, analyzePr, analyzePi methods
TODO: connect this to the database connection in order to analyze previous records
 */
public class RecordBuilder {
    Record record;


    Record buildRecord(){  //DONT CHANGE ANYTHING IN THIS METHOD
        //create record instance
        record = new Record();

        //generate the measurements using the MONITOR's static methods
        record.setSpo2(Monitor.generateSpo2());
        record.setPr(Monitor.generatePr());
        record.setPi(Monitor.generatePi());

        //analyze the patient's health using the current measurement and the measurements taken from the database
        analyzeSpo2();
        analyzePr();
        analyzePi();

        return record;
    }

    void analyzeSpo2(){
        //check if there is a need to alert the nurse about SpO2 levels...
        //analyze the patient's health using the current measurement and the measurements taken from the database
        if(true)
            record.setSpo2Alert(true);
        else
            record.setSpo2Alert(false);
    }

    void analyzePr(){
        //check if there is a need to alert the nurse about PR levels...
        //analyze the patient's health using the current measurement and the measurements taken from the database
        if(true)
            record.setPrAlert(true);
        else
            record.setPrAlert(false);
    }

    void analyzePi(){
        //check if there is a need to alert the nurse about Pi levels...
        //analyze the patient's health using the current measurement and the measurements taken from the database
        if(true)
            record.setPiAlert(true);
        else
            record.setPiAlert(false);

    }

}
