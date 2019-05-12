package com.example.emedcom_project;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

    ArrayList<spinner_condition_name> condition = new ArrayList<>();

    ArrayList<spinner_count> count = new ArrayList<>();

    ArrayList<spinner_month> month = new ArrayList<>();

    Button b1 ;

    TextView t1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("District Prediction");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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


        // 1
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

        // 2
        // source districts list
        //drop down list of generic names
        Spinner spinnermon = (Spinner) findViewById(R.id.month);

        // Spinner click listener
        //spinner.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        //List<String> categories = new ArrayList<String>();
        month.add(new spinner_month(0,"April"));
        month.add(new spinner_month(1,"August"));
        month.add(new spinner_month(2,"December"));
        month.add(new spinner_month(3,"February"));
        month.add(new spinner_month(4,"January"));
        month.add(new spinner_month(5,"July"));
        month.add(new spinner_month(6,"June"));
        month.add(new spinner_month(7,"March"));
        month.add(new spinner_month(8,"May"));
        month.add(new spinner_month(9,"November"));
        month.add(new spinner_month(10,"October"));
        month.add(new spinner_month(11,"September"));

        // Creating adapter for spinner
        ArrayAdapter<spinner_month> dataAdaptermon = new ArrayAdapter<spinner_month>(this, android.R.layout.simple_spinner_dropdown_item, month);
        // Drop down layout style - list view with radio button
        dataAdaptermon.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnermon.setAdapter(dataAdaptermon);


        spinnermon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                spinner_month months = (spinner_month) parent.getSelectedItem();
                ((TextView) parent.getChildAt(0)).setTextColor(Color.rgb(76, 156, 210));
                ((TextView) parent.getChildAt(0)).setTextSize(18);
                Toast.makeText(getApplicationContext(), " "+months.getId()+"\n Selected "+months.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // 5
        // source districts list
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


        // 3
        //drop down list of generic names
        Spinner spinnercon = (Spinner) findViewById(R.id.condition);
        // Spinner click listener
        //spinner.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        //List<String> categories = new ArrayList<String>();
        condition.add(new spinner_condition_name(0,"AIDS"));
        condition.add(new spinner_condition_name(1,"Acne"));
        condition.add(new spinner_condition_name(2,"Cold"));
        condition.add(new spinner_condition_name(3,"Depression"));
        condition.add(new spinner_condition_name(4,"Gastrointestinal"));
        condition.add(new spinner_condition_name(5,"Hair Loss"));
        condition.add(new spinner_condition_name(6,"Hypertension"));
        condition.add(new spinner_condition_name(7,"Migraine"));

        // Creating adapter for spinner
        ArrayAdapter<spinner_condition_name> dataAdaptercon = new ArrayAdapter<spinner_condition_name>(this, android.R.layout.simple_spinner_dropdown_item, condition);
        // Drop down layout style - list view with radio button
        dataAdaptercon.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinnercon.setAdapter(dataAdaptercon);

        spinnercon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                spinner_condition_name condi = (spinner_condition_name) parent.getSelectedItem();
                ((TextView) parent.getChildAt(0)).setTextColor(Color.rgb(76, 156, 210));
                ((TextView) parent.getChildAt(0)).setTextSize(18);
                Toast.makeText(getApplicationContext(), " "+condi.getId()+"\nSelected "+condi.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        // 4
        //drop down list of count
        Spinner spinnercount = (Spinner) findViewById(R.id.count);
        // Spinner click listener
        //spinner.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        //List<String> categories = new ArrayList<String>();
        count.add(new spinner_count(0,"2"));
        count.add(new spinner_count(1,"3"));
        count.add(new spinner_count(2,"5"));
        count.add(new spinner_count(3,"6"));
        count.add(new spinner_count(4,"7"));
        count.add(new spinner_count(5,"9"));
        count.add(new spinner_count(6,"10"));
        count.add(new spinner_count(7,"11"));
        count.add(new spinner_count(8,"12"));
        count.add(new spinner_count(9,"13"));
        count.add(new spinner_count(10,"15"));
        count.add(new spinner_count(11,"16"));
        count.add(new spinner_count(12,"20"));
        count.add(new spinner_count(13,"21"));
        count.add(new spinner_count(14,"22"));
        count.add(new spinner_count(15,"23"));
        count.add(new spinner_count(16,"24"));
        count.add(new spinner_count(17,"25"));
        count.add(new spinner_count(18,"30"));
        count.add(new spinner_count(19,"31"));
        count.add(new spinner_count(20,"32"));
        count.add(new spinner_count(21,"34"));
        count.add(new spinner_count(22,"35"));
        count.add(new spinner_count(23,"36"));
        count.add(new spinner_count(24,"41"));
        count.add(new spinner_count(25,"44"));
        count.add(new spinner_count(26,"45"));
        count.add(new spinner_count(27,"50"));
        count.add(new spinner_count(28,"51"));
        count.add(new spinner_count(29,"52"));
        count.add(new spinner_count(30,"54"));
        count.add(new spinner_count(31,"55"));
        count.add(new spinner_count(32,"56"));
        count.add(new spinner_count(33,"57"));
        count.add(new spinner_count(34,"58"));
        count.add(new spinner_count(35,"60"));
        count.add(new spinner_count(36,"62"));
        count.add(new spinner_count(37,"64"));
        count.add(new spinner_count(38,"65"));
        count.add(new spinner_count(39,"66"));
        count.add(new spinner_count(40,"67"));
        count.add(new spinner_count(41,"69"));
        count.add(new spinner_count(42,"75"));
        count.add(new spinner_count(43,"76"));
        count.add(new spinner_count(44,"77"));
        count.add(new spinner_count(45,"87"));
        count.add(new spinner_count(46,"98"));
        count.add(new spinner_count(47,"120"));
        count.add(new spinner_count(48,"123"));
        count.add(new spinner_count(49,"124"));
        count.add(new spinner_count(50,"125"));
        count.add(new spinner_count(51,"210"));
        count.add(new spinner_count(52,"213"));
        count.add(new spinner_count(53,"214"));
        count.add(new spinner_count(54,"231"));
        count.add(new spinner_count(55,"235"));
        count.add(new spinner_count(56,"245"));
        count.add(new spinner_count(57,"312"));
        count.add(new spinner_count(58,"320"));
        count.add(new spinner_count(59,"321"));
        count.add(new spinner_count(60,"324"));
        count.add(new spinner_count(61,"325"));
        count.add(new spinner_count(62,"328"));
        count.add(new spinner_count(63,"340"));
        count.add(new spinner_count(64,"350"));
        count.add(new spinner_count(65,"354"));
        count.add(new spinner_count(66,"356"));
        count.add(new spinner_count(67,"362"));
        count.add(new spinner_count(68,"365"));
        count.add(new spinner_count(69,"368"));
        count.add(new spinner_count(70,"412"));
        count.add(new spinner_count(71,"431"));
        count.add(new spinner_count(72,"456"));
        count.add(new spinner_count(73,"458"));
        count.add(new spinner_count(74,"465"));
        count.add(new spinner_count(75,"478"));
        count.add(new spinner_count(76,"500"));
        count.add(new spinner_count(77,"537"));
        count.add(new spinner_count(78,"543"));
        count.add(new spinner_count(79,"544"));
        count.add(new spinner_count(80,"546"));
        count.add(new spinner_count(81,"547"));
        count.add(new spinner_count(82,"548"));
        count.add(new spinner_count(83,"549"));
        count.add(new spinner_count(84,"564"));
        count.add(new spinner_count(85,"587"));
        count.add(new spinner_count(86,"614"));
        count.add(new spinner_count(87,"621"));
        count.add(new spinner_count(88,"645"));
        count.add(new spinner_count(89,"646"));
        count.add(new spinner_count(90,"647"));
        count.add(new spinner_count(91,"652"));
        count.add(new spinner_count(92,"654"));
        count.add(new spinner_count(93,"655"));
        count.add(new spinner_count(94,"657"));
        count.add(new spinner_count(95,"658"));
        count.add(new spinner_count(96,"674"));
        count.add(new spinner_count(97,"677"));
        count.add(new spinner_count(98,"698"));
        count.add(new spinner_count(99,"741"));
        count.add(new spinner_count(100,"784"));
        count.add(new spinner_count(101,"787"));
        count.add(new spinner_count(102,"789"));
        count.add(new spinner_count(103,"797"));
        count.add(new spinner_count(104,"854"));
        count.add(new spinner_count(105,"857"));
        count.add(new spinner_count(106,"879"));
        count.add(new spinner_count(107,"897"));
        count.add(new spinner_count(108,"958"));
        count.add(new spinner_count(109,"972"));
        count.add(new spinner_count(110,"982"));
        count.add(new spinner_count(111,"984"));
        count.add(new spinner_count(112,"987"));
        count.add(new spinner_count(113,"988"));



        // Creating adapter for spinner
        ArrayAdapter<spinner_count> dataAdaptercount = new ArrayAdapter<spinner_count>(this, android.R.layout.simple_spinner_dropdown_item, count);
        // Drop down layout style - list view with radio button
        dataAdaptercount.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinnercount.setAdapter(dataAdaptercount);

        spinnercount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                spinner_count count = (spinner_count) parent.getSelectedItem();
                ((TextView) parent.getChildAt(0)).setTextColor(Color.rgb(76, 156, 210));
                ((TextView) parent.getChildAt(0)).setTextSize(18);
                Toast.makeText(getApplicationContext(), " "+count.getId()+"\nSelected "+count.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}
