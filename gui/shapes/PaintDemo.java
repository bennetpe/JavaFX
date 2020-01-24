package gui.shapes;

import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class PaintDemo extends Application
{
    private static final int X_OFFSET = 10;
    private static final int Y_OFFSET = 10;

    public void start(Stage primaryStage)
    {
        Rectangle r = new Rectangle(X_OFFSET, Y_OFFSET, 0, 0);
        Pane root = new Pane(r);
        primaryStage.setTitle("Paint-Demo");
        Scene scene = new Scene(root, 600, 150);
        r.widthProperty().bind(scene.widthProperty().subtract(2 * X_OFFSET));
        r.heightProperty().bind(scene.heightProperty().subtract(2 * Y_OFFSET));
        @SuppressWarnings("unused")
        Paint p1, p2;
        p1 = new LinearGradient(0, 0, 0.25, 0, 
                                true, CycleMethod.REFLECT,
                                new Stop(0.0, Color.WHITE),
                                new Stop(0.25, Color.RED),
                                new Stop(0.5, Color.GREEN),
                                new Stop(0.75, Color.BLUE),
                                new Stop(1.0, Color.BLACK));
        p2 = new RadialGradient(90, 0.9, 0.75, 0.25, 0.2, 
                                true, CycleMethod.REPEAT,
                                new Stop(0.0, Color.WHITE),
                                new Stop(0.25, Color.RED),
                                new Stop(0.5, Color.GREEN),
                                new Stop(0.75, Color.BLUE),
                                new Stop(1.0, Color.BLACK));
        r.setFill(p2);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
