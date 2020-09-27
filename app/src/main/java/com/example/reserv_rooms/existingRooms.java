package com.example.reserv_rooms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class existingRooms extends AppCompatActivity {
    TextView txtType, txtNo, txtDes, txtPrice, txtSp, txtSports, txtRef, txtBoat, txtSight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_rooms);


        txtType = findViewById(R.id.txtType);
        txtNo = findViewById(R.id.txtNo);
        txtDes = findViewById(R.id.txtDet);
        txtPrice = findViewById(R.id.txtPrice);
        txtSp = findViewById(R.id.txtSp);
        txtSports = findViewById(R.id.txtSports);
        txtRef = findViewById(R.id.txtRef);
        txtBoat = findViewById(R.id.txtBoat);
        txtSight = findViewById(R.id.txtSight);


        String type = getIntent().getStringExtra("type");
        String no = getIntent().getStringExtra("no");
        String des = getIntent().getStringExtra("des");
        String price = getIntent().getStringExtra("price");
        String sp = getIntent().getStringExtra("sp");
        String sports = getIntent().getStringExtra("sports");
        String ref = getIntent().getStringExtra("ref");
        String boat = getIntent().getStringExtra("boat");
        String sight = getIntent().getStringExtra("sight");


        txtType.setText(type);
        txtNo.setText(no);
        txtDes.setText(des);
        txtPrice.setText(price);
        txtSp.setText(sp);
        txtSports.setText(sports);
        txtRef.setText(ref);
        txtBoat.setText(boat);
        txtSight.setText(sight);

    }
}