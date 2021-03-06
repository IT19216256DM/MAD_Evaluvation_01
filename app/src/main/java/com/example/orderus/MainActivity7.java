package com.example.orderus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity7 extends AppCompatActivity {
    private Button button10;

    EditText a,b,c,d,e,f;
    Button btn;

    DatabaseReference dbRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);


        a = findViewById(R.id.ema4);
        b = findViewById(R.id.ema3);
        c = findViewById(R.id.ema2);
        d = findViewById(R.id.ema);
        e = findViewById(R.id.ema5);
        f = findViewById(R.id.ema6);

        btn = findViewById(R.id.button10);

        String idd = getIntent().getStringExtra("idd");
        String nmm = getIntent().getStringExtra("nmm");
        String ade = getIntent().getStringExtra("ade");
        String pht = getIntent().getStringExtra("pht");
        String eml = getIntent().getStringExtra("eml");
        String own = getIntent().getStringExtra("own");

        a.setText(idd);
        b.setText(nmm);
        c.setText(ade);
        d.setText(pht);
        e.setText(eml);
        f.setText(own);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                String i = a.getText().toString();
                String n = b.getText().toString();
                String m = c.getText().toString();
                String p = d.getText().toString();
                String o = e.getText().toString();
                String q = f.getText().toString();


                dbRef = FirebaseDatabase.getInstance().getReference().child("Employee");

                HashMap hashMap = new HashMap();

                hashMap.put("txtId", i);
                hashMap.put("txtName", n);
                hashMap.put("txtAdd", m);
                hashMap.put("txtNum", p);
                hashMap.put("txtMail", o);
                hashMap.put("txtOwn", q);


                dbRef.child("Emp1").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(), "Successfully Updated", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity4.class);
                        startActivity(i);
                    }
                });
            }
        });


    }

}