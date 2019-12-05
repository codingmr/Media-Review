/* @st20102906			1.0	23/11/2016
 *
 * Matthew Aaron Roberts, 2016
 * Student number: st20102906
 */

package st20102906;
import java.util.ArrayList;

/**
 * MediaCollection.java - a class to contain a collection of media. The
 * collection is held in 4 Lists; a List for each of the media objects
 * (Film, AudioTrack, TelevisionProgramme), and a fourth List to hold all
 * of them in one List. 
 * 
 * The class creates a media object and adds it to the 
 * corresponding List. Each time a new media object is added the fourth List
 * is updated. Media objects can be retrieved from either their corresponding
 * List or the fourth List.
 * 
 * 
 * @author 	Matthew Roberts
 * @version 1.0
 */

public class MediaCollection {
	
	// 4 declared Lists to temporarily store media data
	private ArrayList<Media> mediaCollection 					= new ArrayList<Media>(); 	/* Must be Media object */
	
	private ArrayList<Film> films 								= new ArrayList<Film>();
	private ArrayList<AudioTrack> audioTracks 					= new ArrayList<AudioTrack>();
	private ArrayList<TelevisionProgramme> televisionProgrammes = new ArrayList<TelevisionProgramme>();
	
	/**
	 * Class constructor adding lists of media objects to private lists. 
	 * 
	 * The media objects are combined into a single list.
	 * 
	 * @param films
	 * @param audioTracks
	 * @param televisionProgrammes
	 */
	public MediaCollection(ArrayList<Film> films, 
						   ArrayList<AudioTrack> audioTracks, 
						   ArrayList<TelevisionProgramme> televisionProgrammes)
	{
		this.films 					= films;
		this.audioTracks 			= audioTracks;
		this.televisionProgrammes 	= televisionProgrammes;
		
		// combine films, audio tracks and television programmes into a single list
		updateMediaCollection();
	}
	
	/**
	 * Creates a new Film object from the given parameters and adds the object to 
	 * the List of films.
	 * 
	 * List of all media is updated with the new Film object.
	 * 
	 * @param title
	 * @param yearOfRelease
	 * @param duration
	 * @param studio
	 * @param director
	 * @param rating
	 */
	public void addFilm(String title, int yearOfRelease, double duration, String studio, String director, int rating)
	{
		// create a film object
		Film newFilm = new Film(title, yearOfRelease, duration, studio, director, rating);
		
		// add film to media collection
		this.films.add(newFilm);
		
		// update media collection with added film
		this.updateMediaCollection();
	}
	
	/**
	 * Creates a new AudioTrack object from the given parameters and adds the object to 
	 * the List of audio tracks.
	 * 
	 * List of all media is updated with the new AudioTrack object.
	 * 
	 * @param title
	 * @param creator
	 * @param yearOfRelease
	 * @param duration
	 * @param recordLabel
	 * @param rating
	 */
	public void addAudioTrack(String title, String creator, int yearOfRelease, double duration, String recordLabel, int rating)
	{
		AudioTrack newAudioTrack = new AudioTrack(title, creator, yearOfRelease, duration, recordLabel, rating);
		
		this.audioTracks.add(newAudioTrack);
		
		this.updateMediaCollection();
	}
	
	/**
	 * Creates a new TelevisionProgramme object from the given parameters and adds the 
	 * object to the List of television programmes.
	 * 
	 * List of all media is updated with the new TelevisionProgramme object.
	 * 
	 * @param title
	 * @param series
	 * @param episode
	 * @param yearOfRelease
	 * @param studio
	 * @param channel
	 * @param rating
	 */
	public void addTelevisionProgramme(String title, int series, int episode, int yearOfRelease, String studio, String channel, int rating)
	{
		TelevisionProgramme newTelevisionProgramme = new TelevisionProgramme(title, series, episode, yearOfRelease, studio, channel, rating);
		
		this.televisionProgrammes.add(newTelevisionProgramme);
		
		this.updateMediaCollection();
	}
	
	/**
	 * Removes the given Film object from the list of films.
	 * 
	 * List of all media is updated without the Film object.
	 * 
	 * @param film
	 */
	public void deleteFilm(Film film)
	{
		// remove film from list of films
		this.films.remove(film);
		
		// update media collection without the removed film
		this.updateMediaCollection();
	}

	/**
	 * Removes the given AudioTrack object from the list of audio tracks.
	 * 
	 * List of all media is updated without the AudioTrack object.
	 * 
	 * @param audioTrack
	 */
	public void deleteAudioTrack(AudioTrack audioTrack)
	{
		this.audioTracks.remove(audioTrack);
		
		this.updateMediaCollection();
	}
	
	/**
	 * Removes the given TelevisionProgramme object from the list of 
	 * television programmes.
	 * 
	 * List of all media is updated without the TelevisionProgramme object.
	 * 
	 * @param televisionProgramme
	 */
	public void deleteTelevisionProgramme(TelevisionProgramme televisionProgramme)
	{
		this.televisionProgrammes.remove(televisionProgramme);
		
		this.updateMediaCollection();
	}
	
	/**
	 * Removes all objects from the List of media.
	 * 
	 * Copies the list of films, audio tracks and television programmes, 
	 * and adds them to a single list of media.
	 * 
	 * The order of media items is lost.
	 */
	private void updateMediaCollection()
	{
		this.mediaCollection.clear();
		this.mediaCollection.addAll(films);
		this.mediaCollection.addAll(audioTracks);
		this.mediaCollection.addAll(televisionProgrammes);
	}
	
	/**
	 * Returns a list of all the stored films, as an array list.
	 * 
	 * @return ArrayList of Film objects. 
	 */
	public ArrayList<Film> getFilms()
	{
		return this.films;
	}
	
	/**
	 * Returns a list of all the stored audio tracks, as an array list.
	 * 
	 * @return ArrayList of AudioTrack objects.
	 */
	public ArrayList<AudioTrack> getAudioTracks()
	{
		return this.audioTracks;
	}
	
	/**
	 * Returns a list of all the stored television programmes, as an 
	 * array list.
	 * 
	 * @return ArrayList of TelevisionProgrammes objects.
	 */	
	public ArrayList<TelevisionProgramme> getTelevisionProgrammes()
	{
		return this.televisionProgrammes;
	}
	
	/**
	 * Returns a list of all the stored media (films, audio tracks, 
	 * television programmes), as an array list.
	 * 
	 * @return an ArrayList of Media.
	 */
	public ArrayList<Media> getMediaCollection()
	{
		return this.mediaCollection;
	}
}