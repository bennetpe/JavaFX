package gui.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Calculator extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            Pane root = FXMLLoader.load(this.getClass().getResource("calc.fxml"));
            Scene scene = new Scene(root, 210, 350);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
