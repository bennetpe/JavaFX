package gui.stage;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class EmptyStage extends Application
{
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Empty Stage");
        primaryStage.setScene(new Scene(new Group(new Label("Hallo")), 200, 200));
//        primaryStage.setOpacity(0.8);
//        primaryStage.setWidth(200);
//        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
