/* @st20102906			1.0	06/12/2016
 *
 * Matthew Aaron Roberts, 2016
 * Student number: st20102906
 */

package st20102906;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * MediaManager.java - the class consists exclusively of static methods that 
 * allows a user to catalogue various forms of media, including films, audio
 * tracks and television programmes.
 * 
 * The user is provided with a menu system, with which they can use to 
 * navigate and perform a number of operations. These operations include the 
 * ability to add, edit, delete and search for a film, audio track or 
 * television programme.
 * 
 * @author 	Matthew Roberts
 * @version 1.0
 */
public class MediaManager{
	
	// declares a global media collection
	private static MediaCollection mediaCollection;
	
	// declares global scanner to receive input from the user
	private static Scanner sGet = new Scanner(System.in);
	
	/**
	 * Initialise Media Collection with test data, call Home Screen and call
	 * exit method once Home Screen has finished. 
	 * @param args
	 */
	public static void main(String[] args)
	{
		// call initialisation
		init();
		
		// call home screen
		screenHome();
		
		// call exit once finished with home screen
		exit();
	}
	
	/**
	 * Creates a collection of media objects and populate the media collection 
	 * with test data.
	 */
	private static void init()
	{
		// load test data into lists of the corresponding objects.
		ArrayList<Film> films 								= Testing_DataLoader.loadFilms();
		ArrayList<AudioTrack> audioTracks 					= Testing_DataLoader.loadAudioTracks();
		ArrayList<TelevisionProgramme> televisionProgrammes = Testing_DataLoader.loadTelevisionProgrammes();
		
		// initialise Media Collection and add the test data.
		mediaCollection = new MediaCollection(films, audioTracks, televisionProgrammes);	
	}
	
	/**
	 * Main program loop. Displays Home screen menu, receives input from the 
	 * user and directs user to new screens depending on input decision.
	 */
	private static void screenHome()
	{
		int input = 0;
		
		// repeat until user specifies to exit the program
		while (input!=5)
		{
			displayHeader();
			
			// display home screen menu
			System.out.println("1. Add a new media item");
			System.out.println("2. Search media items");
			System.out.println("3. List view media items");
			System.out.println("4. Randomly select media item");
			System.out.println("5. Exit\n");
			
			// get home screen menu input
			System.out.print(" > ");
			input = convertStringToInt();
			
			// make home screen menu decision
			if (input==5)
				break;
			else if (input==4)
				randomMedia();
			else if (input==3)
				screenViewMedia();
			else if (input==2)
				screenSearchMedia();
			else if (input==1)
				screenAddMedia();
			else
				System.out.println("Invalid option: Enter a number (1-5)!");
		}
	}
	
	/**
	 * Add Media loop. Displays Add media menu, receives input from the user and 
	 * directs user to either add film, audio track or television programme.
	 */
	private static void screenAddMedia()
	{
		int input = 0;
		
		// repeat until user enters a valid menu option
		while (!((input<=4)&&(input>=1)))
		{
			displayHeader();
			
			// display menu
			System.out.println("Add to a media type:");
			System.out.println("1. Film");
			System.out.println("2. Audio Track");
			System.out.println("3. Television Programme");
			System.out.println("4. Back\n");
			
			// get input
			System.out.print(" > ");
			input = convertStringToInt();
			
			// menu decision
			if (input==4)
				break;
			else if (input==3)
				addTelevisionProgramme();
			else if (input==2)
				addAudioTrack();
			else if (input==1)
				addFilm();
			else
				System.out.println("Invalid option: Enter a number (1-4)!");
		}
	}
	
	/**
	 * Loops until user confirms that the data they added is correct. Prompts 
	 * the user to input attribute data for a Film.
	 */
	private static void addFilm()
	{
		String input = "n";
		
		String title 		= null;
		int yearOfRelease 	= 0;
		double duration 	= 0.0;
		String studio 		= null;
		String director 	= null;
		int rating 			= 0;
		
		// decision to loop unless user is confident with input data
		while (!(input.equals("y") || input.equals("Y")))
		{
			displayHeader();
			
			// prompts the user for input for the Film
			System.out.println("Input Film:- ");
			System.out.print("   - Title:\n    > ");
			title = sGet.nextLine();
			System.out.print("   - Year of Release:\n    > ");
			yearOfRelease = convertStringToInt();
			System.out.print("   - Duration(minutes):\n    > ");
			duration = convertStringToDouble();
			System.out.print("   - Studio:\n    > ");
			studio = sGet.nextLine();
			System.out.print("   - Director:\n    > ");
			director = sGet.nextLine();
			System.out.print("   - Rating(1-5):\n    > ");
			rating = convertStringToInt();
			
			// get loop decision
			System.out.println("\nDetails correct? (Y/N)");
			System.out.print(" > ");
			input = sGet.nextLine();
		}
		
		// add Film with entered attribute values, to media collection.
		mediaCollection.addFilm(title, yearOfRelease, duration, studio, director, rating);
		System.out.println("\nSuccessfully added to the system!\n");
		
		System.out.println("..Press Enter to return to Homescreen..");
		sGet.nextLine();
	}

	/**
	 * Loops until user confirms that the data they added is correct. Prompts 
	 * the user to input attribute data for an Audio Track.
	 */
	private static void addAudioTrack()
	{
		String input = "n";
		
		String title 		= null;
		String creator 		= null;
		int yearOfRelease 	= 0;
		double duration 	= 0.0;
		String recordLabel	= null;
		int rating 			= 0;

		
		while (!(input.equals("y") || input.equals("Y")))
		{
			displayHeader();
			
			System.out.println("Input Audio Track:- ");
			System.out.print("   - Title:\n    > ");
			title = sGet.nextLine();
			System.out.print("   - Creators:\n    > ");
			creator = sGet.nextLine();
			System.out.print("   - Year of Release:\n    > ");
			yearOfRelease = convertStringToInt();
			System.out.print("   - Duration(minutes):\n    > ");
			duration = convertStringToDouble();
			System.out.print("   - Record Label:\n    > ");
			recordLabel = sGet.nextLine();
			System.out.print("   - Rating(1-5):\n    > ");
			rating = convertStringToInt();
			
			System.out.println("\nDetails correct? (Y/N)");
			System.out.print(" > ");
			input = sGet.nextLine();
		}
		
		mediaCollection.addAudioTrack(title, creator, yearOfRelease, duration, recordLabel, rating);
		System.out.println("\nSuccessfully added to the system!\n");
		
		System.out.println("..Press Enter to return to Homescreen..");
		sGet.nextLine();
	}

	/**
	 * Loops until user confirms that the data they added is correct. Prompts 
	 * the user to input attribute data for a Television Programme.
	 */
	private static void addTelevisionProgramme()
	{
		String input = "n";
		
		String title 		= null;
		int series 			= 0;
		int episode 		= 0;
		int yearOfRelease 	= 0;
		String studio 		= null;
		String channel 		= null;
		int rating 			= 0;

		
		while (!(input.equals("y") || input.equals("Y")))
		{
			displayHeader();
			
			System.out.println("Input Television Programme:- ");
			System.out.print("   - Title:\n    > ");
			title = sGet.nextLine();
			System.out.print("   - Series:\n    > ");
			series = convertStringToInt();
			System.out.print("   - Episode:\n    > ");
			episode = convertStringToInt();
			System.out.print("   - Year of Release:\n    > ");
			yearOfRelease = convertStringToInt();
			System.out.print("   - Studio:\n    > ");
			studio = sGet.nextLine();
			System.out.print("   - Channel:\n    > ");
			channel = sGet.nextLine();
			System.out.print("   - Rating(1-5):\n    > ");
			rating = convertStringToInt();
			
			System.out.println("\nDetails correct? (Y/N)");
			System.out.print(" > ");
			input = sGet.nextLine();
		}
		
		mediaCollection.addTelevisionProgramme(title, series, episode, yearOfRelease, studio, channel, rating);
		System.out.println("\nSuccessfully added to the system!\n");
		
		System.out.println("..Press Enter to return to Homescreen..");
		sGet.nextLine();
		
	}
	
	/**
	 * Search Media loop. Displays Search Media menu, receives input form the user
	 * and directs user to either search film, audio track or television programme.
	 */
	private static void screenSearchMedia()
	{	
		int input = 0;
		
		// repeat until user enters a valid menu option
		while (!(input<=4 && input>=1))
		{
			displayHeader();
			
			// display menu
			System.out.println("Search a media type:");
			System.out.println("1. Films");
			System.out.println("2. Audio Tracks");
			System.out.println("3. Television Programmes");
			System.out.println("4. Back\n");
			
			// get user input
			System.out.print(" > ");
			input = convertStringToInt();
			
			// make decision depending on user input
			if (input==4)
				break;
			else if (input==3)
				searchTelevisionProgramme();
			else if (input==2)
				searchAudioTrack();
			else if (input==1)
				searchFilm();
			else
				System.out.println("Invalid option: Enter a number (1-4)!");
		}
	}
	
	/**
	 * Searches through Media Collection's list of Films, if an attribute matches then
	 * it adds it to a new list of Films. Displays the new list as results and offers
	 * the user to either, search again or select one of the resultant Films.
	 */
	private static void searchFilm()
	{
		// creates a temporary list of films from the stored films within media collection
		ArrayList<Film> films = mediaCollection.getFilms();
		
		// creates an empty list for films
		ArrayList<Film> results = new ArrayList<Film>();
		
		String result = null;
		
		int inAttributeMenu = 0;
		int inResultsMenu	= 0;
		
		String inputTitle;
		int inputYearOfRelease;
		double inputDuration;
		String inputStudio;
		String inputDirector;
		int inputRating;
		

		/*
		 * repeat while: -
		 *  - out of scope of the menu options
		 *  - if user doesn't enter 7
		 *  - if user doesn't select a film
		 */
		do
		{
			inAttributeMenu = 0;
			results.clear();
			result = null;
			
			// repeats until user enters a number between 7 and 1
			while (!((inAttributeMenu<=7)&&(inAttributeMenu>=1)))
			{
				displayHeader();
				
				System.out.println("Specify Film attribute:");
				System.out.println("1. Title");
				System.out.println("2. Year of Release");
				System.out.println("3. Duration");
				System.out.println("4. Studio");
				System.out.println("5. Director");
				System.out.println("6. Rating");
				System.out.println("7. Back\n");
				
				System.out.print(" > ");
				inAttributeMenu = convertStringToInt();
				
				/*
				 * inside options 1-6:-
				 * - prompt user for input
				 * - get input from user
				 * - search through films for matching rating
				 *  - if a match is found: add film to array list
				 */
				if (inAttributeMenu==7)
					break;
				else if (inAttributeMenu==6)
				{
					// prompt the user for input
					System.out.println("Type a Film 'Rating':\n");
					System.out.print(" > ");
					
					// get input from user
					inputRating = convertStringToInt();
					
					// search through films for matching rating
					for (Film film : films)
					{
						// if match found: add film to array list
						if (inputRating==film.getRating())
						{
							results.add(film);
						}
					}
				}
				else if (inAttributeMenu==5)
				{
					System.out.println("Type a Film 'Director':\n");
					System.out.print(" > ");
					inputDirector = sGet.nextLine();
					
					for (Film film : films)
					{
						if (inputDirector.equals(film.getDirector()))
						{
							results.add(film);
						}
					}
				}
				else if (inAttributeMenu==4)
				{
					System.out.println("Type a Film 'Studio':\n");
					System.out.print(" > ");
					inputStudio = sGet.nextLine();
					
					for (Film film : films)
					{
						if (inputStudio.equals(film.getStudio()))
						{
							results.add(film);
						}
					}
				}
				else if (inAttributeMenu==3)
				{
					System.out.println("Type a Film 'Duration(minutes)':\n");
					System.out.print(" > ");
					inputDuration = convertStringToDouble();
					
					for (Film film : films)
					{
						if (inputDuration==film.getDuration())
						{
							results.add(film);
						}
					}
				}
				else if (inAttributeMenu==2)
				{
					System.out.println("Type a Film 'Year of Release':\n");
					System.out.print(" > ");
					inputYearOfRelease = convertStringToInt();
					
					for (Film film : films)
					{
						if (inputYearOfRelease==film.getYearOfRelease())
						{
							results.add(film);
						}
					}
				}
				else if (inAttributeMenu==1)
				{
					System.out.println("Type a Film 'Title':\n");
					System.out.print(" > ");
					inputTitle = sGet.nextLine();
					
					for (Film film : films)
					{
						if (inputTitle.equals(film.getTitle()))
						{
							results.add(film);
						}
					}
				}
				else
					System.out.println("Invalid option: Enter a number (1-7)!");
			} // end while loop
			
			if (inAttributeMenu!=7)
			{
				displayHeader();	
				
				// display all the results with matching values
				System.out.println("Found " + results.size() + " results");
				
				for (int i = 0; i<results.size(); i++)
				{
					result = (results.get(i).getTitle() + " (" + results.get(i).getYearOfRelease() + ")");
					System.out.println((i+1) + ". Select \'" + result + "\'");
				}
				
				// depending on the number of results, add two menu options afterwards
				System.out.println((results.size()+1) + ". Search again");
				System.out.println((results.size()+2) + ". Return to Homescreen\n");
				
				// get user input
				System.out.print(" > ");
				inResultsMenu = convertStringToInt();
				
				/* 
				 * depending on the number of results, check if the user entered a 
				 * value outside the scope of the menu options
				 */
				if (inResultsMenu<1 || inResultsMenu>(results.size()+2))
					System.out.println("Invalid option: Enter a number (1-" + (results.size()+2) + ")");
			}
			/*
			 * repeat while: -
			 *  - out of scope of the menu options
			 *  - if user didn't previously enter 7
			 *  - if user didn't select a film
			 */
		} while((inResultsMenu==(results.size()+1) || (inResultsMenu<1 || inResultsMenu>(results.size()+2))) && !(inAttributeMenu==7) );
		
		// if user selects a film, call method selectFilm with the parameter of selected film
		if (inResultsMenu>0 && inResultsMenu<=results.size())
			selectFilm(results.get(inResultsMenu-1));
		
		if (inAttributeMenu==7)
			screenSearchMedia();
	}
	
	/**
	 * Searches through Media Collection's list of Audio Tracks, if an attribute matches 
	 * then it adds it to a new list of Audio Tracks. Displays the new list as results 
	 * and offers the user to either, search again or select one of the resultant
	 * Audio Tracks.
	 */
	private static void searchAudioTrack()
	{
		/* 
		 * creates a temporary list of audio tracks from the stored audio tracks within 
		 * media collection
		 */
		ArrayList<AudioTrack> audioTracks = mediaCollection.getAudioTracks();
		
		// creates an empty list for audio tracks
		ArrayList<AudioTrack> results = new ArrayList<AudioTrack>();
		
		String result = null;
		
		int inAttributeMenu = 0;
		int inResultsMenu 	= 0;
		
		String inputTitle;
		String inputCreator;
		int inputYearOfRelease;
		double inputDuration;
		String inputRecordLabel;
		int inputRating;
		
		do
		{
			inAttributeMenu = 0;
			results.clear();
			result = null;
			
			while (!((inAttributeMenu<=7)&&(inAttributeMenu>=1)))
			{
				displayHeader();
				
				System.out.println("Specify Audio Track attribute:");
				System.out.println("1. Title");
				System.out.println("2. Creator");
				System.out.println("3. Year of Release");
				System.out.println("4. Duration(seconds)");
				System.out.println("5. Record Label");
				System.out.println("6. Rating");
				System.out.println("7. Back\n");
				
				System.out.print(" > ");
				inAttributeMenu = convertStringToInt();
				
				if (inAttributeMenu==7)
					break;
				else if (inAttributeMenu==6)
				{
					System.out.println("\nEnter an Audio Track 'Rating':");
					System.out.print(" > ");
					inputRating = convertStringToInt();
					
					for (AudioTrack audioTrack : audioTracks)
					{
						if (inputRating==audioTrack.getRating())
						{
							results.add(audioTrack);
						}
					}
				}
				else if (inAttributeMenu==5)
				{
					System.out.println("\nEnter an Audio Track 'Record Label':");
					System.out.print(" > ");
					inputRecordLabel = sGet.nextLine();
					
					for (AudioTrack audioTrack : audioTracks)
					{
						if (inputRecordLabel.equals(audioTrack.getRecordLabel()))
						{
							results.add(audioTrack);
						}
					}
				}
				else if (inAttributeMenu==4)
				{
					System.out.println("\nEnter an Audio Track 'Duration(minutes)':");
					System.out.print(" > ");
					inputDuration = convertStringToDouble();
					
					for (AudioTrack audioTrack : audioTracks)
					{
						if (inputDuration==audioTrack.getDuration())
						{
							results.add(audioTrack);
						}
					}
				}
				else if (inAttributeMenu==3)
				{
					System.out.println("\nEnter an Audio Track 'Year of Release':");
					System.out.print(" > ");
					inputYearOfRelease = convertStringToInt();
					
					for (AudioTrack audioTrack : audioTracks)
					{
						if (inputYearOfRelease==audioTrack.getYearOfRelease())
						{
							results.add(audioTrack);
						}
					}
				}
				else if (inAttributeMenu==2)
				{
					System.out.println("\nEnter an Audio Track 'Creator':");
					System.out.print(" > ");
					inputCreator = sGet.nextLine();
					
					for (AudioTrack audioTrack : audioTracks)
					{
						if (inputCreator.equals(audioTrack.getCreator()))
						{
							results.add(audioTrack);
						}
					}
				}
				else if (inAttributeMenu==1)
				{
					System.out.println("\nEnter an Audio Track 'Title':");
					System.out.print(" > ");
					inputTitle = sGet.nextLine();
					
					for (AudioTrack audioTrack : audioTracks)
					{
						if (inputTitle.equals(audioTrack.getTitle()))
						{
							results.add(audioTrack);
						}
					}
				}
				else
					System.out.println("Invalid option: Enter a number (1-7)!");
				
			}
			
			if (!(inAttributeMenu==7))
			{
				displayHeader();	
				
				System.out.println("Found " + results.size() + " results");
				for (int i = 0; i<results.size(); i++)
				{
					result = (results.get(i).getTitle() + " (" + results.get(i).getYearOfRelease() + ")");
					System.out.println((i+1) + ". Select \'" + result + "\'");
				}
				
				System.out.println((results.size()+1) + ". Search again");
				System.out.println((results.size()+2) + ". Return to Homescreen\n");
				System.out.print(" > ");
				inResultsMenu = convertStringToInt();
				
				if (inResultsMenu<1 || inResultsMenu>(results.size()+2))
					System.out.println("Invalid option: Enter a number (1-" + (results.size()+2) + ")");
			}

		} while((inResultsMenu==(results.size()+1) || (inResultsMenu<1 || inResultsMenu>(results.size()+2))) && !(inAttributeMenu==7) );
		
		if (inResultsMenu>0 && inResultsMenu<=results.size())
			selectAudioTrack(results.get(inResultsMenu-1));
		
		if (inAttributeMenu==7)
			screenSearchMedia();
	}
	
	/**
	 * Searches through Media Collection's list of Television Programmes, if an 
	 * attribute matches then it adds it to a new list of Television Programmes.
	 * Displays the new list as results and offers the user to either, search 
	 * again or select one of the resultant Television Programmes.
	 */
	private static void searchTelevisionProgramme()
	{
		ArrayList<TelevisionProgramme> televisionProgrammes = mediaCollection.getTelevisionProgrammes();
		
		ArrayList<TelevisionProgramme> results = new ArrayList<TelevisionProgramme>();
		
		String result = null;
		
		int inAttributeMenu = 0;
		int inResultsMenu 	= 0;
		
		String inputTitle;
		int inputSeries;
		int inputEpisode;
		int inputYearOfRelease;
		String inputStudio;
		String inputChannel;
		int inputRating;
		
		do
		{
			inAttributeMenu = 0;
			results.clear();
			result = null;
			
			while (!((inAttributeMenu<=7)&&(inAttributeMenu>=1)))
			{
				displayHeader();
				
				System.out.println("Specify Television Programme attribute:");
				System.out.println("1. Title");
				System.out.println("2. Series");
				System.out.println("3. Episode");
				System.out.println("4. Year of Release");
				System.out.println("5. Studio");
				System.out.println("6. Channel");
				System.out.println("7. Rating");
				System.out.println("8. Back\n");
				
				System.out.print(" > ");
				inAttributeMenu = convertStringToInt();
				
				if (inAttributeMenu==8)
					break;
				else if (inAttributeMenu==7)
				{
					System.out.println("\nEnter a Television Programme 'Rating':");
					System.out.print(" > ");
					inputRating = convertStringToInt();
					
					for (TelevisionProgramme televisionProgramme : televisionProgrammes)
					{
						if (inputRating==televisionProgramme.getRating())
						{
							results.add(televisionProgramme);
						}
					}
				}
				else if (inAttributeMenu==6)
				{
					System.out.println("\nEnter a Television Programme 'Channel':");
					System.out.print(" > ");
					inputChannel = sGet.nextLine();
					
					for (TelevisionProgramme televisionProgramme : televisionProgrammes)
					{
						if (inputChannel.equals(televisionProgramme.getChannel()))
						{
							results.add(televisionProgramme);
						}
					}
				}
				else if (inAttributeMenu==5)
				{
					System.out.println("\nEnter a Television Programme 'Studio':");
					System.out.print(" > ");
					inputStudio = sGet.nextLine();
					
					for (TelevisionProgramme televisionProgramme : televisionProgrammes)
					{
						if (inputStudio.equals(televisionProgramme.getStudio()))
						{
							results.add(televisionProgramme);
						}
					}
				}
				else if (inAttributeMenu==4)
				{
					System.out.println("\nEnter a Television Programme 'Year of Release':");
					System.out.print(" > ");
					inputYearOfRelease = convertStringToInt();
					
					for (TelevisionProgramme televisionProgramme : televisionProgrammes)
					{
						if (inputYearOfRelease==televisionProgramme.getYearOfRelease())
						{
							results.add(televisionProgramme);
						}
					}
				}
				else if (inAttributeMenu==3)
				{
					System.out.println("\nEnter a Television Programme 'Episode':");
					System.out.print(" > ");
					inputEpisode = convertStringToInt();
					
					for (TelevisionProgramme televisionProgramme : televisionProgrammes)
					{
						if (inputEpisode==televisionProgramme.getEpisode())
						{
							results.add(televisionProgramme);
						}
					}
				}
				else if (inAttributeMenu==2)
				{
					System.out.println("\nEnter a Television Programme 'Series':");
					System.out.print(" > ");
					inputSeries = convertStringToInt();
					
					for (TelevisionProgramme televisionProgramme : televisionProgrammes)
					{
						if (inputSeries==televisionProgramme.getSeries())
						{
							results.add(televisionProgramme);
						}
					}
				}
				else if (inAttributeMenu==1)
				{
					System.out.println("\nEnter a Television Programme 'Title':");
					System.out.print(" > ");
					inputTitle = sGet.nextLine();
					
					for (TelevisionProgramme televisionProgramme : televisionProgrammes)
					{
						if (inputTitle.equals(televisionProgramme.getTitle()))
						{
							results.add(televisionProgramme);
						}
					}
				}
				else
					System.out.println("Invalid option: Enter a number (1-8)!");
				
			}
			
			if (!(inAttributeMenu==8))
			{
				displayHeader();	
				
				System.out.println("Found " + results.size() + " results");
				
				for (int i = 0; i<results.size(); i++)
				{
					result = (results.get(i).getTitle() + " (" + results.get(i).getYearOfRelease() + ")");
					System.out.println((i+1) + ". Select \'" + result + "\'");
				}
				
				System.out.println((results.size()+1) + ". Search again");
				System.out.println((results.size()+2) + ". Return to Homescreen\n");
				
				System.out.print(" > ");
				inResultsMenu = convertStringToInt();
				
				
				if (inResultsMenu<1 || inResultsMenu>(results.size()+2))
					System.out.println("Invalid option: Enter a number (1-" + (results.size()+2) + ")");
			} // end while loop

		} while((inResultsMenu==(results.size()+1) || (inResultsMenu<1 || inResultsMenu>(results.size()+2))) && !(inAttributeMenu==8) );
		
		
		if (inResultsMenu>0 && inResultsMenu<=results.size())
			selectTelevisionProgramme(results.get(inResultsMenu-1));
		
		if (inAttributeMenu==8)
			screenSearchMedia();
	}
	
	/**
	 * Offers the user with a menu option to choose which media type the user wishes to 
	 * view details for.
	 */
	private static void screenViewMedia() 
	{
		int input = 0;
		
		// return here after choice
		while (input!=5)
		{
			displayHeader();
			
			System.out.println("Select a List View");
			System.out.println("1. Films");
			System.out.println("2. Audio Tracks");
			System.out.println("3. Television Programmes");
			System.out.println("4. View all");
			System.out.println("5. Back\n");
			
			System.out.print(" > ");
			input = convertStringToInt();
			
			if (input==5)
				break;
			else if (input==4)
				viewListAll();
			else if (input==3)
				viewListTelevisionProgrammes();
			else if (input==2)
				viewListAudioTracks();
			else if (input==1)
				viewListFilms();
			else
				System.out.println("Invalid option: Enter a number (1-5)!");
			}			
		}

	/**
	 * Displays a table-like display of all Films stored in Media Collection. Formats text
	 * to keep within the bounds of the table. 
	 */
	private static void viewListFilms()
	{
		// get a list of films from media collection's list of films
		ArrayList<Film> films = mediaCollection.getFilms();
		
		displayHeader();
		
		String title 		= null;
		int yearOfRelease 	= 0;
		int rating 			= 0;
		
		// all media types have three attributes in common; title, year of release, and rating
		System.out.println("╔══════════════╦═══════════════╦══════╗");
		System.out.println("║Title         ║Year of Release║Rating║");
		System.out.println("╠══════════════╩═══════╤═══════╬══════╣");
		
		// display a table-like display of all films
		for (Film film : films)
		{
			title 			= film.getTitle();
			yearOfRelease 	= film.getYearOfRelease();
			rating 			= film.getRating();
			
			/* change format of the title so that the text stays within the table-like display
			 * if the title is longer than 20 characters, remove any characters after and change 
			 * the last two for two periods '..'.
			 */
			if (title.length()>20)
			{
				System.out.format("║%.20s..│ %4d  ║ %d/5  ║\n", title, yearOfRelease, rating);
			}
			else
			{
				System.out.format("║%-22s│ %4d  ║ %d/5  ║\n", title, yearOfRelease, rating);
			}
		}
		
		System.out.println("╚══════════════════════╧═══════╩══════╝\n");
		
		System.out.println("..Press Enter to return..");
		sGet.nextLine();
	}
	
	/**
	 * Displays a table-like display of all Audio Tracks stored in Media Collection. 
	 * Formats text to keep within the bounds of the table. 
	 */
	private static void viewListAudioTracks()
	{
		ArrayList<AudioTrack> audioTracks = mediaCollection.getAudioTracks();
		
		displayHeader();
		
		String title 		= null;
		int yearOfRelease 	= 0;
		int rating 			= 0;
		
		System.out.println("╔══════════════╦═══════════════╦══════╗");
		System.out.println("║Title         ║Year of Release║Rating║");
		System.out.println("╠══════════════╩═══════╤═══════╬══════╣");
		
		for (AudioTrack audioTrack : audioTracks)
		{
			title 			= audioTrack.getTitle();
			yearOfRelease 	= audioTrack.getYearOfRelease();
			rating 			= audioTrack.getRating();
			
			if (title.length()>20)
			{
				System.out.format("║%.20s..│ %4d  ║ %d/5  ║\n", title, yearOfRelease, rating);
			}
			else
			{
				System.out.format("║%-22s│ %4d  ║ %d/5  ║\n", title, yearOfRelease, rating);
			}
		}
		
		System.out.println("╚══════════════════════╧═══════╩══════╝\n");
		
		System.out.println("..Press Enter to return..");
		sGet.nextLine();
	}
	
	/**
	 * Displays a table-like display of all Television Programmes stored in Media Collection.
	 * Formats text to keep within the bounds of the table. 
	 */
	private static void viewListTelevisionProgrammes()
	{
		ArrayList<TelevisionProgramme> televisionProgrammes = mediaCollection.getTelevisionProgrammes();
		
		displayHeader();
		
		String title 		= null;
		int yearOfRelease 	= 0;
		int rating 			= 0;
		
		System.out.println("╔══════════════╦═══════════════╦══════╗");
		System.out.println("║Title         ║Year of Release║Rating║");
		System.out.println("╠══════════════╩═══════╤═══════╬══════╣");
		
		for (TelevisionProgramme televisionProgramme : televisionProgrammes)
		{
			title 			= televisionProgramme.getTitle();
			yearOfRelease 	= televisionProgramme.getYearOfRelease();
			rating 			= televisionProgramme.getRating();
			
			if (title.length()>20)
			{
				System.out.format("║%.20s..│ %4d  ║ %d/5  ║\n", title, yearOfRelease, rating);
			}
			else
			{
				System.out.format("║%-22s│ %4d  ║ %d/5  ║\n", title, yearOfRelease, rating);
			}
		}
		
		System.out.println("╚══════════════════════╧═══════╩══════╝\n");
		
		System.out.println("..Press Enter to return..");
		sGet.nextLine();
	}
	
	/**
	 * Displays a table-like display of all Media stored in Media Collection. Formats text
	 * to keep within the bounds of the table. 
	 */
	private static void viewListAll()
	{
		ArrayList<Media> collection = mediaCollection.getMediaCollection();
		
		displayHeader();
		
		String title 		= null;
		int yearOfRelease 	= 0;
		int rating 			= 0;
		
		System.out.println("╔══════════════╦═══════════════╦══════╗");
		System.out.println("║Title         ║Year of Release║Rating║");
		System.out.println("╠══════════════╩═══════╤═══════╬══════╣");
		
		// title limit 20 characters (automatic add .. if length > 20)
		
		for (Media media : collection)
		{
			title 			= media.getTitle();
			yearOfRelease	= media.getYearOfRelease();
			rating 			= media.getRating();
			
			if (title.length()>20)
			{
				System.out.format("║%.20s..│ %4d  ║ %d/5  ║\n", title, yearOfRelease, rating);
			}
			else
			{
				System.out.format("║%-22s│ %4d  ║ %d/5  ║\n", title, yearOfRelease, rating);
			}
		}
		
		System.out.println("╚══════════════════════╧═══════╩══════╝\n");
		
		System.out.println("..Press Enter to return..");
		sGet.nextLine();
	}
	
	/**
	 * Randomly selects a Film, Audio Track, or Television Programme, from Media Collection.
	 */
	private static void randomMedia()
	{
		// initialise a new Random object
		Random rand = new Random();
		
		// get a random integer between, 0 and the number of items stored in media collection
		int randomInteger = rand.nextInt(mediaCollection.getMediaCollection().size());
		
		// get a random Media object from Media Collection
		Media media = mediaCollection.getMediaCollection().get(randomInteger);
		
		// get the type of Media (Film or Audio Track or Television Programme) from the Media object
		String mediaType = media.getType();
		
		
		// check which Media Type the Media object belongs too 
		if ("Film".equals(mediaType))
		{
			// cast the Media object to a Film object
			selectFilm((Film) media);
		}
		else if ("AudioTrack".equals(mediaType))
		{
			// cast the Media object to an AudioTrack object
			selectAudioTrack((AudioTrack) media);
		}
		else if ("TelevisionProgramme".equals(mediaType))
		{
			// cast the Media object to a Television Programme object
			selectTelevisionProgramme((TelevisionProgramme) media);
		}
	}
	
	/**
	 * Selects the Film given as parameter and displays the details of that Film. Offers 
	 * user options to change details or delete selected Film.
	 * @param film
	 */
	private static void selectFilm(Film film)
	{
		int input = 0;
		
		while (input==0)
		{
			displayHeader();
			
			// display selected film's details
			System.out.print("Title:\n ");
			System.out.println(film.getTitle());
			System.out.print("Year of Release:\n ");
			System.out.println(film.getYearOfRelease());
			System.out.print("Duration(minutes):\n ");
			System.out.println(film.getDuration());
			System.out.print("Studio:\n ");
			System.out.println(film.getStudio());
			System.out.print("Rating:\n ");
			System.out.println(film.getRating());
		
			// display menu
			System.out.println("\n1. Change details");
			System.out.println("2. Delete item");
			System.out.println("3. Return to Homescreen\n");
			
			// get menu input
			System.out.print(" > ");
			input = convertStringToInt();
			
			// call methods depending on menu input
			if (input==3)
				break;
			else if (input==2)
				deleteFilm(film);
			else if (input==1)
				editFilm(film);
		}
	}
	
	/**
	 * Displays details of selected Film and offers an option menu to choose which
	 * attribute to change. Once an attribute has been chosen, the user is prompted
	 * for a new value.
	 * 
	 * @param film
	 */
	private static void editFilm(Film film)
	{
		int input = 0;
		
		String title;
		int yearOfRelease;
		double duration;
		String studio;
		String director;
		int rating;
		
		// repeat until user enters 7
		while (input!=7)
		{
			// get film attribute values
			title 			= film.getTitle();
			yearOfRelease 	= film.getYearOfRelease();
			duration 		= film.getDuration();
			studio 			= film.getStudio();
			director 		= film.getDirector();
			rating 			= film.getRating();
			
			displayHeader();
			
			// display option menu for attribute choice
			System.out.println("Which property to edit:");
			System.out.println("1. Title");
			System.out.println(" " + title);
			System.out.println("2. Year of Release");
			System.out.println(" " + yearOfRelease);
			System.out.println("3. Duration(minutes)");
			System.out.println(" " + duration);
			System.out.println("4. Studio");
			System.out.println(" " + studio);
			System.out.println("5. Director");
			System.out.println(" " + director);
			System.out.println("6. Rating");
			System.out.println(" " + rating);
			System.out.println("7. Finish\n");
			
			// get user choice
			System.out.print(" > ");	
			input = convertStringToInt();
			
			// depending on choice, change specific attribute value
			if (input==7)
				break;
			else if (input==6)
			{
				System.out.println("\nEnter a new Rating:");
				
				System.out.print(" > ");
				rating = convertStringToInt();
				
				// change film's rating to user input
				film.setRating(rating);
			}
			else if (input==5)
			{
				System.out.println("\nEnter a new Director:");
				
				System.out.print(" > ");
				director = sGet.nextLine();
				
				// change film's director to user input
				film.setDirector(director);
			}
			else if (input==4)
			{
				System.out.println("\nEnter a new Studio:");
				
				System.out.print(" > ");
				studio = sGet.nextLine();
				
				// change film's studio name to user input
				film.setStudio(studio);
			}
			else if (input==3)
			{
				System.out.println("\nEnter a new Duration(minutes):");
				
				System.out.print(" > ");
				duration = convertStringToDouble();
				
				// change film's duration to user input
				film.setDuration(duration);
			}
			else if (input==2)
			{
				System.out.println("\nEnter a new Year of Release:");
				
				System.out.print(" > ");
				yearOfRelease = convertStringToInt();
				
				// change film's year of release to user input
				film.setYearOfRelease(yearOfRelease);
			}
			else if (input==1)
			{
				System.out.println("\nEnter a new Title:");
				
				System.out.print(" > ");
				title = sGet.nextLine();
				
				// change film's title to user input
				film.setTitle(title);
			}
		}
		
		System.out.println("Successfully updated!\n");
		
		System.out.println("..Press Enter to return to Homescreen..");
		sGet.nextLine();
	}
	
	/**
	 * Deletes selected Film from Media Collection, after confirming user's choice.
	 * 
	 * @param film
	 */
	private static void deleteFilm(Film film)
	{
		String input = "n";
		
		// confirm user choice
		System.out.println("\nAre you sure you want to delete '" + film.getTitle() + "'? (Y/N)");
		
		System.out.print(" > ");
		input = sGet.nextLine();
		
		if (input.equals("y") || input.equals("Y"))
		{
			// delete selected film from mediaCollection's list of films
			mediaCollection.deleteFilm(film);
			
			System.out.println("Successfully deleted film!");
		}
		
		System.out.println("\n..Press Enter to return to Homescreen..");
		
		// wait for user to press enter
		sGet.nextLine();
		
	}
	
	/**
	 * Selects the Audio Track given as parameter and displays the details of that 
	 * Audio Track. Offers user options to change details or delete selected Audio Track.
	 * 
	 * @param audioTrack
	 */
	private static void selectAudioTrack(AudioTrack audioTrack)
	{
		int input = 0;
		
		while (input==0)
		{
			displayHeader();
			
			System.out.print("Title:\n ");
			System.out.println(audioTrack.getTitle());
			System.out.print("Creator:\n ");
			System.out.println(audioTrack.getCreator());
			System.out.print("Year of Release:\n ");
			System.out.println(audioTrack.getYearOfRelease());
			System.out.print("Duration(seconds):\n ");
			System.out.println(audioTrack.getDuration());
			System.out.print("Record Label:\n ");
			System.out.println(audioTrack.getRecordLabel());
			System.out.print("Rating:\n ");
			System.out.println(audioTrack.getRating());
		
			System.out.println("\n1. Change details");
			System.out.println("2. Delete item");
			System.out.println("3. Return to Homescreen\n");
			
			System.out.print(" > ");
			input = convertStringToInt();
			
			if (input==3)
				break;
			else if (input==2)
				deleteAudioTrack(audioTrack);
			else if (input==1)
			{
				editAudioTrack(audioTrack);
			}
		}
	}
	
	/**
	 * Displays details of selected Audio Track and offers an option menu to choose
	 * which attribute to change. Once an attribute has been chosen, the user is 
	 * prompted for a new value.
	 * 
	 * @param audioTrack
	 */
	private static void editAudioTrack(AudioTrack audioTrack)
	{		
		int input = 0;
		
		String title;
		String creator;
		int yearOfRelease;
		double duration;
		String recordLabel;
		int rating;
		
		while (input!=7)
		{
			title 			= audioTrack.getTitle();
			creator 		= audioTrack.getCreator();
			yearOfRelease 	= audioTrack.getYearOfRelease();
			duration 		= audioTrack.getDuration();
			recordLabel 	= audioTrack.getRecordLabel();
			rating 			= audioTrack.getRating();
			
			displayHeader();
			
			System.out.println("Which property to edit:");
			System.out.println("1. Title");
			System.out.println(" " + title);
			System.out.println("2. Creator");
			System.out.println(" " + creator);
			System.out.println("3. Year of Release");
			System.out.println(" " + yearOfRelease);
			System.out.println("4. Duration(seconds)");
			System.out.println(" " + duration);
			System.out.println("5. Record Label");
			System.out.println(" " + recordLabel);
			System.out.println("6. Rating");
			System.out.println(" " + rating);
			System.out.println("7. Save\n");
			
			System.out.print(" > ");
			input = convertStringToInt();
			
			if (input==7)
				break;
			else if (input==6)
			{
				System.out.println("\nEnter a new Rating:");
				System.out.print(" > ");
				rating = convertStringToInt();
				audioTrack.setRating(rating);
			}
			else if (input==5)
			{
				System.out.println("\nEnter a new Record Label:");
				System.out.print(" > ");
				recordLabel = sGet.nextLine();
				audioTrack.setRecordLabel(recordLabel);
			}
			else if (input==4)
			{
				System.out.println("\nEnter a new Duration(minutes):");
				System.out.print(" > ");
				duration = convertStringToDouble();
				audioTrack.setDuration(duration);
			}
			else if (input==3)
			{
				System.out.println("\nEnter a new Year of Release:");
				System.out.print(" > ");
				yearOfRelease = convertStringToInt();
				audioTrack.setYearOfRelease(yearOfRelease);
			}
			else if (input==2)
			{
				System.out.println("\nEnter a new Creator:");
				System.out.print(" > ");
				creator = sGet.nextLine();
				audioTrack.setCreator(creator);
			}
			else if (input==1)
			{
				System.out.println("\nEnter a new Title:");
				System.out.print(" > ");
				title = sGet.nextLine();
				audioTrack.setTitle(title);
			}
		}
		
		System.out.println("Successfully updated!\n");
		
		System.out.println("..Press Enter to return to Homescreen..");
		sGet.nextLine();

	}
	
	/**
	 * Deletes selected Audio Track from Media Collection, after confirming user's choice.
	 * 
	 * @param audioTrack
	 */
	private static void deleteAudioTrack(AudioTrack audioTrack)
	{
		String input = "n";
	
		System.out.println("\nAre you sure you want to delete '" + audioTrack.getTitle() + "'? (Y/N)");
		System.out.print(" > ");
	
		input = sGet.nextLine();
	
		if (input.equals("y") || input.equals("Y"))
		{
			mediaCollection.deleteAudioTrack(audioTrack);
			System.out.println("Successfully deleted audio track!");
		}
	
		System.out.println("\n..Press Enter to return to Homescreen..");
		sGet.nextLine();
	}

	/**
	 * Selects the Television Programme given as parameter and displays the details 
	 * of that Television Programme. Offers user options to change details or delete 
	 * selected Television Programme.
	 * 
	 * @param televisionProgramme
	 */
	private static void selectTelevisionProgramme(TelevisionProgramme televisionProgramme)
	{
		int input = 0;
		
		while (input==0) {
			
			displayHeader();
	
			System.out.print("Title:\n ");
			System.out.println(televisionProgramme.getTitle());
			System.out.print("Series:\n ");
			System.out.println(televisionProgramme.getSeries());
			System.out.print("Episode:\n ");
			System.out.println(televisionProgramme.getEpisode());
			System.out.print("Year of Release:\n ");
			System.out.println(televisionProgramme.getYearOfRelease());
			System.out.print("Studio:\n ");
			System.out.println(televisionProgramme.getStudio());
			System.out.print("Channel:\n ");
			System.out.println(televisionProgramme.getChannel());
			System.out.print("Rating:\n ");
			System.out.println(televisionProgramme.getRating());
			
			// display menu
			System.out.println("\n1. Change details");
			System.out.println("2. Delete item");
			System.out.println("3. Return to Homescreen\n");
			
			// get menu input
			System.out.print(" > ");
			input = convertStringToInt();
			
			// call methods depending on menu input
			if (input == 3)
				break;
			else if (input == 2)
				deleteTelevisionProgramme(televisionProgramme);
			else if (input == 1)
				editTelevisionProgramme(televisionProgramme);
		}
	}
	
	/**
	 * Displays details of selected Television Programme and offers an option menu to 
	 * choose which attribute to change. Once an attribute has been chosen, the user is 
	 * prompted for a new value.
	 * 
	 * @param televisionProgramme
	 */
	private static void editTelevisionProgramme(TelevisionProgramme televisionProgramme)
	{
		int input = 0;
		
		String title;
		int series;
		int episode;
		int yearOfRelease;
		String studio;
		String channel;
		int rating;
		
		while (input!=7)
		{
			title 			= televisionProgramme.getTitle();
			series 			= televisionProgramme.getSeries();
			episode 		= televisionProgramme.getEpisode();
			yearOfRelease	= televisionProgramme.getYearOfRelease();
			studio 			= televisionProgramme.getStudio();
			channel 		= televisionProgramme.getChannel();
			rating 			= televisionProgramme.getRating();
			
			displayHeader();
			
			System.out.println("Which property to edit:");
			System.out.println("1. Title");
			System.out.println(" " + title);
			System.out.println("2. Series");
			System.out.println(" " + series);
			System.out.println("3. Episode");
			System.out.println(" " + episode);
			System.out.println("4. Year of Release");
			System.out.println(" " + yearOfRelease);
			System.out.println("5. Studio");
			System.out.println(" " + studio);
			System.out.println("6. Channel");
			System.out.println(" " + channel);
			System.out.println("7. Rating");
			System.out.println(" " + rating);
			System.out.println("7. Save\n");
			
			System.out.print(" > ");
			input = convertStringToInt();
			
			if (input==8)
				break;
			else if (input==7)
			{
				System.out.println("\nEnter a new Rating:");
				System.out.print(" > ");
				rating = convertStringToInt();
				televisionProgramme.setRating(rating);
			}
			else if (input==6)
			{
				System.out.println("\nEnter a new Channel:");
				System.out.print(" > ");
				channel = sGet.nextLine();
				televisionProgramme.setChannel(channel);
			}
			else if (input==5)
			{
				System.out.println("\nEnter a new Studio:");
				System.out.print(" > ");
				studio = sGet.nextLine();
				televisionProgramme.setStudio(studio);
			}
			else if (input==4)
			{
				System.out.println("\nEnter a new Year of Release:");
				System.out.print(" > ");
				yearOfRelease = convertStringToInt();
				televisionProgramme.setYearOfRelease(yearOfRelease);
			}
			else if (input==3)
			{
				System.out.println("\nEnter a new Episode:");
				System.out.print(" > ");
				episode = convertStringToInt();
				televisionProgramme.setEpisode(episode);
			}
			else if (input==2)
			{
				System.out.println("\nEnter a new Series:");
				System.out.print(" > ");
				series = convertStringToInt();
				televisionProgramme.setSeries(series);
			}
			else if (input==1)
			{
				System.out.println("\nEnter a new Title:");
				System.out.print(" > ");
				title = sGet.nextLine();
				televisionProgramme.setTitle(title);
			}
		}
		
		System.out.println("Successfully updated!\n");
		
		System.out.println("..Press Enter to return to Homescreen..");
		sGet.nextLine();
	}
	
	/**
	 * Deletes selected Television Programme from Media Collection, after confirming
	 * user's choice.
	 * 
	 * @param televisionProgramme
	 */
	private static void deleteTelevisionProgramme(TelevisionProgramme televisionProgramme)
	{
		String input = "n";
	
		System.out.println("\nAre you sure you want to delete '" + televisionProgramme.getTitle() + "'? (Y/N)");
		System.out.print(" > ");
	
		input = sGet.nextLine();
	
		if (input.equals("y") || input.equals("Y"))
		{
			mediaCollection.deleteTelevisionProgramme(televisionProgramme);
			System.out.println("Successfully deleted television programme!");
		}
	
		System.out.println("\n..Press Enter to return to Homescreen..");
		sGet.nextLine();
	}
	
	/**
	 * Converts user input from a String to an integer. Catches the thrown exception if
	 * the conversion fails; if the String cannot be converted to an integer.
	 * 
	 * @return integer value of converted user input
	 */
	private static int convertStringToInt()
	{
		int input = 0;
		
		// try to convert user input from a string to an integer
		try
		{
			input = Integer.parseInt(sGet.nextLine());
		}
		catch(NumberFormatException convertProblem)
		{
			// if conversion fails: assume user entered a string 
			System.out.println("Invalid input: Enter an integer!");
		}
		
		// return converted user input
		return input;
	}
	
	/**
	 * Converts user input from a String to a double. Catches the thrown exception if
	 * the conversion fails; if the String cannot be converted to a double.
	 * 
	 * @return double value of converted user input
	 */
	private static double convertStringToDouble()
	{
		double input = 0.0;
		
		// try to convert user input from a string to a double
		try
		{
			input = Double.parseDouble(sGet.nextLine());
		}
		catch(NumberFormatException convertProblem)
		{
			// if conversion fails: assume user entered a string
			System.out.println("Invalid input: Enter a decimal number!");
		}
		
		// return converted user input
		return input;
	}
	
	/**
	 * Displays Media Review System header, containing some information about the system
	 * and by whom it was created.
	 */
	private static void displayHeader()
	{
		System.out.println("---- ---- ---- ---- ---- ---- ---- ----");
		System.out.println("Media Review System (version 1.0)");
		System.out.println("created by Matthew Roberts, 2016");
		System.out.println("---- ---- ---- ---- ---- ---- ---- ----\n");
	}
	
	/**
	 * Dispose of used resources and display a pleasant goodbye message.
	 */
	private static void exit()
	{
		// dispose scanner
		sGet.close();
		
		System.out.println("Goodbye!");
	}
}
