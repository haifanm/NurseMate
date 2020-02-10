package com.example.haifa.nursemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NextActivity();
    }

    public void NextActivity()
    {
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {


                Intent mainIntent = new Intent(ctx, Login.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
            }
        }, 5000);

    }


}
