package com.example.orderus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity16 extends AppCompatActivity {

    EditText txtType, txtNo, txtDes, txtPrice, txtSp, txtSports, txtRef, txtBoat, txtSight;
    Button btn;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);


        txtType = findViewById(R.id.uTp);
        txtNo = findViewById(R.id.uN);
        txtDes = findViewById(R.id.uDe);
        txtPrice = findViewById(R.id.uP);
        txtSp = findViewById(R.id.uS);
        txtSports = findViewById(R.id.uSp);
        txtRef = findViewById(R.id.uR);
        txtBoat = findViewById(R.id.uB);
        txtSight  = findViewById(R.id.uSi);
        btn = findViewById(R.id.btn);




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


                dbRef = FirebaseDatabase.getInstance().getReference().child("Rooms");

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


                dbRef.child("room1").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(),"Successfully Updated ",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(),MainActivity15.class);
                        startActivity(i);
                    }
                });



            }
        });



    }
}