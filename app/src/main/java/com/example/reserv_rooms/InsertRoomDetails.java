package com.example.reserv_rooms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class InsertRoomDetails extends AppCompatActivity {


    EditText type, no, des, price, sp, sports, ref, boat, sight;
    Button addRoomBtn;

    DatabaseReference databaseRoomDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_room_details);

        databaseRoomDetails = FirebaseDatabase.getInstance().getReference("insertRooms");


        type = (EditText) findViewById(R.id.type);
        no = (EditText) findViewById(R.id.no);
        des = (EditText) findViewById(R.id.des);
        price = (EditText) findViewById(R.id.price);
        sp = (EditText) findViewById(R.id.sp);
        sports = (EditText) findViewById(R.id.sports);
        ref = (EditText) findViewById(R.id.ref);
        boat = (EditText) findViewById(R.id.boat);
        sight = (EditText) findViewById(R.id.sight);
        addRoomBtn = (Button) findViewById(R.id.addRoomBtn);

        addRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addRoom();
            }
        });

    }
    private void addRoom(){
        String roomType = type.getText().toString().trim();
        String roomNo = no.getText().toString().trim();
        String roomDes = des.getText().toString().trim();
        String roomPrice = price.getText().toString().trim();
        String roomSp = sp.getText().toString().trim();
        String roomSports = sports.getText().toString().trim();
        String roomRef = ref.getText().toString().trim();
        String roomBoat = boat.getText().toString().trim();
        String roomSight = sight.getText().toString().trim();

        if(!TextUtils.isEmpty(roomType) && !TextUtils.isEmpty(roomNo) && !TextUtils.isEmpty(roomDes) && !TextUtils.isEmpty(roomPrice) && !TextUtils.isEmpty(roomSp) && !TextUtils.isEmpty(roomSports) && !TextUtils.isEmpty(roomRef) && !TextUtils.isEmpty(roomBoat) && !TextUtils.isEmpty(roomSight)){

            String id = databaseRoomDetails.push().getKey();

            roomDet roomDetObj = new roomDet(id,  roomType, roomNo, roomDes, roomPrice, roomSp, roomSports, roomRef, roomBoat, roomSight);
            databaseRoomDetails.child("ins_room").setValue(roomDetObj);

            Toast.makeText(this,"Room Added Successfully", Toast.LENGTH_LONG).show();
        }

        else{
            Toast.makeText(this, "Please fill out the form", Toast.LENGTH_LONG).show();
        }


        String data1 = type.getText().toString();
        String data2 = no.getText().toString();
        String data3 = des.getText().toString();
        String data4 = price.getText().toString();
        String data5 = sp.getText().toString();
        String data6 = sports.getText().toString();
        String data7 = ref.getText().toString();
        String data8 = boat.getText().toString();
        String data9 = sight.getText().toString();

        Intent intent = new Intent(getApplicationContext(), existingRooms.class);

        intent.putExtra("type", data1);
        intent.putExtra("no", data2);


}
}