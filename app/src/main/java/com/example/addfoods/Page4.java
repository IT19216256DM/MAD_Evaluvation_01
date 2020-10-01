package com.example.addfoods;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class Page4 extends AppCompatActivity {


    //    EditText a,b,c,d,e,f,g;
    EditText id, title, author, price, preparation, cook, total;
    DatabaseReference dbRef;
    Button btn;
    User usr;

    private String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        id = findViewById(R.id.details1);
        title = findViewById(R.id.details2);
        price = findViewById(R.id.details3);
        author = findViewById(R.id.details4);
        preparation = findViewById(R.id.details5);
        cook = findViewById(R.id.details6);
        total = findViewById(R.id.details7);

        btn = findViewById(R.id.btnupdatedata);
        usr = new User();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference();
                usr.setID(id.getText().toString().trim());
                ID = usr.getID();



            }
        });



    }
}