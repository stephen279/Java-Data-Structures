package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SongBook {
	
	private List<Song> mSongs;  //list of songs
	
	public SongBook(){
		
		mSongs = new ArrayList<Song>();
	}
	
	//songbook to accept new songs to be added
	public void addSong(Song song){
		
		
		mSongs.add(song);  //add new song to arrayList
	}
	
	public int getSongCount(){
		
		
		return mSongs.size();
		
	}
	
	private Map<String, List<Song>> byArtist(){  //create a map off artist to songs
		Map<String, List<Song>> byArtist = new HashMap<>(); //brand new map when method starts
		
		for(Song song : mSongs){  //loop through each songs
			//see if in byArtist 
			List<Song> artistsongs = byArtist.get(song.getArtist());
			if (artistsongs == null){  // if not
				//make new one put into map this stuff
				artistsongs = new ArrayList<>();
				byArtist.put(song.getArtist(), artistsongs);
				
								
			}
			artistsongs.add(song);
		}
		return byArtist;
		
	}
	
	//expose out artist
	public Set<String> getArtist(){
	
		return byArtist().keySet();
		
	}
	
	//list songs
	public List<Song> getSongsForArtist(String artistName){
		return byArtist().get(artistName);
		
		
	
	}
	


}
