package com.example.addfoods;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;


public class Page5 extends AppCompatActivity {

    TextView iteamno,title, author, price, preparation, cook, total;
    DatabaseReference dbRef;
    private  Button buteditdata,butsave;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);
//
//        button = (Button) findViewById(R.id.button4);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(Page5.this,Page4.class);
//                startActivity(intent);
//            }
//        });

        butsave = (Button) findViewById(R.id.buttonsavedetails);
        butsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Page5.this,MainActivity.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Back to home page";


                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
                toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
            }
        });

        iteamno = findViewById(R.id.viewId);
        title = findViewById(R.id.viewtitle);
        price = findViewById(R.id.viewPrice);
        author = findViewById(R.id.viewauthor);
        preparation = findViewById(R.id.viewPreparationtime);
        cook = findViewById(R.id.viewCooktime);
        total = findViewById(R.id.viewTotaltime);
        

        String id = getIntent().getStringExtra("id");
        String ti = getIntent().getStringExtra("ti");
        String pr = getIntent().getStringExtra("pr");
        String au = getIntent().getStringExtra("au");
        String pt = getIntent().getStringExtra("pt");
        String co = getIntent().getStringExtra("co");
        String to = getIntent().getStringExtra("to");

        title.setText(ti);
        author.setText(au);
        price.setText(pr);
        iteamno.setText(id);
        preparation.setText(pt);
        cook.setText(co);
        total.setText(to);

        buteditdata = findViewById(R.id.btneditdata);
        buteditdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data1 = iteamno.getText().toString();
                String data2 = title.getText().toString();
                String data3 = price.getText().toString();
                String data4 = author.getText().toString();
                String data5 = preparation.getText().toString();
                String data6 = cook.getText().toString();
                String data7 = total.getText().toString();

                Intent i = new Intent(getApplicationContext(), Page4.class);
                clearControls();
                
                i.putExtra("id", data1);
                i.putExtra("ti", data2);
                i.putExtra("pr", data3);
                i.putExtra("au", data4);
                i.putExtra("pt", data5);
                i.putExtra("co", data6);
                i.putExtra("to", data7);

                startActivity(i);
            }
            

            });

        }

    private void clearControls() {
    }
}