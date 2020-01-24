package gui.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BindingSliderSlider extends Application
{
    public void start(Stage primaryStage)
    {
        Slider slider1 = new Slider(0, 100, 50);
        Slider slider2 = new Slider(0, 100, 50);
        slider1.valueProperty().bind(slider2.valueProperty());
        //slider1.valueProperty().bindBidirectional(slider2.valueProperty());

        GridPane grid = new GridPane();
        grid.add(slider1, 0, 0);
        grid.add(slider2, 0, 1);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        Scene scene = new Scene(grid, 480, 80);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Binding-Beispiel von Slider zu Slider");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}