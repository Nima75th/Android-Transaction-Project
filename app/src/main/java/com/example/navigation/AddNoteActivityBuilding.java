package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class AddNoteActivityBuilding extends AppCompatActivity {

    private EditText Title,Description,Old,Meter,Floor,RoomNumber,HouseModel,FixedPrice,PricePerMeter,MeliCode,Document,Mobile;
    private SwitchMaterial Parking,Storeroom,Elevator;
    private DB_Bulding db;
    private FloatingActionButton Floating;
    private int idExtra = 0;
    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    private Button Auth,Submit;
    private ImageView imageView2;
    private Button Pic;
    private TextView PicPath;
    private final int GALLERY_REQ_CODE = 1000;
    private  String picPath="";
    private ByteArrayOutputStream bt;
    private byte[] ImageByte;
    private Bitmap ImageStore;
    private BottomNavigationView bottomNavigationView;
    public SighnUpDB db1;
    private ArrayList<SighnUpNote>notes;




    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note_building);

        Auth=findViewById(R.id.Auth);
        Submit=findViewById(R.id.Submit);
        Submit.setEnabled(false);

        Pic=findViewById(R.id.Pic);

        db1=new SighnUpDB(this);
        db1.OpenDatabase();
        notes=db1.GetNotes(null);



        executor= ContextCompat.getMainExecutor(this);
        biometricPrompt=new BiometricPrompt(AddNoteActivityBuilding.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);

                Toast.makeText(AddNoteActivityBuilding.this, "احراز هویت انجام نشد", Toast.LENGTH_SHORT).show();

                Submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });


            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);

                Toast.makeText(AddNoteActivityBuilding.this, "احراز هویت انجام شد", Toast.LENGTH_SHORT).show();
                Submit.setEnabled(true);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();

                Toast.makeText(AddNoteActivityBuilding.this, "احراز هویت انجام نشد", Toast.LENGTH_SHORT).show();
            }
        });

        promptInfo=new BiometricPrompt.PromptInfo.Builder()
                .setTitle("احراز هویت ")
                .setSubtitle("احراز هویت با استفاده از اثر انگشت و تصویر صورت")
                .setNegativeButtonText("لغوو")
                .build();

        Auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                biometricPrompt.authenticate(promptInfo);
            }
        });

        Pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent iGallery=new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery,GALLERY_REQ_CODE);


            }
        });



       //picPath=PicPath.getText().toString();
        db=new DB_Bulding(this);
        db.OpenDatabase();

        Title=findViewById(R.id.Title);
        Description=findViewById(R.id.Description);
        Old=findViewById(R.id.Old);
        Meter=findViewById(R.id.Meter);
        Floor=findViewById(R.id.Floor);
        RoomNumber=findViewById(R.id.RoomNumber);
        HouseModel=findViewById(R.id.HouseModel);
        FixedPrice=findViewById(R.id.FixedPrice);
        PricePerMeter=findViewById(R.id.PricePerMeter);
        MeliCode=findViewById(R.id.MeliCode);
        Document=findViewById(R.id.Document);
        Mobile=findViewById(R.id.Mobile);
        Parking=findViewById(R.id.Parking);
        Storeroom=findViewById(R.id.Storeroom);
        Elevator=findViewById(R.id.Elevator);
        //Floating=findViewById(R.id.Floating);


        if (getIntent().hasExtra("IdExtra")){
            idExtra=(getIntent().getExtras().getInt("IdExtra"));

             Building_Note note =new Building_Note();
             note = db.GetNote(idExtra);

            Title.setText(note.getTITLE());
            Description.setText(note.getDESCRIPTION());
            Old.setText(""+note.getOLD());
            Meter.setText(""+note.getMETER());
            Floor.setText(""+note.getFLOOR());
            Parking.setChecked(note.getPARKING() == 1);
            Storeroom.setChecked(note.getSTOREROOM() == 1);
            Elevator.setChecked(note.getELEVATOR() == 1);
            RoomNumber.setText(""+note.getROOM_NUMBER());
            HouseModel.setText(note.getHOUSE_MODEL());
            FixedPrice.setText(""+note.getFIXED_PRICE());
            PricePerMeter.setText(""+note.getPRICE_PER_METER());
            MeliCode.setText(""+note.getMELI_CODE());
            Document.setText(note.getDOCUMENT());
            Mobile.setText(""+note.getMOBILE());


        }

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Building_Note note =new Building_Note(

                        Title.getText().toString(),
                        Description.getText().toString(),
                        Long.parseLong(Old.getText().toString()),
                        Long.parseLong(Meter.getText().toString()),
                        Long.parseLong(Floor.getText().toString()),
                        Parking.isChecked() ? 1 : 0,
                        Storeroom.isChecked() ? 1: 0,
                        Elevator.isChecked() ? 1 : 0,
                        Long.parseLong(RoomNumber.getText().toString()),
                        HouseModel.getText().toString(),
                        Long.parseLong(FixedPrice.getText().toString()),
                        Long.parseLong(PricePerMeter.getText().toString()),
                        Long.parseLong(MeliCode.getText().toString()),
                        Document.getText().toString(),
                        Long.parseLong(Mobile.getText().toString()),
                        ImageStore

                );
                if (idExtra==0){
                    db.InsertNote(note);
                }
                else {
                    db.UpdateNote(idExtra,note);
                }


                Intent intent =new Intent(AddNoteActivityBuilding.this,MainActivity.class);
                intent.putExtra("RefreshItems",true);
                startActivity(intent);
                finish();

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
                        if (notes!=null){
                            startActivity(new Intent(getApplicationContext(),Profile.class));
                        }else {
                            startActivity(new Intent(getApplicationContext(),AddNoteActivity.class));
                        }
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

    private void pickImage (){

    }

    private void requestStoragePermission (){
        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
    }

    private boolean checkStoragePermission (){
        boolean res=ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED;
        return res;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (resultCode==RESULT_OK){
                if (requestCode==GALLERY_REQ_CODE){
                    ImageStore=MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());
                    imageView2.setImageURI(data.getData());
                    PicPath.setText(data.getData().toString());
                }
            }
        }catch (Exception e){
            Toast.makeText(AddNoteActivityBuilding.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

   }


    //public void buttonInsert(View view){
      //  ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
              //  Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        //String stringFilePath = Environment.getExternalStorageDirectory().getPath()+"/Download/"+PicPath.getText().toString()+".jpeg";
       // Bitmap bitmap = BitmapFactory.decodeFile(stringFilePath);
      //  ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
       // bitmap.compress(Bitmap.CompressFormat.PNG,0,byteArrayOutputStream);
       // byte[] bytesImage =byteArrayOutputStream.toByteArray();

    //}
}