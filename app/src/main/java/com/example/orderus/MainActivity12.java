package com.example.orderus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity12 extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        btn1 = findViewById(R.id.button12);
        btn2 = findViewById(R.id.button13);
        btn3 = findViewById(R.id.button14);
        btn4 = findViewById(R.id.button15);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Frontendselection.class);
                startActivity(i);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Frontendselection.class);
                startActivity(i);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Frontendselection.class);
                startActivity(i);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Frontendselection.class);
                startActivity(i);
            }
        });
    }



}