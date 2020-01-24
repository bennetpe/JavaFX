package gui.shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class DrawingPaths extends Application
{
    private Pane root;
    private Path currentPath;
    
    public void start(Stage primaryStage)
    {
        root = new Pane();
        root.setOnMousePressed
        (
            e -> mousePressed(e.getX(), e.getY())
        );
        root.setOnMouseDragged
        (
            e -> mouseDragged(e.getX(), e.getY())
        );
        root.setOnMouseReleased
        (
            e -> mouseReleased()
        );

        primaryStage.setTitle("Freihandzeichnen");
        primaryStage.setScene(new Scene(root, 330, 300));
        primaryStage.show();
    }

    private void mousePressed(double x, double y)
    {
        currentPath = new Path();
        currentPath.setStroke(Color.BLACK);
        currentPath.setStrokeWidth(2);
        currentPath.getElements().add(new MoveTo(x, y));
        root.getChildren().add(currentPath);
    }

    private void mouseDragged(double x, double y)
    {
        currentPath.getElements().add(new LineTo(x, y));
    }

    private void mouseReleased()
    {
        currentPath = null;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
