package gui.graphics.bezier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * 
 * @author bennet
 *
 */
public class Bezier extends Application
{
    private Canvas canvas; // GraphicsContext kann keine Pane benutzen, daher Canvas in Pane stecken sowie doe Circle shapes

    private Circle startC = new Circle(100, 200, DURCHMESSER / 2, Color.RED);

    private Circle endC = new Circle(400, 200, DURCHMESSER / 2, Color.DARKBLUE);

    private Circle cntrPoint1 = new Circle(250, 350, DURCHMESSER / 2, Color.RED);

    private Circle cntrPoint2 = new Circle(250, 50, DURCHMESSER / 2, Color.DARKBLUE);

    private static final double DURCHMESSER = 10;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.canvas = new Canvas(500, 500);
        this.drawShape();
        Pane root = new Pane();

        root.getChildren().addAll(this.canvas, this.startC, this.endC, this.cntrPoint1, this.cntrPoint2);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        // with the Circle shape
        this.startC.setOnMouseDragged(e ->
        {
            this.startC.setCenterX(e.getX());
            this.startC.setCenterY(e.getY());
            Bezier.this.drawShape();
        });

        this.endC.setOnMouseDragged(e ->
        {
            this.endC.setCenterX(e.getX());
            this.endC.setCenterY(e.getY());
            Bezier.this.drawShape();
        });

        this.cntrPoint1.setOnMouseDragged(e ->
        {
            this.cntrPoint1.setCenterX(e.getX());
            this.cntrPoint1.setCenterY(e.getY());
            this.drawShape();
        });

        this.cntrPoint2.setOnMouseDragged(e ->
        {
            this.cntrPoint2.setCenterX(e.getX());
            this.cntrPoint2.setCenterY(e.getY());
            this.drawShape();
        });
    }

    /**
     * new light draw method
     * 
     * @param args
     *            none
     */
    public void drawShape()
    {
        // A graphics context represents a drawing destination 
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        // clear the drawning destination everytime you draw
        gc.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
        gc.setStroke(Color.DARKGREEN);
        // create the stroke and beginn Path
        gc.beginPath();
        gc.moveTo(this.startC.getCenterX(), this.startC.getCenterY());
        gc.bezierCurveTo(this.cntrPoint1.getCenterX(), this.cntrPoint1.getCenterY(), this.cntrPoint2.getCenterX(), this.cntrPoint2.getCenterY(), this.endC.getCenterX(), this.endC.getCenterY());
        gc.stroke(); // stokes the path
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
