package com.example.addfoods;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class Page4 extends AppCompatActivity {
    private Button buttonv;

    EditText a,b,c,d,e,f,g;
    DatabaseReference dbRef;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        a =findViewById(R.id.details1);
        b =findViewById(R.id.details2);
        c =findViewById(R.id.details3);
        d =findViewById(R.id.details4);
        e =findViewById(R.id.details5);
        f =findViewById(R.id.details6);
        g =findViewById(R.id.details7);

        btn = findViewById(R.id.buttonsave);

        String tit = getIntent().getStringExtra("tit");
        String aut = getIntent().getStringExtra("aut");
        String pri = getIntent().getStringExtra("pri");
        String sec = getIntent().getStringExtra("sec");
        String pti = getIntent().getStringExtra("pti");
        String coo = getIntent().getStringExtra("coo");
        String tot = getIntent().getStringExtra("tot");

        a.setText(tit);
        b.setText(aut);
        c.setText(pri);
        d.setText(sec);
        e.setText(pti);
        f.setText(coo);
        g.setText(tot);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String tit = a.getText().toString();
                String aut = b.getText().toString();
                String pri = c.getText().toString();
                String sec = d.getText().toString();
                String pti = e.getText().toString();
                String coo = f.getText().toString();
                String tot = g.getText().toString();

                dbRef = FirebaseDatabase.getInstance().getReference().child("Usr1");

                HashMap hashMap = new HashMap();

                hashMap.put("a",tit);
                hashMap.put("b",aut);
                hashMap.put("c",pri);
                hashMap.put("d",sec);
                hashMap.put("e",pti);
                hashMap.put("f",coo);
                hashMap.put("g",tot);

                dbRef.child("User").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(),"Data updated successfully", Toast.LENGTH_SHORT).show();
                    }
                });


//                Intent intent =new Intent(Page4.this,MainActivity.class);
//                startActivity(intent);
            }
        });
    }
}