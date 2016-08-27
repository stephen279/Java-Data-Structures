import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Song;
import model.SongBook;

public class KaraokeMachine {
	
	private SongBook mSongBook;
	private BufferedReader mReader;
	private Map<String, String> mMenu;
	
	public  KaraokeMachine(SongBook songbook){
	mSongBook = songbook;
	mReader = new BufferedReader(new InputStreamReader(System.in));
		
	//maps build a menu of things/options of choice
	mMenu = new HashMap<String, String>();
	mMenu.put("add", "Add a new Song to the Song Book\n");
	mMenu.put("choose","Choose a song to sing");
	mMenu.put("quit", "Give up. Exit\n");
	
	
	}
	
	private String promptAction() throws IOException {
		
		System.out.printf("ther are %d songs available. your options are: %n", mSongBook.getSongCount());
		//loop that menu when u loop thru map it return 
		for(Map.Entry<String, String> option : mMenu.entrySet()){
			//loop thru eaach one
			System.out.printf("%s = %s", option.getKey(),
					option.getValue());
			
		}
		//promth for what want do
		System.out.println("What u wana do?");
		//use reader object we created
		String choice = mReader.readLine();  
		
		return choice.trim().toLowerCase();
		
		
	}
	
	//build run loop loop till we get value
	
	public void run(){
	String choice = "";
	
	
	do{
		
		try {
			choice = promptAction();  // so need put in try catch
			switch(choice){    //switch statement
			
			case "add":
				//TODO : ADD a new Song
				Song song = promptNewSong();
				mSongBook.addSong(song);
				System.out.printf(" song added!");
				
			break;
			
			case "choose":
				String Artist = promptArtist();
				Song artistSong = promptSongforArtist(Artist);
				System.out.println("you have choosing");
			break;
			
			case "quit":
				System.out.println("Thanks for playing!");
				
				break;
			default:
				System.out.println("Unknown choiice try again");
			
			}
		} catch (IOException e) {
		
			e.printStackTrace();
			System.out.println("problem with inut");
		} // remember promthAction throws exception
		
	
	
		
	}while(!choice.equals("quit"));    //go tell quit is choosen
	
	
	}
	
	//add new song
	private Song promptNewSong() throws IOException{
	 System.out.println("Enter the Artist name: ");
	String artist = mReader.readLine();
	System.out.println("Enter the Title");
	String title = mReader.readLine();
	System.out.println("Enter video url");
	String videoUrl = mReader.readLine();
	
	return new Song(artist,title,videoUrl);
	}
	
	private String promptArtist() throws IOException{
		
		
		System.out.println("Available Artist");
		List<String> artists = new ArrayList<>(mSongBook.getArtist());
		int index = promptforIndex(artists);
		return artists.get(index);
	}
	
	private Song promptSongforArtist(String artist) throws IOException{
		List<Song> songs = mSongBook.getSongsForArtist(artist);
		List<String> songTitles = new ArrayList<>();
		for (Song song: songs){
		
			songTitles.add(song.getTitle());
		}
		int index = promptforIndex(songTitles);
		return songs.get(index);
	}
	
	//reusable helper function UI
	
	private int promptforIndex(List<String> options) throws IOException{
	
		int counter = 1;
		for (String option : options)//loop through option the string option in options
		{
			
		System.out.printf("%d.) %s %n",counter, option);	
		counter ++;
		}
		String optionAsString = mReader.readLine();
		int choice = Integer.parseInt(optionAsString);
		System.out.println("Your Choice");
		return choice - 1;
	}
	
	
	
}

