// --== CS400 File Header Information ==--
// Name: Rahul S
// Email: sudhakar2@wisc.edu
// Team: LB
// Role: Data Wrangler
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

/**
 * @author Rahul S
 *
 */
public class Song {
  private String songName; 
  private String songArtist; 
  private String songGenre; 
  private String songAlbum;
  
  /**
   * Default constructor for Song class.
   * 
   */
  public Song() {
  }
  
  /**
   * Constructor for Song with parameters song, artist, genre and album.
   * 
   * @param song
   * @param artist
   * @param genre
   * @param album
   */
  public Song(String song, String artist, String genre, String album) {
    this.songName = song;
    this.songArtist = artist;
    this.songGenre = genre;
    this.songAlbum = album;
  }
  
  /**
   * Setter for song name.
   * @param song
   */
  public void setSongName(String song) {
    this.songName = song;
  }
  /**
   * Setter for artist name.
   * @param artist
   */
  public void setSongArtist(String artist) {
    this.songName = artist;
  } 
  /**
   * Setter for genre.
   * @param genre
   */
  public void setSongGenre(String genre) {
    this.songName = genre;
  } 
  /**
   * Setter for album name.
   * @param album
   */
  public void setSongAlbum(String album) {
    this.songName = album;
  }
  
  /**
   * Getter for song name.
   * @return songName
   */
  public String getSongName() {
    return this.songName;
  }
  /**
   * Getter for artist name.
   * @return songArtist
   */
  public String getSongArtist() {
    return this.songArtist;
  } 
  /**
   * Getter for genre.
   * @return songGenre
   */
  public String getSongGenre() {
    return this.songGenre;
  } 
  /**
   * Getter for song album.
   * @return songAlbum
   */
  public String getSongAlbum() {
    return this.songAlbum;
  }
  
  public String toString() {
    String toReturn = "";
    toReturn += "Song Name: " + this.songName + '\n';
    toReturn += "Artist Name: " + this.songArtist + '\n';
    toReturn += "Album: " + this.songAlbum + '\n';
    toReturn += "Genre: " + this.songGenre;
    
    return toReturn;
  }

}

