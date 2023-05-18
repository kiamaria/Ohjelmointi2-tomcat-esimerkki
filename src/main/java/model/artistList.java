package model;

/**
 * artistList on "Model"-luokka, eli se mallintaa yksittäistä data-alkiota
 */

public class artistList {

    private String artist;
    private long id;

    public artistList(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }
    
    public artistList(long id, String artist) {
        this.id = id;
        this.artist = artist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

