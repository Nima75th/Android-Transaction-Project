package com.example.navigation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContractView extends RecyclerView.ViewHolder {

    public TextView Title,FixedPrice,FixedPriceLabl;
    public ImageView Image;
    public ContractView(@NonNull View itemView) {
        super(itemView);

        Title=itemView.findViewById(R.id.Title);
        FixedPrice=itemView.findViewById(R.id.FixedPrice);
        FixedPriceLabl=itemView.findViewById(R.id.FixedPrice_Lable);
        Image=itemView.findViewById(R.id.Image);
    }
}
