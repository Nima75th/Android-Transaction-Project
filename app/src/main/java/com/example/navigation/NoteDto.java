package com.example.navigation;

public class NoteDto {
    private String Name;

    public NoteDto() {
    }

    public NoteDto(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
