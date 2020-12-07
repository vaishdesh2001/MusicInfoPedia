// --== CS400 File Header Information ==--
// Name: Vaishnavi Deshpande
// Email: vvdeshpande@wisc.edu
// Team: LB
// TA: Divyanshu Saxena
// Lecturer: Prof. Gary Dahl
// Notes to Grader: <optional extra notes>

import java.io.FileWriter; 
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.IOException;

public class WebWindow extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        WebView webView = new WebView();
        Button view = new Button("View!");
        WebEngine webEngine = webView.getEngine();
        webEngine.load( getClass().getResource("/index.html").toString());
        view.setOnAction( event -> {
        	Document document = webEngine.getDocument();
        	Element link = document.getElementById("output");
        	System.out.println(link);
        	System.out.println(link.getTextContent());
        	try{
			FileWriter query = new FileWriter("query.txt");
			query.write(link.getTextContent());
			query.close();
        	}
        	catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	    	}
	    	try{
	    		BackEndRunner.runner();
	    	} catch(FileNotFoundException fnfe){
	    		System.out.println("Looks like query.txt was not created properly");
	    	}
	    webEngine.load( getClass().getResource("/outputSong.html").toString());
	    	
        });
        
        view.setLayoutX(375);
        view.setLayoutY(575);
        Button quit = new Button("Exit");
	quit.setOnAction(event -> { Platform.exit(); });
	quit.setLayoutY(575);
	Button home = new Button("Home Page");
	home.setOnAction(event -> 
	{webEngine.load( getClass().getResource("/index.html").toString());});
	home.setLayoutX(700);
	home.setLayoutY(575);
        Group group = new Group(webView, view, quit, home);
        Scene scene = new Scene(group,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Music Infopedia!");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
