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

import edu.txstate.cs3320.toman.weaver.data.film.Film;


public class FilmReader {
	private static String CLASS_NAME = "FilmReader";

	public List <Film> readFilmFile(String pathName, String fileName) {

		List <Film>films = new ArrayList <Film> ();
		Path path = Paths.get(pathName, fileName);
		System.out.println ("FilmReader path: " + path.toString());
		if (Files.exists(path)) {
			try {
				BufferedReader buffer  = Files.newBufferedReader(path, Charset.forName("UTF-8"));
				FilmFactory    factory = new FilmFactory ();
				String filmInformation;
				filmInformation = buffer.readLine();
	
				while (filmInformation != null) {
					Scanner scanner = new Scanner(filmInformation);
					scanner.useDelimiter(",");
					String filmID	 	= scanner.next();
					String title 		= scanner.next();
					String description 	= scanner.next();
					String releaseYear	= scanner.next();
					String length       = scanner.next();
					String rating 	    = scanner.next();

					Film aFilm = factory.makeFilm(filmID, title, description, releaseYear, length, rating);
					films.add(aFilm);

					filmInformation = buffer.readLine();
					scanner.close();
				}
	
				if (films.isEmpty()) films = null;
			} catch (IOException e) {
				System.err.println("***" + CLASS_NAME + ".readFilmFile :" + e);
			}
		} else {
			System.err.println("***" + CLASS_NAME +" can't find file: " + pathName + " " + fileName);
		}
		return films;
	}
}

