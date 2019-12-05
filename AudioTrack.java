/* @st20102906			1.0	06/12/2016
 *
 * Matthew Aaron Roberts, 2016
 * Student number: st20102906
 */

package st20102906;

/**
 * AudioTrack.java - a class to represent playable Audio Tracks.
 * 
 * @author 	Matthew Roberts
 * @version 1.0
 * @see 	Media
 */

public class AudioTrack extends Media{
	
	// declared private - encapsulation
	private String creator;
	private double duration;
	private String recordLabel;
	
	/**
	 * Class constructor specifying Audio Track attributes.
	 * 
	 * @param title
	 * @param creator
	 * @param yearOfRelease
	 * @param duration
	 * @param recordLabel
	 * @param rating
	 */
	public AudioTrack(String title, String creator, int yearOfRelease, double duration, String recordLabel, int rating)
	{
		// invoke superclass constructor
		super(title, yearOfRelease, rating);
		
		this.creator 		= creator;
		this.duration 		= duration;
		this.recordLabel 	= recordLabel;
	}
		
	/**
	 * Sets a value for creator.
	 * 
	 * @param creator
	 */
	public void setCreator(String creator)
	{
		this.creator = creator;
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
	 * Sets a value for record label.
	 * 
	 * @param recordLabel
	 */
	public void setRecordLabel(String recordLabel)
	{
		this.recordLabel = recordLabel;
	}
	
	/**  
	 * Returns the creator as a String.
	 * 
	 * @return a String data type.
	 */
	public String getCreator()
	{
		return this.creator;
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
	 * Returns the record label as a String.
	 * 
	 * @return a String value for record label.
	 */
	public String getRecordLabel()
	{
		return this.recordLabel;
	}
}
