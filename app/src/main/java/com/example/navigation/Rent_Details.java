package com.example.navigation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Rent_Details extends SQLiteOpenHelper {

    public static final String TABLE_NAME ="Rent_Details_Table";
    public static final String ID ="Id";
    public static final String TYPE_OF_RENT ="Type_Of_Rent";
    public static final String PARKING = "Parking";
    public static final String STOREROOM = "Storeroom";
    public static final String WATER = "Water";
    public static final String ELECTRICITY = "Electricity";
    public static final String GAZ = "Gaz";
    public static final String ROOM = "Room";
    public static final String ROOM_COUNT = "Room_Count";
    public static final String TIME_OF_RENT = "Time_Of_Rent";
    public static final String FROM_DAY = "From_Day";
    public static final String FROM_MONTH = "From_Month";
    public static final String FROM_YEAR = "From_Year";
    public static final String TO_DAY = "To_Day";
    public static final String TO_MONTH = "To_Month";
    public static final String TO_YEAR = "To_Year";
    public static final String MORTGAGE_NUMBER = "Mortgage_Number";
    public static final String MORTGAGE_WORD = "Mortgage_Word";
    public static final String MONTHLY_RENT_NUMBER = "Monthly_Rent_Number";
    public static final String MONTHLY_RENT_WORD = "Monthly_Rent_Word";

    public Rent_Details(@Nullable Context context) {
        super(context, "Rent_Details_Table", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TYPE_OF_RENT + " TEXT, " + PARKING + " INT, " + STOREROOM + " INT, " + WATER + " INT, "
                + ELECTRICITY + " INT, " + GAZ + " INT, " + ROOM + " INT, " + ROOM_COUNT + " INT, "
                + TIME_OF_RENT + " TEXT, " + FROM_DAY + " LONG, " + FROM_MONTH + " LONG, "
                + FROM_YEAR + " LONG, " + TO_DAY + " LONG, " + TO_MONTH + " LONG, " + TO_YEAR + " LONG, "
                + MORTGAGE_NUMBER + " LONG, " + MORTGAGE_WORD + " TEXT, " + MONTHLY_RENT_NUMBER + " LONG, "
                + MONTHLY_RENT_WORD + " TEXT)";

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
         String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
         db.execSQL(DROP_TABLE);
         onCreate(db);
    }

    public void InsertNote(Rent_Details_Note note){
        ContentValues cv =new ContentValues();
        cv.put(TYPE_OF_RENT,note.getTYPE_OF_RENT());
        cv.put(PARKING,note.getPARKING());
        cv.put(STOREROOM,note.getSTOREROOM());
        cv.put(WATER,note.getWATER());
        cv.put(ELECTRICITY,note.getELECTRICITY());
        cv.put(GAZ,note.getGAZ());
        cv.put(ROOM,note.getROOM());
        cv.put(ROOM_COUNT,note.getROOM_COUNT());
        cv.put(TIME_OF_RENT,note.getTIME_OF_RENT());
        cv.put(FROM_DAY,note.getFROM_DAY());
        cv.put(FROM_MONTH,note.getFROM_MONTH());
        cv.put(FROM_YEAR,note.getFROM_YEAR());
        cv.put(TO_DAY,note.getTO_DAY());
        cv.put(TO_MONTH,note.getTO_MONTH());
        cv.put(TO_YEAR,note.getTO_YEAR());
        cv.put(MORTGAGE_NUMBER,note.getMORTGAGE_NUMBER());
        cv.put(MORTGAGE_WORD,note.getMORTGAGE_WORD());
        cv.put(MONTHLY_RENT_NUMBER,note.getMONTHLY_RENT_NUMBER());
        cv.put(MONTHLY_RENT_WORD,note.getMONTHLY_RENT_WORD());

        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(TABLE_NAME,null,cv);


    }

    public Rent_Details_Note GetNote (int noteId){
        SQLiteDatabase db=this.getWritableDatabase();
        Rent_Details_Note note =null;
        Cursor cursor = null;
        try {
            cursor=db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + " = " + ID + noteId , null);
            if (cursor!=null){
                if (cursor.moveToFirst()){
                    note=new Rent_Details_Note(
                            cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
                            cursor.getString(cursor.getColumnIndexOrThrow(TYPE_OF_RENT)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(PARKING)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(STOREROOM)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(WATER)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(ELECTRICITY)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(GAZ)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(ROOM)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(ROOM_COUNT)),
                            cursor.getString(cursor.getColumnIndexOrThrow(TIME_OF_RENT)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(FROM_DAY)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(FROM_MONTH)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(FROM_YEAR)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(TO_DAY)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(TO_MONTH)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(TO_YEAR)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(MORTGAGE_NUMBER)),
                            cursor.getString(cursor.getColumnIndexOrThrow(MORTGAGE_WORD)),
                            cursor.getLong(cursor.getColumnIndexOrThrow(MONTHLY_RENT_NUMBER)),
                            cursor.getString(cursor.getColumnIndexOrThrow(MONTHLY_RENT_WORD))
                    );
                }
            }
        }finally {
           cursor.close();
        }
        return note;
    }
}
