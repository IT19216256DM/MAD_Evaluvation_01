package com.example.addfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeletePage extends AppCompatActivity {

    EditText txtID;
    Button button;
    DatabaseReference db;
    User usr;
    private String ID;

    private void clearControls(){
        txtID.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_foods);

        txtID = findViewById(R.id.deleteEditText);

        button = findViewById(R.id.buttondelete);

        usr =  new User();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usr.setID(txtID.getText().toString().trim());
                ID = usr.getID();

                db = FirebaseDatabase.getInstance().getReference().child("User").child(ID);
                db.removeValue();
                Toast.makeText(getApplicationContext(),"Delete Successfully", Toast.LENGTH_SHORT).show();

                Intent intent =new Intent(DeletePage.this, MainActivity.class);
                startActivity(intent);
                clearControls();
            }
        });


    }
}