/* @st20102906			1.0	23/11/2016
 *
 * Matthew Aaron Roberts, 2016
 * Student number: st20102906
 */

package st20102906;

/**
 * Media.java - a superclass for various forms of media, including films, 
 * audio tracks and television programmes.
 * 
 * @author 	Matthew Roberts
 * @version 1.0
 * @see 	Media
 */

public class Media {
	
	// declared private - encapsulation
	private String title;
	private int yearOfRelease;
	private int rating;
	
	/**
	 * Class constructor specifying common media attributes. 
	 * This class is invoked by subclasses because it shares 
	 * common attributes.
	 * 
	 * @param title
	 * @param yearOfRelease
	 * @param rating
	 */
	public Media(String title, int yearOfRelease, int rating)
	{
		this.title = title;
		this.yearOfRelease = yearOfRelease;
		this.rating = rating;
	}

	/**
	 * Sets a value for the title.
	 * 
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/**
	 * Sets a value for the year the media was first released.
	 * 
	 * @param yearOfRelease
	 */
	public void setYearOfRelease(int yearOfRelease)
	{
		this.yearOfRelease = yearOfRelease;
	}
	
	/**
	 * Sets a rating value.
	 * 
	 * @param rating
	 */
	public void setRating(int rating)
	{
		this.rating = rating;
	}
	
	/**
	 * Returns the title as a String.
	 * 
	 * @return a String value for the title.
	 */
	public String getTitle()
	{
		return this.title;
	}
	
	/**
	 * Returns the year the media was first released, as an integer.
	 * 
	 * @return an integer value representing the year for whence the media was first released.
	 */
	public int getYearOfRelease()
	{
		return this.yearOfRelease;
	}
	
	/**
	 * Returns the user-determined rating of the media, as an integer between 1-5.
	 * 
	 * @return an integer value between 1-5 representing the rating.
	 */
	public int getRating()
	{
		return this.rating;
	}
	
	/**
	 * Returns the type of Media object. When a subclass class this method it will 
	 * return the object type of the subclasses, as a String.
	 * @return a string value for the object type
	 */
	public String getType()
	{
		return this.getClass().getSimpleName();
	}
}
