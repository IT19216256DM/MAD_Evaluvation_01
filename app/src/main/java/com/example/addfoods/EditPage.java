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



public class EditPage extends AppCompatActivity {

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

                dbRef.child("User").child(ID).child("author").setValue(author.getText().toString().trim());
                dbRef.child("User").child(ID).child("cook").setValue(Double.parseDouble(cook.getText().toString().trim()));
                dbRef.child("User").child(ID).child("id").setValue(id.getText().toString().trim());
                dbRef.child("User").child(ID).child("preparation").setValue(Double.parseDouble(preparation.getText().toString().trim()));
                dbRef.child("User").child(ID).child("price").setValue(Double.parseDouble(price.getText().toString().trim()));
                dbRef.child("User").child(ID).child("title").setValue(title.getText().toString().trim());
                dbRef.child("User").child(ID).child("total").setValue(Double.parseDouble(total.getText().toString().trim()));

                Toast.makeText(getApplicationContext(),"Updated Successfully", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(EditPage.this, MainActivity.class);
                startActivity(intent);
                clear();


            }
        });

    }
    private void clear(){
        id.setText("");
        cook.setText("");
        author.setText("");
        preparation.setText("");
        price.setText("");
        title.setText("");
        total.setText("");
    }

}