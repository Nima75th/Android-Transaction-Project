package com.example.navigation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SighnUpAdapter extends RecyclerView.Adapter<SighnUpHolder> {
    private Context context;
    private ArrayList<SighnUpNote> notes;

    public SighnUpAdapter(Context context,ArrayList<SighnUpNote> notes){

        this.context=context;
        this.notes=notes;

    }

    @NonNull
    @Override
    public SighnUpHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.frontsighnup,parent,false);
        return new SighnUpHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SighnUpHolder holder, int position) {

        SighnUpNote note =notes.get(position);
        holder.NameView.setText(note.getNAME());
        holder.CodeMeli.setText(""+note.getID_CODE());
        holder.MobileNumber.setText(""+note.getMOBILE());
        holder.EmailValue.setText(note.getEMAIL());
        holder.AddressValue.setText(note.getADDRESS());
        holder.ImageProf.setImageBitmap(note.getPIC());

       // holder.itemView.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View view) {
               // Intent intent=new Intent(context,SighnUp.class);
               // intent.putExtra("IdExtra",note.getID());
               // context.startActivity(intent);

          //  }


       // });

    }

    @Override
    public int getItemCount() {
      return   notes.size();
    }
}
