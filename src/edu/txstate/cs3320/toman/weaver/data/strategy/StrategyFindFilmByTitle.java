package edu.txstate.cs3320.toman.weaver.data.strategy;

import edu.txstate.cs3320.toman.weaver.data.film.Film;

public class StrategyFindFilmByTitle extends SelectorStrategy {
	String title; 

	public StrategyFindFilmByTitle (String title) {
		this.title = title.toLowerCase();
	}

	@Override
	public boolean meetsCriteria(Film aFilm) {
		String filmTitle = aFilm.getTitle().toLowerCase();
		if (filmTitle.contains(this.title)) return true;
		return false;
	}

	@Override
	public String toString() {
		
		return "StrategyFindFilmByTitle [title=" + title + "]";
	}
	
	
}
