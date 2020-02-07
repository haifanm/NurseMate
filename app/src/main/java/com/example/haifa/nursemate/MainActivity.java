package com.example.haifa.nursemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private Button Login;
    private TextView Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login= (Button)findViewById(R.id.loginbutton);
        Result= (TextView)findViewById(R.id.textView3);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private void validate(){


        Intent intent = new Intent(MainActivity.this, ScanPage.class);
        startActivity(intent);

        System.out.println("WRONG");
        Result.setText("you have tried: times");

    }

    @Override
    public void onBackPressed() {

    }


}
