package gui.exam.undoredoFinal;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Exam extends Application {

	private BorderPane root;
	private Line lineShape;
	private Circle circleShape;
	private Rectangle rectangleShape;
	private double endX, endY, startY, startX;
	private Pane drawingPane;
	private Button protokoll, delete, undo, redo;
	private ToolBar tb, footer;
	private ToggleGroup tg;
	private RadioButton lineRadio, circleRadio, rectangleRadio;
	private Label countLabel;
	private int countLines, countCircles, countRectangle, sum;
	private StringBuffer sb = new StringBuffer();
	private TextArea textArea = new TextArea();
	private Stage stage;
	private Stage secondStage;
	private UndoRedoManager um;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		initView();
		addToContainer();
		primaryStage.setTitle("Zeichnen vom Formen");
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
		
	}
	
	public void initView() {
		um = new UndoRedoManager();
		root = new BorderPane();
		drawingPane = new Pane();
		lineRadio = new RadioButton("Linie");
		lineRadio.setSelected(true);
		circleRadio = new RadioButton("Kreis");
		rectangleRadio = new RadioButton("Rechteck");
		delete = new Button("Löschen");
		undo = new Button("Undo");
		redo = new Button("Redo");
		tg = new ToggleGroup();
		tg.getToggles().addAll(lineRadio, circleRadio, rectangleRadio);
		tb = new ToolBar();
		footer = new ToolBar();
		tb.getItems().addAll(undo, lineRadio, circleRadio, rectangleRadio, delete, redo);
		protokoll = new Button("Protokoll");
		countLabel = new Label("Linien: " + countLines + ", Kreise: " + countCircles + ", Rechtecke: " + countRectangle + "Insgesamt: " + sum);
		footer.getItems().addAll(countLabel, protokoll);
		initProtokol();
		handleProtokoll();
		handlePressed();
		handleDragged();
		handleExit();
		onDelete();
		handleRedo();
		handleUndo();
	}
	
	public void addToContainer() {
		root.setCenter(drawingPane);
		root.setTop(tb);
		root.setBottom(footer);
	}
	
	public void setUpShape(Shape s, Color c, double w) {
		s.setStroke(c);
		s.setStrokeWidth(w);
		s.setFill(null);
		
	}
	public void onPressed(double x, double y) {
		startX = x;
		startY = y;
		if (lineRadio.isSelected()) {
			lineShape = new Line(startX, startY, startX, startY);
			setUpShape(lineShape, Color.GRAY, 0.5);
			drawingPane.getChildren().add(lineShape);
		}
		if (circleRadio.isSelected()) {
			circleShape = new Circle(startX, startY, 0);
			drawingPane.getChildren().add(circleShape);
			setUpShape(circleShape, Color.GRAY, 0.5);
		}
		if (rectangleRadio.isSelected()) {
			rectangleShape = new Rectangle(startX, startY, 0, 0);
			drawingPane.getChildren().add(rectangleShape);
			setUpShape(rectangleShape, Color.GRAY, 0.5);
		}
	}
	
	public void handlePressed() {
		drawingPane.setOnMousePressed(e -> {
			onPressed(e.getX(), e.getY());
		});
	}
	
	public void onDragged(double endX, double endY) {
		this.endX = endX;
		this.endY = endY;
		if (lineRadio.isSelected()) {
			lineShape.setEndX(endX);
			lineShape.setEndY(endY);
			
		}
		if(circleRadio.isSelected()) {
			double a = endX - startX;
			double b = endY - startY;
			double c = Math.sqrt((a*a) + (b*b));
			double radius = c;
			circleShape.setRadius(radius);
	
		}
		if (rectangleRadio.isSelected()) {
			double b = endX - startX;
			double h = endY - startY;
			if(h > 0) {
				rectangleShape.setY(startY);
				rectangleShape.setHeight(h);
			}
			if ( b > 0) {
				rectangleShape.setX(startX);
				rectangleShape.setWidth(b);
			}
			if ( h < 0 ) {
				rectangleShape.setY(endY);
				rectangleShape.setHeight(-h);
			}
			if ( b < 0 ) {
				rectangleShape.setX(endX);
				rectangleShape.setWidth(-b);
			}
		}
	}
	
	public void handleExit() {
		drawingPane.setOnMouseReleased(e -> {
			int sum = (countLines+countCircles+countRectangle) + 1;
			if(lineRadio.isSelected()) {
				countLines++;
				textArea.appendText(lineShape.toString()+"\n");
				countLabel.setText("Linien: " + countLines + ", Kreise: " + countCircles + ", Rechtecke: " + countRectangle + " Insgesamt: " + sum);
				setUpShape(lineShape, Color.BLACK, 2);
				um.add(new Action((Shape)lineShape, this));
			}
			if(circleRadio.isSelected()) {
				countCircles++;
				textArea.appendText(circleShape.toString()+"\n");
				countLabel.setText("Linien: " + countLines + ", Kreise: " + countCircles + ", Rechtecke: " + countRectangle + " Insgesamt: "  + sum);
				um.add(new Action((Shape)circleShape, this));
			}
			if(rectangleRadio.isSelected()) {
				countRectangle++;
				textArea.appendText(rectangleShape.toString()+"\n");
				countLabel.setText("Linien: " + countLines + ", Kreise: " + countCircles + ", Rechtecke: " + countRectangle + " Insgesamt: "  + sum);
				setUpShape(rectangleShape, Color.BLACK, 2);
				um.add(new Action((Shape)rectangleShape, this));
			}
		});
	}
	
	public void onDelete() {
		delete.setOnAction(e ->{
			resetAllCount();	
			sb = new StringBuffer("");
			textArea.clear();
			drawingPane.getChildren().clear();
		});
	}
	
	public void resetAllCount() {
		countCircles = 0;
		countRectangle = 0;
		countLines = 0;
		sum = 0;
		countLabel.setText("Linien: " + countLines + ", Kreise: " + countCircles + ", Rechtecke: " + countRectangle + "Insgesamt: " + sum);
	}
	
	public void handleDragged() {
		drawingPane.setOnMouseDragged(e -> {
			onDragged(e.getX(), e.getY());
		});
	}
	
	public void initProtokol() {
		VBox vbox = new VBox();
		secondStage = new Stage();
		textArea = new TextArea(sb.toString());
		textArea.setEditable(false);
		vbox.getChildren().addAll(textArea);
		secondStage.setTitle("Protokoll");
		secondStage.setScene(new Scene(vbox));
	}

	public void handleProtokoll() {
		protokoll.setOnAction(e ->onProtokoll());
	}
	
	public void onProtokoll() {
		secondStage.show();
	}

	public void deleteShape(Shape shape) {
		drawingPane.getChildren().remove(shape);
		
	}

	public void addShape(Shape shape) {
		drawingPane.getChildren().add(shape);
	}

	public void handleRedo() {
		redo.setOnAction(e -> {
			um.redo();
		});
	}
	
	public void handleUndo() {
		undo.setOnAction(e -> {
			um.undo();
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
