package com.example.orderus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class MainActivity8 extends AppCompatActivity {

    TextView txtName;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        txtName = findViewById(R.id.textView5);

        String nm = getIntent().getStringExtra("nm");


        txtName.setText(nm);
    }
}