package com.example.orderus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteFoodPage extends AppCompatActivity {

    EditText txtID;
    Button button;
    DatabaseReference db;
    Food fd;
    private String ID;

    private void clearControls(){
        txtID.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_food_page);


        txtID = findViewById(R.id.deleteEditText);

        button = findViewById(R.id.buttondelete);

        fd =  new Food();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fd.setID(txtID.getText().toString().trim());
                ID = fd.getID();

                db = FirebaseDatabase.getInstance().getReference().child("Food").child(ID);
                db.removeValue();
                Toast.makeText(getApplicationContext(),"Delete Successfully", Toast.LENGTH_SHORT).show();

                Intent intent =new Intent(DeleteFoodPage.this, FoodHomePage.class);
                startActivity(intent);
                clearControls();
            }
        });


    }
}