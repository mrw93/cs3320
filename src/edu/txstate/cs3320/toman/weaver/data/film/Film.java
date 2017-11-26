package edu.txstate.cs3320.toman.weaver.data.film;

import java.util.ArrayList;
import java.util.List;
import edu.txstate.cs3320.toman.weaver.data.film.FilmCategory;
import edu.txstate.cs3320.toman.weaver.data.actor.Actor;

public class Film {
	public enum FilmRating {
		G, PG, PG_13, R, NC_17, X, UR
	}
	
	private int filmID;
	private String title;
	private String description;
	private String releaseYear;
	private int length;
	private FilmRating rating;
	private List <Actor> actors;
	private String link;
	private String category;
	public Film(int filmID, String title, String description,
			String releaseYear, int length, FilmRating rating) {
		super();
		this.filmID = filmID;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.length = length;
		this.rating = rating;
		this.actors = new ArrayList <Actor> ();
	}
	
	public void setActors(List<Actor> actors){
		this.actors = actors;
	}
	
	public void setCategory(FilmCategory cat){
		switch(cat){
		case ACTION: this.category = "ACTION";
		case ANIMATION: this.category = "ANIMATION";
		case CHILDREN: this.category = "CHILDREN";
		case CLASSICS: this.category = "CLASSICS";
		case COMEDY: this.category = "COMEDY";
		case DOCUMENTARY: this.category = "DOCUMENTARY";
		case DRAMA: this.category = "DRAMA";
		case FAMILY: this.category = "FAMILY";
		case FOREIGN: this.category = "FOREIGN";
		case GAMES: this.category = "GAMES";
		case HORROR: this.category = "HORROR";
		case MUSIC: this.category = "MUSIC";
		case NEW: this.category = "NEW";
		case SCI_FI: this.category = "SCIFI";
		case SPORTS: this.category = "SPORTS";
		case TRAVEL: this.category = "TRAVEL";
		default: this.category = "";
		}
	}
	
	public String getCategory(){
		return this.category;
	}
	public void setLink(String link){
		this.link = link;
	}
	public String getLink(){
		return this.link;
	}
	public void addActor (Actor anActor) {
		if (!actors.contains(anActor)) actors.add(anActor);
	}
	
	public List <Actor>getActors () {
		return actors;
	}

	public String getDescription() {
		return description;
	}

	public int getFilmID() {
		return filmID;
	}

	public int getLength() {
		return length;
	}

	public FilmRating getRating() {
		return rating;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public String getTitle() {
		return title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setRating(FilmRating rating) {
		this.rating = rating;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Film [filmID=" + filmID + ", title=" + title + ", description="
				+ description + ", releaseYear=" + releaseYear + ", length="
				+ length + ", rating=" + rating + "]";
	}
}
