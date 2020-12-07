// --== CS400 File Header Information ==--
// Name: Ayushi Mishra
// Email: mishra37@wisc.edu
// Team: LB
// Role: Test Engineer
// TA: Divyanshu Saxena
// Lecturer: Florian
// Notes to Grader: <optional extra notes>
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class checks the functionality of the Music Management System
 * 
 * Tests methods implemented in the MusicManager class thoroughly.
 * @author Ayushi mishra 
 *
 */
class MusicTester {
  
  MusicManager manager = new MusicManager();
  Song song1, song2, song3, song4, song5, song6, song7, song8, song9;

  /**
   * initializes song object with its attributes and adds it to hashtable using 
   * putSong() method implemented by back-end
   */
  @BeforeEach
  public void initialiseSong() {
    // initializes song object to be added in the hashtable
    song1 = new Song("Numb" ,"Linkin Park", "Alternative rock", "Meteora");
    song2 = new Song("Paradise","Coldplay","Indie", "Mylo Xyloto");
    song3 = new Song("Shadow of the Day" , "Linkin Park" ,"Alternative rock", "Minutes to Midnight");
    song4 = new Song("Blackout", "Linkin Park" ,"Dance-pop", "A Thousand Suns");
    song5 = new Song("Fix You" ,"Coldplay" , "Rock", " X&Y");
    song6 = new Song("Young Dumb & Broke" , "Khalid" ,"R&B" ,"American Teen");
    song7 = new Song("Nothing Else Matters" ,"Metallica","Rock", "Metallica");
    song8 = new Song("The Unforgiven","Metallica","Metal","Metallica");
    song9 = new Song("In Between", "Linkin Park", "Hard Rock", "Minutes to Midnight");
    
    // uses putSong method to add song into hashtable using song name as key
    manager.putSong("Numb", song1);
    manager.putSong("Paradise", song2);
    manager.putSong("Shadow of the Day", song3);
    manager.putSong("Blackout", song4);
    manager.putSong("Fix You", song5);
    manager.putSong("Nothing Else Matters", song7);
    manager.putSong("The Unforgiven", song8);
    manager.putSong("In Between", song9);
  }
   
  /**
   * tests if the getSong() method returns correct song object, when passed with song name as key
   * if stored in hashtable,
   * else throws NoSuchElementException
   */
  @Test
  void testGetSong() { 
    // checking with songs added in hashtable
    Song check1 = manager.getSong("Numb");
    Song check2 = manager.getSong("Blackout");
    if (!song1.equals(check1)) {
      fail("song was not added properly");
    }
    if (!song4.equals(check2)) {
      fail("song was not added properly");
    }
    
    // checking with songs which are not added in the hashtable
    boolean test3 = false;
    try {
    manager.getSong("Thank you, Next!");
    }
    catch(NoSuchElementException e) { 
      test3 = true;  
    }
    assertTrue(test3); 
  }
 
  /**
   * tests if the getArtist() method returns correct song object, when passed with artist name as key
   * if it is stored in hashtable,
   * else throws NoSuchElementException if not found.
   */
  @Test
  void testGetArtist() {   
    // checking for artist whose song is added in hashtable
    LinkedList<Song> check1 = manager.getArtist("Linkin Park");
    LinkedList<Song> linkinSongs = new LinkedList<>();
    linkinSongs.add(song4);
    linkinSongs.add(song1);
    linkinSongs.add(song3);
    linkinSongs.add(song9);
    if (!linkinSongs.equals(check1)) {
      fail("song with specified artist is not added properly");
    }
    
    LinkedList<Song> check2 = manager.getArtist("Coldplay");
    LinkedList<Song> coldplaySongs = new LinkedList<>();
    coldplaySongs.add(song5);
    coldplaySongs.add(song2);
    if (!coldplaySongs.equals(check2)) {
      fail("song with specified artist is not added properly");
    }
    
    // checking for artist whose song is not added in hashtable
    boolean test3 = false;
    try {
      manager.getArtist("Khalid");
    }
    catch(NoSuchElementException e) {
      test3 = true;
    }
    assertTrue(test3);
  }
  
  /**
   * tests if the getGenre() method returns correct song object, when passed with song genre as key
   * if it is stored in hashtable,
   * else throws NoSuchElementException if not found.
   */
  @Test
  void testGetGenre() { 
    // checking for genre which is added in hashtable
    LinkedList<Song> check1 = manager.getGenre("Alternative rock");
    LinkedList<Song> alternativeRockSongs = new LinkedList<>();
    alternativeRockSongs.add(song1);
    alternativeRockSongs.add(song3);
    if (!alternativeRockSongs.equals(check1)) {
      fail("song with specified genre is not added properly");
    }
    
    LinkedList<Song> check2 = manager.getGenre("Indie");
    LinkedList<Song> IndieSongs = new LinkedList<>();
    IndieSongs.add(song2);
    if (!IndieSongs.equals(check2)) {
      fail("song with specified genre is not added properly");
    }
    
    // checking for genre which is not added in hashtable
    boolean test3 = false;
    try {
       manager.getGenre("R&B");
    }
    catch(NoSuchElementException e) {
      test3 = true;
    }
    assertTrue(test3);
  }
  
  /**
   * tests if the getAlbum() method returns correct song object, when passed with album name of song 
   * as key if it is stored in hashtable,
   * else throws NoSuchElementException if not found.
   */
  @Test
  void testGetAlbum() {
    // checking for album which is added in hashtable
    LinkedList<Song> check1 = manager.getAlbum("Metallica");
    LinkedList<Song> metallicaSongs = new LinkedList<>();
    metallicaSongs.add(song8);
    metallicaSongs.add(song7);
    if (!metallicaSongs.equals(check1)) {
      fail("song with specified album is not added properly");
    }
    
    LinkedList<Song> check2 = manager.getAlbum("Minutes to Midnight");
    LinkedList<Song> midnightSongs = new LinkedList<>();
    midnightSongs.add(song3);
    midnightSongs.add(song9);
    if (!midnightSongs.equals(check2)) {
      fail("song with specified album is not added properly");
    }
    
    // checking for album which is not added in hashtable
    boolean test3 = false;
    try {
      manager.getAlbum("American Teen");
    }
    catch(NoSuchElementException e) {
      test3 = true;
    }
    assertTrue(test3);
  }
  
  /**
   * checks if print() method correctly returns string representation of song object
   */
  @Test
  void testPrint() {
    String actualSong1 = manager.print(song1);
    String expected1 = "Linkin Park- Numb( Meteora )( Alternative rock )";
    
    if (!actualSong1.equals(expected1)) {
      fail("print method doesn't return the correct string!");
    }

    String actualSong2 = manager.print(song5);
    String expected2 = "Coldplay- Fix You(  X&Y )( Rock )";
    
    if (!actualSong2.equals(expected2)) {
      fail("print method doesn't return the correct string!");
    }
  }
  
}
