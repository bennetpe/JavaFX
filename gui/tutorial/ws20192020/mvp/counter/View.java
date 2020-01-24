package gui.tutorial.ws20192020.mvp.counter;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class View
{
    private VBox root;
    private Label counterLabel;
    private ProgressBar progressBar; //zweckentfremdet!!!

    public void initView(Presenter presenter, int initValue)
    {
        root = new VBox(10);
        root.setPadding(new Insets(10));
        progressBar = new ProgressBar(initValue/100.0);
        progressBar.setMaxWidth(Double.MAX_VALUE);
        counterLabel = new Label("" + initValue);

        HBox buttons = new HBox(10);
        Button plus = new Button("+");
        plus.setOnAction(e->presenter.plus());
        Button minus = new Button("-");
        minus.setOnAction(e->presenter.minus());
        Button reset = new Button("0");
        reset.setOnAction(e->presenter.setZero());

        buttons.getChildren().addAll(plus, minus, reset);
        root.getChildren().addAll(progressBar, counterLabel, buttons);
    }

    public Pane getUI()
    {
        return root;
    }
    
    public void update(int newValue)
    {
        progressBar.setProgress(newValue/100.0);
        counterLabel.setText("" + newValue);
    }
}
