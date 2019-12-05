/* @st20102906			1.0	06/12/2016
 *
 * Matthew Aaron Roberts, 2016
 * Student number: st20102906
 */

package st20102906;

/**
 * TelevisionProgramme.java - a class to represent playable 
 * Television Programmes.
 * 
 * @author 	Matthew Roberts
 * @version 1.0
 * @see 	Media
 */

public class TelevisionProgramme extends Media{
	
	// declared private - encapsulation
	private int series;
	private int episode;
	private String studio;
	private String channel;
	
	/**
	 * Class constructor specifying Television Programme attributes.
	 * 
	 * @param title
	 * @param series
	 * @param episode
	 * @param yearOfRelease
	 * @param studio
	 * @param channel
	 * @param rating
	 */
	public TelevisionProgramme(String title, int series, int episode, int yearOfRelease, String studio, String channel, int rating)
	{
		super(title, yearOfRelease, rating);
		
		this.series 	= series;
		this.episode 	= episode;
		this.studio 	= studio;
		this.channel 	= channel;
	}
	
	/**
	 * Sets a value for series.
	 * 
	 * @param series
	 */
	public void setSeries(int series)
	{
		this.series = series;
	}
	
	/**
	 * Sets a value for episode.
	 * 
	 * @param episode
	 */
	public void setEpisode(int episode)
	{
		this.episode = episode;
	}
	
	/**
	 * Sets a value for studio.
	 * 
	 * @param studio
	 */
	public void setStudio(String studio)
	{
		this.studio = studio;
	}
	
	/**
	 * Sets a value for channel.
	 * 
	 * @param channel
	 */
	public void setChannel(String channel)
	{
		this.channel = channel;
	}
	
	/**
	 * Returns the number for the series as an integer.
	 * 
	 * @return an integer value for series.
	 */
	public int getSeries()
	{
		return this.series;
	}
	
	/**
	 * Returns the number for the episode as an integer.
	 * 
	 * @return an integer value for episode.
	 */
	public int getEpisode()
	{
		return this.episode;
	}
		
	/**
	 * Returns the name for the studio as a String.
	 * 
	 * @return a String value for studio.
	 */
	public String getStudio()
	{
		return this.studio;
	}
	
	/**
	 * Returns the name for the channel as a String.
	 * 
	 * @return a String value for channel.
	 */
	public String getChannel()
	{
		return this.channel;
	}
}
