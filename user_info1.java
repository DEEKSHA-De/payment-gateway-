package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class user_info1 extends AppCompatActivity {

    TextView upi1,bank1,About1,terms1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info1);
        upi1=(TextView)findViewById(R.id.upi);
        bank1=(TextView)findViewById(R.id.bank);
        About1=(TextView)findViewById(R.id.about);
        terms1=(TextView)findViewById(R.id.terms);

        upi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(user_info1.this,upi.class);
                startActivity(intent);
            }
        });
        About1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(user_info1.this,About.class);
                startActivity(intent);
            }
        });
        bank1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(user_info1.this,bank.class);
                startActivity(intent);
            }
        });
        terms1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(user_info1.this,Terms.class);
                startActivity(intent);
            }
        });

    }
    }
