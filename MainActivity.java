package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
   BottomNavigationView bottomNavigationView;
   Button btnreach,btncontact,btnbalance;
//   home_frag hf=new home_frag();
//   Notification_frag nf=new Notification_frag();
//   Transaction_frag tf=new Transaction_frag();
   user_info1 ui=new user_info1();
   Exit exit=new Exit();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT);
        bottomNavigationView=findViewById(R.id.btmenu);
       btnbalance=(Button)findViewById(R.id.balance);
//        getSupportFragmentManager().beginTransaction().replace(R.id.container,hf).commit();
//       BadgeDrawable badgeDrawable=bottomNavigationView.getOrCreateBadge(R.id.notification);
//       badgeDrawable.setVisible(true);
//       badgeDrawable.setNumber(8);
  btnreach=(Button)findViewById(R.id.recharge);
 btncontact=(Button)findViewById(R.id.contacts);
    btnreach.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, reacharge.class);
            startActivity(intent);
        }
    });
    btnbalance.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, bank_balance.class);
            startActivity(intent);
        }
    });
   btncontact.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent intent=new Intent(MainActivity.this,contact.class);
           startActivity(intent);
       }
   });

        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected( MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Intent intent=new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                        return;
                    case R.id.notification:
                        Intent intent1=new Intent(MainActivity.this,Notification.class);
                        startActivity(intent1);
                        return;
                    case R.id.transaction:
                        Intent intent2=new Intent(MainActivity.this,transaction.class);
                        startActivity(intent2);
                        return;
                }
                return;
            }
        });






    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.UA){
            startActivity(new Intent(MainActivity.this,user_info1.class));

        }
        else if(id==R.id.Exit){
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
           return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.top_menu,menu);
        return true;
    }
}
