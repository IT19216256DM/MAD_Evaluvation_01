package com.example.orderus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity4 extends AppCompatActivity {



    TextView a, b, c, d,e,f;
    Button btn,btn1,btn2;

    DatabaseReference dbRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);



        a=(TextView)findViewById(R.id.textView6);
        b=(TextView)findViewById(R.id.textView4);
        c=(TextView)findViewById(R.id.textView9);
        d=(TextView)findViewById(R.id.textView16);
        e=(TextView)findViewById(R.id.textView17);
        f=(TextView)findViewById(R.id.textView18);

        btn=(Button)findViewById(R.id.button6);
        btn1=(Button)findViewById(R.id.button7);
        btn2=(Button)findViewById(R.id.button16);

        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       dbRef = FirebaseDatabase.getInstance().getReference().child("Employee");
                                       dbRef.addValueEventListener(new ValueEventListener() {
                                           @Override
                                           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                               String txtId = dataSnapshot.child("txtId").getValue().toString();
                                               String txtName = dataSnapshot.child("txtName").getValue().toString();
                                               String txtAdd = dataSnapshot.child("txtAdd").getValue().toString();
                                               String txtNum = dataSnapshot.child("txtNum").getValue().toString();
                                               String txtMail = dataSnapshot.child("txtMail").getValue().toString();
                                               String txtOwn = dataSnapshot.child("txtOwn").getValue().toString();


                                               a.setText(txtId);
                                               b.setText(txtName);
                                               c.setText(txtAdd);
                                               d.setText(txtNum);
                                               e.setText(txtMail);
                                               f.setText(txtOwn);

                                           }

                                           @Override
                                           public void onCancelled(@NonNull DatabaseError databaseError) {

                                           }
                                       });
                                   }
                               });

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


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eid = a.getText().toString();
                String nam = b.getText().toString();
                String ade = c.getText().toString();
                String phh = d.getText().toString();
                String em = e.getText().toString();
                String owe = f.getText().toString();


                Intent i = new Intent(getApplicationContext(), MainActivity7.class);

                i.putExtra("idd", eid);
                i.putExtra("nmm", nam);
                i.putExtra("ade", ade);
                i.putExtra("pht", phh);
                i.putExtra("eml", em);
                i.putExtra("own", owe);





                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference[] dbRef = {FirebaseDatabase.getInstance().getReference().child("Emp1")};
                dbRef[0].addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Emp1")){
                            dbRef[0] =FirebaseDatabase.getInstance().getReference().child("Emp1").child("Emp1");
                            dbRef[0].removeValue();
                            Toast.makeText(getApplicationContext(),"Data Deleted Successfully",Toast.LENGTH_LONG).show();

                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source To Delete", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });




    }


}
