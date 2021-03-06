package gui.exam.SS2017;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
//import javafx.stage.Modality;
import javafx.stage.Stage;

public class KlausurSS17 extends Application {
	private BorderPane root;
	private Pane drawingPane;
	private Line line;
	private Circle circle;
	private Rectangle rectangle;
	private double startX, startY;
	private double endX, endY;
	private RadioButton lineRadio, circleRadio, rectangleRadio;
	private int lines = 0, circles = 0, rectangles = 0, sum = 0;
	private ToggleGroup tg;
	private ToolBar toolbar;
	private Label anzeigeLabel;
	private Button protokoll, delete;
	private ToolBar footer;
	private Pane protokollPane;
	private TextArea textArea;
	private StringBuffer stringBuffer;

	@Override
	public void start(Stage primaryStage) throws Exception {
		initView();
		addToContainer();
		addToRoot();
		onPressed();
		onDragged();
		onReleased();
		showProtokoll();
		onDelete();
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.setTitle("Zeichen von Formen");
		primaryStage.show();
	}

	public void initView() {
		stringBuffer = new StringBuffer();
		delete = new Button("L�schen");
		protokoll = new Button("Protokoll");
		root = new BorderPane();
		drawingPane = new Pane();
		lineRadio = new RadioButton("Linie");
		circleRadio = new RadioButton("Kreis");
		rectangleRadio = new RadioButton("Rechteck");
		tg = new ToggleGroup();
		toolbar = new ToolBar();
		lineRadio.setSelected(true);
		footer = new ToolBar();
		textArea = new TextArea();
		anzeigeLabel = new Label();
		anzeigeLabel.setText("Lines: " + lines + " ,Circles: " + circles + " ,Rectangle: " + rectangles
				+ " ,insgesamt: " + sum);
	}

	public void addToContainer() {
		tg.getToggles().addAll(lineRadio, circleRadio, rectangleRadio);
		toolbar.getItems().addAll(lineRadio, circleRadio, rectangleRadio, delete);
		footer.getItems().addAll(anzeigeLabel, protokoll);
	}

	public void addToRoot() {
		this.root.setCenter(drawingPane);
		this.root.setTop(toolbar);
		this.root.setBottom(footer);
	}

	public void setUpShape(Shape s, Color c, double width) {
		s.setStroke(c);
		s.setStrokeWidth(width);
	}

	public void drawStart(double x, double y) {
		startX = x;
		startY = y;
		if (lineRadio.isSelected()) {
			line = new Line(startX, startY, startX, startY);
			setUpShape(line, Color.GRAY, 0.5);
			drawingPane.getChildren().add(line);
		} else if (circleRadio.isSelected()) {
			circle = new Circle(x, y, 0);
			setUpShape(circle, Color.GRAY, 0.5);
			circle.setFill(null);
			drawingPane.getChildren().add(circle);
		} else if (rectangleRadio.isSelected()) {
			rectangle = new Rectangle(startX, startY, 0, 0);
			setUpShape(rectangle, Color.GRAY, 0.5);
			rectangle.setFill(null);
			drawingPane.getChildren().add(rectangle);
		}
	}

	public void drawEnd(javafx.scene.input.MouseEvent e) {
		endX = e.getX();
		endY = e.getY();
		if (lineRadio.isSelected()) {
			line.setEndX(e.getX());
			line.setEndY(e.getY());
			setUpShape(line, Color.GRAY, 0.5);
		} else if (circleRadio.isSelected()) {
			double a = endX - startX; 
			double b = endY - startY;
			double c = Math.sqrt((a * a) + (b * b)); // c -> Radius
			circle.setRadius(c);
			setUpShape(circle, Color.GRAY, 0.5);
		}
		else if (rectangleRadio.isSelected()) {
			double b = endX - startX;
			double h = endY - startY;	
			 if ( h > 0) {
				rectangle.setY(startY);
				rectangle.setHeight(h);
			}
			 if (b > 0 ) {
				 
				rectangle.setX(Math.abs(startX));
				rectangle.setWidth(b);
			 }
			 if ( b < 0	) {
				 rectangle.setX(Math.abs(endX));
				 rectangle.setWidth(-b);
			 }
			 if ( h < 0) {
				 rectangle.setY(Math.abs(endY));
				 rectangle.setHeight(-h);
			 }
		}
	}

	public void resetAllCounter() {
        lines = 0;
        circles = 0;
        rectangles = 0;
        sum = 0;
	}

	public void drawDone() {
		if (lineRadio.isSelected()) {
			setUpShape(line, Color.BLACK, 2);
			stringBuffer.append(line + "\n");
			lines++;
			sum++;
		} else if (circleRadio.isSelected()) {
			setUpShape(circle, Color.BLACK, 2);
			stringBuffer.append(circle + "\n");
			circles++;
			sum++;
		} else if (rectangleRadio.isSelected()) {
			setUpShape(rectangle, Color.BLACK, 2);
			stringBuffer.append(rectangle+ "\n");
			rectangles++;
			sum++;
		}
//		updateStatus();
		anzeigeLabel.setText("Lines: " + lines + " ,Circles: " + circles + " ,Rectangle: " + rectangles
				+ " ,insgesamt: " + sum);
	}

	public void onReleased() {
		drawingPane.setOnMouseReleased(e -> drawDone());
	}

	public void onDragged() {
		drawingPane.setOnMouseDragged(e -> drawEnd(e));
	}

	public void onPressed() {
		drawingPane.setOnMousePressed(e -> drawStart(e.getX(), e.getY()));
	}

	public void onDelete() {
		delete.setOnAction(e -> {
			resetAllCounter();
			drawingPane.getChildren().clear();
			anzeigeLabel.setText("Lines: " + lines + " ,Circles: " + circles + " ,Rectangle: " + rectangles
					+ " ,insgesamt: " + sum);
			stringBuffer = new StringBuffer("");
			textArea.clear();
		});
	}

	public void showProtokoll() {
		protokoll.setOnAction(e -> {
			getProtokollStage().show();
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

	// ##############Protokoll################################
	public Stage getProtokollStage() {
		Stage stage = new Stage();
		protokollPane = new Pane();
		Scene scene = new Scene(protokollPane);
		textArea.setText(stringBuffer.toString());
		textArea.setEditable(false);
		protokollPane.getChildren().add(textArea);
		stage.setScene(scene);
		stage.setTitle("Protokoll");
//		stage.initModality(Modality.APPLICATION_MODAL );
		return stage;
	}
}
