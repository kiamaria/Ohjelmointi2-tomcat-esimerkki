package model;

/**
 * albumList on "Model"-luokka, eli se mallintaa yksittäistä data-alkiota
 */

public class albumList {
	
	private long artistId;
	private long albumId;
	private String title;
	
    public albumList(long albumID, String title) {
        this.title = title;
        this.albumId = albumID;
    }
	
	public long getArtistId() {
		return artistId;
	}
	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}
	public long getAlbumId() {
		return albumId;
	}
	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
