package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SearchView extends AppCompatActivity {

    ListView list1;
    String[] city = {"کرستان", "تهران", "ایلام", "خوزستان", "فارس", "کرج", "گیلان", "مازندران", "آذربایجان غربی", "آذربایجان شرقی", "کرمانشاه", "سیستان"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        //list1 = findViewById(R.id.list1);


       // arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, city);
        //list1.setAdapter(arrayAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu );

        MenuItem menuItem = menu.findItem(R.id.action_search);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) menuItem.getActionView();
        searchView.setQueryHint("سرچ در دسته آگهی ها");
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
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