package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    Button btnloginh,btnforgotl;
    EditText userl,userp;
    dehelper payfi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnloginh=findViewById(R.id.loginh);
        btnforgotl=findViewById(R.id.forgotl);
        userl=findViewById(R.id.deeuser);
        userp=findViewById(R.id.deepass);
        payfi=new dehelper(this);
        btnloginh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userjk=userl.getText().toString();
                String passjk=userp.getText().toString();
                if(userjk.equals("")|| passjk.equals("")){
                    Toast.makeText(login.this, "Please enter credentials", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean result= payfi.checkusernamepassword(userjk,passjk);
                    if(result==true){
                        Intent intent = new Intent(login.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(login.this, "invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        btnforgotl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,forgot.class);
                startActivity(intent);
            }
        });
    }
}