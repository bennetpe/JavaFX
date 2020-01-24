package gui.tutorial.ws20192020;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class HelloSimple extends Application
{
    public void start(Stage primaryStage)
    {
        VBox root = new VBox(10);
        Insets s = new Insets(15);
        root.setPadding(s);
        TextField tf = new TextField();
        Button b = new Button("Sag hallo");
        Label l = new Label();
        Button exit = new Button("Ende");
        root.getChildren().addAll(tf, b, l, exit);

        b.setOnAction(e -> l.setText("Hallo " + tf.getText()));
        tf.setOnAction(e -> l.setText("Hallo " + tf.getText()));
        tf.setOnKeyTyped(e->System.out.println("key typed: " + e.getCharacter()));
        tf.textProperty().addListener((prop, oldValue, newValue) -> action(tf.textProperty(), oldValue, newValue));
        exit.setOnAction(e -> Platform.exit());

        Scene scene = new Scene(root, 310, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello");
        primaryStage.show();
    }

    private void action(StringProperty prop, String oldValue, String newValue)
    {
        System.out.println(oldValue + " => " + newValue);
        for(int i = 0; i < newValue.length(); i++)
        {
            if(!Character.isLetter(newValue.charAt(i)))
            {
                prop.set(oldValue);
                return;
            }
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Vor launch");
        launch(args);
        System.out.println("Nach launch");
    }
}
