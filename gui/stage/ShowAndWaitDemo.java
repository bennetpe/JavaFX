package gui.stage;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ShowAndWaitDemo extends Application
{
    private int stageCounter;
    
    public void start(Stage primaryStage)
    {
        Scene scene = makeScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Primary Stage");
        primaryStage.show();
    }
    
    private void open(int stageNumber, Modality mod, Stage owner)
    {
        Stage stage = new Stage();
        Scene scene = makeScene(stage);
        stage.setScene(scene);
        stage.initModality(mod);
        stage.initOwner(owner);
        stage.setX((stageNumber-1)*20);
        stage.setY((stageNumber-1)*15);
        stage.setTitle("Stage #" + stageNumber);
        
        System.out.println("Before showAndWait for Stage #" +
                           stageNumber);
        stage.showAndWait();
        System.out.println("After showAndWait for Stage #" +
                           stageNumber);
    }
    
    private Scene makeScene(Stage owner)
    {
        VBox root = new VBox(20);
        Button b;
        b = new Button("Say hello");
        String stageName;
        if(stageCounter == 0)
        {
            stageName = "Primary Stage";
        }
        else
        {
            stageName = "Stage #" + stageCounter;
        }
        b.setOnAction(e -> 
                      System.out.println("Hello from " + 
                                         stageName));
        root.getChildren().add(b);
        b = new Button ("Open");
        b.setOnAction(e -> open(++stageCounter, Modality.NONE, owner));
        root.getChildren().add(b);
        b = new Button ("Open (window modal)");
        b.setOnAction(e -> open(++stageCounter, Modality.WINDOW_MODAL, owner));
        root.getChildren().add(b);
        b = new Button ("Open (application modal)");
        b.setOnAction(e -> open(++stageCounter, Modality.APPLICATION_MODAL, owner));
        root.getChildren().add(b);
        return new Scene(root);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
