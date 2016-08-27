import model.Song;

import model.SongBook;


//Main Class
public class Karaoke {
	
	

public static void main(String args[]){
	//working progress before method calls
	/*Song song = new Song (
			"Micheal Jackson",
			"Beat It",
			"https://www.youtube.com/watch?v=SaEC9i9Q0vk"
			);
	SongBook songbook = new SongBook();
	System.out.printf("Adding %s %n", song);
	songbook.addSong(song);
	System.out.printf("there are %d songs. %n", songbook.getSongCount());
	
	*/
	
	//now methods calls
	
	SongBook songbook = new SongBook();
	KaraokeMachine machine = new KaraokeMachine(songbook);
	machine.run();
			
	
	
	
	
	
	
	
			
	
}
	

}






