package gui.shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MouseListeners extends Application
{
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();
        pane.setOnMousePressed
        (
            e -> log("mouse pressed", e)
        );
        pane.setOnMouseReleased
        (
            e -> log("mouse released", e)
        );
        pane.setOnMouseClicked
        (
            e -> log("mouse clicked", e)
        );
        pane.setOnMouseMoved
        (
            e -> log("mouse moved", e)
        );
        pane.setOnMouseDragged
        (
        e -> log("mouse dragged", e)
        );
        pane.setOnMouseEntered
        (
            e -> log("mouse entered", e)
        );
        pane.setOnMouseExited
        (
            e -> log("mouse exited", e)
        );

        primaryStage.setTitle("Logging von Mausereignissen");
        primaryStage.setScene(new Scene(pane, 800, 600));
        primaryStage.show();
    }
    
    private void log(String action, MouseEvent e)
    {
        System.out.println(action + " at [" + 
                           e.getX() + ", " + 
                           e.getY() + "]");
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
