package gui.shapes;

import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class ShapesLayout extends Application
{
    public void start(Stage primaryStage)
    {
        Rectangle r1 = new Rectangle(500, 500, 100, 200);
        r1.setFill(Color.BLUE);
        Rectangle r2 = new Rectangle(1000, 10000, 200, 400);
        r2.setFill(Color.RED);
        Line l = new Line(1000, 1000, 1100, 1100);
//        VBox root = new VBox(r1, r2, l);
        HBox root = new HBox(r1, r2, l);
//        BorderPane root = new BorderPane();
//        root.setTop(r1);
//        root.setRight(r2);
//        GridPane root = new GridPane();
//        root.add(r1, 0, 0);
//        root.add(r2, 1, 0);
//        root.add(l, 2, 0);
//        TilePane root = new TilePane(r1, r2, l);
        primaryStage.setTitle("ShapesLayout");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
