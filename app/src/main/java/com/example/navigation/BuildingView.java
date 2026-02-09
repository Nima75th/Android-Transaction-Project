package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;

public class BuildingView extends AppCompatActivity {

    public DB_Bulding db;
    private RecyclerView recyclerView;
    private BuildingNoteRecyclerAdapter buildingNoteRecyclerAdapter;
    private FrontNoteAdapter frontNoteAdapter;
    private ArrayList<Building_Note> notes;
    private int idExtra=0;
    public TextView Title,Description,Old,Meter,Floor,RoomNumber,HouseModel,FixedPrice,PricePerMeter,MeliCode,Document,Mobile,Parking,StoreRoom,Elevator;
    //public SwitchMaterial Parking,StoreRoom,Elevator;
    private Button Req,Req2,Req3;
    private BottomNavigationView bottomNavigationView;
    private ImageView ImgView;
    public SighnUpDB db1;
    private ArrayList<SighnUpNote>notes1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_view);

        Title=findViewById(R.id.Title);
        Description=findViewById(R.id.Description);
        Old=findViewById(R.id.Old);
        Meter=findViewById(R.id.Meter);
        Floor=findViewById(R.id.Floor);
        Parking=findViewById(R.id.Parking);
        StoreRoom=findViewById(R.id.StoreRoomView);
        Elevator=findViewById(R.id.ElevatorView);
        RoomNumber=findViewById(R.id.RoomNumber);
        HouseModel=findViewById(R.id.HouseModel);
        FixedPrice=findViewById(R.id.FixedPrice);
        PricePerMeter=findViewById(R.id.PricePerMeter);
        MeliCode=findViewById(R.id.MeliCode);
        Document=findViewById(R.id.Document);
        Mobile=findViewById(R.id.Mobile);
        Req=findViewById(R.id.Req);
        Req2=findViewById(R.id.Req2);
        Req3=findViewById(R.id.Req3);
        ImgView=findViewById(R.id.ImgView);



        Req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BuildingView.this,RantActivity.class);
                startActivity(intent);
            }
        });

        Req2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BuildingView.this,Mortgage.class);
                startActivity(intent);
            }
        });

        Req3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BuildingView.this,Buyer.class);
                startActivity(intent);
            }
        });
        db=new DB_Bulding(this);
        db.OpenDatabase();


        if (getIntent().hasExtra("IdExtra")){
            idExtra=(getIntent().getExtras().getInt("IdExtra"));

            Building_Note note =db.GetNote(idExtra);

            Title.setText(note.getTITLE());
            Description.setText(note.getDESCRIPTION());
            Old.setText(""+note.getOLD());
            Meter.setText(""+note.getMETER());
            Floor.setText(""+note.getFLOOR());

            //Parking.setText(""+note.getPARKING());
            //StoreRoom.setText(""+note.getSTOREROOM());
            //Elevator.setText(""+note.getELEVATOR());
            if (note.getPARKING()==1){
                Parking.setText("دارد");
            }else {
                Parking.setText("ندارد");
            }

            if (note.getSTOREROOM()==1){
                StoreRoom.setText("دارد");
            }else {
                StoreRoom.setText("ندارد");
            }

            if (note.getELEVATOR()==1){
                Elevator.setText("دارد");
            }else {
                Elevator.setText("ندارد");
            }
           // Parking.setChecked(note.getPARKING() == 1);
            //StoreRoom.setChecked(note.getSTOREROOM() == 1);
           // Elevator.setChecked(note.getELEVATOR() == 1);
            RoomNumber.setText(""+note.getROOM_NUMBER());
            HouseModel.setText(note.getHOUSE_MODEL());
            FixedPrice.setText(""+note.getFIXED_PRICE());
            PricePerMeter.setText(""+note.getPRICE_PER_METER());
            MeliCode.setText(""+note.getMELI_CODE());
            Document.setText(note.getDOCUMENT());
            Mobile.setText(""+note.getMOBILE());
            ImgView.setImageBitmap(note.getPIC());





            //recyclerView=findViewById(R.id.recyclerview);
            //frontNoteAdapter=new FrontNoteAdapter(this,notes);
            //recyclerView.setAdapter(frontNoteAdapter);


        }

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

        //notes=db.GetNotes(null);






    }
}