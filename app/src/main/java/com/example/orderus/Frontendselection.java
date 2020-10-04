package com.example.orderus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Frontendselection extends AppCompatActivity {


    private Button button3;
    private Button button17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontendselection);


        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFoodHomePage();
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFoodHomePage();
            }

        });

        button17 = findViewById(R.id.button17);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFrontRoomReservation();
            }
        });
    }

    public void openFoodHomePage() {
        Intent intent = new Intent(this, FoodHomePage.class);
        startActivity(intent);
    }

    public void openFrontRoomReservation(){
        Intent intent = new Intent(this, FrontRoomReservation.class);
        startActivity(intent);
    }
}