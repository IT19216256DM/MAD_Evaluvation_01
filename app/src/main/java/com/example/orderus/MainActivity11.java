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

public class MainActivity11 extends AppCompatActivity {


    EditText fname, lname, passwrd, confpass, email, mobile;
    Button Register;
    DatabaseReference dbRef;
    SingIn sig;

    private void clearControls() {
        fname.setText("");
        lname.setText("");
        passwrd.setText("");
        confpass.setText("");
        email.setText("");
        mobile.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        fname = findViewById(R.id.ID);
        lname = findViewById(R.id.name);
        passwrd = findViewById(R.id.address);
        confpass = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        mobile = findViewById(R.id.textfor);

        Register = findViewById(R.id.button4);

        sig = new SingIn();
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("SingIn");

                try {
                    if (TextUtils.isEmpty(fname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a first name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(lname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a last name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(passwrd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a password", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(confpass.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a password again", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(email.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Email", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(mobile.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter  Contact Number", Toast.LENGTH_SHORT).show();
                    else {
                        sig.setFname(fname.getText().toString().trim());
                        sig.setLname(lname.getText().toString().trim());
                        sig.setPasswrd(passwrd.getText().toString().trim());
                        sig.setConfpass(Integer.parseInt(confpass.getText().toString().trim()));
                        sig.setEmail(email.getText().toString().trim());
                        sig.setMobile(Integer.parseInt(mobile.getText().toString().trim()));

                        // dbRef.push().setValue(emp);
                        dbRef.child("Emp1").setValue(sig);

                        Toast.makeText(getApplicationContext(), "data saved successfully", Toast.LENGTH_SHORT).show();


                        Intent i = new Intent(getApplicationContext(), MainActivity8.class);
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

