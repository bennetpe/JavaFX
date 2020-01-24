package gui.container;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

public class FlowPaneExample extends Application
{
    public void start(Stage primaryStage)
    {
        FlowPane root = new FlowPane(10, 5);
        Insets ins = new Insets(10);
        root.setPadding(ins);
        root.setAlignment(Pos.BOTTOM_RIGHT);
        root.setOrientation(Orientation.VERTICAL);
        for(int i = 1; i <= 5; i++)
        {
            Button b = new Button("Button " + i);
            root.getChildren().add(b);
        }
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FlowPane-Beispiel");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
