package com.example.navigation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class NoteBuildingView extends RecyclerView.ViewHolder {

    public TextView Title,Description,Old,Meter,Floor,RoomNumber,HouseModel,FixedPrice,PricePerMeter,MeliCode,Document,Mobile;
    public SwitchMaterial Parking,StoreRoom,Elevator;
    public NoteBuildingView(@NonNull View itemView) {
        super(itemView);

        Title=itemView.findViewById(R.id.Title);
        Description=itemView.findViewById(R.id.Description);
        Old=itemView.findViewById(R.id.Old);
        Meter=itemView.findViewById(R.id.Meter);
        Floor=itemView.findViewById(R.id.Floor);
        Parking=itemView.findViewById(R.id.Parking);
        StoreRoom=itemView.findViewById(R.id.Storeroom);
        Elevator=itemView.findViewById(R.id.Elevator);
        RoomNumber=itemView.findViewById(R.id.RoomNumber);
        HouseModel=itemView.findViewById(R.id.HouseModel);
        FixedPrice=itemView.findViewById(R.id.FixedPrice);
        PricePerMeter=itemView.findViewById(R.id.PricePerMeter);
        MeliCode=itemView.findViewById(R.id.MeliCode);
        Document=itemView.findViewById(R.id.Document);
        Mobile=itemView.findViewById(R.id.Mobile);


    }
}
