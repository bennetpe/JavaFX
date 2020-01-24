package gui.shapes;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class PropertyShapeBinding extends Application
{
    public void start(Stage primaryStage)
    {
        BorderPane root = new BorderPane();
        init(root);

        primaryStage.setTitle("Kopplung von Shape-Properties");
        primaryStage.setScene(new Scene(root, 800, 750));
        primaryStage.show();
    }

    private void init(BorderPane root)
    {
        Rectangle r = new Rectangle(50, 50, 40, 40);
        r.setFill(Color.GREEN);
        Pane pane = new Pane();
        pane.getChildren().add(r);
        root.setCenter(pane);
        Rectangle clipRect = new Rectangle();
        clipRect.widthProperty().bind(pane.widthProperty());
        clipRect.heightProperty().bind(pane.heightProperty());
        //pane.setClip(clipRect);
        
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        Slider s;
        HBox hb;
        VBox vb;
        
        hb = new HBox();
        s = new Slider(-100, 1000, 50);
        r.xProperty().bind(s.valueProperty());
        hb.getChildren().add(new Label("x"));
        hb.getChildren().add(s);
        hbox.getChildren().add(hb);
        
        vb = new VBox();
        s = new Slider(-100, 1000, 50);
        s.setOrientation(Orientation.VERTICAL);
        r.yProperty().bind(s.valueProperty());
        //r.yProperty().bind(new SimpleIntegerProperty(1000).subtract(s.valueProperty()));
        //s.setRotate(180);
        vb.getChildren().add(s);
        vb.getChildren().add(new Label("y"));
        hbox.getChildren().add(vb);

        hb = new HBox();
        s = new Slider(0, 1000, 40);
        r.widthProperty().bind(s.valueProperty());
        hb.getChildren().add(new Label("Breite"));
        hb.getChildren().add(s);
        hbox.getChildren().add(hb);
        
        vb = new VBox();
        s = new Slider(0, 1000, 40);
        s.setOrientation(Orientation.VERTICAL);
        r.heightProperty().bind(s.valueProperty());
        //r.heightProperty().bind(new SimpleIntegerProperty(1000).subtract(s.valueProperty()));
        //s.setRotate(180);
        vb.getChildren().add(s);
        vb.getChildren().add(new Label("Höhe"));
        hbox.getChildren().add(vb);
        
        root.setBottom(hbox);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
