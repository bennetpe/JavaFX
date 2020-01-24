package gui.stage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MultipleStages extends Application
{
    private Stage primaryStage, secondaryStage;
    
    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        
        StackPane root2 = new StackPane();
        Button b = new Button("Dieses Fenster schließen!");
        b.setOnAction
        (
            e -> secondaryStage.close()
        );
        root2.getChildren().add(b);
        Scene scene2 = new Scene(root2, 300, 80);
        secondaryStage = new Stage();
        secondaryStage.setScene(scene2);
        secondaryStage.setTitle("Zweitfenster");
        
        Button bShow = new Button("Zeige Fenster!");
        bShow.setOnAction(e->showWindow(e));
        Button bHide = new Button("Verstecke Fenster!");
        bHide.setOnAction(e->hideWindow(e));
        HBox root1 = new HBox(20);
        root1.getChildren().add(bShow);
        root1.getChildren().add(bHide);
        Scene scene1 = new Scene(root1, 300, 80);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Hauptfenster");
        primaryStage.show();
    }
    
    private void showWindow(ActionEvent e)
    {
        secondaryStage.setX(primaryStage.getX() +
                            primaryStage.getWidth() + 
                            10);
        secondaryStage.setY(primaryStage.getY());
        secondaryStage.show();
    }
    
    private void hideWindow(ActionEvent e)
    {
        secondaryStage.hide();
        //gleichbedeutend zu:
        //secondaryStage.close();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
