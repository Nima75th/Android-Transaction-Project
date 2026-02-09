package com.example.navigation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DB_Helper_Asa extends SQLiteOpenHelper  {

    public static final String TABLE_NAME="Asa_Table";
    public static final String ID ="id";
    public static final String NAME ="Name";
    public static final String MELI_CODE = "Meli_Code";
    public static final String Mobile = "Mobile";
    public static final String EMAIL = "Email";
    public static final String ADDRESS = "Address";
    public static final String PIC = "Pic";
    private ByteArrayOutputStream bt;
    private byte[] ImageByte;



    public DB_Helper_Asa(@Nullable Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NOTE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + MELI_CODE + " LONG, " + Mobile + " LONG, " + EMAIL + " TEXT, " + ADDRESS + " TEXT, " + PIC + "BLOB)";
        db.execSQL(CREATE_NOTE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP_TABLE);
        onCreate(db);

    }
    //open database;
    public void OpenDatabase(){
        SQLiteDatabase db = this.getWritableDatabase();

    }

    //Insert in to database;
    public void InsertNote(Note_Sighnup note){

        Bitmap bitmap =note.getPic();
        bt=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,bt);
        ImageByte=bt.toByteArray();

        ContentValues cv = new ContentValues();
        cv.put(NAME,note.getName());
        cv.put(MELI_CODE,note.getId_Code());
        cv.put(Mobile,note.getMobile());
        cv.put(EMAIL,note.getEmail());
        cv.put(ADDRESS,note.getAddress());
        cv.put(PIC,ImageByte);

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME,null,cv);
    }

    //Get single Note;
    public Note_Sighnup getNote(Long notMeli){

        SQLiteDatabase db = this.getWritableDatabase();
        Note_Sighnup note = null;
        Cursor cursor = null;

        try {

            cursor=db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + MELI_CODE + " = " + notMeli,null);
            if (cursor!=null){
                if (cursor.moveToFirst()){
                    byte[] ImageByte =cursor.getBlob(cursor.getColumnIndexOrThrow(PIC));
                    Bitmap bitmap = BitmapFactory.decodeByteArray(ImageByte,0,ImageByte.length);
                    note=new Note_Sighnup(

                            cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
                            cursor.getString(cursor.getColumnIndexOrThrow(NAME)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(MELI_CODE)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(Mobile)),
                            cursor.getString(cursor.getColumnIndexOrThrow(EMAIL)),
                            cursor.getString(cursor.getColumnIndexOrThrow(ADDRESS)),
                         bitmap

                    );
                }
            }

        }finally {
            cursor.close();

        }

        return note;
    }


    //Show note;
    public Note_Sighnup ShowNote(){

        SQLiteDatabase db = this.getWritableDatabase();
        Note_Sighnup note = null;
        Cursor cursor = null;

        try {

            cursor=db.rawQuery("SELECT * FROM " + TABLE_NAME ,null);
            if (cursor!=null){
                if (cursor.moveToFirst()){
                    byte [] ImageByte =cursor.getBlob(cursor.getColumnIndexOrThrow(PIC));
                    Bitmap bitmap =BitmapFactory.decodeByteArray(ImageByte,0,ImageByte.length);
                    note=new Note_Sighnup(

                            cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
                            cursor.getString(cursor.getColumnIndexOrThrow(NAME)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(MELI_CODE)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(Mobile)),
                            cursor.getString(cursor.getColumnIndexOrThrow(EMAIL)),
                            cursor.getString(cursor.getColumnIndexOrThrow(ADDRESS)),
                            bitmap

                    );
                }
            }

        }finally {
            cursor.close();

        }

        return note;
    }


    //Get List Of Not`s;
    public ArrayList<Note_Sighnup> getNotes(NoteDto noteDto){

        ArrayList<Note_Sighnup> notes = new ArrayList<>();
        Cursor cursor =null;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            cursor=db.query(TABLE_NAME,null,noteDto != null ? NAME + " LIKE '%" +noteDto.getName().toLowerCase() + "%'" : ID + " > " + 0 , null,null, null,null,null);
            if (cursor!=null){
                if (cursor.moveToFirst()){
                    do {

                        Note_Sighnup note =new  Note_Sighnup(
                                cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
                                cursor.getString(cursor.getColumnIndexOrThrow(NAME)),
                                cursor.getLong(cursor.getColumnIndexOrThrow(MELI_CODE)),
                                cursor.getLong(cursor.getColumnIndexOrThrow(Mobile)),
                                cursor.getString(cursor.getColumnIndexOrThrow(EMAIL)),
                                cursor.getString(cursor.getColumnIndexOrThrow(ADDRESS)),
                                null
                        );
                        notes.add(note);

                    }while (cursor.moveToNext());
                }

            }

        }finally {
            assert cursor!=null;
            cursor.close();

        }
        return notes;
    }

    //Update Note ;
    public void UpdateNote(Long noteId,Note_Sighnup note){

        Bitmap bitmap =note.getPic();
        bt=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,bt);
        ImageByte=bt.toByteArray();

        ContentValues cv = new ContentValues();
        cv.put(NAME,note.getName());
        cv.put(MELI_CODE,note.getId_Code());
        cv.put(Mobile,note.getMobile());
        cv.put(EMAIL,note.getEmail());
        cv.put(ADDRESS,note.getAddress());
        cv.put(PIC,ImageByte);

        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_NAME,cv,ID + "=?" , new String[]{String.valueOf(noteId)});
    }
    //Delete a Note;
    public void DeleteNote(Long noteId){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,ID + "=?" , new String[]{String.valueOf(noteId)});

    }

}
