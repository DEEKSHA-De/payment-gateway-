package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class forgot extends AppCompatActivity {
    EditText emailf,passwordf,cnfrmf;
    Button btnsub;
    dehelper payfi;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,32}$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        emailf=findViewById(R.id.emailf);
        passwordf=findViewById(R.id.passwordf);
        cnfrmf=findViewById(R.id.confrmf);
        btnsub=findViewById(R.id.btnfor);
        payfi=new dehelper(this);
        Intent intent=getIntent();
        emailf.setText(intent.getStringExtra("emailf"));
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userf=emailf.getText().toString();
                String passf=passwordf.getText().toString();
                String repass=cnfrmf.getText().toString();
                if (!PASSWORD_PATTERN.matcher(passf).matches()) {
                    passwordf.setError("Please enter a valid password");
                }
                else if(passf.equals(repass))
                {
                    Boolean  checkpasswordupdate=payfi.updatepassword(userf,passf);
                    if(checkpasswordupdate==true)
                    {
                        Intent intent=new Intent(getApplicationContext(),login.class);
                        startActivity(intent);
                        Toast.makeText(forgot.this, "Password Updated Succussfully", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(forgot.this, "Password Not Updated", Toast.LENGTH_SHORT).show();
                    }}
                else{
                    cnfrmf.setError("Make sure that Password are Matching");
                }
            }
        });


    }
}