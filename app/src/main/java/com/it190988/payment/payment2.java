package com.it190988.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class payment2 extends AppCompatActivity {
    TextView txtCardNum,txtExpirydate,txtcVV,txtcardHoldername;
    DatabaseReference dbRef;
    private Button deletePayBtn,viewPayBtn,updatePayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment2);

    }
}