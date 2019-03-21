package com.example.emedcom;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class SignupActivity extends AppCompatActivity {

    Button btnsignup;
    EditText username, password;
    HashMap<String,String> dataMap =  new HashMap<String, String>();

    DatabaseReference dr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username=(EditText)findViewById(R.id.editTextUsername);
        password=(EditText)findViewById(R.id.editTextPassword);
        btnsignup=(Button)findViewById(R.id.buttonSignup);

        FirebaseApp.initializeApp(this);
        FirebaseDatabase fr=FirebaseDatabase.getInstance();
        //dr= FirebaseDatabase.getInstance().getReference();

        /*btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataMap.put("username", username.getText().toString());
                dataMap.put("password",password.getText().toString());

                dr.child("login").push().setValue(dataMap);

                //adding values to more than one table

         //       dataMap1.put("username", username.getText().toString());
         //       dataMap1.put("password",password.getText().toString());

          //      dr.child("user").push().setValue(dataMap);

            }
        });*/

    }
}
