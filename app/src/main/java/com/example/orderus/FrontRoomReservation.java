package com.example.orderus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrontRoomReservation extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_room_reservation);

        btn = findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(FrontRoomReservation.this, PaymentFood.class);
                startActivity(intent);

            }
        });
    }
}