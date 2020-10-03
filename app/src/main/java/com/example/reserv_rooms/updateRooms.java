package com.example.reserv_rooms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class updateRooms extends AppCompatActivity {
    TextView txtType, txtNo, txtDes, txtPrice, txtSp, txtSports, txtRef, txtBoat, txtSight;
    Button btn;
    DatabaseReference databaseRoomDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_rooms);


        txtType = findViewById(R.id.uType);
        txtNo = findViewById(R.id.uNo);
         txtDes = findViewById(R.id.uDes);
         txtPrice = findViewById(R.id.uPrice);
         txtSp = findViewById(R.id.uSp);
         txtSports = findViewById(R.id.uSports);
         txtRef = findViewById(R.id.uRef);
         txtBoat = findViewById(R.id.uBoat);
         txtSight  = findViewById(R.id.uSight);
         btn = findViewById(R.id.roomUpdateBtn);

         String idd = getIntent().getStringExtra("idd");
        String nmm = getIntent().getStringExtra("nmm");
        String ade = getIntent().getStringExtra("ade");
        String pht = getIntent().getStringExtra("pht");
        String eml = getIntent().getStringExtra("eml");
        String own = getIntent().getStringExtra("own");
        String api = getIntent().getStringExtra("api");
        String nul = getIntent().getStringExtra("nul");
        String hel = getIntent().getStringExtra("hel");


        txtType.setText(idd);
        txtNo.setText(nmm);
        txtDes.setText(ade);
        txtPrice.setText(pht);
        txtSp.setText(eml);
        txtSports.setText(own);
        txtRef.setText(api);
        txtBoat.setText(nul);
        txtSight.setText(hel);






    }
}