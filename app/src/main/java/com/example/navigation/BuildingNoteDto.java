package com.example.navigation;

public class BuildingNoteDto {

    private String Title;

    public BuildingNoteDto() {
    }

    public BuildingNoteDto(String title) {
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
