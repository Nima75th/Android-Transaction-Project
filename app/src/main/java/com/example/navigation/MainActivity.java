package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    BottomNavigationView btnNavigation;
    ListView list1;
    ArrayAdapter<String> arrayAdapter;
    public DB_Bulding db;
    private FloatingActionButton Float;
    private RecyclerView recyclerView;
    private BuildingNoteRecyclerAdapter buildingNoteRecyclerAdapter;
    private FrontNoteAdapter frontNoteAdapter;
    private ArrayList<Building_Note> notes;
    public SighnUpDB db2;
    private ArrayList<SighnUpNote> notes2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db2=new SighnUpDB(this);
        db2.OpenDatabase();
        notes2=db2.GetNotes(null);

        db=new DB_Bulding(this);
        db.OpenDatabase();
        notes=db.GetNotes(null);

        recyclerView=findViewById(R.id.Recycler);
        frontNoteAdapter=new FrontNoteAdapter(this,notes);
        //buildingNoteRecyclerAdapter=new BuildingNoteRecyclerAdapter(this,notes);
        recyclerView.setAdapter(frontNoteAdapter);

        Float=findViewById(R.id.Float);

        Float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Meli_Ask.class));
            }
        });

        //list1=findViewById(R.id.list1);


        //arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,city);
        //list1.setAdapter(arrayAdapter);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu,menu);

       MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("سرچ در دسته آگهی ها");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String nameText) {

                arrayAdapter.getFilter().filter(nameText);

                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}