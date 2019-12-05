/* @st20102906			1.0	06/12/2016
 *
 * Matthew Aaron Roberts, 2016
 * Student number: st20102906
 */

package st20102906;

/**
 * Film.java - a class to represent playable Films.
 * 
 * @author 	Matthew Roberts
 * @version 1.0
 * @see 	Media
 */

public class Film extends Media
{
	// declared private - encapsulation
	private double duration;
	private String studio;
	private String director;
	
	/**
	 * Class constructor specifying Film attributes. Superclass is invoked
	 * to specify title, yearOfRelease and rating.
	 * 
	 * @param title
	 * @param yearOfRelease
	 * @param duration
	 * @param studio
	 * @param director
	 * @param rating
	 */
	public Film(String title, int yearOfRelease, double duration, String studio, String director, int rating)
	{
		// invoke superclass constructor
		super(title, yearOfRelease, rating);
		
		this.duration 	= duration;
		this.studio 	= studio;
		this.director	= director;
	}
	
	/**
	 * Sets a total duration value.
	 * 
	 * @param duration
	 */
	public void setDuration(double duration)
	{
		this.duration = duration;
	}
	
	/**
	 * Sets a value for the studio.
	 * 
	 * @param studio
	 */
	public void setStudio(String studio)
	{
		this.studio = studio;
	}
	
	/**
	 * Sets a value for the director.
	 * 
	 * @param director
	 */
	public void setDirector(String director)
	{
		this.director = director;
	}
	
	/**
	 * Returns the total duration value in minutes, as a double.
	 * 
	 * @return a double value for duration in minutes.
	 */
	public double getDuration()
	{
		return this.duration;
	}
	
	/**
	 * Returns the name of the studio as a String.
	 * 
	 * @return a String value for studio.
	 */
	public String getStudio()
	{
		return this.studio;
	}
	
	/**
	 * Returns the name of the film director as a String.
	 * 
	 * @return a String value for director.
	 */
	public String getDirector()
	{
		return this.director;
	}
}

