// --== CS400 File Header Information ==--
// Name: Uday Malhotra
// Email: umalhotra@wisc.edu
// Team: LB
// Role: Back End Developer 2
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader:
/**
 * This class contains the various filters that search the Hashtable for matches.
 * 
 * @author Uday Malhotra
 *
 */
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MusicManager{
    private HashTableMap<String, Song> database = new HashTableMap<String, Song>(10);

    public Song getSong( String song ){
    try {
        Song toReturn = database.get(song);
        return toReturn;
    } 
    catch (NoSuchElementException e) {
        throw new NoSuchElementException();
    }  

    }

    public LinkedList<Song> getArtist( String artist ){
        LinkedList<Song> songs = new LinkedList<>();

        for(int i =0; i< database.pairs.length; i++){

            if(database.pairs[i] != null){
                LinkedPair<String, Song> temp = database.pairs[i];

            while(temp != null){
                if(temp.getValue().getSongArtist().equalsIgnoreCase(artist)){
                songs.add(temp.getValue());
                temp = temp.getNext();
                }
                else
                temp = temp.getNext();
                }

            }
            else
            continue;

        }
        if(songs.isEmpty())
        throw new NoSuchElementException();
        else
        return songs;
    }

    public LinkedList<Song> getGenre( String genre ){
        LinkedList<Song> songs = new LinkedList<>();

        for(int i =0; i< database.pairs.length; i++){

            if(database.pairs[i] != null){
                LinkedPair<String, Song> temp = database.pairs[i];

            while(temp != null){
                if(temp.getValue().getSongGenre().equalsIgnoreCase(genre)){
                songs.add(temp.getValue());
                temp = temp.getNext();
                }
                else
                temp = temp.getNext();
                }

            }
            else
            continue;

        }

        if(songs.isEmpty())
        throw new NoSuchElementException();
        else
        return songs;
    }

    public LinkedList<Song> getAlbum( String album ){
        LinkedList<Song> songs = new LinkedList<>();

        for(int i =0; i< database.pairs.length; i++){

            if(database.pairs[i] != null){
                LinkedPair<String, Song> temp = database.pairs[i];

            while(temp != null){
                if(temp.getValue().getSongAlbum().equalsIgnoreCase(album)){
                songs.add(temp.getValue());
                temp = temp.getNext();
                }
                else
                temp = temp.getNext();
                }

            }
            else
            continue;

        }

        if(songs.isEmpty())
        throw new NoSuchElementException();
        else
        return songs;
    }

    public boolean putSong(String key, Song value){

        if(database.put(key, value)){
        System.out.println("Song was added succesfully!");
        return true;
        }
        else
          return false;

    }

    public String print(Song song){

        return song.getSongArtist()+"- "+song.getSongName()+"( "+song.getSongAlbum()+" )"+"( "
        +song.getSongGenre()+" )";

    }
}
