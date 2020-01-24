package gui.container;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class PaneExample extends Application
{
    public void start(Stage primaryStage)
    {
        Pane root = new Pane();
        for(int i = 1; i <= 10; i++)
        {
            Button b = new Button("Button " + i);
            b.setLayoutX((i-1) * 20);
            b.setLayoutY((i-1) * 20);
            root.getChildren().add(b);
        }
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pane-Beispiel");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
