/* @st20102906			1.0	06/12/2016
 *
 * Matthew Aaron Roberts, 2016
 * Student number: st20102906
 */

package st20102906;
import java.util.ArrayList;

/**
 * Testing_DataLoader.java - a class to add a few Films, AudioTracks and
 * Television Programmes into the system to be used for testing.
 * 
 * @author 	Matthew Roberts
 * @version 1.0
 */

public class Testing_DataLoader {
	
	/**
	 * Create a new list of films, add a number of new Film objects to the list,
	 * and return an ArrayList of Film objects.
	 * 
	 * @return an ArrayList of Film objects.
	 */
	public static ArrayList<Film> loadFilms()
	{
		// create a list of films
		ArrayList<Film> films = new ArrayList<Film>();
		
		// initialise new film objects
		Film filmBatman = new Film("Batman", 1989, 152.0, "Warner Bros.", "Tim Burton", 2);
		Film filmStarTrek = new Film("Star Trek", 2009, 122.0, "Paramount", "J.J. Abrams", 3);
		
		// add films to array list
		films.add(filmBatman);
		films.add(filmStarTrek);
		
		return films;
	}
	
	/**
	 * Create a new list of audio tracks, add a number of new Audio Track 
	 * objects to the list, and return an ArrayList of Audio Track objects.
	 * 
	 * @return an ArrayList of Audio Track objects.
	 */
	public static ArrayList<AudioTrack> loadAudioTracks()
	{
		// create a list of audio tracks
		ArrayList<AudioTrack> audioTracks = new ArrayList<AudioTrack>();	
		
		// initialise new audio track objects
		AudioTrack trackBlueSpark = new AudioTrack("Flite - Blue Spark", "Flite", 2015, 6.7, "Unknown", 5);
		AudioTrack trackPolice = new AudioTrack("King - Police", "King", 2015, 3.5, "Unknown", 5);
		
		// add audio tracks to array list
		audioTracks.add(trackBlueSpark);
		audioTracks.add(trackPolice);
		
		return audioTracks;
	}
	
	/**
	 * Create a new list of television programmes, add a number of new 
	 * Television Programme objects to the list, and return an ArrayList 
	 * of Television Programme objects.
	 * 
	 * @return an ArrayList of Television Programme objects.
	 */
	public static ArrayList<TelevisionProgramme> loadTelevisionProgrammes()
	{
		// create a list of television programmes
		ArrayList<TelevisionProgramme> televisionProgrammes = new ArrayList<TelevisionProgramme>();
		
		// initialise new television programme objects
		TelevisionProgramme tvOutlander = new TelevisionProgramme("Outlander: Return of the Unholy Seven", 1, 12, 2014, "Tall Ship Productions", "Netflix", 4);
		TelevisionProgramme tvGameOfThrones = new TelevisionProgramme("Game of Thrones: A Song of Ice and Fire", 6, 3, 2011, "HBO", "Sky Atlantic", 5);
		
		// add television programmes to array list
		televisionProgrammes.add(tvOutlander);
		televisionProgrammes.add(tvGameOfThrones);
		
		return televisionProgrammes;
	}
}

