package gui.TreeTableView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	private Presenter p;
	private Model m;
	private View v;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Bachelor Durchschnitt");
		primaryStage.setScene(new Scene(initMVP().getView()));
		primaryStage.show();
	}
	
	public Presenter initMVP() {
		this.m = new Model();
		this.p = new Presenter();
		this.v = new View(p);
		this.p.setModel(m);
		this.p.setView(v);
		
		return p;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
}
