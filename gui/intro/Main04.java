package gui.intro;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Main04 extends Application
{
    public void start(Stage primaryStage)
    {
        Label l1 = new Label("Hallo Welt");
        Label l2 = new Label("Nochmals hallo");
        GridPane root = new GridPane();
        root.add(l1, 0, 0);
        root.add(l2, 0, 1);
        
        Scene scene = new Scene(root, 310, 70);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
