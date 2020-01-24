package gui.dragndrop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DragAndDrop extends Application
{
    public void start(Stage stage)
    {
        AnchorPane root = new AnchorPane();

        Label source = new Label("DRAG ME");
        source.setLayoutX(50);
        source.setLayoutY(100);
        source.setScaleX(2.0);
        source.setScaleY(2.0);
        root.getChildren().add(source);

        Label target = new Label("DROP HERE");
        target.setLayoutX(250);
        target.setLayoutY(100);
        target.setScaleX(2.0);
        target.setScaleY(2.0);
        root.getChildren().add(target);

        source.setOnDragDetected(e->onDragDetected(e));
        target.setOnDragOver(e->onDragOver(e));
        target.setOnDragEntered(e->onDragEntered(e));
        target.setOnDragExited(e->onDragExited(e));
        target.setOnDragDropped(e->onDragDropped(e));
        source.setOnDragDone(e->onDragDone(e));

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.setTitle("Drag and Drop");
        stage.show();
    }

    private void onDragDetected(MouseEvent e)
    {
        System.out.println("onDragDetected");
        Label source = (Label)e.getSource();

        Dragboard db = source.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();
        content.putString(source.getText());
        db.setContent(content);
    }
    
    private void onDragOver(DragEvent e)
    {
        System.out.println("onDragOver");
        Label target = (Label)e.getSource();
        if(e.getGestureSource() != target && e.getDragboard().hasString())
        {
            e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
    }

    private void onDragEntered(DragEvent e)
    {
        System.out.println("onDragEntered");
        Label target = (Label)e.getSource();
        if(e.getGestureSource() != target && e.getDragboard().hasString())
        {
            target.setTextFill(Color.RED);
        }
    }

    private void onDragExited(DragEvent e)
    {
        System.out.println("onDragExited");
        Label target = (Label)e.getSource();
        target.setTextFill(Color.BLACK);
    }

    private void onDragDropped(DragEvent e)
    {
        System.out.println("onDragDropped");
        Label target = (Label)e.getSource();
        Dragboard db = e.getDragboard();
        boolean success = false;
        if(db.hasString())
        {
            target.setText(db.getString());
            success = true;
        }
        e.setDropCompleted(success);
    }

    private void onDragDone(DragEvent e)
    {
        System.out.println("onDragDone");
        Label source = (Label)e.getSource();
        if (e.getTransferMode() == TransferMode.MOVE)
        {
            source.setText("");
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}