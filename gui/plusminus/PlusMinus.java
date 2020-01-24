package gui.plusminus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlusMinus extends Application
{// build object. attributes
    private int counter;

    private Label label;

    private Button inc;

    private Button dec;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.counter = 0;
        VBox root = new VBox();
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("PlusMinus");

        this.inc = new Button("+");
        this.inc.setId("plus");

        this.inc.setOnAction(e -> this.increment());

        this.dec = new Button("-");
        this.dec.setId("minus");

        this.dec.setOnAction(e -> this.decrement());

        this.label = new Label();
        this.label.setId("counterL");

        this.label.setText(String.valueOf(this.counter));

        root.getChildren().addAll(this.inc, this.label, this.dec);

        primaryStage.show();

    }

    public void increment()
    {
        this.counter++;

        this.label.setText(String.valueOf(this.counter));
    }

    public void decrement()
    {
        this.counter--;

        this.label.setText(String.valueOf(this.counter));
    }

}
