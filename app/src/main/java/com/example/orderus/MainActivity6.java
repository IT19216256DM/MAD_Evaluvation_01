package com.example.orderus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity6 extends AppCompatActivity {

    EditText txtUser, txtPass;
    Button btnlog;
    DatabaseReference dbRef;
    Login log;

    private void clearControls() {
        txtUser.setText("");
        txtPass.setText("");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        txtUser = findViewById(R.id.uname);
        txtPass = findViewById(R.id.pass);

        btnlog = findViewById(R.id.button17);

        log = new Login();

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Login");

                try {
                    if (TextUtils.isEmpty(txtUser.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter an User name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtPass.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a Password", Toast.LENGTH_SHORT).show();
                    else {
                        log.setTxtUser(txtUser.getText().toString().trim());
                        log.setTxtPass(txtPass.getText().toString().trim());

                        dbRef.child("Emp1").setValue(log);

                        Toast.makeText(getApplicationContext(), "data saved successfully", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(getApplicationContext(),MainMenu.class);
                        startActivity(i);
                        clearControls();

                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}