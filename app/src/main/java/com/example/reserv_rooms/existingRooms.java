package com.example.reserv_rooms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class existingRooms extends AppCompatActivity {
    TextView txtType, txtNo, txtDes, txtPrice, txtSp, txtSports, txtRef, txtBoat, txtSight;
    Button updateRoomBtn, DeleteBtn;
    DatabaseReference databaseRoomDetails;

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
        updateRoomBtn = findViewById(R.id.updateRoomBtn);
        DeleteBtn = findViewById(R.id.DeleteBtn);



       /* String type = getIntent().getStringExtra("type");
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


        */


        DatabaseReference databaseRoomDetails = FirebaseDatabase.getInstance().getReference().child("Rooms").child("room1");
        databaseRoomDetails.addListenerForSingleValueEvent(new ValueEventListener() {
                                                               @Override
                                                               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                   if (dataSnapshot.hasChildren()) {
                                                                       txtType.setText(dataSnapshot.child("type").getValue().toString());
                                                                       txtNo.setText(dataSnapshot.child("no").getValue().toString());
                                                                       txtDes.setText(dataSnapshot.child("des").getValue().toString());
                                                                       txtPrice.setText(dataSnapshot.child("price").getValue().toString());
                                                                       txtSp.setText(dataSnapshot.child("sp").getValue().toString());
                                                                       txtSports.setText(dataSnapshot.child("sports").getValue().toString());
                                                                       txtRef.setText(dataSnapshot.child("ref").getValue().toString());
                                                                       txtBoat.setText(dataSnapshot.child("boat").getValue().toString());
                                                                       txtSight.setText(dataSnapshot.child("sight").getValue().toString());


                                                                   } else {
                                                                       Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_LONG).show();
                                                                   }
                                                               }

                                                               @Override
                                                               public void onCancelled(@NonNull DatabaseError databaseError) {

                                                               }
                                                           });




        updateRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String upType = txtType.getText().toString();
                String upNo = txtNo.getText().toString();
                String upDes = txtDes.getText().toString();
                String upPrice = txtPrice.getText().toString();
                String upSp = txtSp.getText().toString();
                String upSports = txtSports.getText().toString();
                String upRef = txtRef.getText().toString();
                String upBoat = txtBoat.getText().toString();
                String upSight = txtSight.getText().toString();

                Intent i = new Intent(getApplicationContext(), updateRooms.class);

                i.putExtra("uType", upType);
                i.putExtra("uNo", upNo);
                i.putExtra("uDes", upDes);
                i.putExtra("uPrice", upPrice);
                i.putExtra("uSp", upSp);
                i.putExtra("uSports", upSports);
                i.putExtra("uRef", upRef);
                i.putExtra("uBoat", upBoat);
                i.putExtra("uSight", upSight);

                startActivity(i);
            }
        });



        DeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference[] databaseRoomDetails ={FirebaseDatabase.getInstance().getReference().child("Rooms")};
                databaseRoomDetails[0].addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("room1")){
                            databaseRoomDetails[0] = FirebaseDatabase.getInstance().getReference().child("Rooms").child("room1");
                            databaseRoomDetails[0].removeValue();
                            Toast.makeText(getApplicationContext(),"Data deleted successfully",Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getApplicationContext(),"No source to delete ",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });


    }




}