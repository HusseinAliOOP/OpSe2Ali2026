package main;

import gui.VolkshochschuleAnwendungssystem;
import gui.VolkshochschulkursControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new VolkshochschulkursControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
