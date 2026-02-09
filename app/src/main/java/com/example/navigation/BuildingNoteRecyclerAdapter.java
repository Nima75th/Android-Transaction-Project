package com.example.navigation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BuildingNoteRecyclerAdapter extends RecyclerView.Adapter<NoteBuildingView> {

    private Context context;
    private ArrayList<Building_Note> notes;

    public BuildingNoteRecyclerAdapter (Context context,ArrayList<Building_Note> notes){
        this.context=context;
        this.notes=notes;


    }

    @NonNull
    @Override
    public NoteBuildingView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_note_building,parent,false);

        return new NoteBuildingView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteBuildingView holder, int position) {

        Building_Note note = notes.get(position);

        holder.Title.setText(note.getTITLE());
        holder.Description.setText(note.getDESCRIPTION());
        holder.Old.setText(""+note.getOLD());
        holder.Meter.setText(""+note.getMETER());
        holder.Floor.setText(""+note.getFLOOR());
        holder.Parking.setChecked(note.getPARKING() == 1);
        holder.StoreRoom.setChecked(note.getSTOREROOM() == 1);
        holder.Elevator.setChecked(note.getELEVATOR() == 1);
        holder.RoomNumber.setText(""+note.getROOM_NUMBER());
        holder.HouseModel.setText(note.getHOUSE_MODEL());
        holder.FixedPrice.setText(""+note.getFIXED_PRICE());
        holder.PricePerMeter.setText(""+note.getPRICE_PER_METER());
        holder.MeliCode.setText(""+note.getMELI_CODE());
        holder.Document.setText(note.getDOCUMENT());
        holder.Mobile.setText(""+note.getMOBILE());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,BuildingView.class);
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
