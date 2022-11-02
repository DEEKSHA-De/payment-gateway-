package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class register extends AppCompatActivity{
    Button btnprcd;
    EditText firstname,lastname,email,password,reset;
    dehelper payfi;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,32}$");        // at least 8 characters

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firstname=(EditText)findViewById(R.id.editText3);
        lastname=(EditText)findViewById(R.id.editText2);
        email=(EditText)findViewById(R.id.remail);
        password=(EditText)findViewById(R.id.rpass);
        reset=(EditText)findViewById(R.id.rconfrm);

        btnprcd=(Button) findViewById(R.id.btnprocd);
        payfi=new dehelper(this);
        btnprcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first=firstname.getText().toString();
                String last=lastname.getText().toString();
                String emai=email.getText().toString();
                String pass=password.getText().toString();
                String ret=reset.getText().toString();
                Integer balance=5000;
                String upi = ""; //changes added
                if (first.length() > 4)
                {
                    upi = first.substring(0, 4);
                }
                else
                {
                    upi = first;
                }
                upi = upi.concat("@ybl");
                if(first.equals("")|| last.equals("") || emai.equals("") ||pass.equals("") || ret.equals(""))
                {
                    Toast.makeText(register.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(emai).matches()) {
                    email.setError("Please enter a valid email address");
                }
                else if (!PASSWORD_PATTERN.matcher(pass).matches()) {
                    password .setError("Please enter a valid password");
                }
                else
                {
                    if(pass.equals(ret))
                    {
                        Boolean usercheckResult=payfi.checkusername(emai);
                        if(usercheckResult==false)
                        {
                            Boolean regResult = payfi.insertData(first,last,emai,pass,ret,balance,upi);
                            if(regResult==true){
                                Toast.makeText(register.this, "Register Succussful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(register.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(register.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(register.this, "user already exist", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(register.this, "Password Not Matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}