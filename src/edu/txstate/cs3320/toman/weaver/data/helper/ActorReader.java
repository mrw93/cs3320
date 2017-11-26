package edu.txstate.cs3320.toman.weaver.data.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.txstate.cs3320.toman.weaver.data.actor.Actor;


public class ActorReader {
	private static String CLASS_NAME = "ActorReader";

	public List<Actor> readActorFile(String pathName, String fileName) {
		List <Actor> actors = null; 
		Path path = Paths.get(pathName, fileName);
		if (Files.exists(path)) {
			try {
				actors = new ArrayList <Actor> ();
				ActorFactory actorFactory = new ActorFactory ();
				BufferedReader buffer = Files.newBufferedReader(path, Charset.forName("UTF-8"));
				String actorInformation = buffer.readLine();
				
				while (actorInformation != null) {
					Scanner scanner = new Scanner(actorInformation);
					scanner.useDelimiter(",");
					String actorID = scanner.next();
					String firstName = scanner.next();
					String lastName = scanner.next();		
					
					Actor anActor =  actorFactory.makeActor(actorID, firstName, lastName);
					actors.add(anActor);

					actorInformation = buffer.readLine();
					scanner.close();
				}
				buffer.close();
				if (actors.isEmpty()) actors = null;
			} catch (IOException e) {
				System.err.println("***" + CLASS_NAME + ".readFilmFile :" + e);
			}
		} else {
			System.err.println("Can't find file: " + pathName + " " + fileName);
		}
		return actors;
	}
}

