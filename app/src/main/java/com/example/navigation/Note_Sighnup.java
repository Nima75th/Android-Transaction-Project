package com.example.navigation;

import android.graphics.Bitmap;

public class Note_Sighnup {
    private int ID;
    private String Name;
    private long Id_Code;
    private long Mobile;
    private String Email;
    private String Address;
    private Bitmap Pic;

    public Note_Sighnup(int ID, String name,  long id_Code,  long mobile, String email, String address, Bitmap pic) {
        this.ID = ID;
        Name = name;
        Id_Code = id_Code;
        Mobile = mobile;
        Email = email;
        Address = address;
        Pic = pic;
    }

    public Note_Sighnup(String name,  long id_Code,  long mobile, String email, String address, Bitmap pic) {
        Name = name;
        Id_Code = id_Code;
        Mobile = mobile;
        Email = email;
        Address = address;
        Pic = pic;
    }

    public Note_Sighnup() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public long getId_Code() {
        return Id_Code;
    }

    public void setId_Code(long id_Code) {
        Id_Code = id_Code;
    }


    public long getMobile() {
        return Mobile;
    }

    public void setMobile(long mobile) {
        Mobile = mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Bitmap getPic() {
        return Pic;
    }

    public void setPic(Bitmap pic) {
        Pic = pic;
    }
}
