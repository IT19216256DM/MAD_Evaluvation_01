package com.example.addfoods;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;


public class Page5 extends AppCompatActivity {

    TextView title, author, price, servings, preparation, cook, total;
    DatabaseReference dbRef;
    private  Button butsub;
    
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

        butsub = findViewById(R.id.buttonedit);
        butsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data1 = title.getText().toString();
                String data2 = author.getText().toString();
                String data3 = price.getText().toString();
                String data4 = servings.getText().toString();
                String data5 = preparation.getText().toString();
                String data6 = cook.getText().toString();
                String data7 = total.getText().toString();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
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