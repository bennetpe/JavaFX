package gui.intro;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class Main01 extends Application
{
    public void start(Stage primaryStage)
    {
        Label l = new Label("Hallo Welt");        
        Scene scene = new Scene(l, 310, 70);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        //primaryStage.setX(1000);
        //primaryStage.setY(20);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
