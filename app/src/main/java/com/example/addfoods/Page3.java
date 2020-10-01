package com.example.addfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Page3 extends AppCompatActivity {

    EditText txtIteamno,txtTitle, txtAuthor, txtPrice, txtPreparation, txtCook, txtTotal;
    Button butAdd;
    DatabaseReference dbRef;
    User usr;
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
        setContentView(R.layout.activity_page3);

//        button = (Button) findViewById(R.id.button3);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(Page3.this,Page5.class);
//                startActivity(intent);

        txtIteamno = findViewById(R.id.Etiteamno);
        txtTitle = findViewById(R.id.EtTitle);
        txtPrice = findViewById(R.id.Etprice);
        txtAuthor = findViewById(R.id.EtAuthor);
        txtPreparation = findViewById(R.id.Etpreparation);
        txtCook =  findViewById(R.id.Etcook);
        txtTotal = findViewById(R.id.Ettotal);

        butAdd = findViewById(R.id.button3);

        usr = new User();



//add data

        butAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("User");

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
                    usr.setTitle(txtTitle.getText().toString().trim());
                    usr.setAuthor(txtAuthor.getText().toString().trim());
                    usr.setPrice(Double.parseDouble(txtPrice.getText().toString().trim()));
                    usr.setIteamno(Integer.parseInt(txtIteamno.getText().toString().trim()));
                    usr.setCook(Double.parseDouble(txtCook.getText().toString().trim()));
                    usr.setPreparation(Double.parseDouble(txtPreparation.getText().toString().trim()));
                    usr.setTotal(Double.parseDouble(txtTotal.getText().toString().trim()));
                    //insert into the database
//                    dbRef.push().setValue(usr);
                    dbRef.child("Usr12").setValue(usr);
                    //feedback from database
                    Toast.makeText(getApplicationContext(),"Data saved successfully", Toast.LENGTH_SHORT).show();

                    String data1 = txtIteamno.getText().toString();
                    String data2 = txtTitle.getText().toString();
                    String data3 = txtPrice.getText().toString();
                    String data4 = txtAuthor.getText().toString();
                    String data5 = txtPreparation.getText().toString();
                    String data6 = txtCook.getText().toString();
                    String data7 = txtTotal.getText().toString();
//
                    Intent i = new Intent(getApplicationContext(),Page5.class);
                    clearControls();
//
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
//    private void clearControls(){
//        txtTitle.setText("");
//        txtAuthor.setText("");
//        txtPrice.setText("");
//        txtServings.setText("");
//        txtCook.setText("");
//        txtPreparation.setText("");
//        txtTotal.setText("");
//    }
}


