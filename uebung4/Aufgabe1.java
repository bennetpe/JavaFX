package uebung4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aufgabe1 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        try
        { // lege VBox mit 10 px spacing
            VBox root = new VBox(10);
            Scene scene = new Scene(root, 400, 400);
            primaryStage.setTitle("Vbox");
            primaryStage.setScene(scene);
            primaryStage.show();

            // lege Buttons an

            Button b1 = new Button("Button 1");
            Button b2 = new Button("Button 2");
            Button b3 = new Button("Button 3");
            Button b4 = new Button("Button 4");
            // füge root pane child obj zu
            root.getChildren().addAll(b1, b2, b3, b4);
            // Hinzufügen von Padding
            Insets ins = new Insets(10);
            root.setPadding(ins);
            // Pane nach rechts ausrichten
            root.setAlignment(Pos.CENTER_RIGHT);
            // Transformationsstrategie einzelnd [nicht statisch]
            // Button b1 Höhe und Breite transformierbar
            VBox.setVgrow(b1, Priority.ALWAYS);
            b1.setMaxHeight(Double.MAX_VALUE);
            b1.setMaxWidth(Double.MAX_VALUE);
            // Button b3 Breite
            VBox.setVgrow(b3, Priority.ALWAYS);
            b3.setMaxWidth(Double.MAX_VALUE);
            // Button b4 Höhe
            VBox.setVgrow(b4, Priority.ALWAYS);
            b4.setMaxHeight(Double.MAX_VALUE);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
