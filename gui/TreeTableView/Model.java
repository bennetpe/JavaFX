package gui.TreeTableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	
	private ObservableList<Module> ol = FXCollections.observableArrayList(
			new Module("Java", 10, 3.7),
			new Module("GDM", 10, 2.7),
			new Module("englisch", 10, 3.7),
			new Module("test", 10, 2.7),
			new Module("wp", 10, 1.7),
			new Module("bla", 10, 4.0)
			);

	public ObservableList<Module> getOl() {
		return ol;
	}

	public void setOl(ObservableList<Module> ol) {
		this.ol = ol;
	}
	
	
}
