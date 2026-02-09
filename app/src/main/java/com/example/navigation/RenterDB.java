package com.example.navigation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class RenterDB extends SQLiteOpenHelper {

    public static final String TABLE_NAME ="Renter_Table";
    public static final String ID ="Id";
    public static final String DAY = "Day";
    public static final String MONTH = "Month";
    public static final String YEAR = "Year";
    public static final String GIVE_RENT = "Give_Rent";
    public static final String SON_OF = "Son_Of";
    public static final String MELI_NUMBER = "Meli_Number";
    public static final String FROM_WHERE = "From_Where";
    public static final String MELI_CODE = "MeliCode";
    public static final String BIRTH_OF ="Birth_Of";
    public static final String ADDRESS ="Address";
    public static final String POST_CODE = "Post_Code";
    public static final String TELEPHONE = "Telephone";
    public static final String MOBILE = "Mobile";

    public RenterDB(@Nullable Context context) {
        super(context, "Renter_Table", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DAY + " INT, " + MONTH + " INT, " + YEAR + " INT, "
                + GIVE_RENT + " TEXT, " + SON_OF + " TEXT, " + MELI_NUMBER + " LONG, " + FROM_WHERE + " TEXT, "
                + MELI_CODE + " LONG, " + BIRTH_OF + " TEXT, " + ADDRESS + " TEXT, " + POST_CODE + " LONG, "
                + TELEPHONE + " LONG, " + MOBILE + " LONG)";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP_TABLE);
        onCreate(db);

    }

    public void OpenDatabase(){
        SQLiteDatabase db=this.getWritableDatabase();
    }

    public void InsertNote(RentNote note){
        ContentValues cv = new ContentValues();
        cv.put(DAY,note.getDAY());
        cv.put(MONTH,note.getMONTH());
        cv.put(YEAR,note.getYEAR());
        cv.put(GIVE_RENT,note.getRENTER());
        cv.put(SON_OF,note.getSON_OF());
        cv.put(MELI_NUMBER,note.getMELI_NUMBER());
        cv.put(FROM_WHERE,note.getFROM_WHERE());
        cv.put(MELI_CODE,note.getMELI_CODE());
        cv.put(BIRTH_OF,note.getBIRTH_OF());
        cv.put(ADDRESS,note.getADDRESS());
        cv.put(POST_CODE,note.getPOST_CODE());
        cv.put(TELEPHONE,note.getTELEPHONE());
        cv.put(MOBILE,note.getMOBILE());
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(TABLE_NAME,null,cv);
    }

    public RentNote GetNote(int noteId){
        SQLiteDatabase db =this.getWritableDatabase();
        RentNote note=null;
        Cursor cursor =null;
        try {
            cursor=db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + " = " + ID + noteId ,null );
            if (cursor!=null){
                if (cursor.moveToFirst()){
                    note=new RentNote(
                            cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(DAY)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(MONTH)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(YEAR)),
                            cursor.getString(cursor.getColumnIndexOrThrow(GIVE_RENT)),
                            cursor.getString(cursor.getColumnIndexOrThrow(SON_OF)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(MELI_NUMBER)),
                            cursor.getString(cursor.getColumnIndexOrThrow(FROM_WHERE)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(MELI_CODE)),
                            cursor.getString(cursor.getColumnIndexOrThrow(BIRTH_OF)),
                            cursor.getString(cursor.getColumnIndexOrThrow(ADDRESS)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(POST_CODE)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(TELEPHONE)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(MOBILE))
                    );
                }
            }
        }finally {
            cursor.close();
        }
        return note;
    }

}
