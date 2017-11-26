package edu.txstate.cs3320.toman.weaver.data.strategy;

import edu.txstate.cs3320.toman.weaver.data.film.Film;

public class StrategyFindFilmByLength extends SelectorStrategy {
	int length;
	public StrategyFindFilmByLength (int length) {
		this.length = length;
	}

	@Override
	public boolean meetsCriteria(Film aFilm) {
		if (length >= aFilm.getLength()) return true;
		return false;
	}

	@Override
	public String toString() {
		return "StrategyFindFilmByLength [length=" + length + "]";
	}
	
	
}
