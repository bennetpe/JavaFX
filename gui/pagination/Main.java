package gui.pagination;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	private Presenter p;
	private View v;
	private Model m;
	private SecondView sv;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initMVP() ;
		v.initView();
		sv.initView();
		primaryStage.setScene(new Scene(v.getView(), 800, 600));
		primaryStage.setTitle("Pagination Example");
		primaryStage.show();
	}
	
	public void initMVP() {
		// initialize Object Attributes
		p = new Presenter();
		v = new View();
		m = new Model();
		sv = new SecondView();
		// set up MVP association 
		p.setView(v);
		p.setSecondView(sv);
		p.setModel(m);
		v.setPresenter(p);
		sv.setPressed(p);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
