package com.example.addfoods;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;


public class Page5 extends AppCompatActivity {

    TextView title, author, price, servings, preparation, cook, total;
    DatabaseReference dbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);
//
//        button = (Button) findViewById(R.id.button4);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(Page5.this,Page4.class);
//                startActivity(intent);
//            }
//        });

        title = findViewById(R.id.viewTitle);
        author = findViewById(R.id.viewAuthor);
        price = findViewById(R.id.viewPrice);
        servings = findViewById(R.id.viewServings);
        preparation = findViewById(R.id.viewPreparationtime);
        cook = findViewById(R.id.viewCooktime);
        total = findViewById(R.id.viewTotaltime);

        String ti = getIntent().getStringExtra("ti");
        String au = getIntent().getStringExtra("au");
        String pr = getIntent().getStringExtra("pr");
        String se = getIntent().getStringExtra("se");
        String pt = getIntent().getStringExtra("pt");
        String co = getIntent().getStringExtra("co");
        String to = getIntent().getStringExtra("to");

        title.setText(ti);
        author.setText(au);
        price.setText(pr);
        servings.setText(se);
        preparation.setText(pt);
        cook.setText(co);
        total.setText(to);

        String tit = title.getText().toString();
        String aur = author.getText().toString();
        String pri = price.getText().toString();
        String ser = servings.getText().toString();
        String pre = preparation.getText().toString();
        String cok = cook.getText().toString();
        String tot = total.getText().toString();

        Intent i =new Intent(getApplicationContext(),Pagex.class);

        i.putExtra("ti",tit);
        i.putExtra("au",aur);
        i.putExtra("pr",pri);
        i.putExtra("se",ser);
        i.putExtra("pt",pre);
        i.putExtra("co",cok);
        i.putExtra("to",tot);

        startActivity(i);


    }


}