package edu.txstate.cs3320.toman.weaver.data.actor;

import java.util.ArrayList;
import java.util.List;

import edu.txstate.cs3320.toman.weaver.data.film.Film;


/**
 * The Actor class identifies an actor within CyberFlix film catalog
 * All the films within CyberFlix that the Actor has appeared in are
 * referenced in List <Film> 
 *
 */
public class Actor {

	private int id;
	private String lastName;
	private String firstName;
	private List <Film> films;

	public Actor(int id, String firstName, String lastName) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		films = new ArrayList <Film> ();
	}
	public void addFilm (Film aFilm) {
		if (!films.contains(aFilm)) films.add(aFilm);
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getActorId() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		Actor anActor;
		if (obj instanceof Actor) {
			anActor = (Actor)obj;
		} else {
			return false;
		}
		return this.id == anActor.getActorId();
	}
	@Override
	public String toString() {
		return "Actor [id=" + id + ", lastName=" + lastName + ", firstName="
				+ firstName + "]";
	}


}

