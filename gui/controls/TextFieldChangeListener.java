package gui.controls;

import javafx.application.Application;
import javafx.beans.value.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFieldChangeListener extends Application
{
    public void start(Stage primaryStage)
    {
        TextField tf = new TextField();
        Label status1 = new Label();
        Label status2 = new Label();
        tf.textProperty().addListener(new ChangeListener<String>()
        {
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue)
            {
                status1.setText(">>>changed from " + oldValue + " to " + newValue);
            }
        }
        );
        //oder als Lambda-Ausdruck:
        tf.textProperty().addListener(
            (observable, oldValue, newValue)
            -> status2.setText("***changed from " + oldValue + " to " + newValue)
        );

        VBox box = new VBox(tf, status1, status2);
        Scene scene = new Scene(box, 580, 60);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ChangeListener für ein TextField");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}