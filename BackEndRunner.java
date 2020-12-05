// --== CS400 File Header Information ==--
// Name: Vaishnavi Deshpande
// Email: vvdeshpande@wisc.edu
// Team: LB
// Role: Front End Developer 2
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader:

import java.io.File;
import java.util.LinkedList;
import java.io.FileWriter; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BackEndRunner {

  static MusicManager musicMethodsObj = new MusicManager();
  public static String getSongString(String query) {
    int num = 0;
    int index = 0;
    for (int i = 0; i < query.length(); i++) {
      if (query.charAt(i) == '.') {
        num++;
        if (num == 3) {
          index = i + 1;
          break;
        }
      }
    }
    String songName = query.substring(index, query.length());
    return songName.strip();
  }
  
  public static void writeTable(LinkedList<Song> outList) throws FileNotFoundException{
    String styleText = "";
    File styleRead = new File("style.txt");
    @SuppressWarnings("resource")
    Scanner scnr = new Scanner(styleRead);
    while(scnr.hasNextLine()){  
        styleText += scnr.nextLine();
    }
    String toWrite = styleText;
    toWrite += "<html><table class = \"center\" ><tr><th>﻿song name</th><th> artist</th><th> album</th><th> genre</th><th> link</th></tr>";
      int i = 0;
      for (Song song : outList) {
          toWrite += "<tr>";
          toWrite += "<td>" + song.getSongName() + "</td>";
          toWrite += "<td>" + song.getSongArtist() + "</td>";
          toWrite += "<td>" + song.getSongGenre() + "</td>";
          toWrite += "<td>" + song.getSongAlbum() + "</td>";	
          toWrite += "<td>" + "link goes here" + "</td>";
          toWrite += "</tr>";
          if(i==10){
          	break;
          }
        i++;
      }
     
    toWrite += "</table></html>";
    try {
      FileWriter myWriter = new FileWriter("outputSong.html");
      myWriter.write(toWrite);
      myWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  } 
  
  
  public static String callMethodString(String query) throws FileNotFoundException{
    String toSearch = getSongString(query);

    if(query.contains("Artist")) {
      LinkedList<Song> outList = musicMethodsObj.getArtist(toSearch);
      System.out.println("Searching for artist!");
      writeTable(outList);
      return outList.toString();
    }
    if(query.contains("Genre")) {
      LinkedList<Song> outList = musicMethodsObj.getArtist(toSearch);
      System.out.println("Searching for genre!");
      writeTable(outList);
      return musicMethodsObj.getGenre(toSearch).toString();
    }
    if(query.contains("Song")) {
      System.out.println("Searching for song!");
      Song output = musicMethodsObj.getSong(toSearch);
      String toWrite = "";
      toWrite = "<h1>" + output.getSongName() + "</h1>";
      toWrite += "<h2>Artist: " + output.getSongArtist() + "</h2>";
      toWrite += "<h2>Genre: " + output.getSongGenre() + "</h2>";
      toWrite += "<h2>Album: " + output.getSongAlbum() + "</h2>";
      try{
		FileWriter writeHTML = new FileWriter("outputSong.html");
		writeHTML.write(toWrite);
		writeHTML.close();
	}
	catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
    	}
      return output.toString();
    }
    // never going to happen
    return null;
  }
  
  public static String getQueryFile() throws FileNotFoundException {
    String query = "";
    File queryRead = new File("query.txt");
    @SuppressWarnings("resource")
    Scanner scnr = new Scanner(queryRead);
    query = scnr.nextLine();
    return query;
  }
  
  // something that is called by javaFX?
  public static void runner() throws FileNotFoundException {
    LoadSongs.readFile(musicMethodsObj);
    String query = getQueryFile();
    System.out.println(callMethodString(query));
    
  }
  
  public static void main(String args[]) throws FileNotFoundException {
    runner();
  }
}

