package gui.tutorial.ws20192020;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class DrawingShapes extends Application
{
    private Pane graphicsPane;
    private RadioButton circle, line, rectangle;
    private Label status;
    private Stage secondaryStage;
    private Shape s;
    private double startX, startY; //only for rectangles

    public void start(Stage primaryStage)
    {
        BorderPane root = new BorderPane();
        graphicsPane = new Pane();
        graphicsPane.setOnMousePressed
        (
            e -> mousePressed(e.getX(), e.getY())
        );
        graphicsPane.setOnMouseDragged
        (
            e -> mouseDragged(e.getX(), e.getY())
        );
        graphicsPane.setOnMouseReleased
        (
            e -> mouseReleased()
        );
        root.setCenter(graphicsPane);

        HBox top = new HBox(5);
        line = new RadioButton("Linie");
        line.setSelected(true);
        circle = new RadioButton("Kreis");
        rectangle = new RadioButton("Rechteck");
        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(line, circle, rectangle);
        Button deleteButton = new Button("Löschen");
        deleteButton.setOnAction(e -> deleteAll());
        top.getChildren().addAll(line, circle, rectangle, deleteButton);
        root.setTop(top);

        TextArea loggingArea = new TextArea();
        loggingArea.setEditable(false);
        Scene scene = new Scene(loggingArea, 800, 750);
        secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.setTitle("Protokoll");

        HBox bottom = new HBox(5);
        status = new Label();
        Button logButton = new Button("Protokoll");
        logButton.setOnAction(e -> secondaryStage.show());
        bottom.getChildren().addAll(status, logButton);
        root.setBottom(bottom);
        updateStatus();

        clip();

        primaryStage.setTitle("Zeichnen von Formen");
        primaryStage.setScene(new Scene(root, 350, 120));
        primaryStage.show();
    }

    private void clip()
    {
        Rectangle clipRect = new Rectangle();
        clipRect.widthProperty().bind(graphicsPane.widthProperty());
        clipRect.heightProperty().bind(graphicsPane.heightProperty());
        graphicsPane.setClip(clipRect);

    }

    private void mousePressed(double x, double y)
    {
        if(line.isSelected())
        {
            s = new Line(x, y, x, y);
        }
        else if(circle.isSelected())
        {
            s = new Circle(x, y, 0);
        }
        else if(rectangle.isSelected())
        {
            s = new Rectangle(x, y, 0, 0);
            startX = x;
            startY = y;
        }
        s.setStroke(Color.GRAY);
        s.setStrokeWidth(0.5);
        s.setFill(null);
        graphicsPane.getChildren().add(s);
    }

    private void mouseDragged(double x, double y)
    {
        if(s instanceof Line)
        {
            Line l = (Line)s;
            l.setEndX(x);
            l.setEndY(y);
        }
        else if(s instanceof Circle)
        {
            Circle c = (Circle)s;
            double centerX = c.getCenterX();
            double centerY = c.getCenterY();
            double r = Math.sqrt((x-centerX)*(x-centerX) + (y-centerY)*(y-centerY));
            c.setRadius(r);
        }
        else if(s instanceof Rectangle)
        {
            Rectangle r = (Rectangle)s;
            double w = x-startX;
            if(w < 0)
            {
                r.setX(x);
                r.setWidth(-w);
            }
            else
            {
                r.setX(startX);
                r.setWidth(w);
            }
            double h = y - startY;
            if(h < 0)
            {
                r.setY(y);
                r.setHeight(-h);
            }
            else
            {
                r.setY(startY);
                r.setHeight(h);
            }
        }
    }

    private void mouseReleased()
    {
        s.setStrokeWidth(2);
        s.setStroke(Color.BLACK);
        updateStatus();
        appendLog();
        Shape sCopy = s;
        s.setOnMouseEntered(e->status.setText(""+sCopy));
        s.setOnMouseExited(e->updateStatus());
    }

    private void updateStatus()
    {
        int lines = 0, circles = 0, rectangles = 0;
        for(Node n: graphicsPane.getChildren())
        {
            if(n instanceof Line)
            {
                lines++;
            }
            else if(n instanceof Circle)
            {
                circles++;
            }
            else if(n instanceof Rectangle)
            {
                rectangles++;
            }
        }
        status.setText("Linien: " + lines + ", Kreise: " + circles + ", Rechtecke: " + rectangles +
                       ", insgesamt: " + (lines+circles+rectangles));
    }

    private void appendLog()
    {
        TextArea ta = (TextArea)secondaryStage.getScene().getRoot();
        ta.appendText(s + "\n");
    }

    private void deleteAll()
    {
        graphicsPane.getChildren().clear();
        updateStatus();
        TextArea ta = (TextArea)secondaryStage.getScene().getRoot();
        ta.setText("");
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
