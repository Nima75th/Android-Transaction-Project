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

public class DB_Bulding extends SQLiteOpenHelper {


    public static final String TABLE_NAME ="Building_Table";
    public static final String ID ="Id";
    public static final String TITLE = "Title";
    public static final String DESCRIPTION = "Description";
    public static final String OLD = "Old";
    public static final String METER = "Meter";
    public static final String FLOOR ="Floor";
    public static final String PARKING = "Parking";
    public static final String STOREROOM = "Storeroom";
    public static final String ELEVATOR = "Elevator";
    public static final String ROOM_NUMBER = "Room_Number";
    public static final String HOUSE_MODEL = "House_Model";
    public static final String FIXED_PRICE = "Fixed_Price";
    public static final String PRICE_PER_METER = "Price_Per_meter";
    public static final String MELI_CODE = "Meli_Code";
    public static final String DOCUMENT = "Document";
    public static final String MOBILE = "Mobile";
    public static final String PIC = "Pic";
    private ByteArrayOutputStream bt;
    private byte[] ImageByte;



    public DB_Bulding(@Nullable Context context) {
        super(context, "Building_Table", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TITLE + " TEXT, " + DESCRIPTION + " TEXT, " + OLD + " LONG, "
                + METER + " LONG," + FLOOR + " LONG," + PARKING + " INT," + STOREROOM + " INT," + ELEVATOR + " INT," + ROOM_NUMBER + " LONG," + HOUSE_MODEL + " TEXT,"
                + FIXED_PRICE + " LONG," + PRICE_PER_METER + " LONG," + MELI_CODE  + " LONG, " + DOCUMENT + " TEXT," + MOBILE + " LONG," + PIC + " BLOB)";

        db.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String DROP_TABLE ="DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP_TABLE);
        onCreate(db);

    }

    //Open Database;
    public void OpenDatabase(){
        SQLiteDatabase db =this.getWritableDatabase();
    }

    //Insert Into Database;
    public void InsertNote(Building_Note note){


        Bitmap bitmap =note.getPIC();
        bt=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,50,bt);
        ImageByte=bt.toByteArray();

        ContentValues cv = new ContentValues();
        cv.put(TITLE,note.getTITLE());
        cv.put(DESCRIPTION,note.getDESCRIPTION());
        cv.put(OLD,note.getOLD());
        cv.put(METER,note.getMETER());
        cv.put(FLOOR,note.getFLOOR());
        cv.put(PARKING,note.getPARKING());
        cv.put(STOREROOM,note.getSTOREROOM());
        cv.put(ELEVATOR,note.getELEVATOR());
        cv.put(ROOM_NUMBER,note.getROOM_NUMBER());
        cv.put(HOUSE_MODEL,note.getHOUSE_MODEL());
        cv.put(FIXED_PRICE,note.getFIXED_PRICE());
        cv.put(PRICE_PER_METER,note.getPRICE_PER_METER());
        cv.put(MELI_CODE,note.getMELI_CODE());
        cv.put(DOCUMENT,note.getDOCUMENT());
        cv.put(MOBILE,note.getMOBILE());
        cv.put(PIC,ImageByte);
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(TABLE_NAME,null,cv);

    }

    //Get Single Note;
    public Building_Note GetNote(int noteId){

        SQLiteDatabase db=this.getWritableDatabase();
        Building_Note note =null;
        Cursor cursor =null;
        try {
            cursor=db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = " + noteId ,null);
            if (cursor != null){
                if (cursor.moveToFirst()){
                    byte[] ImageByte =cursor.getBlob(cursor.getColumnIndexOrThrow(PIC));
                    Bitmap bitmap = BitmapFactory.decodeByteArray(ImageByte,0,ImageByte.length);
                    note=new Building_Note(

                            cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
                            cursor.getString(cursor.getColumnIndexOrThrow(TITLE)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(OLD)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(METER)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(FLOOR)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(PARKING)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(STOREROOM)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(ELEVATOR)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(ROOM_NUMBER)),
                            cursor.getString(cursor.getColumnIndexOrThrow(HOUSE_MODEL)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(FIXED_PRICE)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(PRICE_PER_METER)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(MELI_CODE)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DOCUMENT)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(MOBILE)),
                            bitmap

                    );
                }
            }

        }finally {
            cursor.close();
        }
        return note;
    }

    //Get List of Notes;
    public ArrayList<Building_Note> GetNotes(BuildingNoteDto noteDto){

        ArrayList<Building_Note> notes = new ArrayList<>();
        Cursor cursor =null;
        try {

            SQLiteDatabase db=this.getWritableDatabase();
            cursor=db.query(TABLE_NAME,null,noteDto != null ? TITLE + " LIKE '%" +noteDto.getTitle().toLowerCase() + "%'" : ID + " > " + 0 ,null,null,null,null,null );
            if (cursor!=null){
                if (cursor.moveToFirst()){
                    do {
                        byte[] ImageByte =cursor.getBlob(cursor.getColumnIndexOrThrow(PIC));
                        Bitmap bitmap = BitmapFactory.decodeByteArray(ImageByte,0,ImageByte.length);
                        Building_Note note =new Building_Note(

                                cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
                                cursor.getString(cursor.getColumnIndexOrThrow(TITLE)),
                                cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION)),
                                cursor.getLong(cursor.getColumnIndexOrThrow(OLD)),
                                cursor.getLong(cursor.getColumnIndexOrThrow(METER)),
                                cursor.getLong(cursor.getColumnIndexOrThrow(FLOOR)),
                                cursor.getInt(cursor.getColumnIndexOrThrow(PARKING)),
                                cursor.getInt(cursor.getColumnIndexOrThrow(STOREROOM)),
                                cursor.getInt(cursor.getColumnIndexOrThrow(ELEVATOR)),
                                cursor.getLong(cursor.getColumnIndexOrThrow(ROOM_NUMBER)),
                                cursor.getString(cursor.getColumnIndexOrThrow(HOUSE_MODEL)),
                                cursor.getLong(cursor.getColumnIndexOrThrow(FIXED_PRICE)),
                                cursor.getLong(cursor.getColumnIndexOrThrow(PRICE_PER_METER)),
                                cursor.getLong(cursor.getColumnIndexOrThrow(MELI_CODE)),
                                cursor.getString(cursor.getColumnIndexOrThrow(DOCUMENT)),
                                cursor.getLong(cursor.getColumnIndexOrThrow(MOBILE)),
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

    //Update Note;
    public void UpdateNote(int noteId,Building_Note note){

        ContentValues cv = new ContentValues();

        cv.put(TITLE,note.getTITLE());
        cv.put(DESCRIPTION,note.getDESCRIPTION());
        cv.put(OLD,note.getOLD());
        cv.put(METER,note.getMETER());
        cv.put(FLOOR,note.getFLOOR());
        cv.put(PARKING,note.getPARKING());
        cv.put(STOREROOM,note.getSTOREROOM());
        cv.put(ELEVATOR,note.getELEVATOR());
        cv.put(ROOM_NUMBER,note.getROOM_NUMBER());
        cv.put(HOUSE_MODEL,note.getHOUSE_MODEL());
        cv.put(FIXED_PRICE,note.getFIXED_PRICE());
        cv.put(PRICE_PER_METER,note.getPRICE_PER_METER());
        cv.put(MELI_CODE,note.getMELI_CODE());
        cv.put(DOCUMENT,note.getDOCUMENT());
        cv.put(MOBILE,note.getMOBILE());

        SQLiteDatabase db=this.getWritableDatabase();
        db.update(TABLE_NAME,cv, ID + "=?" ,new String[]{String.valueOf(noteId)});


    }

    //Delete Note;
    public void DeleteNote(int noteId){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,ID + "=?" ,new String[]{String.valueOf(noteId)});
    }
}
