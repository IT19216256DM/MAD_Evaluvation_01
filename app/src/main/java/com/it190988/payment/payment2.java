package com.it190988.payment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class payment2 extends AppCompatActivity {
    TextView txtCardNum,txtExpirydate,txtcVV,txtcardHoldername;
    DatabaseReference dbRef;
    private Button deletePayBtn,viewPayBtn,updatePayBtn;

    //DatabaseReference dbRef;
    private  int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment2);

        txtCardNum=findViewById(R.id.cardNumber);
        txtExpirydate=findViewById(R.id.epiryDate);
        txtcVV=findViewById(R.id.cvvNumber);
        txtcardHoldername=findViewById(R.id.cardHolderName);

        int cardnumber=getIntent().getIntExtra("cardnumber",1);
        int date=getIntent().getIntExtra("date",2);
        int cvv=getIntent().getIntExtra("cvv",3);
        String cardholdername=getIntent().getStringExtra("cardholdername");

        txtCardNum.setText("cardnumber");
        txtExpirydate.setText("date");
        txtcVV.setText("cvv");
        txtcardHoldername.setText("cardholdername");

        deletePayBtn=findViewById(R.id.btnDeletePay);
        viewPayBtn=findViewById(R.id.btnViewPay);
        updatePayBtn=findViewById(R.id.btnUpdatePay);

        final payment_details pay=new payment_details();

        deletePayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef= FirebaseDatabase.getInstance().getReference().child("payDetail").child("");
                dbRef.removeValue();
                Toast.makeText(getApplicationContext(),"sucessfully deleted", Toast.LENGTH_SHORT).show();

            }
        });

        updatePayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef=FirebaseDatabase.getInstance().getReference();
                pay.setCardNum(Integer.parseInt(txtCardNum.getText().toString().trim()));
                ID = pay.getCardNum();
                dbRef.child("payDetail").child("pay1").child("cardnumber").setValue(txtCardNum.getText().toString().trim());
                dbRef.child("payDetail/pay1/date").setValue(txtExpirydate.getText().toString().trim());
                dbRef.child("payDetail").child("pay1").child("cvv").setValue(txtcVV.getText().toString().trim());
                dbRef.child("payDetail/pay1/cardholdername").setValue(txtcardHoldername.getText().toString().trim());
                Toast.makeText(getApplicationContext(),"text sucessfully updated",Toast.LENGTH_SHORT).show();
                clearControls();

            }
        });

        viewPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef=FirebaseDatabase.getInstance().getReference().child("payDetail/pay1");
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                      //  if (dataSnapshot.hasChildren()){
                       for (DataSnapshot data: dataSnapshot.getChildren()){
                            txtCardNum.setText(dataSnapshot.child("cardNum").getValue().toString());
                            txtExpirydate.setText(dataSnapshot.child("expiry date").getValue().toString());
                            txtcVV.setText(dataSnapshot.child("cvv no").getValue().toString());
                            txtcardHoldername.setText(dataSnapshot.child("card holder name").getValue().toString());


                        }
                       // else
                       //    Toast.makeText(getApplicationContext()," Cannot find pay1", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });




    }
    private void clearControls(){
        txtCardNum.setText("");
        txtExpirydate.setText("");
        txtcVV.setText("");
        txtcardHoldername.setText("");

    }
}