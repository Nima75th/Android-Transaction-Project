package com.example.navigation;

public class Note {
    private int ID;
    private String Name;
    private int Age;


    public Note() {
    }

    public Note(int ID, String name,int age) {
        this.ID = ID;
        Name = name;
        Age = age;    }

    public Note(String name, int age) {
        Name = name;
        Age = age;
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

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
