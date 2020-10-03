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

public class FoodInsertPage extends AppCompatActivity {

    EditText txtIteamno,txtTitle, txtAuthor, txtPrice, txtPreparation, txtCook, txtTotal;
    Button butAdd;
    DatabaseReference dbRef;
    Food fd;
    private String ID;
//    public Button button;

    private void clearControls(){
        txtIteamno.setText("");
        txtTitle.setText("");
        txtAuthor.setText("");
        txtPrice.setText("");
        txtCook.setText("");
        txtPreparation.setText("");
        txtTotal.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_food_page);

        txtIteamno = findViewById(R.id.Etiteamno);
        txtTitle = findViewById(R.id.EtTitle);
        txtPrice = findViewById(R.id.Etprice);
        txtAuthor = findViewById(R.id.EtAuthor);
        txtPreparation = findViewById(R.id.Etpreparation);
        txtCook =  findViewById(R.id.Etcook);
        txtTotal = findViewById(R.id.Ettotal);

        butAdd = findViewById(R.id.button3);

        fd = new Food();



//add data

        butAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("Food");

                if (TextUtils.isEmpty(txtTitle.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Empty title", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(txtAuthor.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Empty author", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(txtPrice.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Empty price", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(txtIteamno.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Empty iteam no", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(txtCook.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Empty cook time", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(txtPreparation.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Empty preparation time", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(txtTotal.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Empty total time", Toast.LENGTH_SHORT).show();
                else {
                    fd.setTitle(txtTitle.getText().toString().trim());
                    fd.setAuthor(txtAuthor.getText().toString().trim());
                    fd.setPrice(Double.parseDouble(txtPrice.getText().toString().trim()));
                    fd.setID(txtIteamno.getText().toString().trim());
                    fd.setCook(Double.parseDouble(txtCook.getText().toString().trim()));
                    fd.setPreparation(Double.parseDouble(txtPreparation.getText().toString().trim()));
                    fd.setTotal(Double.parseDouble(txtTotal.getText().toString().trim()));
                    //insert into the database
//                    dbRef.push().setValue(usr);
                    ID = fd.getID();
                    dbRef.child(ID).setValue(fd);
                    //feedback from database
                    Toast.makeText(getApplicationContext(),"Data saved successfully", Toast.LENGTH_SHORT).show();

                    String data1 = txtIteamno.getText().toString();
                    String data2 = txtTitle.getText().toString();
                    String data3 = txtPrice.getText().toString();
                    String data4 = txtAuthor.getText().toString();
                    String data5 = txtPreparation.getText().toString();
                    String data6 = txtCook.getText().toString();
                    String data7 = txtTotal.getText().toString();

                    Intent i = new Intent(getApplicationContext(), FoodRetrievePage.class);
                    clearControls();

                    i.putExtra("id",data1);
                    i.putExtra("ti",data2);
                    i.putExtra("pr",data3);
                    i.putExtra("au",data4);
                    i.putExtra("pt",data5);
                    i.putExtra("co",data6);
                    i.putExtra("to",data7);

                    startActivity(i);
                }


            }


        });
    }
}