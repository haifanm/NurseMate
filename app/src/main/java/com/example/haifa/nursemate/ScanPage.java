package com.example.haifa.nursemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class ScanPage extends AppCompatActivity {

    private Button Scan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_page);

        Scan= (Button)findViewById(R.id.scanbutton);
        Scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome();
            }
        });
    }

    private void goToHome(){


        Intent intent = new Intent(ScanPage.this, HomePage.class);
        startActivity(intent);

        System.out.println("done scanning");

    }


    @Override
    public void onBackPressed() {

    }
}
