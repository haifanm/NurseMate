package com.example.haifa.nursemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScanTemp extends AppCompatActivity {

    public BackendFacade backendFacade;
    private Button goToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_temp);

        Intent i = getIntent();
        backendFacade = (BackendFacade) i.getParcelableExtra("backendfacade");


        System.out.println(backendFacade.afacadestring);

        goToHome= (Button)findViewById(R.id.scanbttemp);
        goToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHomePage();
            }
        });

    }

    private void goToHomePage(){


        Intent intent = new Intent(ScanTemp.this, HomePage.class);
        intent.putExtra("backendfacade",backendFacade);
        startActivity(intent);

        System.out.println("going to home page!");

    }

    //DONT CHANGE THIS.. this method is created just to disable the page button on the phone
    public void onBackPressed() {    }

}
