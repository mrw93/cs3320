package edu.txstate.cs3320.toman.weaver.data.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import edu.txstate.cs3320.toman.weaver.data.actor.Actor;
import edu.txstate.cs3320.toman.weaver.data.film.Film;
import edu.txstate.cs3320.toman.weaver.data.helper.ActorFactory;
import edu.txstate.cs3320.toman.weaver.data.helper.FilmFactory;

/**
 * Contributer: Kimberley
 * @author Kimberley
 *
 */
public class ActorDAO extends DAO{
	
	private int ID = 0;
	private int FIRST = 1;
	private int LAST = 2;
	
	private int film_id;
	
	private String SELECT = String.format("SELECT actor_id, first_name, last_name FROM actor" +
     "WHERE actor_id in" +
     "(select actor_id from film_actor where film_id = %d);", film_id);
	
	private final static Logger LOGGER = Logger.getLogger(ActorDAO.class.getName());
	
	public List<Actor> findActorsFromFilm(Film film){
		film_id = film.getFilmID(); //must get instantiate prior to using SELECT
		List <Actor> actors = null;
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			Statement statement 	= dbConnection.createStatement();
			ResultSet results       = statement.executeQuery(SELECT);
			actors = buildResults (results);
			dbConnection.close();
		} catch (SQLException e) {
			System.err.println("FilmDAO.findFilmsByAttributes: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}	
		return actors;
	}
	
	private List<Actor> buildResults (ResultSet results) {
		List<Actor> actors  = new ArrayList<Actor>();
		ActorFactory actorFactory = new ActorFactory ();
		try {
			while (results.next()) {
				int    id             =  results.getInt   (ID);
				String firstName       = results.getString(FIRST);
				String lastName		 = results.getString(LAST);
				Actor actor = actorFactory.makeActor(id, firstName, lastName);
				actors.add(actor);
			}
		} catch (SQLException e) {
			LOGGER.severe(e.toString());
		}
		return actors;
	}
	
	@Override
	public void save(Object anObject) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
