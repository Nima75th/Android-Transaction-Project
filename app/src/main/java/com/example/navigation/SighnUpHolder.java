package com.example.navigation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SighnUpHolder extends RecyclerView.ViewHolder {

    public TextView NameView,CodeMeli,MobileNumber,EmailValue,AddressValue;
    public ImageView ImageProf;
    public SighnUpHolder(@NonNull View itemView) {


        super(itemView);

        NameView=itemView.findViewById(R.id.NameView);
        CodeMeli=itemView.findViewById(R.id.CodeMeli);
        MobileNumber=itemView.findViewById(R.id.MobileNumber);
        EmailValue=itemView.findViewById(R.id.EmailValue);
        AddressValue=itemView.findViewById(R.id.AddressValue);
        ImageProf=itemView.findViewById(R.id.ImageProf);

    }
}
