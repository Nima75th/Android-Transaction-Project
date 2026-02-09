package com.example.navigation;

import androidx.biometric.BiometricPrompt;

public class Rent_Details_Note {

    private int ID;
    private String TYPE_OF_RENT;
    private int PARKING;
    private int STOREROOM;
    private int WATER;
    private int ELECTRICITY;
    private int GAZ;
    private int ROOM;
    private int ROOM_COUNT;
    private String TIME_OF_RENT;
    private long FROM_DAY;
    private long FROM_MONTH;
    private long FROM_YEAR;
    private long TO_DAY;
    private long TO_MONTH;
    private long TO_YEAR;
    private long MORTGAGE_NUMBER;
    private String MORTGAGE_WORD;
    private long MONTHLY_RENT_NUMBER;
    private String MONTHLY_RENT_WORD;

    public Rent_Details_Note() {
    }

    public Rent_Details_Note(int ID, String TYPE_OF_RENT, int PARKING, int STOREROOM, int WATER, int ELECTRICITY, int GAZ, int ROOM, int ROOM_COUNT, String TIME_OF_RENT, long FROM_DAY, long FROM_MONTH, long FROM_YEAR, long TO_DAY, long TO_MONTH, long TO_YEAR, long MORTGAGE_NUMBER, String MORTGAGE_WORD, long MONTHLY_RENT_NUMBER, String MONTHLY_RENT_WORD) {
        this.ID = ID;
        this.TYPE_OF_RENT = TYPE_OF_RENT;
        this.PARKING = PARKING;
        this.STOREROOM = STOREROOM;
        this.WATER = WATER;
        this.ELECTRICITY = ELECTRICITY;
        this.GAZ = GAZ;
        this.ROOM = ROOM;
        this.ROOM_COUNT = ROOM_COUNT;
        this.TIME_OF_RENT = TIME_OF_RENT;
        this.FROM_DAY = FROM_DAY;
        this.FROM_MONTH = FROM_MONTH;
        this.FROM_YEAR = FROM_YEAR;
        this.TO_DAY = TO_DAY;
        this.TO_MONTH = TO_MONTH;
        this.TO_YEAR = TO_YEAR;
        this.MORTGAGE_NUMBER = MORTGAGE_NUMBER;
        this.MORTGAGE_WORD = MORTGAGE_WORD;
        this.MONTHLY_RENT_NUMBER = MONTHLY_RENT_NUMBER;
        this.MONTHLY_RENT_WORD = MONTHLY_RENT_WORD;
    }

    public Rent_Details_Note(String TYPE_OF_RENT, int PARKING, int STOREROOM, int WATER, int ELECTRICITY, int GAZ, int ROOM, int ROOM_COUNT, String TIME_OF_RENT, long FROM_DAY, long FROM_MONTH, long FROM_YEAR, long TO_DAY, long TO_MONTH, long TO_YEAR, long MORTGAGE_NUMBER, String MORTGAGE_WORD, long MONTHLY_RENT_NUMBER, String MONTHLY_RENT_WORD) {
        this.TYPE_OF_RENT = TYPE_OF_RENT;
        this.PARKING = PARKING;
        this.STOREROOM = STOREROOM;
        this.WATER = WATER;
        this.ELECTRICITY = ELECTRICITY;
        this.GAZ = GAZ;
        this.ROOM = ROOM;
        this.ROOM_COUNT = ROOM_COUNT;
        this.TIME_OF_RENT = TIME_OF_RENT;
        this.FROM_DAY = FROM_DAY;
        this.FROM_MONTH = FROM_MONTH;
        this.FROM_YEAR = FROM_YEAR;
        this.TO_DAY = TO_DAY;
        this.TO_MONTH = TO_MONTH;
        this.TO_YEAR = TO_YEAR;
        this.MORTGAGE_NUMBER = MORTGAGE_NUMBER;
        this.MORTGAGE_WORD = MORTGAGE_WORD;
        this.MONTHLY_RENT_NUMBER = MONTHLY_RENT_NUMBER;
        this.MONTHLY_RENT_WORD = MONTHLY_RENT_WORD;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTYPE_OF_RENT() {
        return TYPE_OF_RENT;
    }

    public void setTYPE_OF_RENT(String TYPE_OF_RENT) {
        this.TYPE_OF_RENT = TYPE_OF_RENT;
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

    public int getWATER() {
        return WATER;
    }

    public void setWATER(int WATER) {
        this.WATER = WATER;
    }

    public int getELECTRICITY() {
        return ELECTRICITY;
    }

    public void setELECTRICITY(int ELECTRICITY) {
        this.ELECTRICITY = ELECTRICITY;
    }

    public int getGAZ() {
        return GAZ;
    }

    public void setGAZ(int GAZ) {
        this.GAZ = GAZ;
    }

    public int getROOM() {
        return ROOM;
    }

    public void setROOM(int ROOM) {
        this.ROOM = ROOM;
    }

    public int getROOM_COUNT() {
        return ROOM_COUNT;
    }

    public void setROOM_COUNT(int ROOM_COUNT) {
        this.ROOM_COUNT = ROOM_COUNT;
    }

    public String getTIME_OF_RENT() {
        return TIME_OF_RENT;
    }

    public void setTIME_OF_RENT(String TIME_OF_RENT) {
        this.TIME_OF_RENT = TIME_OF_RENT;
    }

    public long getFROM_DAY() {
        return FROM_DAY;
    }

    public void setFROM_DAY(long FROM_DAY) {
        this.FROM_DAY = FROM_DAY;
    }

    public long getFROM_MONTH() {
        return FROM_MONTH;
    }

    public void setFROM_MONTH(long FROM_MONTH) {
        this.FROM_MONTH = FROM_MONTH;
    }

    public long getFROM_YEAR() {
        return FROM_YEAR;
    }

    public void setFROM_YEAR(long FROM_YEAR) {
        this.FROM_YEAR = FROM_YEAR;
    }

    public long getTO_DAY() {
        return TO_DAY;
    }

    public void setTO_DAY(long TO_DAY) {
        this.TO_DAY = TO_DAY;
    }

    public long getTO_MONTH() {
        return TO_MONTH;
    }

    public void setTO_MONTH(long TO_MONTH) {
        this.TO_MONTH = TO_MONTH;
    }

    public long getTO_YEAR() {
        return TO_YEAR;
    }

    public void setTO_YEAR(long TO_YEAR) {
        this.TO_YEAR = TO_YEAR;
    }

    public long getMORTGAGE_NUMBER() {
        return MORTGAGE_NUMBER;
    }

    public void setMORTGAGE_NUMBER(long MORTGAGE_NUMBER) {
        this.MORTGAGE_NUMBER = MORTGAGE_NUMBER;
    }

    public String getMORTGAGE_WORD() {
        return MORTGAGE_WORD;
    }

    public void setMORTGAGE_WORD(String MORTGAGE_WORD) {
        this.MORTGAGE_WORD = MORTGAGE_WORD;
    }

    public long getMONTHLY_RENT_NUMBER() {
        return MONTHLY_RENT_NUMBER;
    }

    public void setMONTHLY_RENT_NUMBER(long MONTHLY_RENT_NUMBER) {
        this.MONTHLY_RENT_NUMBER = MONTHLY_RENT_NUMBER;
    }

    public String getMONTHLY_RENT_WORD() {
        return MONTHLY_RENT_WORD;
    }

    public void setMONTHLY_RENT_WORD(String MONTHLY_RENT_WORD) {
        this.MONTHLY_RENT_WORD = MONTHLY_RENT_WORD;
    }
}
