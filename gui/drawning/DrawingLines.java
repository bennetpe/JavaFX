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
import javafx.util.StringConverter;
/**
 * 
 * @author bennet <br>
 * ComboBox kann editierbar gemacht werden:
 * dann Eingabe eines Prompt-Texts möglich
 * dann StringConverter-Methode fromString sinnvoll.
 */
public class DrawingLines extends Application
{
    private Pane drawPane;

    private BorderPane root;

    private ToolBar toolBar;

    private ChoiceBox<String> colorCB;

    private ChoiceBox<Number> sizeCB;

    private Button loeschen;

    private double x, y;

    private Line l = new Line();

    private List<String> colors = new ArrayList<>();

    // fuer die richtige Anzeige in der ChoiceBox
    StringConverter<Color> converter = new StringConverter<Color>() {
    	
    	@Override
    	public Color fromString(String string) {
    		Color color = null;
    		if (string.equals("Red")) {
    			color = Color.RED;
    		}
    		if (string.equals("Green")) {
    			color = Color.GREEN;
    		}
    		if (string.equals("Blue")) {
    			color = Color.BLUE;
    		}
    		return color;
    	}
    	
    	@Override
    	public String toString(Color c) {
    		String s = null;
    		if(c == Color.RED) {
    			s = "Red";
    		}
    		if(c == Color.GREEN) {
    			s = "Green";
    		}
    		if(c == Color.BLUE) {
    			s = "Blue";
    		}
    		return s;
    	}
    };
    
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
            Color selectedColor = converter.fromString(this.colorCB.getSelectionModel().getSelectedItem());
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
            Color selectedColor = converter.fromString(this.colorCB.getSelectionModel().getSelectedItem());
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
        this.colors.add(converter.toString(Color.RED));
        this.colors.add(converter.toString(Color.GREEN));
        this.colors.add(converter.toString(Color.BLUE));
        
        System.out.println(converter.toString(Color.RED));
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
        for (String colorName : this.colors)
        {
            this.colorCB.getItems().add(colorName);
        }

        this.colorCB.getSelectionModel().selectFirst();
    }

    private void mouseDragged(double newX, double newY)
    {
        this.l = new Line(this.x, this.y, newX, newY);
        this.l.setFill(converter.fromString(this.colorCB.getValue()));
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

}
