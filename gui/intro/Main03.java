package gui.intro;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Main03 extends Application
{
    public void start(Stage primaryStage)
    {
        Label l1 = new Label("Hallo Welt");
        Label l2 = new Label("Nochmals hallo");
        StackPane root = new StackPane();
        root.getChildren().add(l1);
        root.getChildren().add(l2);
        
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
