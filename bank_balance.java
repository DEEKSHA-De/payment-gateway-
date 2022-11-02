package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bank_balance extends AppCompatActivity {
    Button btnbalback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_balance);
        btnbalback=(Button) findViewById(R.id.btnbnkbalback);
        btnbalback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent=new Intent(bank_balance.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}