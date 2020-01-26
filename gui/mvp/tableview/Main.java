package gui.mvp.tableview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * 
 * @author bennet
 * TODO undo redo implementieren
 */
public class Main extends Application{
	private Presenter p;
	private Model m;
	private View v;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initMVP();
		primaryStage.setTitle("MVP-TabelView");
		primaryStage.setScene(new Scene(v.getView()));
		primaryStage.show();
	}
	
	public void initMVP() {
		p = new Presenter();
		m = new Model();
		v = new View();
		// setup mvp connectors
		p.setView(v);
		p.setModel(m);
		v.setPresenter(p);
		//init main view
		v.initView();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
