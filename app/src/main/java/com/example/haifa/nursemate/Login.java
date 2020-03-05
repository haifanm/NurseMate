package com.example.haifa.nursemate;
/*
LOGIN PAGE

TODO: validate() according to the accounts in the database
TODO: send the facade to the next page (ScanPage) in intent
TODO: text view to tell the user to try again in case of unsuccessful login
 */
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText usernameedittext;
    private EditText passwordedittext;
    private Button Login;
    private TextView try_again_text;

    public BackendFacade backendFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        backendFacade= new BackendFacade();


        usernameedittext= (EditText) findViewById(R.id.usernameedittext);
        passwordedittext= (EditText) findViewById(R.id.passwordedittext);
        Login= (Button)findViewById(R.id.ButtonSignIn);
        try_again_text= (TextView)findViewById(R.id.try_again_text);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login(){
        //connect to database, check if this nurse is authorized -> login
        //....
        //else -> ask user to try again
        //....

        //go to the scan page and send the backend facade to it
        if(backendFacade.usernamevalid(this,usernameedittext.getText().toString(),passwordedittext.getText().toString())){
            Bundle extras = new Bundle();

            Intent intent = new Intent(Login.this, ScanPage.class);
            intent.putExtra("backendfacade",backendFacade);
            startActivity(intent);
        }
        else{
            try_again_text.setText("Login Unsuccessful. Please try again.");
        }

    }


    //DONT CHANGE THIS.. this method is created just to disable the page button on the phone
    public void onBackPressed() {    }

}
