package gui.controls2;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TreeViewSample extends Application
{
    public void start(Stage stage)
    {
        TreeItem<String> rootNode = new TreeItem<>("HS Trier");
        rootNode.setExpanded(true);

        TreeItem<String> fbi = new TreeItem<>("FB Informatik");
        fbi.getChildren().add(new TreeItem<String>("Bläsius"));
        fbi.getChildren().add(new TreeItem<String>("Künkler"));
        fbi.getChildren().add(new TreeItem<String>("Lohscheller"));
        fbi.getChildren().add(new TreeItem<String>("Lürig"));
        fbi.getChildren().add(new TreeItem<String>("Rock"));
        fbi.getChildren().add(new TreeItem<String>("Schmitz"));
        rootNode.getChildren().add(fbi);

        TreeItem<String> fbw = new TreeItem<>("FB Wirtschaft");
        fbw.getChildren().add(new TreeItem<String>("Keilus"));
        fbw.getChildren().add(new TreeItem<String>("Steinbuß"));
        fbw.getChildren().add(new TreeItem<String>("Steinmann"));
        fbw.getChildren().add(new TreeItem<String>("Rieder"));
        rootNode.getChildren().add(fbw);

        TreeView<String> treeView = new TreeView<>(rootNode);
        //treeView.setShowRoot(false);
        
        Label status = new Label();
        
        treeView.getSelectionModel().selectedItemProperty().addListener
        (
            (ov, oldValue, newValue) ->
            status.setText("selected: " + newValue.getValue())
        );

        VBox box = new VBox();
        box.getChildren().addAll(treeView, status);

        Scene scene = new Scene(box, 400, 300);
        scene.setFill(Color.LIGHTGRAY);
        stage.setTitle("HS Trier");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}