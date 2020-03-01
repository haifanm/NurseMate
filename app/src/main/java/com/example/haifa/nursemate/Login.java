package com.example.haifa.nursemate;
/*
LOGIN PAGE

TODO: validate() according to the accounts in the database
TODO: send the facade to the next page (ScanPage) in intent
TODO: text view to tell the user to try again in case of unsuccessful login
 */
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private Button Login;
    public BackendFacade backendfacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        backendfacade= new BackendFacade();

        Login= (Button)findViewById(R.id.ButtonSignIn);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private void validate(){
        //connect to database, check if this nurse is authorized -> login
        //....
        //else -> ask user to try again
        //....

        //go to the scan page and send the backend facade to it
        Intent intent = new Intent(Login.this, ScanTemp.class);
        startActivity(intent);


    }

    //DONT CHANGE THIS.. this method is created just to disable the page button on the phone
    public void onBackPressed() {    }

}
