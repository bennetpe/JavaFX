package gui.dynamisch.rectangle;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

	private Pane drawingPane;
	private BorderPane root;
	private Slider nSlider;
	private Slider pSlider;
	private HBox hb;
	private VBox vb;
	private Label nLabel;
	private Label pLabel;
	private double h;
	private static final double  BREITE = 7;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initView();
		nSlider.valueProperty().addListener((obs,oldV,newV) ->{
			hb.getChildren().clear();
			nLabel.setText("n="+(int)nSlider.getValue());
			for(int x = 0; x < (int)nSlider.getValue(); x ++) {
				hb.getChildren().add(new Rectangle(BREITE, h));
			}
		});
		pSlider.valueProperty().addListener((obs, oldV, newV) ->{
			pLabel.setText("p="+pSlider.getValue());
			h = pSlider.getValue() * 1000;
		});
		primaryStage.setScene(new Scene(root, 800, 500));
		primaryStage.setTitle("Exam");
		primaryStage.show();
		
	}
	
	public void initView() {
		root = new BorderPane();
		
		nSlider = new Slider(0, 30, 10);
		pSlider = new Slider(0, 1, 0);
		nLabel = new Label("n="+nSlider.getValue());
		pLabel = new Label("p="+pSlider.getValue());
		hb = new HBox(3);
		hb.setPadding(new Insets(30, 30, 30, 30));
		hb.setAlignment(Pos.BOTTOM_LEFT);
		vb = new VBox(4);
		vb.getChildren().addAll(nLabel,nSlider,pLabel,pSlider);
		root.setCenter(hb);
		root.setBottom(vb);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
