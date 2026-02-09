package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Renter extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private FloatingActionButton Float;
    private EditText Day,Month,Year,BuyerName,ChildOfName,IdCodeValue,FromValue,MeliCode,BornValue,AddressValue,PostCodeValue,PhoneValue,MobileValue;
    public RenterDB db;
    private int IdExtra =0;
    private TextView Text_Value;
    private Button Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter);

        Text_Value=findViewById(R.id.Text_Value);

        Day=findViewById(R.id.Day);
        Month=findViewById(R.id.Month);
        Year=findViewById(R.id.Year);
        BuyerName=findViewById(R.id.BuyerName);
        ChildOfName=findViewById(R.id.ChildOfName);
        IdCodeValue=findViewById(R.id.IdCodeValue);
        FromValue=findViewById(R.id.FromValue);
        MeliCode=findViewById(R.id.MeliCode);
        BornValue=findViewById(R.id.BornValue);
        AddressValue=findViewById(R.id.AddressValue);
        PostCodeValue=findViewById(R.id.PostCodeValue);
        PhoneValue=findViewById(R.id.PhoneValue);
        MobileValue=findViewById(R.id.MobileValue);
        Next=findViewById(R.id.Next);

        db=new RenterDB(this);
        db.OpenDatabase();

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RentNote note =new RentNote(
                  Integer.parseInt(Day.getText().toString()),
                  Integer.parseInt(Month.getText().toString()),
                  Integer.parseInt(Year.getText().toString()),
                  BuyerName.getText().toString(),
                  ChildOfName.getText().toString(),
                  Long.parseLong(IdCodeValue.getText().toString()),
                  FromValue.getText().toString(),
                  Long.parseLong(MeliCode.getText().toString()),
                  BornValue.getText().toString(),
                  AddressValue.getText().toString(),
                  Long.parseLong(PostCodeValue.getText().toString()),
                  Long.parseLong(PhoneValue.getText().toString()),
                  Long.parseLong(MobileValue.getText().toString())
                );


                db.InsertNote(note);

                startActivity(new Intent(Renter.this,RentDetails.class));
            }
        });

        Typeface sarbaz=Typeface.createFromAsset(getAssets(),"fonts/7 sarbaz.ttf");
        Text_Value.setTypeface(sarbaz);


        Float=findViewById(R.id.Float);

        Float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Renter.this,AddNoteActivityBuilding.class));
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