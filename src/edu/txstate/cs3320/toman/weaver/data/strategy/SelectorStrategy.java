package edu.txstate.cs3320.toman.weaver.data.strategy;

import edu.txstate.cs3320.toman.weaver.data.film.Film;

public abstract class SelectorStrategy  {
	public abstract boolean meetsCriteria (Film searchCandidate);
}