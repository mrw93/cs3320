package edu.txstate.cs3320.toman.weaver.data.helper;

import edu.txstate.cs3320.toman.weaver.data.film.Film;

public class FilmFactory {
	
	public FilmFactory () {	
	}

	public Film makeFilm (int id2, String title, String description,
			String releaseYear, int filmLength2, String rating) {
		int id = Integer.valueOf(id2);
		int filmLength = Integer.valueOf(filmLength2);
		return new Film (id, title, description, releaseYear, filmLength, FilmFactory.convert(rating));
	}
	
	public Film makeFilm (int filmID, String title, String description,
			String releaseYear, int length, Film.FilmRating rating) {
				return new Film (filmID, title,description,releaseYear,length,rating);
		
	}
	
	public static Film.FilmRating convert (String rating) {
		switch (rating) {
		case "G": return Film.FilmRating.G;
		case "PG": return Film.FilmRating.PG;
		case "PG-13": return Film.FilmRating.PG_13;
		case "R": return Film.FilmRating.R;
		case "NC-17": return Film.FilmRating.NC_17;
		case "X": return Film.FilmRating.X;
		case "UR": return Film.FilmRating.UR;
		default: return Film.FilmRating.UR;
		}
	}
}
