package com.example.emedcom_project;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

public class PredictionActivity extends AppCompatActivity {


    ArrayList<spinner_generic_name> categories = new ArrayList<>();

    ArrayList<spinner_source_districts> source = new ArrayList<>();

    Button b1 ;

    TextView t1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        final int a = 15, b = 1, c = 1, d = 112, e = 3;

        b1 = (Button) findViewById(R.id.predict_btn);

        t1 = (TextView) findViewById(R.id.print_result);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Ion.with(getApplicationContext())
                        .load("http://192.168.0.106/emedcom/?action=Y&a="+a+"&b="+b+"&c="+c+"&d="+d+"&e="+e)
                        .asString()
                        .setCallback(new FutureCallback<String>() {
                            @Override
                            public void onCompleted(Exception e, String result) {

                                t1.setText(result);

                            }
                        });

            }
        });

        //drop down list of generic names
        Spinner spinner = (Spinner) findViewById(R.id.generic_name);
        // Spinner click listener
        //spinner.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        //List<String> categories = new ArrayList<String>();
        categories.add(new spinner_generic_name(0,"alvimopan"));
        categories.add(new spinner_generic_name(1,"bupropion"));
        categories.add(new spinner_generic_name(2,"chlorpheniramine"));
        categories.add(new spinner_generic_name(3,"clindamycin topical"));
        categories.add(new spinner_generic_name(4,"darunavir"));
        categories.add(new spinner_generic_name(5,"diphenhydramine"));
        categories.add(new spinner_generic_name(6,"doxycycline"));
        categories.add(new spinner_generic_name(7,"duloxetine"));
        categories.add(new spinner_generic_name(8,"eletriptan"));
        categories.add(new spinner_generic_name(9,"elvitegravir"));
        categories.add(new spinner_generic_name(10,"emtricitabine"));
        categories.add(new spinner_generic_name(11,"lidocaine topical"));
        categories.add(new spinner_generic_name(12,"lidocaine viscous"));
        categories.add(new spinner_generic_name(13,"lisinopril"));
        categories.add(new spinner_generic_name(14,"losartan"));
        categories.add(new spinner_generic_name(15,"minocycline"));
        categories.add(new spinner_generic_name(16,"minoxidil topical"));
        categories.add(new spinner_generic_name(17,"rizatriptan"));
        categories.add(new spinner_generic_name(18,"sertraline"));
        categories.add(new spinner_generic_name(19,"spironolactone"));
        categories.add(new spinner_generic_name(20,"sumatriptan"));
        categories.add(new spinner_generic_name(21,"tretinoin topical"));
        categories.add(new spinner_generic_name(22,"triamcinolone"));
        // Creating adapter for spinner
        ArrayAdapter<spinner_generic_name> dataAdapter = new ArrayAdapter<spinner_generic_name>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                spinner_generic_name generic = (spinner_generic_name) parent.getSelectedItem();
                ((TextView) parent.getChildAt(0)).setTextColor(Color.rgb(76, 156, 210));
                ((TextView) parent.getChildAt(0)).setTextSize(18);
                Toast.makeText(getApplicationContext(), " "+generic.getId()+"\nSelected "+generic.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // source distrcits list
        //drop down list of generic names
        Spinner spinnerdis = (Spinner) findViewById(R.id.source);

        // Spinner click listener
        //spinner.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        //List<String> categories = new ArrayList<String>();
        source.add(new spinner_source_districts(0,"Aleppey"));
        source.add(new spinner_source_districts(1,"Ernakulam"));
        source.add(new spinner_source_districts(2,"Idukki"));
        source.add(new spinner_source_districts(3,"Kannur"));
        source.add(new spinner_source_districts(4,"Kasargod"));
        source.add(new spinner_source_districts(5,"Kollam"));
        source.add(new spinner_source_districts(6,"Kottayam"));
        source.add(new spinner_source_districts(7,"Kozhikode"));
        source.add(new spinner_source_districts(8,"Malappuram"));
        source.add(new spinner_source_districts(9,"Palakkad"));
        source.add(new spinner_source_districts(10,"Pathanamthitta"));
        source.add(new spinner_source_districts(11,"Thiruvananthapuram"));
        source.add(new spinner_source_districts(12,"Thrissur"));
        source.add(new spinner_source_districts(13,"Wayanad"));
        // Creating adapter for spinner
        ArrayAdapter<spinner_source_districts> dataAdapterdis = new ArrayAdapter<spinner_source_districts>(this, android.R.layout.simple_spinner_dropdown_item, source);
        // Drop down layout style - list view with radio button
        dataAdapterdis.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerdis.setAdapter(dataAdapterdis);


        spinnerdis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                spinner_source_districts districts = (spinner_source_districts) parent.getSelectedItem();
                ((TextView) parent.getChildAt(0)).setTextColor(Color.rgb(76, 156, 210));
                ((TextView) parent.getChildAt(0)).setTextSize(18);
                Toast.makeText(getApplicationContext(), " "+districts.getId()+"\n Selected "+districts.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




    }
}
