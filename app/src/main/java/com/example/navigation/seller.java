package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.net.Inet4Address;

public class seller extends AppCompatActivity {

    private Button Next;
    private BottomNavigationView TopNavigation;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        Next=findViewById(R.id.Next);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(seller.this,SellDetails.class));
            }
        });

        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        TopNavigation=findViewById(R.id.btnNavigation);
        TopNavigation.setBackground(null);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.account);
        bottomNavigationView.setSelectedItemId(R.id.Login);
        bottomNavigationView.setSelectedItemId(R.id.About);
        bottomNavigationView.setSelectedItemId(R.id.Home);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return;
                    case R.id.Login:
                        startActivity(new Intent(getApplicationContext(),AddNoteActivity.class));
                        overridePendingTransition(0,0);
                        return;
                    case R.id.About:
                        startActivity(new Intent(getApplicationContext(),About.class));
                        overridePendingTransition(0,0);
                        return;
                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });
        TopNavigation=findViewById(R.id.btnNavigation);
        TopNavigation.setSelectedItemId(R.id.Login);
        TopNavigation.setSelectedItemId(R.id.account);
        TopNavigation.setSelectedItemId(R.id.Login);
        TopNavigation.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.Login:
                        startActivity(new Intent(getApplicationContext(),Mine.class));
                        overridePendingTransition(0,0);
                        return;
                }

            }
        });
    }
}