package com.example.navigation;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    public TextView TxtName;
    public TextView T_Meli ,T_Email, T_Address,T_Mobile;


    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);


        TxtName =itemView.findViewById(R.id.TxtName);
        T_Meli = itemView.findViewById(R.id.T_Meli);
        T_Email=itemView.findViewById(R.id.T_Email);
        T_Address=itemView.findViewById(R.id.T_Address);
        T_Mobile=itemView.findViewById(R.id.T_Mobile);
    }
}
