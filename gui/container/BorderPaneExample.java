package gui.container;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

public class BorderPaneExample extends Application
{
    public void start(Stage primaryStage)
    {
        BorderPane root = new BorderPane();
        Insets ins = new Insets(10);
        root.setPadding(ins);
        Button b;
        b = new Button("Top");
        BorderPane.setAlignment(b, Pos.CENTER);
        b.setMaxWidth(Double.MAX_VALUE);
        root.setTop(b);
        b = new Button("Bottom");
        BorderPane.setAlignment(b, Pos.CENTER);
        root.setBottom(b);
        b = new Button("Left");
        BorderPane.setAlignment(b, Pos.CENTER);
        b.setMaxHeight(Double.MAX_VALUE);
        root.setLeft(b);
        b = new Button("Right");
        BorderPane.setAlignment(b, Pos.CENTER);
        root.setRight(b);
        b = new Button("Center");
        BorderPane.setAlignment(b, Pos.CENTER);
        root.setCenter(b);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BorderPane-Beispiel");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
