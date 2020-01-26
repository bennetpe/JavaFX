package gui.shapes;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.stage.Stage;

public class Bezier extends Application
{
    private Circle start;
    private Circle end;
    private Circle c1;
    private Circle c2;
    private Slider sliderX1;
    private Slider sliderX2;
    private Slider sliderY1;
    private Slider sliderY2;
    private Pane pane;
    private BorderPane root;
    private VBox leftVBox;
    private VBox rightVBox;
    private Label labelC1;
    private Label labelC2;
    private CubicCurve bezier; 
    
    public void start(Stage primaryStage)
    {
        
        initView();
        addToContainer();
        drawBezier(root);
        bindFunctions();
        primaryStage.setTitle("Bezier-Kurve");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public void initView() {
        root = new BorderPane();
        pane = new Pane();
        labelC1 = new Label("Control Point 1");
        labelC2 = new Label("Control Point 2");
        labelC1.setTextFill(Color.RED);
        labelC2.setTextFill(Color.RED);
        //###########Initialize Slider#######################
        //merke das die Slider mit min und max sowie value init müssen
        //TODO Slider Value auf C1 Position xy und C2 position xy
        sliderX1 = new Slider(0, 600, 100);
        sliderX2 = new Slider(0, 600, 250);
        sliderY1 = new Slider(0, 600, 200);
        sliderY2 = new Slider(-400, 200, 200);
        //###########Initialize Left Boder VBOX and Right Border VBOX
        leftVBox = new VBox(10);
        rightVBox = new VBox(10);
        //############Set Slider Orientation#################
        sliderY1.setOrientation(Orientation.VERTICAL);
        sliderY2.setOrientation(Orientation.VERTICAL);
      //#################Initialize Circle Shapes############
        start = new Circle(50, 50, 5, Color.RED);
        c1 = new Circle(100, 200, 5, Color.BLUE);
        c2 = new Circle(250, 200, 5, Color.GREEN);
        end = new Circle(300, 50, 5, Color.PINK);
    }
    
    public void bindFunctions() {
    //####################ControllPoints Bindings###########################    
        c2.centerXProperty().bind(sliderX2.valueProperty());
        c2.centerYProperty().bind(sliderY2.valueProperty());
        c1.centerXProperty().bind(sliderX1.valueProperty());
        c1.centerYProperty().bind(sliderY1.valueProperty());
   //#############Label Bindings############################################
        labelC1.layoutXProperty().bind(sliderX1.valueProperty());
        labelC1.layoutYProperty().bind(sliderY1.valueProperty());
        labelC2.layoutXProperty().bind(sliderX2.valueProperty());
        labelC2.layoutYProperty().bind(sliderY2.valueProperty());
//####################Cubic Curve Bindings###################################
        bezier.controlX1Property().bind(sliderX1.valueProperty());
        bezier.controlY1Property().bind(sliderY1.valueProperty());
        bezier.controlX2Property().bind(sliderX2.valueProperty());
        bezier.controlY2Property().bind(sliderY2.valueProperty());
    }
    
    public void listenToChanges() {
        
    }
    /**
     * @see add interactble to the container
     */
    public void addToContainer() {
        leftVBox.getChildren().addAll(sliderX1, sliderY1);
        rightVBox.getChildren().addAll(sliderX2, sliderY2);
        root.setLeft(leftVBox);
        root.setRight(rightVBox);
        pane.getChildren().add(labelC1);
        pane.getChildren().add(labelC2);
        pane.getChildren().add(start);
        pane.getChildren().add(end);
        pane.getChildren().add(c1);
        pane.getChildren().add(c2);
    }
    private void drawBezier(BorderPane root)
    {
        bezier = new CubicCurve(50, 50, 100, 200, 250, 200, 300, 50);
        bezier.setStroke(Color.BLACK);
        bezier.setFill(null);
        bezier.setStrokeWidth(3);
        pane.getChildren().add(bezier);
        root.setCenter(pane);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
