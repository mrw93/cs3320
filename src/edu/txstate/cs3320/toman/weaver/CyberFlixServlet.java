package edu.txstate.cs3320.toman.weaver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.txstate.cs3320.toman.weaver.data.DataSource;
import edu.txstate.cs3320.toman.weaver.data.film.Film;
import edu.txstate.cs3320.toman.weaver.utils.HTMLTags;
import edu.txstate.cs3320.toman.weaver.utils.ServletUtils;

/**
 * Servlet implementation class CyberFlixServlet
 */
@WebServlet("/CyberFlixServlet")
public class CyberFlixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static List<Film> sr;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyberFlixServlet() {
        super();
        
        
    }
    
    /**
     * Server config for main servlet
     */
    @Override
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	ServletUtils.setAbsolutePath(config);
    	DataSource.init();
    }

	/**Gets string from search form in HTML file
	 * Finds film by title strategy
	 * sets a link to movie detail server and creates a film_ID parameter and sets it to the current films ID
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("film_title");
		
		List<Film> results = DataSource.findFilmByTitle(search);
		if(results != null){
		for(Film film : results){
			response.getWriter().append("bla");
			film.setLink("http://localhost:8080/CyberFlix0/CyberFlixMovieDetailServlet?film_ID=" + film.getFilmID());
			}
		} else {
			response.getWriter().append("Your search did not return any results." + HTMLTags.LINE_BREAK );
		}
		CyberFlixServlet.sr = results;
		request.setAttribute("detailServlet", "http://localhost:8080/CyberFlixOne/CyberFlixMovieDetailServlet"); 
		request.setAttribute("films", results); 
		request.getRequestDispatcher("SearchResults.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
