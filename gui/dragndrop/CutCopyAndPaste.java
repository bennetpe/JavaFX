package gui.dragndrop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CutCopyAndPaste extends Application
{
    private Label label1, label2;
    
    public void start(Stage primaryStage)
    {
        GridPane root = new GridPane();
        root.setGridLinesVisible(true);
        root.setPadding(new Insets(8));
        label1 = new Label("Hallo");
        label1.setMaxWidth(Double.MAX_VALUE);
        root.add(label1, 0, 0);
        label2 = new Label("Auf Wiedersehen");
        label2.setMaxWidth(Double.MAX_VALUE);
        root.add(label2, 0, 1);
        
        GridPane.setHgrow(label1, Priority.ALWAYS);
        GridPane.setHgrow(label2, Priority.ALWAYS);
        
        ContextMenu contextMenu1 = new ContextMenu();
        CustomMenuItem title1 = new CustomMenuItem(new Label("Label1"));
        SeparatorMenuItem sep1 = new SeparatorMenuItem();
        MenuItem cut1 = new MenuItem("Cut");
        cut1.setOnAction(e->copyLabel(label1, true));
        MenuItem copy1 = new MenuItem("Copy");
        copy1.setOnAction(e->copyLabel(label1, false));
        MenuItem paste1 = new MenuItem("Paste");
        paste1.setOnAction(e->pasteLabel(label1));
        contextMenu1.getItems().addAll(title1, sep1, cut1, copy1, paste1);
        label1.setContextMenu(contextMenu1);
        ContextMenu contextMenu2 = new ContextMenu();
        CustomMenuItem title2 = new CustomMenuItem(new Label("Label2"));
        SeparatorMenuItem sep2 = new SeparatorMenuItem();
        MenuItem cut2 = new MenuItem("Cut");
        cut2.setOnAction(e->copyLabel(label2, true));
        MenuItem copy2 = new MenuItem("Copy");
        copy2.setOnAction(e->copyLabel(label2, false));
        MenuItem paste2 = new MenuItem("Paste");
        paste2.setOnAction(e->pasteLabel(label2));
        contextMenu2.getItems().addAll(title2, sep2, cut2, copy2, paste2);
        label2.setContextMenu(contextMenu2);
        
        Scene scene = new Scene(root, 800, 60);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cut, Copy and Paste");
        primaryStage.show();
    }

    private void copyLabel(Label l, boolean erase)
    {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(l.getText());
        clipboard.setContent(content);
        if(erase)
        {
            l.setText("");
        }
    }

    private void pasteLabel(Label l)
    {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        if(clipboard.hasString())
        {
            l.setText(clipboard.getString());
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}