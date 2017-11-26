package edu.txstate.cs3320.toman.weaver.data.actor;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ActorInventory {
	private List <Actor> actors;
	private static ActorInventory instance = null;

	public static ActorInventory getInstance () {
		if (instance == null) {
			instance = new ActorInventory ();
		}
		return instance;
	}
	private ActorInventory () {
		actors = new ArrayList <Actor> ();
	}

	public void add (Actor anActor) {
		actors.add(anActor);
	}
	public void addAll (Collection<Actor> newActors) {
		actors.addAll(newActors);
	}
	public Actor get (int id) {
	   if ((id >= 1) && (id <= actors.size())) return actors.get(id-1);
	   return null;
	}
}