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
    Button btn1,btn2;

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


        btn1=(Button)findViewById(R.id.button7);
        btn2=(Button)findViewById(R.id.button16);

              /*  String as = getIntent().getStringExtra("aa");
                  String bs = getIntent().getStringExtra("bb");
                   String cs = getIntent().getStringExtra("cc");
                    String ds = getIntent().getStringExtra("dd");
                     String es = getIntent().getStringExtra("ee");
                      String fs = getIntent().getStringExtra("ff");

                      a.setText(as);
                      b.setText(bs);
                      c.setText(cs);
                      d.setText(ds);
                      e.setText(es);
                      f.setText(fs); */




                                 DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Employee").child("Emp1");
                                       dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                           @Override
                                           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                               if (dataSnapshot.hasChildren()) {
                                                   a.setText(dataSnapshot.child("txtId").getValue().toString());
                                                   b.setText(dataSnapshot.child("txtName").getValue().toString());
                                                   c.setText(dataSnapshot.child("txtAdd").getValue().toString());
                                                   d.setText(dataSnapshot.child("txtNum").getValue().toString());
                                                   e.setText(dataSnapshot.child("txtMail").getValue().toString());
                                                   f.setText(dataSnapshot.child("txtOwn").getValue().toString());

                                               } else
                                                   Toast.makeText(getApplicationContext(), "No Source to Display", Toast.LENGTH_SHORT).show();
                                           }
                                           @Override
                                           public void onCancelled(@NonNull DatabaseError databaseError) {

                                           }
                                       });



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
                final DatabaseReference[] dbRef = {FirebaseDatabase.getInstance().getReference().child("Employee")};
                dbRef[0].addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Emp1")){
                            dbRef[0] =FirebaseDatabase.getInstance().getReference().child("Employee").child("Emp1");
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
