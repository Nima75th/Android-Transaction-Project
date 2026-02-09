package com.example.navigation;

public class Give_Rent_Note {
    private int ID;
    private int DAY;
    private int MONTH;
    private int YEAR;
    private String GIVE_RENT;
    private String SON_OF;
    private long MELI_NUMBER;
    private String FROM_WHERE;
    private long MELI_CODE;
    private String BIRTH_OF;
    private String ADDRESS;
    private long POST_CODE;
    private long TELEPHONE;
    private long MOBILE;

    public Give_Rent_Note(int DAY, int MONTH, int YEAR, String GIVE_RENT, String SON_OF, long MELI_NUMBER, String FROM_WHERE, long MELI_CODE, String BIRTH_OF, String ADDRESS, long POST_CODE, long TELEPHONE, long MOBILE) {
        this.DAY = DAY;
        this.MONTH = MONTH;
        this.YEAR = YEAR;
        this.GIVE_RENT = GIVE_RENT;
        this.SON_OF = SON_OF;
        this.MELI_NUMBER = MELI_NUMBER;
        this.FROM_WHERE = FROM_WHERE;
        this.MELI_CODE = MELI_CODE;
        this.BIRTH_OF = BIRTH_OF;
        this.ADDRESS = ADDRESS;
        this.POST_CODE = POST_CODE;
        this.TELEPHONE = TELEPHONE;
        this.MOBILE = MOBILE;
    }

    public Give_Rent_Note(int ID, int DAY, int MONTH, int YEAR, String GIVE_RENT, String SON_OF, long MELI_NUMBER, String FROM_WHERE, long MELI_CODE, String BIRTH_OF, String ADDRESS, long POST_CODE, long TELEPHONE, long MOBILE) {
        this.ID = ID;
        this.DAY = DAY;
        this.MONTH = MONTH;
        this.YEAR = YEAR;
        this.GIVE_RENT = GIVE_RENT;
        this.SON_OF = SON_OF;
        this.MELI_NUMBER = MELI_NUMBER;
        this.FROM_WHERE = FROM_WHERE;
        this.MELI_CODE = MELI_CODE;
        this.BIRTH_OF = BIRTH_OF;
        this.ADDRESS = ADDRESS;
        this.POST_CODE = POST_CODE;
        this.TELEPHONE = TELEPHONE;
        this.MOBILE = MOBILE;
    }

    public Give_Rent_Note() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDAY() {
        return DAY;
    }

    public void setDAY(int DAY) {
        this.DAY = DAY;
    }

    public int getMONTH() {
        return MONTH;
    }

    public void setMONTH(int MONTH) {
        this.MONTH = MONTH;
    }

    public int getYEAR() {
        return YEAR;
    }

    public void setYEAR(int YEAR) {
        this.YEAR = YEAR;
    }

    public String getGIVE_RENT() {
        return GIVE_RENT;
    }

    public void setGIVE_RENT(String GIVE_RENT) {
        this.GIVE_RENT = GIVE_RENT;
    }

    public String getSON_OF() {
        return SON_OF;
    }

    public void setSON_OF(String SON_OF) {
        this.SON_OF = SON_OF;
    }

    public long getMELI_NUMBER() {
        return MELI_NUMBER;
    }

    public void setMELI_NUMBER(long MELI_NUMBER) {
        this.MELI_NUMBER = MELI_NUMBER;
    }

    public String getFROM_WHERE() {
        return FROM_WHERE;
    }

    public void setFROM_WHERE(String FROM_WHERE) {
        this.FROM_WHERE = FROM_WHERE;
    }

    public long getMELI_CODE() {
        return MELI_CODE;
    }

    public void setMELI_CODE(long MELI_CODE) {
        this.MELI_CODE = MELI_CODE;
    }

    public String getBIRTH_OF() {
        return BIRTH_OF;
    }

    public void setBIRTH_OF(String BIRTH_OF) {
        this.BIRTH_OF = BIRTH_OF;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public long getPOST_CODE() {
        return POST_CODE;
    }

    public void setPOST_CODE(long POST_CODE) {
        this.POST_CODE = POST_CODE;
    }

    public long getTELEPHONE() {
        return TELEPHONE;
    }

    public void setTELEPHONE(long TELEPHONE) {
        this.TELEPHONE = TELEPHONE;
    }

    public long getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(long MOBILE) {
        this.MOBILE = MOBILE;
    }
}
