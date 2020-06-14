package gui.listview;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class View extends BorderPane{
	
	private TableView treeView;
	private Presenter p;
	
	public View() {
		p.initLV();
		initView();
	}
	
	public ObservableList<Module> getOL(ObservableList<Module> ol){
		return ol;
	}
	
	public void initView() {
		treeView = new TableView<>();
//		treeView.getColumns().add(0, new´´´´´´);
		this.setCenter(treeView);
	}

	public View(Presenter p) {
		this.p = p;
	}

}
