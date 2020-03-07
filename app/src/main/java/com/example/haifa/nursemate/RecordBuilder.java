package com.example.haifa.nursemate;
/*
BUILDER DESIGN PATTERN

this builder creates an instance on 'record' builds it, and returns it to the 'client'  (BackEndFacade)

 */
public class RecordBuilder {
    Record record;
    BackendFacade backendFacade;

    public RecordBuilder (BackendFacade backendFacade){
        this.backendFacade=backendFacade;
    }
    Record buildRecord(){  //DONT CHANGE ANYTHING IN THIS METHOD

        //create record instance
        record = new Record();

        //generate the measurements using the MONITOR's static methods
        record.setSpo2(Monitor.generateSpo2());
        record.setPr(Monitor.generatePr());
        record.setPi(Monitor.generatePi());
        record.setRecordTime(getTime());
        //analyze the patient's health using the current measurement and the measurements taken from the database
        analyzeSpo2();
        analyzePr();
        analyzePi();

        return record;
    }

    void analyzeSpo2(){
        //check if there is a need to alert the nurse about SpO2 levels...
        //analyze the patient's health using the current measurement and the measurements taken from the database
//        System.out.println("ANALYZING SPO2 result : "+backendFacade.spo2abnormal());
        if(backendFacade.spo2abnormal())
            record.setSpo2Alert(true);
        else
            record.setSpo2Alert(false);
    }

    void analyzePr(){
        //check if there is a need to alert the nurse about PR levels...
        //analyze the patient's health using the current measurement and the measurements taken from the database
//        System.out.println("ANALYZING PR result : "+backendFacade.prabnormal());
        if(backendFacade.prabnormal())
            record.setPrAlert(true);
        else
            record.setPrAlert(false);
    }

    void analyzePi(){
        //check if there is a need to alert the nurse about Pi levels...
        //analyze the patient's health using the current measurement and the measurements taken from the database
//        System.out.println("ANALYZING PI result : "+backendFacade.piabnormal());
        if(backendFacade.piabnormal())
            record.setPiAlert(true);
        else
            record.setPiAlert(false);

    }

    int getTime(){
        int maxh = 00; int minh = 11; int rangeh = maxh - minh + 1;
        int randh = (int)(Math.random() * rangeh) + minh;

        int maxm = 00;
        int minm = 59;
        int rangem = maxm - minm + 1;
        int randm = (int)(Math.random() * rangem) + minm;

        System.out.println(" randh: "+randh+" randm: "+randm+" result: "+randh*100+randm);
        return  randh*100+randm;
    }

}
