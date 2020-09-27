package com.example.orderus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {


    EditText txtId, txtName, txtAdd, txtNum, txtMail, txtOwn;
    Button btnAdd,btnViwe;
    DatabaseReference dbRef;
    Employee emp;

    private void clearControls() {
        txtId.setText("");
        txtName.setText("");
        txtAdd.setText("");
        txtNum.setText("");
        txtMail.setText("");
        txtOwn.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        txtId = findViewById(R.id.ID);
        txtName = findViewById(R.id.name);
        txtAdd = findViewById(R.id.address);
        txtNum = findViewById(R.id.phone);
        txtMail = findViewById(R.id.email);
        txtOwn = findViewById(R.id.textfor);

        btnAdd = findViewById(R.id.button5);
        btnViwe = findViewById(R.id.button4);

        emp = new Employee();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Employee");

                try {
                    if (TextUtils.isEmpty(txtId.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter an ID", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtAdd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter an Address", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtNum.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a phone Number",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtMail.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter Email",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtOwn.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter Owners Contact Number",Toast.LENGTH_SHORT).show();
                    else {
                        emp.setTxtId(txtId.getText().toString().trim());
                        emp.setTxtName(txtName.getText().toString().trim());
                        emp.setTxtAdd(txtAdd.getText().toString().trim());
                        emp.setTxtNum(Integer.parseInt(txtNum.getText().toString().trim()));
                        emp.setTxtMail(txtMail.getText().toString().trim());
                        emp.setTxtOwn(Integer.parseInt(txtOwn.getText().toString().trim()));

                       // dbRef.push().setValue(emp);
                        dbRef.child("Emp1").setValue(emp);

                        Toast.makeText(getApplicationContext(), "data saved successfully", Toast.LENGTH_SHORT).show();


                        String data1 = txtId.getText().toString();
                        String data2 = txtName.getText().toString();
                        String data3 = txtAdd.getText().toString();
                        String data4 = txtNum.getText().toString();
                        String data5 = txtMail.getText().toString();
                        String data6 = txtOwn.getText().toString();

                        Intent i = new Intent(getApplicationContext(),MainActivity5.class);
                        clearControls();

                        i.putExtra("id",data1);
                        i.putExtra("nm",data2);
                        i.putExtra("ad",data3);
                        i.putExtra("ph",data4);
                        i.putExtra("em",data5);
                        i.putExtra("ow",data6);

                        startActivity(i);








                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
                }


            }
        });



        };
    }

