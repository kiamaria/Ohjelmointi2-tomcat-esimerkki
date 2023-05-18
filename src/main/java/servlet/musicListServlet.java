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
import model.artistList;


@WebServlet("/musicList")
public class musicListServlet extends HttpServlet { 
	
	private Dao dao = new JDBCmusiikkiDao();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<artistList> allArtists = this.dao.getAllArtists();

		req.setAttribute("Artists", allArtists);

		req.getRequestDispatcher("/WEB-INF/musiikkiApp.jsp/list.jsp").forward(req, resp);

	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		
		if (action.equals("save")) {
			
		    String newArtist = req.getParameter("artistName");
		    System.out.println(newArtist);
		    
		    if (newArtist.equals(" ")) {
		    	resp.sendRedirect("/musicList");
		    	return;
		    }

		    artistList newItem = new artistList(newArtist);

		    boolean saved = this.dao.addArtist(newItem);

		    if (saved) {
		        resp.sendRedirect("/musicList"); 
		    } else {
		        resp.getWriter().write("Not successful"); 
		    }
			
		} else {
			
			String searchWithArtistName = req.getParameter("searchWithArtistName");
			
			List<artistList> allArtists = this.dao.searchAllArtists(searchWithArtistName);

			req.setAttribute("Artists", allArtists);

			req.getRequestDispatcher("/WEB-INF/musiikkiApp.jsp/list.jsp").forward(req, resp);
			
		}
		

	}
	
	
	
}
