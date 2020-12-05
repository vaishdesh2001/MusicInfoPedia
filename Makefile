run: WebWindow.class
	java --module-path JavaFXForLinux/ --add-modules javafx.web,javafx.controls WebWindow

WebWindow.class: WebWindow.java
	javac --module-path JavaFXForLinux/ --add-modules javafx.web,javafx.controls WebWindow.java

clean:
	rm *.class
