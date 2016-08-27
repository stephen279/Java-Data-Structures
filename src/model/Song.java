package model;

public class Song {
	
	private String mArtist;
	private String mTitle;
	private String mVideoUrl;
	
	//create new song give values
	public Song(String artist, String title, String videoUrl){
		
		mArtist = artist;
		mTitle = title;
		mVideoUrl = videoUrl;
		
	
	}
	
	//what users can see
	public String getTitle(){
		
		return mTitle;
	}

	public String getArtist(){
		
		
		return mArtist;
	}
	
	public String getVideoUrl(){
		
		return mVideoUrl;
	}
	
	@Override
	public String toString(){
		
	return String.format("song, %s by %s",mTitle, mArtist);	
	}
	

	
	
}
