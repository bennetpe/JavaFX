package gui.all.shapes.javaEnsamble;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleShape extends Application {
	private Circle c1;
	private Circle c2;
	private VBox root;

	@Override
	public void start(Stage primaryStage) throws Exception {
		initView();
		addElementsToContainer();
		primaryStage.setTitle("Circle Shape");
		primaryStage.setScene(new Scene(root, 500, 600));
		primaryStage.show();
		
	}

	public void initView() {
		root = new VBox(10);
		c1 = new Circle(100, 100, 50);
		c2 = new Circle(400, 400, 60);
		c2.setFill(null);
		c1.setFill(null);
		c2.setStrokeWidth(2);
	}
	
	public void addElementsToContainer() {
		root.getChildren().addAll(c1,c2);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
