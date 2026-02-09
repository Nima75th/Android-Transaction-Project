package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SighnUp extends AppCompatActivity {



    //EditText TXT_Name;
    //Button Btn1;
    Button Btn2;
    //EditText TXT_Age;

    public SighnUpDB db;
    private RecyclerView recyclerView;
    private NoteRecyclerAdapter noteRecyclerAdapter;
    private ArrayList<SighnUpNote> notes;
    private FloatingActionButton floating1;
    private BottomNavigationView bottomTop;
    private SearchView searchview;
    private TextView Show;
    private BottomNavigationView bottomNavigationView;
    private ImageView Image;
    private SighnUpAdapter sighn;
    private SighnUpNote note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sighn_up);

        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
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
                        startActivity(new Intent(getApplicationContext(),Contract.class));
                        overridePendingTransition(0,0);
                        return;
                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });

        recyclerView=findViewById(R.id.Recycler);

        Show=findViewById(R.id.Show);
        Image=findViewById(R.id.Image);
        //Name=findViewById(R.id.Name);
       // MEliCode=findViewById(R.id.MeliCode);
        //Mobile=findViewById(R.id.Mobile);
        //Email=findViewById(R.id.Email);
        //Address=findViewById(R.id.Address);
        //PicView=findViewById(R.id.PicView);

        db=new SighnUpDB(this);
        db.OpenDatabase();

        notes=db.GetNotes(null);

        sighn=new SighnUpAdapter(this,notes);
        recyclerView.setAdapter(sighn);

        //Name.setText(note.getNAME());
        //MEliCode.setText(""+note.getID_CODE());
        //Mobile.setText(""+note.getMOBILE());
        //Email.setText(note.getEMAIL());
        //Address.setText(note.getADDRESS());
        //PicView.setText(""+note.getPIC());
        //Picture.setImageBitmap(note.getPIC());

        note=db.GetNote(null);
        Show.setText(note.getNAME());
        Image.setImageBitmap(note.getPIC());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menue_main,menu);
        MenuItem menuItem = menu.findItem(R.id.search_item);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search....");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String nameText) {
                searchNotes(nameText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void searchNotes (String Name){
     NoteDto noteDto = new NoteDto(Name);
     //notes= db.getNotes(noteDto);
     //noteRecyclerAdapter = new NoteRecyclerAdapter(SighnUp.this,notes);
     recyclerView.setAdapter(noteRecyclerAdapter);

    }
}