package gui.container;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;

public class TilePaneExample extends Application
{
    public void start(Stage primaryStage)
    {
        TilePane root = new TilePane(10, 5);
        Insets ins = new Insets(10);
        root.setPadding(ins);
        root.setOrientation(Orientation.VERTICAL);
        //root.setPrefTileHeight(60);
        //root.setPrefTileWidth(100);
        root.setTileAlignment(Pos.BOTTOM_RIGHT);
        for(int i = 1; i <= 10; i++)
        {
            Button b = new Button("Button " + i);
            root.getChildren().add(b);
        }
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TilePane-Beispiel");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
