package gui.mvp.exams.SS2017;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class View extends BorderPane
{
    private Presenter p;
    private ToolBar tb;
    private ToggleGroup tg;
    private RadioButton line, circle, rectangle;
    private Pane drawingPane;
    private Line lineShape;
    private Button delete;
    private Circle circleShape;
    private javafx.scene.shape.Rectangle rectangleShape;
    private javafx.geometry.Point2D startPoint = new javafx.geometry.Point2D(0, 0);
    private javafx.geometry.Point2D endPoint = new javafx.geometry.Point2D(0, 0);
    private Label statistic;
    private String statisticValue = new String();
    private Button Overview;
    private Pane protokoll;
    private TextArea textArea;
    private StringBuffer sb = new StringBuffer();

    public View() {
        initView();
    }
    public View(Presenter p)
    {
        this.p = p;
    }

    public void initView()
    {
        this.Overview = new Button("Protokoll");
        this.delete = new Button("Löschen");
        this.statistic = new Label();
        this.drawingPane = new Pane();
        tb = new ToolBar();
        tg = new ToggleGroup();
        line = new RadioButton("Linie");
        circle = new RadioButton("Kreis");
        rectangle = new RadioButton("Rechteck");
        tg.getToggles().addAll(line,circle,rectangle);
        tb.getItems().addAll(line,circle,rectangle, delete);
        this.setTop(tb);
        this.setCenter(drawingPane);
        this.setBottom(Overview); // der button verschwindet von sich aus ohne weitere Gruende 
        Rectangle rectangleBorders = new Rectangle();
        rectangleBorders.widthProperty().bind(drawingPane.widthProperty());
        rectangleBorders.heightProperty().bind(drawingPane.heightProperty());
        drawingPane.setClip(rectangleBorders);
        drawingPane.setOnMousePressed(e ->{
            OnMousePressed(e);
        });
        drawingPane.setOnMouseDragged(e ->{
            OnMouseDragged(e);
        });
        drawingPane.setOnMouseReleased(e -> {
            OnMouseReleased();
        });
        delete.setOnAction(e -> clearPane());
        Overview.setOnAction(e -> {
            getProtokoll().show();
        }); 
    }
    
    public void OnMousePressed(MouseEvent e) {
          
        startPoint = new Point2D(e.getX(), e.getY());
        
        if (line.isSelected()) {
            lineShape = new Line(e.getX(),e.getY(), e.getX(), e.getY());
            lineShape.setStroke(Color.GRAY);
            lineShape.setStrokeWidth(0.5);
            drawingPane.getChildren().add(lineShape);
        }
        else if (rectangle.isSelected()) {
            rectangleShape = new javafx.scene.shape.Rectangle(e.getX(), e.getY(), 0, 0);
            rectangleShape.setStroke(Color.GRAY);
            rectangleShape.setStrokeWidth(0.5);
            rectangleShape.setFill(null);
            drawingPane.getChildren().add(rectangleShape);
        }
        else if (circle.isSelected()) {
            circleShape = new Circle(e.getX(), e.getY(), 0);
            circleShape.setStroke(Color.GRAY);
            circleShape.setStrokeWidth(0.5);
            circleShape.setFill(null);
            drawingPane.getChildren().add(circleShape);
        }
    }
    
    public void OnMouseDragged(MouseEvent e) {
        endPoint = new Point2D(e.getX(), e.getY());
        if(line.isSelected()) {
            lineShape.setEndX(endPoint.getX());
            lineShape.setEndY(endPoint.getY());
        }
        else if (rectangle.isSelected()) {
            double height = e.getY() - startPoint.getY(); // die Höhe vom Rechteck
            double width = e.getX() - startPoint.getX(); // die Breite vom Rechteck
            // bei negativer Höhe
            if ( height < 0) {
                rectangleShape.setY(e.getY());
                rectangleShape.setHeight(-height);
            } // bei positiver Höhe 
            else if ( height > 0) {
                rectangleShape.setY(startPoint.getY());
                rectangleShape.setHeight(height);
            } // bei negativer Breite
           if ( width < 0) {
               rectangleShape.setX(e.getX());
               rectangleShape.setWidth(-width);;
           } // bei positiver Breite
           if ( width > 0) {
               rectangleShape.setX(startPoint.getX());
               rectangleShape.setWidth(width);;
           }
        }
        else if (circle.isSelected()) {
            double a = e.getX() - startPoint.getX();
            double b = e.getY() - startPoint.getY();
            circleShape.setRadius(Math.sqrt(a * a + b * b));
        }
    }
    public void OnMouseReleased() {
        for(Node n : drawingPane.getChildren()) {
            if (n instanceof Line) {
                lineShape.setStroke(Color.BLACK);
                lineShape.setStrokeWidth(2);
                sb.append(lineShape);
                sb.append('\n');
            }
            else if (n instanceof Circle) {
               System.out.println(p.checkNull(circleShape)); 
                circleShape.setStroke(Color.BLACK);
                circleShape.setStrokeWidth(2);
                sb.append(circleShape);
                sb.append('\n');
            }
            else if (n instanceof Rectangle) {
                System.out.println(p.checkNull(rectangleShape)); 
                rectangleShape.setStroke(Color.BLACK);
                rectangleShape.setStrokeWidth(2);
                sb.append(rectangleShape);
                sb.append('\n');
                UpdateCounter();
            }
              
                p.Statistic();
                System.out.println(statisticValue);
                statistic = new Label(statisticValue);
            }
        }
        
    
   public void clearPane() {
       drawingPane.getChildren().clear();
       textArea.clear();
//       getProtokoll().close();
       p.resetAllCounter();
   }

    public Parent getView()
    {
        return this;
    }
    
    public Label getStatistic () {
        return statistic;
    }
    public void setStatistic (String text) {
        this.statisticValue = text;
    }
    
    public void UpdateCounter() {
        try
        {
            Node node = drawingPane.getChildren().get(drawingPane.getChildren().size()-1);
            if ( node instanceof Line) {
                p.incrementLine();
                p.incrementSumme();
            }
            else if(node instanceof Circle)
            {
                p.incrementKreis();
                p.incrementSumme();
            }
            else if (node instanceof javafx.scene.shape.Rectangle) {
                p.incrementRechteck();
                p.incrementSumme();
            }
            
        }
        catch (java.lang.ArrayIndexOutOfBoundsException e)
        {
          System.out.println();
        }
    }
    
   public Stage getProtokoll() {
       Stage stage = new Stage();
       protokoll = new Pane();
       Scene scene = new Scene(protokoll);
       textArea = new TextArea(this.sb.toString());
       textArea.setEditable(false);
       protokoll.getChildren().add(textArea);
       stage.setScene(scene);
       stage.setTitle("Protokoll");
       return stage;
   }
}
