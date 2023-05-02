package org.example;

public class Album {
    private int year;
    private String name;
    private String artist;
    private String genre;

    public Album(int year, String name, String artist, String genre) {
        this.year = year;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
