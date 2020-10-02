package com.example.addfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.Addfoodbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,Page3.class);
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
                Intent intent =new Intent(MainActivity.this, Page4.class);
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
                Intent intent =new Intent(MainActivity.this, SearchfoodPage1.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Search food details";


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
                Intent intent =new Intent(MainActivity.this, DeleteFoods.class);
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