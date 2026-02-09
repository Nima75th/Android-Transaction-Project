package com.example.navigation;

import android.graphics.Bitmap;

import java.lang.ref.PhantomReference;
import java.sql.Blob;

public class Building_Note {

    private int ID;
    private String TITLE;
    private String DESCRIPTION;
    private long OLD;
    private long METER;
    private long FLOOR;
    private int PARKING;
    private int STOREROOM;
    private int ELEVATOR;
    private long ROOM_NUMBER;
    private String HOUSE_MODEL;
    private long FIXED_PRICE;
    private long PRICE_PER_METER;
    private long MELI_CODE;
    private String DOCUMENT;
    private long MOBILE;
    private Bitmap PIC;

    public Building_Note(String TITLE, String DESCRIPTION, long OLD, long METER, long FLOOR, int PARKING, int STOREROOM, int ELEVATOR, long ROOM_NUMBER, String HOUSE_MODEL, long FIXED_PRICE, long PRICE_PER_METER, long MELI_CODE, String DOCUMENT, long MOBILE, Bitmap PIC) {
        this.TITLE = TITLE;
        this.DESCRIPTION = DESCRIPTION;
        this.OLD = OLD;
        this.METER = METER;
        this.FLOOR = FLOOR;
        this.PARKING = PARKING;
        this.STOREROOM = STOREROOM;
        this.ELEVATOR = ELEVATOR;
        this.ROOM_NUMBER = ROOM_NUMBER;
        this.HOUSE_MODEL = HOUSE_MODEL;
        this.FIXED_PRICE = FIXED_PRICE;
        this.PRICE_PER_METER = PRICE_PER_METER;
        this.MELI_CODE = MELI_CODE;
        this.DOCUMENT = DOCUMENT;
        this.MOBILE = MOBILE;
        this.PIC = PIC;
    }

    public Building_Note(int ID, String TITLE, String DESCRIPTION, long OLD, long METER, long FLOOR, int PARKING, int STOREROOM, int ELEVATOR, long ROOM_NUMBER, String HOUSE_MODEL, long FIXED_PRICE, long PRICE_PER_METER, long MELI_CODE, String DOCUMENT, long MOBILE, Bitmap PIC) {
        this.ID = ID;
        this.TITLE = TITLE;
        this.DESCRIPTION = DESCRIPTION;
        this.OLD = OLD;
        this.METER = METER;
        this.FLOOR = FLOOR;
        this.PARKING = PARKING;
        this.STOREROOM = STOREROOM;
        this.ELEVATOR = ELEVATOR;
        this.ROOM_NUMBER = ROOM_NUMBER;
        this.HOUSE_MODEL = HOUSE_MODEL;
        this.FIXED_PRICE = FIXED_PRICE;
        this.PRICE_PER_METER = PRICE_PER_METER;
        this.MELI_CODE = MELI_CODE;
        this.DOCUMENT = DOCUMENT;
        this.MOBILE = MOBILE;
        this.PIC = PIC;
    }

    public Building_Note() {
    }

    public Building_Note(int parseInt, String description, long old, long meter, String toString, String description1, int storeroom, String toString1, String toString2, long parseInt1, long fixed_price, long fixed_price1, long parseInt2, long parseInt3, String toString3, long parseInt4) {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public long getOLD() {
        return OLD;
    }

    public void setOLD(int OLD) {
        this.OLD = OLD;
    }

    public long getMETER() {
        return METER;
    }

    public void setMETER(int METER) {
        this.METER = METER;
    }

    public long getFLOOR() {
        return FLOOR;
    }

    public void setFLOOR(int FLOOR) {
        this.FLOOR = FLOOR;
    }

    public int getPARKING() {
        return PARKING;
    }

    public void setPARKING(int PARKING) {
        this.PARKING = PARKING;
    }

    public int getSTOREROOM() {
        return STOREROOM;
    }

    public void setSTOREROOM(int STOREROOM) {
        this.STOREROOM = STOREROOM;
    }

    public int getELEVATOR() {
        return ELEVATOR;
    }

    public void setELEVATOR(int ELEVATOR) {
        this.ELEVATOR = ELEVATOR;
    }

    public long getROOM_NUMBER() {
        return ROOM_NUMBER;
    }

    public void setROOM_NUMBER(int ROOM_NUMBER) {
        this.ROOM_NUMBER = ROOM_NUMBER;
    }

    public String getHOUSE_MODEL() {
        return HOUSE_MODEL;
    }

    public void setHOUSE_MODEL(String HOUSE_MODEL) {
        this.HOUSE_MODEL = HOUSE_MODEL;
    }

    public long getFIXED_PRICE() {
        return FIXED_PRICE;
    }

    public void setFIXED_PRICE(int FIXED_PRICE) {
        this.FIXED_PRICE = FIXED_PRICE;
    }

    public long getPRICE_PER_METER() {
        return PRICE_PER_METER;
    }

    public void setPRICE_PER_METER(int PRICE_PER_METER) {
        this.PRICE_PER_METER = PRICE_PER_METER;
    }

    public long getMELI_CODE() {
        return MELI_CODE;
    }

    public void setMELI_CODE(int MELI_CODE) {
        this.MELI_CODE = MELI_CODE;
    }

    public String getDOCUMENT() {
        return DOCUMENT;
    }

    public void setDOCUMENT(String DOCUMENT) {
        this.DOCUMENT = DOCUMENT;
    }

    public long getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(int MOBILE) {
        this.MOBILE = MOBILE;
    }

    public Bitmap getPIC() {
        return PIC;
    }

    public void setPIC(Bitmap PIC) {
        this.PIC = PIC;
    }
}
