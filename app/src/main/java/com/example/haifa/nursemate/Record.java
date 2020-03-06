package com.example.haifa.nursemate;

/*
a RECORD object holds the measurements that should be measured my the Monitor machine
a record object is built by the RecordBuilder class

PLEASE DONT CHANGE ANYTHING IN THIS CLASS
 */
public class Record {

    private double spo2;
    private double pr;
    private double pi;
    private boolean spo2Alert;
    private boolean prAlert;
    private boolean piAlert;

    public Record(){
        spo2=0;
        pr=0;
        pi=0;
        spo2Alert=false;
        prAlert=false;
        piAlert=false;
    }

    void setSpo2(double spo2Generated){
        this.spo2=spo2Generated;
    }

    void setPr(double prGenerated){
        this.pr=prGenerated;
    }

    void setPi(double piGenerated){
        this.pi=piGenerated;
    }

    void setSpo2Alert(boolean spo2AlertAnalyzed){
        this.spo2Alert=spo2AlertAnalyzed;
    }

    void setPrAlert(boolean prAlertAnalyzed){
        this.prAlert=prAlertAnalyzed;
    }

    void setPiAlert(boolean piAlertAnalyzed){
        this.piAlert=piAlertAnalyzed;
    }

    public double getSpo2() {
        return spo2;
    }

    public double getPr() {
        return pr;
    }

    public double getPi() {
        return pi;
    }

    public boolean isSpo2Alert() {
        return spo2Alert;
    }

    public boolean isPrAlert() {
        return prAlert;
    }

    public boolean isPiAlert() {
        return piAlert;
    }

    public String toString(){
        return "my record is: ["+spo2+","+pr+","+pi+"]";
    }
}
