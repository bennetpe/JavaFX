package gui.graphics;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Bezier extends Application
{
    private static final int DIAMETER = 10;

    private static final int RADIUS = DIAMETER / 2;

    private Canvas canvas;

    private double[] punktA =
    { 100, 100 };

    private double[] punktB =
    { 200, 70 };

    private double[] punktC =
    { 200, 200 };

    private double[] punktD =
    { 125, 200 };

    private double[] start =
    { 0, 0 };

    @Override
    public void start(Stage primaryStage)
    {

        this.canvas = new Canvas(600, 600);
        this.drawShapes();

        this.canvas.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent m)
            {
                Bezier.this.start[0] = m.getX();
                Bezier.this.start[1] = m.getY();
            }
        });

        this.canvas.setOnMouseDragged(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent m)
            {
                if (Bezier.this.start[0] - 5 <= Bezier.this.punktA[0] && Bezier.this.start[0] + 5 >= Bezier.this.punktA[0] && Bezier.this.start[1] - 5 <= Bezier.this.punktA[1] && Bezier.this.start[1] + 5 >= Bezier.this.punktA[1])
                {
                    Bezier.this.punktA[0] = m.getX();
                    Bezier.this.punktA[1] = m.getY();

                    Bezier.this.start[0] = Bezier.this.punktA[0];
                    Bezier.this.start[1] = Bezier.this.punktA[1];
                }
                else if (Bezier.this.start[0] - 5 <= Bezier.this.punktB[0] && Bezier.this.start[0] + 5 >= Bezier.this.punktB[0] && Bezier.this.start[1] - 5 <= Bezier.this.punktB[1] && Bezier.this.start[1] + 5 >= Bezier.this.punktB[1])
                {
                    Bezier.this.punktB[0] = m.getX();
                    Bezier.this.punktB[1] = m.getY();

                    Bezier.this.start[0] = Bezier.this.punktB[0];
                    Bezier.this.start[1] = Bezier.this.punktB[1];
                }
                else if (Bezier.this.start[0] - 5 <= Bezier.this.punktC[0] && Bezier.this.start[0] + 5 >= Bezier.this.punktC[0] && Bezier.this.start[1] - 5 <= Bezier.this.punktC[1] && Bezier.this.start[1] + 5 >= Bezier.this.punktC[1])
                {
                    Bezier.this.punktC[0] = m.getX();
                    Bezier.this.punktC[1] = m.getY();

                    Bezier.this.start[0] = Bezier.this.punktC[0];
                    Bezier.this.start[1] = Bezier.this.punktC[1];
                }
                else if (Bezier.this.start[0] - 5 <= Bezier.this.punktD[0] && Bezier.this.start[0] + 5 >= Bezier.this.punktD[0] && Bezier.this.start[1] - 5 <= Bezier.this.punktD[1] && Bezier.this.start[1] + 5 >= Bezier.this.punktD[1])
                {
                    Bezier.this.punktD[0] = m.getX();
                    Bezier.this.punktD[1] = m.getY();

                    Bezier.this.start[0] = Bezier.this.punktD[0];
                    Bezier.this.start[1] = Bezier.this.punktD[1];
                }
                Bezier.this.drawShapes();
            }
        });

        BorderPane root = new BorderPane();
        root.getChildren().addAll(this.canvas);
        primaryStage.setTitle("Bezier-Kurve");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    private void drawShapes()
    {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());

        gc.setFill(Color.RED);
        gc.fillOval(this.punktA[0] - RADIUS, this.punktA[1] - RADIUS, DIAMETER, DIAMETER);
        gc.fillOval(this.punktB[0] - RADIUS, this.punktB[1] - RADIUS, DIAMETER, DIAMETER);
        gc.setFill(Color.GREEN);
        gc.fillOval(this.punktC[0] - RADIUS, this.punktC[1] - RADIUS, DIAMETER, DIAMETER);
        gc.fillOval(this.punktD[0] - RADIUS, this.punktD[1] - RADIUS, DIAMETER, DIAMETER);

        gc.setStroke(Color.BLACK);
        gc.beginPath();
        gc.moveTo(this.punktA[0], this.punktA[1]);
        gc.bezierCurveTo(this.punktB[0], this.punktB[1], this.punktC[0], this.punktC[1], this.punktD[0], this.punktD[1]);
        // gc.closePath();
        gc.stroke();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
