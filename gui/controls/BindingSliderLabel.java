package gui.controls;

import java.text.NumberFormat;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BindingSliderLabel extends Application
{
    public void start(Stage primaryStage)
    {
        Slider slider = new Slider(0, 100, 50);
        Label label = new Label();
        label.textProperty().bindBidirectional(slider.valueProperty(), NumberFormat.getNumberInstance());

        GridPane grid = new GridPane();
        grid.add(slider, 0, 0);
        grid.add(label, 0, 1);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        Scene scene = new Scene(grid, 480, 80);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Binding-Beispiel von Slider zu Label");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}