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

public class SighnUpDB extends SQLiteOpenHelper {

    public static final String TABLE_NAME="SighnUpDB";
    public static final String ID ="Id";
    public static final String NAME="Name";
    public static final String ID_CODE="Id_Code";
    public static final String MOBILE ="Mobile";
    public static final String EMAIL="Email";
    public static final String ADDRESS="Address";
    public static final String PIC="Pic";
    private ByteArrayOutputStream bt;
    private byte[] ImageByte;

    public SighnUpDB(@Nullable Context context) {
        super(context, "SighnUpDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
          String CREATE_TABLE="CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                  + NAME + " TEXT, " + ID_CODE + " LONG, " + MOBILE + " LONG, " + EMAIL + " TEXT, " + ADDRESS + " TEXT, " + PIC + " BLOB)";
          db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String DROP_TABLE ="DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP_TABLE);
        onCreate(db);

    }
    //Open Database
    public void OpenDatabase(){
        SQLiteDatabase db=this.getWritableDatabase();
    }
    //Insert Into The Database
    public void InsertNote(SighnUpNote note){
        Bitmap bitmap =note.getPIC();
        bt=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,70,bt);
        ImageByte=bt.toByteArray();

        ContentValues cv =new ContentValues();
        cv.put(NAME,note.getNAME());
        cv.put(ID_CODE,note.getID_CODE());
        cv.put(MOBILE,note.getMOBILE());
        cv.put(EMAIL,note.getEMAIL());
        cv.put(ADDRESS,note.getADDRESS());
        cv.put(PIC,ImageByte);
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(TABLE_NAME,null,cv);
    }

//Get Single Note
    public SighnUpNote GetNote(Long noteMeli){
        SQLiteDatabase db=this.getWritableDatabase();
        SighnUpNote note=null;
        Cursor cursor=null;
        try {
            cursor= db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + ID_CODE + " = " + noteMeli ,null);
            if (cursor!= null){
                if (cursor.moveToFirst()){
                    byte[] ImageByte = cursor.getBlob(cursor.getColumnIndexOrThrow(PIC));
                    Bitmap bitmap = BitmapFactory.decodeByteArray(ImageByte,0,ImageByte.length);
                    note = new SighnUpNote(
                            cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
                            cursor.getString(cursor.getColumnIndexOrThrow(NAME)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(ID_CODE)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(MOBILE)),
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

    //Get Notes
    public ArrayList<SighnUpNote>GetNotes(BuildingNoteDto noteDto){
        ArrayList<SighnUpNote> notes=new ArrayList<>();
        Cursor cursor =null;
        try {
            SQLiteDatabase db=this.getWritableDatabase();
            cursor=db.query(TABLE_NAME,null,noteDto !=null ? NAME + " LIKE '%" + noteDto.getTitle().toLowerCase() + "%'" : ID + " > " + 0 ,null,null,null,null,null);
            if (cursor!=null){
                if (cursor.moveToFirst()){
                    do {
                        byte[] ImageByte=cursor.getBlob(cursor.getColumnIndexOrThrow(PIC));
                        Bitmap bitmap =BitmapFactory.decodeByteArray(ImageByte,0,ImageByte.length);
                        SighnUpNote note =new SighnUpNote(
                                cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
                                cursor.getString(cursor.getColumnIndexOrThrow(NAME)),
                                cursor.getLong(cursor.getColumnIndexOrThrow(ID_CODE)),
                                cursor.getLong(cursor.getColumnIndexOrThrow(MOBILE)),
                                cursor.getString(cursor.getColumnIndexOrThrow(EMAIL)),
                                cursor.getString(cursor.getColumnIndexOrThrow(ADDRESS)),
                                bitmap

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

}
