package com.example.navigation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private Context context;
    private ArrayList<Note_Sighnup> notes;


    public NoteRecyclerAdapter(Context context , ArrayList<Note_Sighnup> notes){


        this.context=context;
        this.notes=notes;


    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_note,parent,false);


        return new NoteViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        Note_Sighnup note =notes.get(position);

        holder.TxtName.setText((note.getName()));
        holder.T_Mobile.setText(" "+note.getMobile());
        holder.T_Meli.setText(""+note.getId_Code());
        holder.T_Email.setText(note.getEmail());
        holder.T_Address.setText(note.getAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,AddNoteActivity.class);
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
