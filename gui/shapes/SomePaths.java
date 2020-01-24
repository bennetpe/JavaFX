package gui.shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class SomePaths extends Application
{
    public void start(Stage primaryStage)
    {
        Pane root = new Pane();
        drawPaths(root);

        primaryStage.setTitle("Einige Pfade");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    private void drawPaths(Pane root)
    {
        Path p;

        p = new Path();
        p.getElements().add(new MoveTo(50, 50));
        p.getElements().add(new LineTo(100, 50));
        p.getElements().add(new LineTo(100, 100));
        p.setStroke(Color.RED);
        p.setStrokeWidth(3);
        root.getChildren().add(p);
        
        p = new Path();
        p.getElements().add(new MoveTo(100, 100));
        p.getElements().add(new LineTo(150, 100));
        p.getElements().add(new LineTo(150, 150));
        p.getElements().add(new ClosePath());
        p.setStroke(Color.GREEN);
        p.setStrokeWidth(7);
        root.getChildren().add(p);
        
        p = new Path();
        p.getElements().add(new MoveTo(200, 40));
        p.getElements().add(new LineTo(300, 40));
        p.getElements().add(new MoveTo(200, 60));
        p.getElements().add(new LineTo(300, 60));
        p.getElements().add(new MoveTo(200, 80));
        p.getElements().add(new LineTo(300, 80));
        p.getElements().add(new MoveTo(200, 100));
        p.getElements().add(new LineTo(300, 100));
        p.getElements().add(new MoveTo(200, 120));
        p.getElements().add(new LineTo(300, 120));
        p.getElements().add(new MoveTo(200, 140));
        p.getElements().add(new LineTo(300, 140));
        p.setStroke(Color.CHOCOLATE);
        p.setStrokeWidth(3);
        root.getChildren().add(p);

        p = new Path();
        p.getElements().add(new MoveTo(550, 200));
        p.getElements().add(new ArcTo(100, 180, 0, 350, 200, true, false));
        p.getElements().add(new LineTo(350, 350));
        p.setFill(Color.BLUE);
        root.getChildren().add(p);

        p = new Path();
        p.getElements().add(new MoveTo(250, 350));
        p.getElements().add(new ArcTo(100, 180, 0, 50, 350, true, false));
        p.getElements().add(new LineTo(50, 450));
        p.setStroke(Color.BLUE);
        p.setStrokeWidth(8);
        root.getChildren().add(p);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
