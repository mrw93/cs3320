package edu.txstate.cs3320.toman.weaver.data;
import edu.txstate.cs3320.toman.weaver.data.actor.Actor;
import edu.txstate.cs3320.toman.weaver.data.actor.ActorInventory;
import edu.txstate.cs3320.toman.weaver.data.film.*;
import edu.txstate.cs3320.toman.weaver.data.helper.ActorReader;
import edu.txstate.cs3320.toman.weaver.data.helper.FilmActorBuilder;
import edu.txstate.cs3320.toman.weaver.data.helper.FilmActorReader;
import edu.txstate.cs3320.toman.weaver.data.helper.FilmReader;
import edu.txstate.cs3320.toman.weaver.data.strategy.SelectorStrategy;
import edu.txstate.cs3320.toman.weaver.data.strategy.StrategyFindFilmByDescription;
import edu.txstate.cs3320.toman.weaver.data.strategy.StrategyFindFilmByLength;
import edu.txstate.cs3320.toman.weaver.data.strategy.StrategyFindFilmByTitle;
import edu.txstate.cs3320.toman.weaver.utils.HTMLTags;
import edu.txstate.cs3320.toman.weaver.utils.ServletUtils;

import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public class DataSource {

	final static String FILM_FILE             = "films.csv";
	final static String ACTORS_FILE           = "actors.csv";
	final static String FILM_ACTORS_LINK_FILE = "film_actors.csv";
	
	public static void init () {
		String realPath = ServletUtils.getProjectInputFilesPath();
		FilmReader aReader = new FilmReader ();
		List <Film> films   = aReader.readFilmFile(realPath, FILM_FILE);
        FilmCatalog filmInventory = FilmCatalog.getInstance();
        filmInventory.addAll (films);
        
		ActorReader actorReader = new ActorReader ();
		List <Actor> actors = actorReader.readActorFile(realPath, ACTORS_FILE);
		ActorInventory actorInventory = ActorInventory.getInstance();
		actorInventory.addAll(actors);
		
		FilmActorReader filmActorReader = new FilmActorReader ();
		List <SimpleEntry <Integer, Integer>> pairs = filmActorReader.readFilmActorFile(realPath, FILM_ACTORS_LINK_FILE);
		
		FilmActorBuilder builder = new FilmActorBuilder ();
		builder.build(filmInventory, actorInventory, pairs);
	}
	
	public static List<Film> findFilmByTitle (String title) {
		
		StrategyFindFilmByTitle titleStrategy = new StrategyFindFilmByTitle(title);
		return findFilmByStrategy(titleStrategy);
	}
	
	private static List <Film> findFilmByStrategy (SelectorStrategy strategy) {
		List <Film>foundFilms = FilmCatalog.getInstance().findFilmByStrategy(strategy);
		return foundFilms;
	}
}
