package gui.borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPaneBeispiel extends Application
{
    private BorderPane root;
    private Button[] btnArray = new Button[5];

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        fillButtonArray();
        initView();
        setGrowing();
        primaryStage.setTitle("BorderPane - Beispiel");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void initView() {
        root = new BorderPane();
        root.setTop(btnArray[0]);
        root.setLeft(btnArray[1]);
        root.setRight(btnArray[2]);
        root.setBottom(btnArray[3]);
        root.setCenter(btnArray[4]);
        btnArray[0].setText("top");
        btnArray[1].setText("left");
        btnArray[2].setText("right");
        btnArray[3].setText("bottom");
        btnArray[4].setText("center");
    }
    
    public void setGrowing() {
        for (Button button : btnArray)
        {
            HBox.setHgrow(button, Priority.ALWAYS);
            VBox.setVgrow(button, Priority.ALWAYS);
            button.setMaxHeight(Double.MAX_VALUE);
            button.setMaxWidth(Double.MAX_VALUE);
        }
    }
    
    public void fillButtonArray() {
        for (int i = 0; i < btnArray.length; i++)
        {
            btnArray[i] = new Button();
        }
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}

