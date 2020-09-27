package com.it190988.payment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.it190988.*;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    EditText txtPID,txtcardNum,txtexpDate,txtcvvNum,txtcardHolder;
     private Button addPayBtn,deletePayBtn,viewPayBtn,updatePayBtn;

    DatabaseReference dbRef;

    payment_details payDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtcardNum = findViewById(R.id.etInputcardNum);
        txtexpDate = findViewById(R.id.etInputDate);
        txtcvvNum = findViewById(R.id.etInputCvv);
        txtcardHolder = findViewById(R.id.etInputCardHolderName);

        addPayBtn = (Button) findViewById(R.id.payBtn);
        deletePayBtn=findViewById(R.id.btnDeletePay);
        viewPayBtn=findViewById(R.id.btnViewPay);
        updatePayBtn=findViewById(R.id.btnUpdatePay);

        payDetail = new payment_details();

       addPayBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               openpayment2();
           }
       });



//
//        deletePayBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dbRef=FirebaseDatabase.getInstance().getReference().child("payDetail").child("");
//                dbRef.removeValue();
//                Toast.makeText(getApplicationContext(),"sucessfully deleteed", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//
//        updatePayBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dbRef=FirebaseDatabase.getInstance().getReference();
//                dbRef.child("payDetail").child("//pay1").child("//cardnumber").setValue(txtcardHolder.getText().toString().trim());
//                dbRef.child("payDetail/pay1/cardnumber").setValue(txtexpDate.getText().toString().trim());
//                Toast.makeText(getApplicationContext(),"text sucessfully updated",Toast.LENGTH_SHORT).show();
//                clearControls();
//
//            }
//        });



//
//        viewPayBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                dbRef=FirebaseDatabase.getInstance().getReference().child("payDetail/pay1");
//                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        if (dataSnapshot.hasChildren()){
//                            txtcardNum.setText(dataSnapshot.child("cardNum").getValue().toString());
//                            txtexpDate.setText(dataSnapshot.child("expiry date").getValue().toString());
//                            txtcvvNum.setText(dataSnapshot.child("cvv no").getValue().toString());
//                            txtcardHolder.setText(dataSnapshot.child("card holder name").getValue().toString());
//                            //Aru pani yestai garne
//                        }
//                        else
//                            Toast.makeText(getApplicationContext()," Cannot find pay1", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
//
//            }
//        });
//



        addPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("payment_details");
                try {
                    if (TextUtils.isEmpty(txtcardNum.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Number", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtexpDate.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty expiry date", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtcvvNum.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty cvv", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtcardHolder.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty card holderName", Toast.LENGTH_SHORT).show();
                    else {
                        payDetail.setCardNum(Integer.parseInt(txtcardNum.getText().toString().trim()));
                        payDetail.setDate(txtexpDate.getText().toString().trim());
                        payDetail.setCvv(Integer.parseInt(txtcvvNum.getText().toString().trim()));
                        payDetail.setDate(txtcardHolder.getText().toString().trim());
                        dbRef.child("Payment1").setValue(payDetail);
                        Toast.makeText(getApplicationContext(), "Sucessfully inserted", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                } catch (NumberFormatException nfe) {
                    Toast.makeText(getApplicationContext(), "Successfully inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    private void clearControls(){
        txtcardNum.setText("");
        txtexpDate.setText("");
        txtcvvNum.setText("");
        txtcardHolder.setText("");
    }
    public void openpayment2(){
        Intent intent=new Intent(this,payment2.class);
        startActivity(intent);
    }


    }

