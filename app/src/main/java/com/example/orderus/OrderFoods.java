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

public class OrderFoods extends AppCompatActivity {

    EditText txtId, txtName, txtAdd, txtNum, txtMail, txtOwn;
    Button btnAdd,btnView;
    DatabaseReference dbRef;
    PlaceOrder po;

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
        setContentView(R.layout.activity_order_foods);

        txtId = findViewById(R.id.ID);
        txtName = findViewById(R.id.name);
        txtAdd = findViewById(R.id.address);
        txtNum = findViewById(R.id.phone);
        txtMail = findViewById(R.id.email);
        txtOwn = findViewById(R.id.textfor);


        btnView = findViewById(R.id.button4);

        po = new PlaceOrder();
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Order");

                try {
                    if (TextUtils.isEmpty(txtId.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a contact number", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtAdd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter an Address", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtNum.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter an quantity",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtMail.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter food size",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtOwn.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter special notes",Toast.LENGTH_SHORT).show();
                    else {
                        po.setId(txtId.getText().toString().trim());
                        po.setName(txtName.getText().toString().trim());
                        po.setAddress(txtAdd.getText().toString().trim());
                        po.setQuantity(Integer.parseInt(txtNum.getText().toString().trim()));
                        po.setSize(txtMail.getText().toString().trim());
                        po.setNotes(Integer.parseInt(txtOwn.getText().toString().trim()));

                        // dbRef.push().setValue(emp);
                        dbRef.child("ord1").setValue(po);

                        Toast.makeText(getApplicationContext(), "data saved successfully", Toast.LENGTH_SHORT).show();


                        String data1 = txtId.getText().toString();
                        String data2 = txtName.getText().toString();
                        String data3 = txtAdd.getText().toString();
                        String data4 = txtNum.getText().toString();
                        String data5 = txtMail.getText().toString();
                        String data6 = txtOwn.getText().toString();

                        Intent i = new Intent(getApplicationContext(),PaymentFood.class);
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



    }
}