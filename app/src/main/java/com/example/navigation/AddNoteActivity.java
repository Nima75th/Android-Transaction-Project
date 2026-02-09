package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class AddNoteActivity extends AppCompatActivity {
    private EditText T_Name,T_Age;
    private Button Submit,Pic,Auth;
    public SighnUpDB db;
    TextView T_View;
    private long idExtra =0 ;
    private String name;
    private long mobile,meli;
    private BottomNavigationView bottomTop;
    private EditText T_Meli ,T_Email, T_Address,T_Mobile;
    private BottomNavigationView bottomNavigationView;
    private ByteArrayOutputStream bt;
    private byte[] ImageByte;
    private Bitmap ImageStore;
    private final int GALLERY_REQ_CODE = 1000;
    private ImageView Picture;
    private TextView View;
    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        T_Name=findViewById(R.id.T_Name);
        T_Mobile=findViewById(R.id.T_Mobile);
        T_Meli = findViewById(R.id.T_Meli);
        T_Email=findViewById(R.id.T_Email);
        T_Address=findViewById(R.id.T_Address);
        Submit=findViewById(R.id.Submit);
        Pic=findViewById(R.id.Pic);
        Auth=findViewById(R.id.Auth);
        Picture=findViewById(R.id.Picture);
        //View=findViewById(R.id.View);
        Submit.setEnabled(false);

        executor=ContextCompat.getMainExecutor(this);
        biometricPrompt=new BiometricPrompt(AddNoteActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(AddNoteActivity.this, "احراز هویت انجام نشده است", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(AddNoteActivity.this, "احراز هویت با موفقیت انجام شد", Toast.LENGTH_SHORT).show();
                Submit.setEnabled(true);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(AddNoteActivity.this, "احراز هویت انجام نشده است", Toast.LENGTH_SHORT).show();
            }
        });

        promptInfo=new BiometricPrompt.PromptInfo.Builder()
        .setTitle("احراز هویت")
        .setSubtitle("احراز هویت با استفاده از اثر انگشت و تصویر صورت")
        .setNegativeButtonText("لغوو")
        .build();

        Auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
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


        db=new SighnUpDB(this);
        db.OpenDatabase();

        if (getIntent().hasExtra("IdExtra")){
            idExtra=(getIntent().getExtras().getLong("IdExtra"));

            //Note_Sighnup note =db.getNote(idExtra);

            //name=note.getName();
            //mobile=note.getMobile();
           // meli=note.getId_Code();
            //T_Name.setText(name);
           // T_Mobile.setText(""+mobile);
           // T_Meli.setText(""+meli);
           // T_Email.setText(note.getEmail());
            //T_Address.setText(note.getAddress());
        }

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SighnUpNote note = new SighnUpNote(

                        T_Name.getText().toString(),
                        Long.parseLong(T_Meli.getText().toString()),
                        Long.parseLong(T_Mobile.getText().toString()),
                        T_Email.getText().toString(),
                        T_Address.getText().toString(),
                        ImageStore
                );


                //if (idExtra==0){

                   db.InsertNote(note);
                //}
                //else {

                 //  T_View.setText("salam");
                   //db.UpdateNote(idExtra,note);
                //}

                Intent intent = new Intent(AddNoteActivity.this,Profile.class);
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

        //bottomTop=findViewById(R.id.bottomTop);
        //bottomTop.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
           // @Override
           // public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                // switch (menuItem.getItemId()){
                     //case R.id.deleteNote:

                        // if (idExtra==0){
                           //  startActivity(new Intent( AddNoteActivity.this,SighnUp.class));
                            // finish();
                         //} else {
                            // //db.DeleteNote(idExtra);
                            // startActivity(new Intent( AddNoteActivity.this,SighnUp.class));
                             //finish();
                        // }

                        // break;
                // }
           // }
        //});
    }

    private void pickImage (){

    }

    private void requestStoragePermission (){
        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
    }

    private boolean checkStoragePermission (){
        boolean res= ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED;
        return res;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (resultCode==RESULT_OK){
                if (requestCode==GALLERY_REQ_CODE){
                    ImageStore=MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());
                    Picture.setImageURI(data.getData());

                }
            }
        }catch (Exception e){
            Toast.makeText(AddNoteActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }


}