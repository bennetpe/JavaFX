package gui.gridpane;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GridPaneExample extends Application
{
    private GridPane gridPane;
    private CheckBox cb;
    private List<Button> btnList = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        initBtnList();
        initView();
        cb.setOnAction(e ->showGrid());
        primaryStage.setScene(new Scene(gridPane));
        primaryStage.setTitle("GridPane - Example");
        primaryStage.show();
    }
    
    public void initView() {
        gridPane = new GridPane();
        cb = new CheckBox("Show Gridlines");
        gridPane.add(btnList.get(0),0,0,1,1);
        gridPane.add(btnList.get(1),1,2,1,1);
        gridPane.add(btnList.get(2),2,3,1,1);
        gridPane.add(btnList.get(3),3,4,1,1);
        gridPane.add(cb, 4, 5);
        GridPane.setHgrow(btnList.get(2), Priority.ALWAYS );
        btnList.get(2).setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(gridPane, Priority.ALWAYS);
        gridPane.setMaxHeight(Double.MAX_VALUE);
        GridPane.setValignment(btnList.get(1), VPos.BOTTOM);
      
    }
 
    public void showGrid() {
        gridPane.setGridLinesVisible(cb.isSelected());
    }
    
    public void initBtnList() {
        for (int i = 0; i <= 10; i++) {
            btnList.add(new Button("Button "+i));
        }
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}

