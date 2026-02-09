package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Meli_Ask extends AppCompatActivity {

    private TextView MEli_Ask;
    private EditText MeliCode;
    private Button Submit ;
    public  SighnUpDB db;
    private long IdCode;
    private long noteMeli;
    private BottomNavigationView bottomNavigationView;
    private ArrayList<SighnUpNote>notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meli_ask);

        db=new SighnUpDB(this);
        db.OpenDatabase();
        notes=db.GetNotes(null);
        MEli_Ask=findViewById(R.id.Meli_Ask);
        MeliCode=findViewById(R.id.MeliCode);
        Submit=findViewById(R.id.Submit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                noteMeli=(Long.parseLong(MeliCode.getText().toString()));

                SighnUpNote note =db.GetNote(noteMeli);

                if (note!=null){
                    IdCode = note.getID_CODE();
                }
                else {
                    Toast.makeText(Meli_Ask.this, "لطفا ثبت نام کنید", Toast.LENGTH_SHORT).show();
               }

               if (noteMeli == IdCode){

                    startActivity(new Intent(Meli_Ask.this,AddNoteActivityBuilding.class));
               }
                else {
                    startActivity(new Intent(Meli_Ask.this,AddNoteActivity.class));
                }


            }
        });
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