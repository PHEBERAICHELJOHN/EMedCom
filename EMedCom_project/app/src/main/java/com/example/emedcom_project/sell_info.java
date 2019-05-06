package com.example.emedcom_project;

public class sell_info {

    public String medname, compname,from,quantity,sell,usr_id,collection_center,exp_date,status,medicalstore_id;

    public sell_info(){
    }

    public sell_info(String medname, String compname, String medicalstore_id, String from, String quantity, String val, String usr_id, String collection_center, String exp_date, String status){
        this.medname=medname;
        this.compname=compname;
        this.medicalstore_id=medicalstore_id;
        this.from=from;
        this.quantity=quantity;
        sell=val;
        this.usr_id=usr_id;
        this.collection_center=collection_center;
        this.exp_date=exp_date;
        this.status=status;

    }
}
