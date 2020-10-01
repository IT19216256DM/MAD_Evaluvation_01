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

import java.util.HashMap;


public class Page4 extends AppCompatActivity {


    //    EditText a,b,c,d,e,f,g;
    EditText title,author,price,servings,preparation,cook,total;
    DatabaseReference dbRef;
    Button btn;

//    private void clearControls(){
//        title.setText("");
//        author.setText("");
//        price.setText("");
//        servings.setText("");
//        cook.setText("");
//        preparation.setText("");
//        total.setText("");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);


        //delete
//        btn = findViewById(R.id.btndeletedetails);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final DatabaseReference[] dbRef = {FirebaseDatabase.getInstance().getReference().child("Usr9")};
//                dbRef[0].addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.hasChild("Usr9")){
//                            dbRef[0] =FirebaseDatabase.getInstance().getReference().child("Usr9").child("Usr9");
//                            dbRef[0].removeValue();
//                            Toast.makeText(getApplicationContext(),"Data Deleted Successfully",Toast.LENGTH_LONG).show();
//
//                        }
//                        else
//                            Toast.makeText(getApplicationContext(),"No Source To Delete", Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });


//        a =findViewById(R.id.details1);
//        b =findViewById(R.id.details2);
//        c =findViewById(R.id.details3);
//        d =findViewById(R.id.details4);
//        e =findViewById(R.id.details5);
//        f =findViewById(R.id.details6);
//        g =findViewById(R.id.details7);

        title =findViewById(R.id.details1);
        author =findViewById(R.id.details2);
        price =findViewById(R.id.details3);
        servings =findViewById(R.id.details4);
        preparation =findViewById(R.id.details5);
        cook =findViewById(R.id.details6);
        total =findViewById(R.id.details7);

        String ti = getIntent().getStringExtra("ti");
        String au = getIntent().getStringExtra("au");
        String pr = getIntent().getStringExtra("pr");
        String se = getIntent().getStringExtra("se");
        String pt = getIntent().getStringExtra("pt");
        String co = getIntent().getStringExtra("co");
        String to = getIntent().getStringExtra("to");

//        a.setText(ti);
//        b.setText(au);
//        c.setText(pr);
//        d.setText(se);
//        e.setText(pt);
//        f.setText(co);
//        g.setText(to);

        title.setText(ti);
        author.setText(au);
        price.setText(pr);
        servings.setText(se);
        preparation.setText(pt);
        cook.setText(co);
        total.setText(to);

        btn = findViewById(R.id.btnupdatedata);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                String ti = a.getText().toString();
//                String au = b.getText().toString();
//                String pr = c.getText().toString();
//                String se = d.getText().toString();
//                String pt = e.getText().toString();
//                String co = f.getText().toString();
//                String to = g.getText().toString();

                String ti = title.getText().toString();
                String au = author.getText().toString();
                String pr = price.getText().toString();
                String se = servings.getText().toString();
                String pt = preparation.getText().toString();
                String co = cook.getText().toString();
                String to = total.getText().toString();

                dbRef = FirebaseDatabase.getInstance().getReference().child("Usr10");

                HashMap hashMap = new HashMap();

//                hashMap.put("a",ti);
//                hashMap.put("b",au);
//                hashMap.put("c",pr);
//                hashMap.put("d",se);
//                hashMap.put("e",pt);
//                hashMap.put("f",co);
//                hashMap.put("g",to);

                hashMap.put("title",ti);
                hashMap.put("author",au);
                hashMap.put("price",pr);
                hashMap.put("servings",se);
                hashMap.put("preparation",pt);
                hashMap.put("cook",co);
                hashMap.put("total",to);

                dbRef.child("Usr10").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(),"Data updated successfully", Toast.LENGTH_SHORT).show();
                    }
                });


//                Intent intent =new Intent(Page4.this,MainActivity.class);
//                startActivity(intent);
//                Intent i = new Intent(getApplicationContext(),MainActivity.class);
//                clearControls();
////
//                i.putExtra("ti",ti);
//                i.putExtra("au",au);
//                i.putExtra("pr",pr);
//                i.putExtra("se",se);
//                i.putExtra("co",co);
//                i.putExtra("pt",pt);
//                i.putExtra("to",to);
//
//                startActivity(i);

            }
        });
    }
}