package gui.intro;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class Main09 extends Application
{
    private int counter;
    
    public void start(Stage primaryStage)
    {
        Button b = new Button("Hallo Welt");
        GridPane root = new GridPane();
        Label l = new Label();
        root.add(b, 0, 0);
        root.add(l, 0, 1);
        b.setOnAction(e -> {counter++; l.setText("Hallo Welt zum " + counter + ".");});
        
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
