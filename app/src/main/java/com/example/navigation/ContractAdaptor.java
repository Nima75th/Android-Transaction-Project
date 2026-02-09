package com.example.navigation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContractAdaptor extends RecyclerView.Adapter<ContractView> {

    private Context context;
    private ArrayList<Building_Note> notes;

    public ContractAdaptor (Context context,ArrayList<Building_Note> notes){
        this.context=context;
        this.notes=notes;
    }

    @NonNull
    @Override
    public ContractView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.front_note_row,parent,false);

        return new ContractView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContractView holder, int position) {

        Building_Note note =notes.get(position);

        holder.Title.setText(note.getTITLE());
        holder.FixedPrice.setText(""+note.getFIXED_PRICE());
        holder.Image.setImageBitmap(note.getPIC());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Mine_View.class);
                intent.putExtra("IdExtra",note.getID());
                context.startActivity(intent);

            }


        });

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
