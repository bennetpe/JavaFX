package gui.button.vbox;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
    private List<Button> buttonList = new ArrayList<>();
    private VBox root;
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        initView();
        setGrowStrategy();
        initPadding(root);
        addToContainer();
        primaryStage.setTitle("Button Grow");
        primaryStage.setScene(new Scene(root, 600, 800));
        primaryStage.show();
    }
    
    public void initView() {
        root = new VBox(10);
        addButtons();
    }
    
    public void addButtons() {
        for (int i = 1; i <= 5; i++) {
            buttonList.add(new Button("Button "+i));
        }
    }
    
    public void addToContainer() {
        for (Button button : buttonList)
        {
            root.getChildren().add(button);
        }
    }
    
    public void initPadding(VBox root) {
        Insets insets = new Insets(10);
        root.setPadding(insets);
    }
    
    public void setGrowStrategy() {
        for (Button button : buttonList)
        {
            if(button.getText().contains("1")) {
                HBox.setHgrow(button, Priority.ALWAYS);
                button.setMaxWidth(Double.MAX_VALUE);
            }
            else if(button.getText().contains("2")) {
                VBox.setVgrow(button, Priority.ALWAYS);
                button.setMaxHeight(Double.MAX_VALUE);
            }
            else if (button.getText().contains("4")) {
                VBox.setVgrow(button, Priority.ALWAYS);
                HBox.setHgrow(button, Priority.ALWAYS);
                button.setMaxHeight(Double.MAX_VALUE);
                button.setMaxWidth(Double.MAX_VALUE);
            }
        }
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }

}
