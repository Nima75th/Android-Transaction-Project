package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Contract extends AppCompatActivity {
    private Button Rant,Sell,FirstMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);
        Rant=findViewById(R.id.Rant);
        Sell=findViewById(R.id.Sell);
        FirstMoney=findViewById(R.id.FirstMoney);




        Rant.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Contract.this, RantActivity.class);
                startActivity(intent);
            }
        });

        Sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Contract.this,SellActivity.class);
                startActivity(intent);

            }
        });

        FirstMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Contract.this,FirstMoneyActivity.class);
                startActivity(intent);

            }
        });
    }
}