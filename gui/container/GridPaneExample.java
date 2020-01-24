package gui.container;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class GridPaneExample extends Application
{
    public void start(Stage primaryStage)
    {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        Insets ins = new Insets(10);
        root.setPadding(ins);
        for(int i = 1; i <= 5; i++)
        {
            for(int j = 1; j <= 5; j++)
            {
                if(i < 3 || j < 3)
                {
                    Button b = new Button("Button " + i + "/" + j);
                    root.add(b, i-1, j-1);
                }
            }
        }
        Button b;
        b = new Button("Button 6/*");
        b.setMaxHeight(Double.MAX_VALUE);
        root.add(b, 5, 0, 1, 4);
        b = new Button("Button */6");
        b.setMaxWidth(Double.MAX_VALUE);
        root.add(b, 0, 5, 3, 1);
        b = new Button("Button 3/3");
        b.setMaxHeight(Double.MAX_VALUE);
        b.setMaxWidth(Double.MAX_VALUE);
        root.add(b, 2, 2, 3, 3);
        
        root.setGridLinesVisible(true);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GridPane-Beispiel");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
