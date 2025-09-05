package com.example.finalproject;

public class Movie {
    private String urlPhoto;
    private String title_name;
    private String description;
    private String Type;
    private String Year;

    public Movie(String title_name, String urlPhoto , String year, String description , String Type) {
        this.Year = year;
        this.description = description;
        this.title_name = title_name;
        this.urlPhoto = urlPhoto;
        this.Type = Type;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "urlPhoto='" + urlPhoto + '\'' +
                ", title_name='" + title_name + '\'' +
                ", description='" + description + '\'' +
                ", Type='" + Type + '\'' +
                ", Year='" + Year + '\'' +
                '}';
    }

    public Movie() {
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public String getTitle_name() {
        return title_name;
    }

    public String getDescription() {
        return description;
    }
    public String getYear() {
        return Year;
    }

    public String getType() { return Type; }


    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setYear(String year) {
        Year = year;
    }

}
