package gui.tutorial.ws20192020;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.*;

public class NonrectangularStage extends Application
{
    private double xOffset, yOffset;

    public void start(Stage stage)
    {
        Polygon poly = new Polygon(200, 0, 400, 200, 0, 200);
        poly.setFill(Color.GREEN);
        
        EventHandler<MouseEvent> mousePressed = (MouseEvent event) ->
        {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        };
        EventHandler<MouseEvent> mouseDragged = (MouseEvent event) ->
        {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        };
        poly.setOnMousePressed(mousePressed);
        poly.setOnMouseDragged(mouseDragged);
        
        Text text = new Text("Dies ist ein Text");
        text.setLayoutX(150);
        text.setLayoutY(150);
        text.setOnMousePressed(mousePressed);
        text.setOnMouseDragged(mouseDragged);

        Rectangle exit = new Rectangle(360, 0, 40, 40);
        exit.setFill(Color.RED);
        exit.setOnMouseClicked((MouseEvent event) ->
        {
            Platform.exit();
        });
        exit.setOnMousePressed(mousePressed);
        exit.setOnMouseDragged(mouseDragged);

        Pane root = new Pane();
        root.getChildren().addAll(poly, text, exit);
        Scene scene = new Scene(root);
        scene.setFill(null);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
