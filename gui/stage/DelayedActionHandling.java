package gui.stage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class DelayedActionHandling extends Application
{
    private Label l;
    
    public void start(Stage primaryStage)
    {
        GridPane root = new GridPane();
        Button b = new Button("Hallo Welt");
        l = new Label();
        root.add(b, 0, 0);
        root.add(l, 0, 1);
        b.setOnAction(e -> handleAction(e));
        
        Scene scene = new Scene(root, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    private void handleAction(ActionEvent event)
    {
        for(int i = 1; i <= 10; i++)
        {
            String message = "handle: Runde " + i;
            l.setText(message);
            System.out.println(message);
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
            }
        }
        String message = "handle: Ende";
        l.setText(message);
        System.out.println(message);
    }
}
