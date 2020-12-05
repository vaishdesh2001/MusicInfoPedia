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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadSongs {
    public static void readFile( MusicManager manager ){
        File file = new File("SongInfo.csv");
        Scanner scnr = null;
        try {
          scnr = new Scanner(file);
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        String line;
        line = scnr.nextLine();
        while (scnr.hasNextLine()) {
          line = scnr.nextLine();
          String[] commaSeparated = line.split(",");
          Song toAdd = new Song(commaSeparated[0], commaSeparated[1], commaSeparated[3], commaSeparated[2] );
          manager.putSong(commaSeparated[0], toAdd);
        }
    }
}
