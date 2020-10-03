package com.example.orderus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FoodHomePage extends AppCompatActivity {
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);



        button = (Button) findViewById(R.id.Addfoodbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(FoodHomePage.this, FoodInsertPage.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Add food details";


                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
                toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
            }
        });

        //2nd btn
        button = (Button) findViewById(R.id.Editfoodbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(FoodHomePage.this, EditFoodPage.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Edit food details";


                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
                toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
            }
        });

        //3rd button
        button = (Button) findViewById(R.id.Myfoodbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(FoodHomePage.this, SearchFoodPage.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Order foods";


                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
                toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
            }
        });

        button = (Button) findViewById(R.id.Deletefoodbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(FoodHomePage.this, DeleteFoodPage.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Delete food details";


                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
                toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
            }
        });


    }


}