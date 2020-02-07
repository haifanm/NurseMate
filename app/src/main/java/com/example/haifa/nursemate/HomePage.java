package com.example.haifa.nursemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    private Button show;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
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

        Intent intent = new Intent(HomePage.this, MainActivity.class);
        startActivity(intent);

        System.out.println("logging out");

    }

    private void show(){

        logout.setVisibility(View.VISIBLE);
        show.setVisibility(View.INVISIBLE);

        System.out.println("logging out");

    }


    @Override
    public void onBackPressed() {

    }
}
