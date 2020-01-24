package gui.shapes;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Nikolaus extends Application
{
    public void start(Stage primaryStage)
    {
        Pane root = new Pane();
        drawLines(root);
        primaryStage.setTitle("Haus vom Nikolaus");
        primaryStage.setScene(new Scene(root, 330, 300));
        primaryStage.show();
    }

    private void drawLines(Pane root)
    {
        root.getChildren().add(new Line(30, 200, 200, 200));
        root.getChildren().add(new Line(200, 200, 200, 100));
        root.getChildren().add(new Line(200, 100, 150, 50));
        root.getChildren().add(new Line(150, 50, 100, 100));
        root.getChildren().add(new Line(100, 100, 100, 200));
        root.getChildren().add(new Line(100, 200, 200, 100));
        root.getChildren().add(new Line(200, 100, 100, 100));
        root.getChildren().add(new Line(100, 100, 200, 200));
        root.getChildren().add(new Line(200, 200, 270, 200));
        for(Node node: root.getChildren())
        {
            Line line = (Line) node;
            line.setStrokeWidth(5);
            line.setStroke(Color.RED);
            line.setStrokeLineCap(StrokeLineCap.ROUND);
            line.setSmooth(true);
            line.setOnMouseMoved
            (
                (MouseEvent e) -> log(e)
            );
        }
    }
    
    private void log(MouseEvent e)
    {
        Line l = (Line) e.getSource();
        System.out.println("moved [" + e.getX() +
                           ", " + e.getY() +
                           "] for line(" +
                           l.getStartX() + "," +
                           l.getStartY() + "," +
                           l.getEndX() + "," +
                           l.getEndY());
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
