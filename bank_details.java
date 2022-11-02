package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bank_details extends AppCompatActivity {

    Button btnproc;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bank_details);
            btnproc=(Button)findViewById(R.id.btnbkdetproc);
            btnproc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(bank_details.this, MainActivity.class);
                    startActivity(intent);
                }
            });
    }
}