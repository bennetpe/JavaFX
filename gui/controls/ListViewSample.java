package gui.controls;

import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ListViewSample extends Application
{
    public void start(Stage stage)
    {
        ListView<Integer> list = new ListView<>();
        Label l1 = new Label("nothing selected");
        Label l2 = new Label("nothing selected");
        Button bAdd = new Button("add to list!"); 
        Button bSort = new Button("sort!"); 
        Button bRemove = new Button("remove selected items!"); 

        VBox box = new VBox();
        box.getChildren().addAll(list, l1, l2,
                                 bAdd, bSort, bRemove);
        Scene scene = new Scene(box, 240, 440);
        stage.setScene(scene);
        stage.setTitle("ListDemo");
        list.setOrientation(Orientation.VERTICAL);
        //list.setOrientation(Orientation.HORIZONTAL);
        MultipleSelectionModel<Integer> sm =  list.getSelectionModel();
        sm.setSelectionMode(SelectionMode.MULTIPLE);
        //list.setSelectionModel(sm);

        list.getSelectionModel().selectedItemProperty().addListener
        (
            (ov, oldVal, newVal)
            -> 
            {
                l1.setText("selected: " + oldVal + " => " + newVal);
            }
        );
        list.getSelectionModel().getSelectedItems().addListener
        (
            (ListChangeListener.Change<? extends Integer> change)
            -> 
            {
                StringBuffer sb = new StringBuffer();
                for(Integer i: list.getSelectionModel().getSelectedItems())
                {
                    sb.append(" " + i);
                }
                l2.setText("selected:" + sb);
            }
        );
        bAdd.setOnAction
        (
            e -> list.getItems().add((int)(Math.random() * 1000))
        );
        bSort.setOnAction
        (
            e -> FXCollections.sort(list.getItems())
        );
        bRemove.setOnAction
        (
            e -> list.getItems().removeAll(list.getSelectionModel().getSelectedItems())
        );
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
