package gui.shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class SomeShapes extends Application
{
    public void start(Stage primaryStage)
    {
        Pane root = new Pane();
        drawShapes(root);

        primaryStage.setTitle("Einige Formen");
        primaryStage.setScene(new Scene(root, 400, 350));
        primaryStage.show();
    }

    private void drawShapes(Pane root)
    {
        Line line = new Line(40, 10, 10, 40);
        line.setStroke(Color.RED);
        line.setStrokeWidth(5);
        root.getChildren().add(line);

        Ellipse e1 = new Ellipse(30, 80, 20, 20);
        e1.setFill(Color.GREEN);
        root.getChildren().add(e1);
        Ellipse e2 = new Ellipse(80, 80, 20, 20);
        e2.setStroke(Color.RED);
        e2.setFill(null);
        e2.setStrokeWidth(5);
        root.getChildren().add(e2);

        Rectangle r1 = new Rectangle(110, 60, 40, 40);
        r1.setArcWidth(10);
        r1.setArcHeight(10);
        r1.setFill(Color.GREEN);
        root.getChildren().add(r1);
        Rectangle r2 = new Rectangle(160, 60, 40, 40);
        r2.setArcWidth(10);
        r2.setArcHeight(10);
        r2.setStroke(Color.RED);
        r2.setFill(null);
        r2.setStrokeWidth(5);
        root.getChildren().add(r2);

        Rectangle r3 = new Rectangle(210, 60, 40, 40);
        r3.setArcWidth(10);
        r3.setArcHeight(10);
        r3.setStroke(Color.RED);
        r3.setFill(null);
        r3.setStrokeWidth(10);
        r3.setStrokeType(StrokeType.CENTERED);
        root.getChildren().add(r3);
        Rectangle r4 = new Rectangle(210, 60, 40, 40);
        r4.setArcWidth(10);
        r4.setArcHeight(10);
        r4.setFill(Color.GREEN);
        root.getChildren().add(r4);

        Rectangle r5 = new Rectangle(260, 60, 40, 40);
        r5.setArcWidth(10);
        r5.setArcHeight(10);
        r5.setStroke(Color.RED);
        r5.setFill(null);
        r5.setStrokeWidth(10);
        r5.setStrokeType(StrokeType.INSIDE);
        root.getChildren().add(r5);
        Rectangle r6 = new Rectangle(260, 60, 40, 40);
        r6.setArcWidth(10);
        r6.setArcHeight(10);
        r6.setFill(Color.GREEN);
        root.getChildren().add(r6);

        Rectangle r7 = new Rectangle(315, 60, 40, 40);
        r7.setArcWidth(10);
        r7.setArcHeight(10);
        r7.setStroke(Color.RED);
        r7.setFill(null);
        r7.setStrokeWidth(10);
        r7.setStrokeType(StrokeType.OUTSIDE);
        root.getChildren().add(r7);
        Rectangle r8 = new Rectangle(315, 60, 40, 40);
        r8.setArcWidth(10);
        r8.setArcHeight(10);
        r8.setFill(Color.GREEN);
        root.getChildren().add(r8);

        Rectangle r9 = new Rectangle(210, 125, 40, 40);
        r9.setArcWidth(10);
        r9.setArcHeight(10);
        r9.setFill(Color.GREEN);
        root.getChildren().add(r9);
        Rectangle r10 = new Rectangle(210, 125, 40, 40);
        r10.setArcWidth(10);
        r10.setArcHeight(10);
        r10.setStroke(Color.RED);
        r10.setFill(null);
        r10.setStrokeWidth(10);
        r10.setStrokeType(StrokeType.CENTERED);
        root.getChildren().add(r10);

        Rectangle r11 = new Rectangle(260, 125, 40, 40);
        r11.setArcWidth(10);
        r11.setArcHeight(10);
        r11.setFill(Color.GREEN);
        root.getChildren().add(r11);
        Rectangle r12 = new Rectangle(260, 125, 40, 40);
        r12.setArcWidth(10);
        r12.setArcHeight(10);
        r12.setStroke(Color.RED);
        r12.setFill(null);
        r12.setStrokeWidth(10);
        r12.setStrokeType(StrokeType.INSIDE);
        root.getChildren().add(r12);

        Rectangle r13 = new Rectangle(315, 125, 40, 40);
        r13.setArcWidth(10);
        r13.setArcHeight(10);
        r13.setFill(Color.GREEN);
        root.getChildren().add(r13);
        Rectangle r14 = new Rectangle(315, 125, 40, 40);
        r14.setArcWidth(10);
        r14.setArcHeight(10);
        r14.setStroke(Color.RED);
        r14.setFill(null);
        r14.setStrokeWidth(10);
        r14.setStrokeType(StrokeType.OUTSIDE);
        root.getChildren().add(r14);
        
        Arc a1 = new Arc(30, 175, 20, 20, 45, 240);
        a1.setType(ArcType.OPEN);
        a1.setFill(Color.GREEN);
        root.getChildren().add(a1);
        Arc a2 = new Arc(80, 175, 20, 20, 45, 240);
        a2.setType(ArcType.CHORD);
        a2.setFill(Color.GREEN);
        root.getChildren().add(a2);
        Arc a3 = new Arc(130, 175, 20, 20, 45, 240);
        a3.setType(ArcType.ROUND);
        a3.setFill(Color.GREEN);
        root.getChildren().add(a3);
        Arc a4 = new Arc(30, 225, 20, 20, 45, 240);
        a4.setType(ArcType.OPEN);
        a4.setStroke(Color.RED);
        a4.setStrokeWidth(5);
        a4.setFill(null);
        root.getChildren().add(a4);
        Arc a5 = new Arc(80, 225, 20, 20, 45, 240);
        a5.setType(ArcType.CHORD);
        a5.setStroke(Color.RED);
        a5.setStrokeWidth(5);
        a5.setFill(null);
        root.getChildren().add(a5);
        Arc a6 = new Arc(130, 225, 20, 20, 45, 240);
        a6.setType(ArcType.ROUND);
        a6.setStroke(Color.RED);
        a6.setStrokeWidth(5);
        a6.setFill(null);
        root.getChildren().add(a6);
        
        Polygon poly1 = new Polygon(10, 265, 40, 265,
                                    10, 310, 40, 310);
        poly1.setFill(Color.GREEN);
        root.getChildren().add(poly1);
        Polygon poly2 = new Polygon(60, 265, 90, 265,
                                    60, 310, 90, 310);
        poly2.setStroke(Color.RED);
        poly2.setStrokeWidth(5);
        poly2.setFill(null);
        root.getChildren().add(poly2);
        Polyline poly3 = new Polyline(110, 265, 140, 265,
                                      110, 310, 140, 310);
        poly3.setStroke(Color.BLACK);
        poly3.setStrokeWidth(5);
        root.getChildren().add(poly3);
        Polygon polygonS = new Polygon();
        polygonS.getPoints().addAll(new Double[]{
            0.0, 0.0,
            20.0, 5.0,
            5.0, 20.0 });
        root.getChildren().add(polygonS);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
