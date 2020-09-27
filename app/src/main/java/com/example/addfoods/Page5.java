package com.example.addfoods;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;


public class Page5 extends AppCompatActivity {

    TextView title, author, price, servings, preparation, cook, total;
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

        butsave = (Button) findViewById(R.id.buttonsave);
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

        title = findViewById(R.id.viewTitle);
        author = findViewById(R.id.viewAuthor);
        price = findViewById(R.id.viewPrice);
        servings = findViewById(R.id.viewServings);
        preparation = findViewById(R.id.viewPreparationtime);
        cook = findViewById(R.id.viewCooktime);
        total = findViewById(R.id.viewTotaltime);
        

        String ti = getIntent().getStringExtra("ti");
        String au = getIntent().getStringExtra("au");
        String pr = getIntent().getStringExtra("pr");
        String se = getIntent().getStringExtra("se");
        String pt = getIntent().getStringExtra("pt");
        String co = getIntent().getStringExtra("co");
        String to = getIntent().getStringExtra("to");

        title.setText(ti);
        author.setText(au);
        price.setText(pr);
        servings.setText(se);
        preparation.setText(pt);
        cook.setText(co);
        total.setText(to);

        buteditdata = findViewById(R.id.buttonedit);
        buteditdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data1 = title.getText().toString();
                String data2 = author.getText().toString();
                String data3 = price.getText().toString();
                String data4 = servings.getText().toString();
                String data5 = preparation.getText().toString();
                String data6 = cook.getText().toString();
                String data7 = total.getText().toString();

                Intent i = new Intent(getApplicationContext(), Page4.class);
                clearControls();
                
                i.putExtra("ti", data1);
                i.putExtra("au", data2);
                i.putExtra("pr", data3);
                i.putExtra("se", data4);
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