package com.example.emedcom_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    Button login, predict, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        login = (Button) findViewById(R.id.buttonlogin);
        predict = (Button) findViewById(R.id.buttonpredict);
        about = (Button) findViewById(R.id.buttonabout);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Please Log In with your email and password",Toast.LENGTH_SHORT).show();
                Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Toast.makeText(getApplicationContext(),"Please Log In with your email and password",Toast.LENGTH_SHORT).show();
                Intent predictIntent = new Intent(getApplicationContext(), PredictionActivity.class);
                startActivity(predictIntent);

            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Toast.makeText(getApplicationContext(),"Please Log In with your email and password",Toast.LENGTH_SHORT).show();
                Intent predictIntent = new Intent(getApplicationContext(), OCRcolActivity.class);
                startActivity(predictIntent);

            }
        });
    }
}
