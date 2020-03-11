package com.example.haifa.nursemate;
/*
this page has to layouts on top on each other:
- default layout to show the spo2, pr, pi measurements (contains a button to show patient details)
- hidden layout that has the patient details (will appear if the user presses on the button to show patient details)

TODO: use backendFacade .getPatient() .getRecord() to display the info (front end)
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    BackendFacade backendFacade;
    String patientid;

    private Button logoutbutton1;
    private TextView spo2value;
    private TextView prvalue;
    private TextView pivalue;
    private TextView viewpatientprofile;
    private TextView patientinfotext;

    private Button logoutbutton2;
    ImageButton backbutton;

    LinearLayout measureslayout;
    TableLayout profilelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Intent i = getIntent();
        backendFacade = (BackendFacade) i.getParcelableExtra("backendfacade");
        patientid = getIntent().getStringExtra("patientid");
        System.out.println("home page received PATEINT ID: "+patientid);


        backendFacade.setPatient(patientid);
        System.out.println("my new patient: "+backendFacade.getPatient());


        backendFacade.setRecord();
        System.out.println(backendFacade.getRecord().toString());

        measureslayout= (LinearLayout) findViewById(R.id.measureslayout);
        profilelayout= (TableLayout) findViewById(R.id.profilelayout);
        profilelayout.setVisibility(View.INVISIBLE);

        logoutbutton1 = (Button) findViewById(R.id.logoutbutton1);
        logoutbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        int redColorValue = Color.parseColor("#FFA7A7");
        spo2value = (TextView) findViewById(R.id.spo2value) ;
        spo2value.setText("Oxygen Saturation (SpO2): "+backendFacade.getRecord().getSpo2());
        if(backendFacade.getRecord().isSpo2Alert()){
            spo2value.setBackgroundColor(redColorValue);
            spo2value.setTextColor(0xfff00000);
        }
        prvalue = (TextView) findViewById(R.id.prvalue) ;
        prvalue.setText("Pulse Rate (PR): "+backendFacade.getRecord().getPr());
        if(backendFacade.getRecord().isPrAlert()){
            prvalue.setBackgroundColor(redColorValue);
            prvalue.setTextColor(0xfff00000);
        }
        pivalue = (TextView) findViewById(R.id.pivalue) ;
        pivalue.setText("Perfusion Index (Pi) : "+backendFacade.getRecord().getPi());
        if(backendFacade.getRecord().isPiAlert()){
            pivalue.setBackgroundColor(redColorValue);
            pivalue.setTextColor(0xfff00000);
        }


        viewpatientprofile = (TextView) findViewById(R.id.viewpatientprofile);
        viewpatientprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });

        logoutbutton2= (Button)findViewById(R.id.logoutbutton2);
        logoutbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        backbutton= (ImageButton)findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });

        patientinfotext= (TextView) findViewById(R.id.patientinfotext) ;
        patientinfotext.setText("\nNAME: "+backendFacade.getPatient().getName()
                                +"\n\nGENDER: "+backendFacade.getPatient().getGender()
                                +"\n\nAGE: "+backendFacade.getPatient().getAge()
                                +"\n\nDATE OF ADMISSION: "+backendFacade.getPatient().getDateOfAdmission()
                                +"\n\nMEDICATIONS: "+backendFacade.getPatient().getMedications()
                                +"\n\nADDITIONAL INFO: "+backendFacade.getPatient().getAdditionalInfo()
                );

    }

    private void logout(){

        Intent intent = new Intent(HomePage.this, Login.class);
        startActivity(intent);

        System.out.println("logging out");

    }

    private void show(){

        profilelayout.setVisibility(View.VISIBLE);
        measureslayout.setVisibility(View.INVISIBLE);

        System.out.println("VIEWING");

    }

    private void back(){

        profilelayout.setVisibility(View.INVISIBLE);
        measureslayout.setVisibility(View.VISIBLE);

        System.out.println("VIEWING");

    }

    //DONT CHANGE THIS.. this method is created just to disable the page button on the phone
    public void onBackPressed() {    }
}
