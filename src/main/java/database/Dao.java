package database;

import java.util.List;

import model.albumList;
import model.artistList;


/**
 * Dao on rajapinta, joka määrittelee, mitä operaatioita DAO-luokan on toteutattava.
 */

public interface Dao {

    public List<artistList> getAllArtists();

    public artistList getArtist(String artist);
    
    public String getArtistById(long id);

    public boolean addArtist(artistList newArtist);
    
    public List<albumList> getAllAlbums(long artistId);

	List<artistList> searchAllArtists(String artist);
    
    
}