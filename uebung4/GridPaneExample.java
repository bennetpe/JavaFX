package uebung4;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class GridPaneExample extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);

        Insets ins = new Insets(10);
        root.setPadding(ins);
        // damit Pane weiﬂ wie sie oder was sie skalliert
        ColumnConstraints column = new ColumnConstraints();
        RowConstraints row = new RowConstraints();

        // Spalte
        for (int i = 1; i <= 5; i++)
        { // Zeile
            for (int j = 1; j <= 5; j++)
            {
                if (i < 3 || j < 3)
                {

                    Button b = new Button("Button " + i + "/" + j);
                    root.add(b, i - 1, j - 1);
                    column.setPercentWidth(10);
                    row.setPercentHeight(10);
                    root.getColumnConstraints().add(column);
                    root.getRowConstraints().add(row);

                }
            }
        }

        Button b;
        b = new Button("Button 6/*");
        b.setMaxHeight(Double.MAX_VALUE);
        root.add(b, 5, 0, 1, 4);

        Button b1 = new Button("URechts");
        GridPane.setHalignment(b1, HPos.RIGHT);
        GridPane.setValignment(b1, VPos.BOTTOM);
        // b1.setMaxWidth(Double.MAX_VALUE);
        root.add(b1, 5, 5);

        b = new Button("OMitte");
        // b.setMaxHeight(Double.MAX_VALUE);
        // b.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHalignment(b, HPos.CENTER);
        GridPane.setValignment(b, VPos.TOP);
        root.add(b, 2, 2, 3, 3);

        root.setGridLinesVisible(true);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GridPane-Beispiel");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
