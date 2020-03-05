package com.example.haifa.nursemate;
/*
this page has to layouts on top on each other:
- default layout to show the spo2, pr, pi measurements (contains a button to show patient details)
- hidden layout that has the patient details (will appear if the user presses on the button to show patient details)

TODO: receive the BackEndFacade object from the scan page
TODO: use backendFacade.getNurse() .getPatient() .getRecord() to display the info (front end)
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SymbolTable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    BackendFacade backendFacade;
    int patientid;

    private Button show;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Intent i = getIntent();
        backendFacade = (BackendFacade) i.getParcelableExtra("backendfacade");
        patientid = Integer.parseInt(getIntent().getStringExtra("patientid"));

        System.out.println("HEREEEE PATEINT ID: "+patientid);


        logout= (Button)findViewById(R.id.secondbutton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        logout.setVisibility(View.INVISIBLE);
        show= (Button)findViewById(R.id.firstbutton);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });

    }

    private void logout(){

        Intent intent = new Intent(HomePage.this, Login.class);
        startActivity(intent);

        System.out.println("logging out");

    }

    private void show(){

        logout.setVisibility(View.VISIBLE);
        show.setVisibility(View.INVISIBLE);

        System.out.println("logging out");

    }


    //DONT CHANGE THIS.. this method is created just to disable the page button on the phone
    public void onBackPressed() {    }
}
