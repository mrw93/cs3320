package edu.txstate.cs3320.toman.weaver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.txstate.cs3320.toman.weaver.data.film.Film;
import edu.txstate.cs3320.toman.weaver.data.film.FilmCatalog;
import edu.txstate.cs3320.toman.weaver.utils.HTMLTags;

/**
 * Servlet implementation class CyberFlixMovieDetailServlet
 */
@WebServlet("/CyberFlixMovieDetailServlet")
public class CyberFlixMovieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CyberFlixMovieDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** Gets film ID from servletRequest parameter set by previous servlet
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = request.getParameter("film_ID");
		FilmCatalog films = FilmCatalog.getInstance();
		Film film = films.get(Integer.parseInt(ID));
		if(film != null){
			
			String filmDetail = HTMLTags.H1_START + HTMLTags.BOLD_START + film.getTitle() + HTMLTags.BOLD_END + HTMLTags.H1_END + HTMLTags.LINE_BREAK +
					HTMLTags.PARAGRAPH_START + "Running time: " + film.getLength() + HTMLTags.LINE_BREAK +
					"Rating: " + film.getRating() + HTMLTags.LINE_BREAK +
					film.getDescription() + HTMLTags.PARAGRAPH_END;
			
		request.setAttribute("film", filmDetail); 
		request.getRequestDispatcher("MovieDetails.jsp").forward(request, response);
		} else {
			response.getWriter().append("Movie details not found.").append(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
