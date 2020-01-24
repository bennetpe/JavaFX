package gui.container;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class HBoxExample extends Application
{
    public void start(Stage primaryStage)
    {
        HBox root = new HBox(10);
        Insets ins = new Insets(10);
        root.setPadding(ins);
        root.setAlignment(Pos.TOP_RIGHT);
        root.setFillHeight(true);
        for(int i = 1; i <= 5; i++)
        {
            Button b = new Button("Button " + i);
            b.setLayoutX(i * 20);
            b.setLayoutY(i * 20);
            if(i % 2 == 0)
            {
                b.setMaxWidth(Double.MAX_VALUE);
                HBox.setHgrow(b, Priority.ALWAYS);
            }
            else
            {
                b.setMaxHeight(Double.MAX_VALUE);
            }
            root.getChildren().add(b);
        }
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HBox-Beispiel");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
