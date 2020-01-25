package gui.nikolaus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class HausVomNikolaus extends Application {
	private Pane drawingPane;
	private BorderPane root;
	@Override
	public void start(Stage primaryStage) throws Exception {
		initView();
		addToContainer();
		drawHausVomNikolaus();
		primaryStage.setScene(new Scene(root,600,600, Color.GREEN));
		primaryStage.setTitle("Haus vom Nikolaus");
		primaryStage.show();
	}
	
	public void initView() {
		root = new BorderPane();
		drawingPane = new Pane();
	}
	
	public void addToContainer() {
		root.setCenter(drawingPane);
	}
	
	public void drawHausVomNikolaus() {
		Path p = new Path();
		p.setStroke(Color.BLACK);
		p.setStrokeWidth(2);
		p.setFill(Color.RED);
		MoveTo moveTo = new MoveTo(200, 500);
		LineTo lineTo = new LineTo(400, 500);
		LineTo lineTo2 = new LineTo(400,300);
		LineTo lineTo3 = new LineTo(200, 300);
		LineTo lineTo4 = new LineTo(300, 180);
		LineTo lineTo5 = new LineTo(400,300);
		LineTo lineTo6 = new LineTo(200,500);
		LineTo lineTo7 = new LineTo(200, 300);
		LineTo lineTo8 = new LineTo(400, 500);
		p.getElements().addAll(moveTo, lineTo, lineTo2, lineTo3, lineTo4, lineTo5, lineTo6, lineTo7, lineTo8 );
		drawingPane.getChildren().add(p);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
