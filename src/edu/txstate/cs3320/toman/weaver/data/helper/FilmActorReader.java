package edu.txstate.cs3320.toman.weaver.data.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * A helper class for reading a link file relating films to actors. The relation
 * is expressed as a pairing of film id with actor id.
 * 
 * @author T
 *
 */
public class FilmActorReader {
	private static String CLASS_NAME = "FilmActorReader";
//	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);


	/**
	 * Reads the file specified by pathName fileName. This must be formatted as a pair
	 * of ints that are indices into the FilmInventory and ActorInventory singeletons,
	 * respectively. Returns a List of pairs (SimpleEntry) containing the indices.
	 * 
	 * @param pathName
	 * @param fileName
	 * @return List<SimpleEntry <Integer,Integer>>
	 * @see List
	 * @see SimpleEntry
	 */
	public List <SimpleEntry <Integer, Integer>> readFilmActorFile(String pathName, String fileName) {

		List <SimpleEntry <Integer, Integer>> filmActorPairs =null;
		Path path = Paths.get(pathName, fileName);
		if (Files.exists(path)) {
			try {
				filmActorPairs = new ArrayList <SimpleEntry <Integer,Integer>> ();
				BufferedReader buffer = Files.newBufferedReader(path, Charset.forName("UTF-8"));
				String filmActorInformation;
				filmActorInformation = buffer.readLine();

				
				while (filmActorInformation != null) {
					Scanner scanner = new Scanner(filmActorInformation);
					scanner.useDelimiter(",");
					
					String actorIDTemp = scanner.next();
					int actorID = Integer.valueOf(actorIDTemp);
	
					String filmIDTemp = scanner.next();
					int filmID = Integer.valueOf(filmIDTemp);
					
					SimpleEntry <Integer,Integer> pair = new SimpleEntry <Integer,Integer> (filmID, actorID);
					filmActorPairs.add(pair);
					
					filmActorInformation = buffer.readLine();
					scanner.close();
				}
				buffer.close();
				if (filmActorPairs.isEmpty()) filmActorPairs = null;
			} catch (IOException e) {
				System.err.println("***" + CLASS_NAME + ".readFilmFile :" + e);
			}
		} else {
			System.err.println("***" + CLASS_NAME + " can't find file: " + pathName + " " + fileName);
		}
		return filmActorPairs;
	}
}

