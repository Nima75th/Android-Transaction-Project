package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SellDetails extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    BottomNavigationView btnNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_details);

        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        btnNavigation=findViewById(R.id.btnNavigation);
        btnNavigation.setBackground(null);
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
        btnNavigation=findViewById(R.id.btnNavigation);
        btnNavigation.setSelectedItemId(R.id.Login);
        btnNavigation.setSelectedItemId(R.id.account);
        btnNavigation.setSelectedItemId(R.id.Login);
        btnNavigation.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
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