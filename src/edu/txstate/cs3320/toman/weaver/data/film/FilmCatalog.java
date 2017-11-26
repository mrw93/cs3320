package edu.txstate.cs3320.toman.weaver.data.film;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import edu.txstate.cs3320.toman.weaver.data.strategy.SelectorStrategy;

public class FilmCatalog {

	private ArrayList <Film> films;
	private static FilmCatalog instance = null;

	public static FilmCatalog getInstance () {
		if (instance == null) {
			instance = new FilmCatalog ();
		}
		return instance;
	}

	private FilmCatalog () {
		films = new ArrayList <Film> ();
	}

	public void add (Film aFilm) {
		films.add(aFilm);
	}
	public void addAll (Collection<Film> newFilms) {
		films.addAll(newFilms);
	}
	public Film get (int id) {
		if ((id >= 1) && (id <= films.size())) return films.get(id-1);
		return null;
	}


	public ArrayList <Film> findFilmByStrategy (SelectorStrategy strategy) {
		ArrayList <Film>foundFilms = new ArrayList <Film>();
		Iterator<Film> it = films.iterator ();
		while( it.hasNext()) {
			Film aFilm = it.next();
			if (strategy.meetsCriteria(aFilm)) foundFilms.add(aFilm);
		}
		if (foundFilms.size() > 0) return foundFilms;
		System.out.println("FilmCatalog.findFilmsByStrategy: using " + strategy + 
				". No films found.");
		return null;
	}
}
