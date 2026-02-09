package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Mine extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ArrayAdapter<String> arrayAdapter;
    public DB_Bulding db;
    private FloatingActionButton Float;
    private RecyclerView recyclerView;
    private ContractAdaptor contractAdaptor;
    private ArrayList<Building_Note> notes;
    private TextView Text_Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);

        Text_Value=findViewById(R.id.Text_Value);
        Typeface sarbaz=Typeface.createFromAsset(getAssets(),"fonts/7 sarbaz.ttf");
        Text_Value.setTypeface(sarbaz);

        db=new DB_Bulding(this);
        db.OpenDatabase();
        notes=db.GetNotes(null);

        recyclerView=findViewById(R.id.Recycler);
        contractAdaptor=new ContractAdaptor(this,notes);
        recyclerView.setAdapter(contractAdaptor);

        Float=findViewById(R.id.Float);

        Float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mine.this,Meli_Ask.class));
            }
        });
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
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


    }
}