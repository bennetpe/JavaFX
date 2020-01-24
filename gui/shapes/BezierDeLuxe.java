package gui.shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class BezierDeLuxe extends Application
{
    public void start(Stage primaryStage)
    {
        Pane root = new Pane();
        drawBezier(root);

        primaryStage.setTitle("Bezier-Kurve");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    private void drawBezier(Pane root)
    {
        root.getChildren().add(new Circle(50, 50, 5, Color.RED));
        root.getChildren().add(new Circle(100, 200, 5, Color.RED));
        root.getChildren().add(new Circle(250, 200, 5, Color.RED));
        root.getChildren().add(new Circle(300, 50, 5, Color.RED));

        CubicCurve bezier = new CubicCurve(50, 50, 100, 200,
                                           250, 200, 300, 50);
        drawNormal(bezier, Color.BLACK, 5);
        drawRadialGradient(bezier, Color.BLUE, Color.YELLOW);
        drawLinearGradient(bezier, Color.RED, Color.GREEN, 20);
        //drawDropShadow(bezier, Color.RED);
        root.getChildren().add(bezier);
    }
    
    private void drawNormal(Shape shape, Color color, double width) 
    {
        shape.setStroke(color);
        shape.setFill(null);
        shape.setStrokeWidth(width);
    }
    
    private void drawRadialGradient(Shape shape,
                                    Color firstColor, 
                                    Color lastColor) 
    {
        shape.setFill(new RadialGradient(0, 0, 0.5, 0.5, 0.1, true,
                                         CycleMethod.REFLECT,
                                         new Stop(0.0, firstColor),
                                         new Stop(1.0, lastColor)));
    }
    
    private void drawLinearGradient(Shape shape,
                                    Color firstColor, 
                                    Color secondColor,
                                    double width) 
    {
        LinearGradient lg = new LinearGradient(0, 0, 1, 1, true,
                                               CycleMethod.REFLECT,
                                               new Stop(0.0, firstColor),
                                               new Stop(1.0, secondColor));
        shape.setStroke(lg);
        shape.setStrokeWidth(width);
    }
    
    /*
    private void drawDropShadow(Shape shape,
                                Color color)
    {
        shape.setEffect(new javafx.scene.effect.DropShadow(20, 20, 0, color));
    }
    */

    public static void main(String[] args)
    {
        launch(args);
    }
}
