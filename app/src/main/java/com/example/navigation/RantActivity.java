package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RantActivity extends AppCompatActivity {

    private EditText Day,Month,Year,BuyerName,ChildOfName,IdCodeValue,FromValue,MeliCode,BornValue,AddressValue,PostCodeValue,PhoneValue,MobileValue;
    public Give_Rent_DB db;
    private Button Next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rant);

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

        db= new Give_Rent_DB(this);
        db.OpenDatabase();

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Give_Rent_Note note = new Give_Rent_Note(
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

                Toast.makeText(RantActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });




    }
}