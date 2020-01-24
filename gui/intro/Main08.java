package gui.intro;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;

public class Main08 extends Application
{
    public void start(Stage primaryStage)
    {
        try
        {
            GridPane root = FXMLLoader.load(getClass().getResource("Main08.fxml"));
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main08.fxml"));
//            GridPane root = (GridPane)loader.load();
            
            Scene scene = new Scene(root, 310, 70);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hello World");
            primaryStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
