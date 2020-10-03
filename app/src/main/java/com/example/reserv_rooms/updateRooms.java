package com.example.reserv_rooms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

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


         String type = getIntent().getStringExtra("type");
        String no = getIntent().getStringExtra("no");
        String des= getIntent().getStringExtra("des");
        String price = getIntent().getStringExtra("price");
        String sp = getIntent().getStringExtra("sp");
        String sports = getIntent().getStringExtra("sports");
        String ref = getIntent().getStringExtra("ref");
        String boat = getIntent().getStringExtra("boat");
        String sight= getIntent().getStringExtra("sight");


        txtType.setText(type);
        txtNo.setText(no);
        txtDes.setText(des);
        txtPrice.setText(price);
        txtSp.setText(sp);
        txtSports.setText(sports);
        txtRef.setText(ref);
        txtBoat.setText(boat);
        txtSight.setText(sight);








        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = txtType.getText().toString();
                String b = txtNo.getText().toString();
                String c = txtDes.getText().toString();
                String d = txtPrice.getText().toString();
                String e = txtSp.getText().toString();
                String f = txtSports.getText().toString();
                String g = txtRef.getText().toString();
                String h = txtBoat.getText().toString();
                String i = txtSight.getText().toString();


                databaseRoomDetails = FirebaseDatabase.getInstance().getReference().child("Rooms");

                HashMap hashMap = new HashMap();

                hashMap.put("type",a);
                hashMap.put("no",b);
                hashMap.put("des",c);
                hashMap.put("price",d);
                hashMap.put("sp",e);
                hashMap.put("sports",f);
                hashMap.put("ref",g);
                hashMap.put("boat",h);
                hashMap.put("sight",i);


                databaseRoomDetails.child("room1").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(),"Successfully Updated ",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(),existingRooms.class);
                        startActivity(i);
                    }
                });



            }
        });






    }
}