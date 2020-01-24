package gui.drawingPolygon;
/**
 * 
 * @author bennet
 *
 */

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DrawingPolygon extends Application
{
    private Canvas canvas;

    private static final double RADIUS = 10;

    private Point2D pointA = new Point2D(300, 100);

    private Point2D pointB = new Point2D(300, 300);

    private Point2D pointC = new Point2D(100, 300);

    private Point2D pointD = new Point2D(100, 150);

    private Circle circlePointA = new Circle(this.pointA.getX(), this.pointA.getY(), RADIUS, Color.RED);

    private Circle circlePointB = new Circle(this.pointB.getX(), this.pointB.getY(), RADIUS, Color.GREEN);

    private Circle circlePointC = new Circle(this.pointC.getX(), this.pointC.getY(), RADIUS, Color.YELLOW);

    private Circle circlePointD = new Circle(this.pointD.getX(), this.pointD.getY(), RADIUS, Color.BLUE);

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.canvas = new Canvas(500, 500);
        this.drawShape();
        this.ScanLineAlgorithmus();
        Pane root = new Pane();
        root.getChildren().addAll(this.canvas, this.circlePointA, this.circlePointB, this.circlePointC, this.circlePointD);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FillAlgorithmPolygon");
        primaryStage.show();

        this.circlePointA.setOnMouseDragged(e ->
        {
            this.circlePointA.setCenterX(e.getX());
            this.circlePointA.setCenterY(e.getY());
            this.drawShape();
            this.ScanLineAlgorithmus();
        });

        this.circlePointB.setOnMouseDragged(e ->
        {
            this.circlePointB.setCenterX(e.getX());
            this.circlePointB.setCenterY(e.getY());
            this.drawShape();
            this.ScanLineAlgorithmus();
        });

        this.circlePointC.setOnMouseDragged(e ->
        {
            this.circlePointC.setCenterX(e.getX());
            this.circlePointC.setCenterY(e.getY());
            this.drawShape();
            this.ScanLineAlgorithmus();
        });

        this.circlePointD.setOnMouseDragged(e ->
        {
            this.circlePointD.setCenterX(e.getX());
            this.circlePointD.setCenterY(e.getY());
            this.drawShape();
            this.ScanLineAlgorithmus();
        });

    }

    private void drawShape()
    {
        // set drawing destinatrion with a graphicsContext
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        // clear the drawing destination everytime you draw something
        gc.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
        gc.setStroke(Color.BLACK);
        gc.beginPath();
        gc.moveTo(this.circlePointA.getCenterX(), this.circlePointA.getCenterY());
        gc.lineTo(this.circlePointB.getCenterX(), this.circlePointB.getCenterY());
        gc.lineTo(this.circlePointC.getCenterX(), this.circlePointC.getCenterY());
        gc.lineTo(this.circlePointD.getCenterX(), this.circlePointD.getCenterY());
        gc.lineTo(this.circlePointA.getCenterX(), this.circlePointA.getCenterY());

        gc.stroke(); // strokes the Path
    }

    // TODO Scanline Algorithmus to fill elements in the Polygon
    public void ScanLineAlgorithmus()
    {
        boolean isInside = false;
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        for (int i = 0; i <= 500; i += 10)
        {
            gc.beginPath();
            gc.moveTo(0, i);
            gc.lineTo(500, i);
            gc.stroke();
            // check if inside 1 Fill...0 Fill not
            if (i > 10)
            {
                isInside = true;
            }
            if (isInside)
            {

            }
        }

    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
