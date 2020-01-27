package gui.exam.rucksack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	private Presenter p;
	private Rucksack m;
	private View v;

	@Override
	public void start(Stage primaryStage) throws Exception {
		initMVP();
		primaryStage.setTitle("Rucksack Klausur");
		primaryStage.setScene(new Scene(v.getView()));
		primaryStage.show();
	}
	
	
	public void initMVP() {
		p = new Presenter();
		v = new View();
		m = new Rucksack();
		p.setView(v);
		p.setModel(m);
		v.setPresenter(p);
		v.initView();
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
