package com.example.navigation;

import android.graphics.Bitmap;

public class SighnUpNote {
    private int ID ;
    private String NAME;
    private long ID_CODE;
    private long MOBILE ;
    private String EMAIL;
    private String ADDRESS;
    private Bitmap PIC;

    public SighnUpNote(int ID, String NAME, long ID_CODE, long MOBILE, String EMAIL, String ADDRESS, Bitmap PIC) {
        this.ID = ID;
        this.NAME = NAME;
        this.ID_CODE = ID_CODE;
        this.MOBILE = MOBILE;
        this.EMAIL = EMAIL;
        this.ADDRESS = ADDRESS;
        this.PIC = PIC;
    }

    public SighnUpNote(String NAME, long ID_CODE, long MOBILE, String EMAIL, String ADDRESS, Bitmap PIC) {
        this.NAME = NAME;
        this.ID_CODE = ID_CODE;
        this.MOBILE = MOBILE;
        this.EMAIL = EMAIL;
        this.ADDRESS = ADDRESS;
        this.PIC = PIC;
    }

    public SighnUpNote() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public long getID_CODE() {
        return ID_CODE;
    }

    public void setID_CODE(long ID_CODE) {
        this.ID_CODE = ID_CODE;
    }

    public long getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(long MOBILE) {
        this.MOBILE = MOBILE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public Bitmap getPIC() {
        return PIC;
    }

    public void setPIC(Bitmap PIC) {
        this.PIC = PIC;
    }
}
