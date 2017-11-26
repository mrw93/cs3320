package edu.txstate.cs3320.toman.weaver.data.helper;

import java.util.Iterator;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

import edu.txstate.cs3320.toman.weaver.data.actor.Actor;
import edu.txstate.cs3320.toman.weaver.data.actor.ActorInventory;
import edu.txstate.cs3320.toman.weaver.data.film.Film;
import edu.txstate.cs3320.toman.weaver.data.film.FilmCatalog;

public class FilmActorBuilder {
	private static String CLASS_NAME = "FilmActorBuilder";

	public void build (FilmCatalog filmInventory, ActorInventory actorInventory, List <SimpleEntry <Integer, Integer>> pairs) {
		Iterator <SimpleEntry <Integer, Integer>> iterator = pairs.iterator();
		while (iterator.hasNext()) {
			SimpleEntry<Integer, Integer> pair = iterator.next();
			int filmID     = pair.getKey();
			int actorID    = pair.getValue();
			Actor anActor  = actorInventory.get(actorID);
			Film  aFilm    = filmInventory.get(filmID);

			if ((anActor != null) && (aFilm != null)) {
				aFilm.addActor(anActor);
				anActor.addFilm(aFilm);
			//	String actorName = anActor.getFirstName() + " " + anActor.getLastName();
			//	String filmTitle = aFilm.getTitle();
			} else {
				if (anActor == null) System.err.println (CLASS_NAME + " did not find actor with id " + actorID);
				if (aFilm == null) System.err.println (CLASS_NAME + " did not find film with id " + filmID);
			}

		}
	  }
	}

