package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Dao;
import database.JDBCmusiikkiDao;
import model.albumList;

@WebServlet("/albums")
public class albumServlet extends HttpServlet {

	private Dao dao = new JDBCmusiikkiDao();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String artistId = req.getParameter("ArtistId");

		List<albumList> allAlbums = this.dao.getAllAlbums(Long.parseLong(artistId));

		String artistName = this.dao.getArtistById(Long.parseLong(artistId));

		req.setAttribute("Albums", allAlbums);

		req.setAttribute("ArtistName", artistName);

		req.getRequestDispatcher("/WEB-INF/musiikkiApp.jsp/albums.jsp").forward(req, resp);

	}
}
