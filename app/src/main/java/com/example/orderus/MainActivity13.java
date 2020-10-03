package com.example.orderus;

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

public class MainActivity13 extends AppCompatActivity {


    EditText type, no, des, price, sp, sports, ref, boat, sight;
    Button addRoomBtn;

    DatabaseReference dbRef;

    roomDet detRoom;

    private void clearControls() {
        type.setText("");
        no.setText("");
        des.setText("");
        price.setText("");
        sp.setText("");
        sports.setText("");
        ref.setText("");
        boat.setText("");
        sight.setText("");}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);

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

        detRoom = new roomDet();

        addRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("Rooms");

                try {

                    if (TextUtils.isEmpty(type.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Enter the room type", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(no.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Enter the No of rooms", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(des.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Enter a description", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(price.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Enter price", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(sp.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Enter the swimming pool details", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(sports.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Enter the sports details", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(ref.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Enter the swimming refrigerator details", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(boat.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Enter the boat ride details", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(sight.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Enter the sightseeing details", Toast.LENGTH_SHORT).show();
                    else {
                        detRoom.setType(type.getText().toString().trim());
                        detRoom.setNo(no.getText().toString().trim());
                        detRoom.setDes(des.getText().toString().trim());
                        detRoom.setPrice(price.getText().toString().trim());
                        detRoom.setSp(sp.getText().toString().trim());
                        detRoom.setSports(sports.getText().toString().trim());
                        detRoom.setRef(ref.getText().toString().trim());
                        detRoom.setBoat(boat.getText().toString().trim());
                        detRoom.setSight(sight.getText().toString().trim());

                        //databaseRoomDetails.push().setValue(detRoom);
                        dbRef.child("room1").setValue(detRoom);
                        Toast.makeText(getApplicationContext(), "Data saved", Toast.LENGTH_SHORT).show();


                        String data1 = type.getText().toString();
                        String data2 = no.getText().toString();
                        String data3 = des.getText().toString();
                        String data4 = price.getText().toString();
                        String data5 = sp.getText().toString();
                        String data6 = sports.getText().toString();
                        String data7 = ref.getText().toString();
                        String data8 = boat.getText().toString();
                        String data9 = sight.getText().toString();

                        Intent intent = new Intent(getApplicationContext(), MainActivity15.class);
                        clearControls();

                        intent.putExtra("type", data1);
                        intent.putExtra("no", data2);
                        intent.putExtra("des", data3);
                        intent.putExtra("price", data4);
                        intent.putExtra("sp", data5);
                        intent.putExtra("sports", data6);
                        intent.putExtra("ref", data7);
                        intent.putExtra("boat", data8);
                        intent.putExtra("sight", data9);

                        startActivity(intent);
                    }
                } catch (NumberFormatException e) {

                    Toast.makeText(getApplicationContext(), "invalid", Toast.LENGTH_SHORT).show();
                }
            }

        });
    };

    }
