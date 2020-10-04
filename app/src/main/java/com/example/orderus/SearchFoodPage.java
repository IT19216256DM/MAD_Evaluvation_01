package com.example.orderus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchFoodPage extends AppCompatActivity {


    private Button but1;
    private Button but2;
    private Button but3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_food_page);


        but1 = findViewById(R.id.btnsoldout);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrderFoods();
            }
        });

        but2 = (Button) findViewById(R.id.btnorder1);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrderFoods();
            }

        });

        but3 = findViewById(R.id.btnorder2);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrderFoods();
            }
        });
    }

    public void openOrderFoods() {
        Intent intent = new Intent(this, OrderFoods.class);
        startActivity(intent);
    }




    }
