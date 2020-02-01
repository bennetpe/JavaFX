package gui.curriculum;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Curriculum PO2016 Bachelor Informatik");
		primaryStage.setScene(new Scene( FXMLLoader.load(getClass().getResource("curriculumView.fxml"))));
		primaryStage.show();
		
	}
	
	public void initMVP() {
	
	}
	
	public static void main(String[]args) {
		launch(args);
		
	}

}
