package com.example.orderus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class MainActivity5 extends AppCompatActivity {
    TextView txtId,txtName,txtAdd,txtNum,txtMail,txtOwn;
    DatabaseReference dbRef;
   private Button button18,but9,but8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        txtId = findViewById(R.id.tid);
        txtName = findViewById(R.id.tna);
        txtAdd = findViewById(R.id.tad);
        txtNum = findViewById(R.id.tnu);
        txtMail = findViewById(R.id.tem);
        txtOwn = findViewById(R.id.tow);

        String id = getIntent().getStringExtra("id");
        String nm = getIntent().getStringExtra("nm");
        String ad = getIntent().getStringExtra("ad");
        String ph = getIntent().getStringExtra("ph");
        String em = getIntent().getStringExtra("em");
        String ow = getIntent().getStringExtra("ow");

        txtId.setText(id);
        txtName.setText(nm);
        txtAdd.setText(ad);
        txtNum.setText(ph);
        txtMail.setText(em);
        txtOwn.setText(ow);


        button18 = findViewById(R.id.button18);
        but8 = findViewById(R.id.button8);
        but9 = findViewById(R.id.button9);


        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data2 = txtName.getText().toString();

                Intent i = new Intent(getApplicationContext(), MainActivity8.class);
                clearControls();

                i.putExtra("nm", data2);

                startActivity(i);
            }

            private void clearControls() {
            }
        });


        but8 = findViewById(R.id.button8);
        but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity13();
            }
        });



        but9 = findViewById(R.id.button9);
        but9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity14();
            }
        });
    }
        public void openMainActivity13() {
            Intent intent = new Intent(this, MainActivity13.class);
            startActivity(intent);
        }

    public void openMainActivity14() {
        Intent intent = new Intent(this, FoodHomePage.class);
        startActivity(intent);
    }

    }





