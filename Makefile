run: compile index.html
	java --module-path JavaFXForLinux/ --add-modules javafx.web,javafx.controls WebWindow
	
compile: WebWindow.java BackEndRunner.java HashTableMap.java LinkedPair.java LoadSongs.java MapADT.java MusicManager.java Song.java SongInfo.csv style.txt
	javac LinkedPair.java
	javac MapADT.java
	javac HashTableMap.java
	javac Song.java
	javac LoadSongs.java
	javac MusicManager.java
	javac BackEndRunner.java
	javac --module-path JavaFXForLinux/ --add-modules javafx.web,javafx.controls WebWindow.java
	
test: compile MusicTester.java junit5.jar
	javac -cp .:junit5.jar MusicTester.java
	java -jar junit5.jar -cp . --scan-classpath -n MusicTester
	
clean:
	rm *.class
