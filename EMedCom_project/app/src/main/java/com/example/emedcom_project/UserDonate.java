package com.example.emedcom_project;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class UserDonate extends AppCompatActivity {

    EditText med_name,com_name,from,quantity,exp_date;
    Button donate;

    Calendar mCurrentDate;
    int day, month, year;


    private FirebaseAuth firebaseAuth;
    FirebaseDatabase mDatabase;
    DatabaseReference mDb,mDbUSer,mDbUser_update;
    FirebaseAuth.AuthStateListener Authlistener;

    String userDist,usr_id,tet;
    String userKey;
    String medname,frm,qnty,sell_sell,expdate;
    String compname,type,ph_num,name;
    Integer balance;
    userData usr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_donate);



        med_name = (EditText) findViewById(R.id.med_name);
        com_name = (EditText) findViewById(R.id.com_name);
        from = (EditText) findViewById(R.id.from);
        quantity = (EditText) findViewById(R.id.quantity);
        exp_date=(EditText) findViewById(R.id.med_expiry) ;
        donate = (Button) findViewById(R.id.btnSell);

        mCurrentDate = Calendar.getInstance();
        day = mCurrentDate.get(Calendar.DAY_OF_MONTH);
        month = mCurrentDate.get(Calendar.MONTH);
        year = mCurrentDate.get(Calendar.YEAR);

        month = month+1;
        //  exp_date.setText(day+"/"+month+"/"+year);


        exp_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(UserDonate.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        monthOfYear = monthOfYear+1;
                        exp_date.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                    }
                },year, month, day);
                datePickerDialog.show();
            }
        });



        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mDb = mDatabase.getReference();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        userKey = user.getUid();
        tet=user.getEmail();
        usr=new userData();
        mDbUSer=FirebaseDatabase.getInstance().getReference("registration");
        mDbUSer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for( DataSnapshot ds: dataSnapshot.getChildren()){
                    usr = ds.getValue(userData.class);
                    //userDist = ds.getValue().toString();
                    if(usr.getEmail().equals(tet)){
                        userDist = usr.getDistrict();
                        type=usr.getUser_type();
                        name=usr.getName();
                        ph_num=usr.getPhone();
                        balance=usr.getBalance();
                        Toast.makeText(getApplicationContext(), "Hello" + " " +name+ " "+type, Toast.LENGTH_SHORT).show();
                        break;}
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



//////////////////////////////////////////////////////////////////



        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                medname = med_name.getText().toString();
                compname = com_name.getText().toString();
                frm = from.getText().toString();
                qnty = quantity.getText().toString();
                expdate = exp_date.getText().toString();

                if (medname.isEmpty() || compname.isEmpty() || frm.isEmpty() || qnty.isEmpty() || expdate.isEmpty()) {
                    showMessage("Please verify all fields");

                } else {
                    sell_sell = "No";
                    String status="Save";
                    ////////////////////////////////////////////////////////////////////////////////////////////////////////
                    String temporary_data="abc";
                    usr_id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    final sell_info info = new sell_info(
                            medname,
                            compname,
                            temporary_data,
                            frm,
                            qnty,
                            sell_sell,
                            usr_id,
                            userDist,
                            expdate,
                            status
                    );
                    Long tsLong = System.currentTimeMillis() / 1000;
                    final String ts = tsLong.toString();

                    FirebaseDatabase.getInstance().getReference("Collection_donate_details").child(userDist)
                            .child(usr_id+medname)
                            .setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {

                                Toast.makeText(getApplicationContext(), "Medicine Name : " + medname + "\nGeneric Name : " + compname, Toast.LENGTH_SHORT).show();
                                showMessage(medname);

                                Intent home = new Intent(getApplicationContext(), Home.class);
                                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(home);

                            } else {
                                showMessage("Not Saved");
                                Toast.makeText(UserDonate.this, task.getException().getMessage(),
                                        Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }
            }
        });



    }


    private void showMessage(String message) {

        Toast.makeText(getApplicationContext(), message,Toast.LENGTH_LONG).show();

    }
}

