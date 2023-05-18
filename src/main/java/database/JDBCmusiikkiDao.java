package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.albumList;
import model.artistList;
import database.JDBCmusiikkiDao;

/**
 * JDBCShoppingListItemDao toteuttaa rajapinnan, ja sisältää konkreettisen
 * SQL-logiikan
 */

public class JDBCmusiikkiDao implements Dao {

	private final Database db = new Database();

	@Override
	public List<artistList> getAllArtists() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		List<artistList> items = new ArrayList<>();

		try {

			connection = this.db.connect();

			statement = connection.prepareStatement("SELECT ArtistId, Name FROM Artist");

			results = statement.executeQuery();

			while (results.next()) {
				String artistName = results.getString("Name");
				long artistId = results.getLong("ArtistId");

				artistList newArtist = new artistList(artistId, artistName);

				items.add(newArtist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return items;

	}

	@Override
	public artistList getArtist(String artist) {
		List<artistList> allArtists = this.getAllArtists();
		for (artistList _artist : allArtists) {
			if (artist == _artist.getArtist()) {
				return _artist;
			}
		}
		return null;
	}

	@Override
	public String getArtistById(long id) {
		List<artistList> allArtists = this.getAllArtists();
		for (artistList _artist : allArtists) {
			if (id == _artist.getId()) {
				return _artist.getArtist();
			}
		}
		return null;
	}

	@Override
	public boolean addArtist(artistList newArtist) {
		String sql = "INSERT INTO Artist (Name) VALUES (?)";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet ids = null;

		try {
			connection = this.db.connect();
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, newArtist.getArtist());
			int rows = statement.executeUpdate();
			if (rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, ids);
		}
		return false;
	}

	@Override
	public List<albumList> getAllAlbums(long artistId) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		List<albumList> albums = new ArrayList<>();

		try {
			connection = this.db.connect();

			statement = connection.prepareStatement("SELECT AlbumId, Title, ArtistId FROM Album WHERE ArtistId = ?");
			statement.setLong(1, artistId);

			results = statement.executeQuery();

			while (results.next()) {
				String albumName = results.getString("Title");
				long albumId = results.getLong("AlbumId");

				albumList newAlbum = new albumList(albumId, albumName);

				albums.add(newAlbum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return albums;
	}

	@Override
	public List<artistList> searchAllArtists(String artist) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		List<artistList> items = new ArrayList<>();

		try {

			connection = this.db.connect();

			statement = connection.prepareStatement("SELECT ArtistId, Name FROM Artist WHERE Name LIKE ? ORDER BY Name ASC");
			statement.setString(1, "%" + artist + "%");

			results = statement.executeQuery();

			while (results.next()) {
				String artistName = results.getString("Name");
				long artistId = results.getLong("ArtistId");

				artistList newArtist = new artistList(artistId, artistName);

				items.add(newArtist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return items;

	}

}
