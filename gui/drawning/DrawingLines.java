package gui.drawning;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DrawingLines extends Application
{
    private Pane drawPane;

    private BorderPane root;

    private ToolBar toolBar;

    private ChoiceBox<Color> colorCB;

    private ChoiceBox<Number> sizeCB;

    private Button loeschen;

    private double x, y;

    private Line l = new Line();

    private List<Color> colors = new ArrayList<>();

    @Override
    public void start(Stage primaryStage)
    {
        this.initAllColors();
        this.colorCB = new ChoiceBox<>();
        this.sizeCB = new ChoiceBox<>();
        this.FillColors();
        this.initAllSize();
        this.loeschen = new Button("Loeschen");
        this.toolBar = new ToolBar();
        this.drawPane = new Pane();
        this.root = new BorderPane();
        this.toolBar.getItems().addAll(this.colorCB, this.sizeCB, this.loeschen);
        this.drawPane.setOnMousePressed(e ->
        {
            this.mousePressed(e.getX(), e.getY());
            Color selectedColor = this.colorCB.getSelectionModel().getSelectedItem();
            double size = (double) this.sizeCB.getSelectionModel().getSelectedItem() / 10;
            this.l.setStrokeWidth(size);
            this.l.setStroke(selectedColor);
        }

        );
        this.drawPane.setOnMouseDragged(e ->
        {
            this.mouseDragged(e.getX(), e.getY());
            double size = (double) this.sizeCB.getSelectionModel().getSelectedItem() / 10;
            this.l.setStrokeWidth(size);
            Color selectedColor = this.colorCB.getSelectionModel().getSelectedItem();
            this.l.setStroke(selectedColor);
        });
        this.loeschen.setOnAction(e ->
        {
            this.ClearPane();
        });
        this.root.setCenter(this.drawPane);
        this.root.setTop(this.toolBar);
        primaryStage.setTitle("Freihandzeichnen");
        primaryStage.setScene(new Scene(this.root, 330, 300));
        primaryStage.show();
    }

    private void mousePressed(double newX, double newY)
    {
        this.x = newX;
        this.y = newY;
        this.mouseDragged(this.x, this.y);
    }

    public void initAllColors()
    {
        this.colors.add(Color.RED);
        System.out.println(Color.RED.toString());
        this.colors.add(Color.GREEN);
        this.colors.add(Color.BLUE);
        this.colors.add(Color.BLACK);
    }

    public void initAllSize()
    {
        for (double i = 1; i < 10; i++)
        {
            this.sizeCB.getItems().add(i);
        }
        this.sizeCB.getSelectionModel().selectFirst();
    }

    public void FillColors()
    {
        for (Color color : this.colors)
        {
            this.colorCB.getItems().add(color);
        }

        this.colorCB.getSelectionModel().selectFirst();
    }

    private void mouseDragged(double newX, double newY)
    {
        this.l = new Line(this.x, this.y, newX, newY);
        this.l.setFill(this.colorCB.getValue());
        this.drawPane.getChildren().add(this.l);

        this.x = newX;
        this.y = newY;
    }

    private void ClearPane()
    {

        this.drawPane.getChildren().clear();

    }

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public String toString()
    {
    	String tmp = "";
        if (colorCB.getSelectionModel().getSelectedItem().equals(Color.RED)) {
        	tmp = "Rot";
        }
        return tmp;
    }
    
   
}
