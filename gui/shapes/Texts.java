package gui.shapes;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Line;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Texts extends Application
{
    public void start(Stage primaryStage)
    {
        Pane root = new Pane();
        primaryStage.setTitle("Texte");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        drawTexts(root);
    }

    private void drawTexts(Pane root)
    {
        Text t;
        Line l;
        double x, y;
        
        x = 10; y = 50;
        t= new Text(x, y, "Text bei (" + x + ", " + y + "), " +
                    VPos.BASELINE);
        t.setFont(Font.font(null, FontWeight.BOLD, 40));
        //t.setFill(Color.BLACK);
        //t.setTextOrigin(VPos.BASELINE);
        root.getChildren().add(t);
        l = new Line(0, y, root.getWidth(), y);
        root.getChildren().add(l);

        x = 10; y = 100;
        t= new Text(x, y, "Text bei (" + x + ", " + y + "), " +
                    VPos.TOP);
        t.setFont(Font.font(null, FontWeight.BOLD, 40));
        t.setFill(Color.RED);
        t.setTextOrigin(VPos.TOP);
        root.getChildren().add(t);
        l = new Line(0, y, root.getWidth(), y);
        root.getChildren().add(l);

        x = 10; y = 200;
        t= new Text(x, y, "Text bei (" + x + ", " + y + "), " +
                    VPos.BOTTOM);
        t.setFont(Font.font(null, FontWeight.BOLD, 40));
        t.setFill(Color.GREEN);
        t.setTextOrigin(VPos.BOTTOM);
        root.getChildren().add(t);
        l = new Line(0, y, root.getWidth(), y);
        root.getChildren().add(l);

        x = 10; y = 250;
        t= new Text(x, y, "Text bei (" + x + ", " + y + "), " +
                    VPos.CENTER);
        t.setFont(Font.font(null, FontWeight.BOLD, 40));
        t.setFill(Color.BLUE);
        t.setTextOrigin(VPos.CENTER);
        root.getChildren().add(t);
        l = new Line(0, y, root.getWidth(), y);
        root.getChildren().add(l);

        x = 10; y = 350;
        t= new Text(x, y, "Nicht ausgefüllter Text");
        t.setFont(Font.font(null, FontWeight.BOLD, 40));
        t.setStroke(Color.BLACK);
        t.setFill(null);
        root.getChildren().add(t);

        x = 10; y = 400;
        t= new Text(x, y, "Rot ausgefüllter Text");
        t.setFont(Font.font(null, FontWeight.BOLD, 40));
        t.setStroke(Color.BLACK);
        t.setFill(Color.RED);
        t.setStrokeWidth(2);
        root.getChildren().add(t);

        x = 10; y = 450;
        t= new Text(x, y, "Gestrichelter Text");
        t.setFont(Font.font(null, FontWeight.BOLD, 40));
        t.setStroke(Color.BLACK);
        t.setFill(null);
        t.setStrokeWidth(2);
        t.getStrokeDashArray().addAll(new Double(10), new Double(5));
        root.getChildren().add(t);
        l = new Line(0, y, root.getWidth(), y);

        x = 10; y = 500;
        t= new Text(x, y, "Text mit Farbübergang");
        t.setFont(Font.font(null, FontWeight.BOLD, 40));
        LinearGradient lg = new LinearGradient(0, 0, 1, 1, true,
                                               CycleMethod.REFLECT,
                                               new Stop(0.0, Color.BLUE),
                                               new Stop(1.0, Color.YELLOW));
        t.setFill(lg);
        t.setUnderline(true);
        root.getChildren().add(t);

        x = 10; y = 550;
        t= new Text(x, y, "Anderer Text mit Farbübergang");
        t.setFont(Font.font(null, FontWeight.BOLD, 40));
        RadialGradient rg = new RadialGradient(0, 0, 0.5, 0.5, 0.25, true,
                                               CycleMethod.REFLECT,
                                               new Stop(0.0, Color.BLUE),
                                               new Stop(1.0, Color.RED));
        t.setFill(rg);
        t.setStrikethrough(true);
        root.getChildren().add(t);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}