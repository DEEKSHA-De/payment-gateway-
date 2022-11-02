package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class bank extends AppCompatActivity {

    String[] bank={"-select the bank- ","SBI","ICICI"};


    public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id )
    {
        switch(pos) {
            case 0:
                break;
            case 1:
                LayoutInflater li = getLayoutInflater();
                View layout = li.inflate(R.layout.sbi, (ViewGroup) findViewById(R.id.sbiIfsc));
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
                break;
            case 2:
                LayoutInflater li1 = getLayoutInflater();
                View layout1 = li1.inflate(R.layout.icic, (ViewGroup) findViewById(R.id.icicIfsc));
                Toast toast1 = new Toast(getApplicationContext());
                toast1.setDuration(Toast.LENGTH_LONG);
                toast1.setView(layout1);
                toast1.show();
                break;


            default:
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter dropdown = new ArrayAdapter(this, android.R.layout.simple_spinner_item, bank);
        dropdown.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(dropdown);
        spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }
}