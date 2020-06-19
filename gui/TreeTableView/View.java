package gui.TreeTableView;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

public class View extends BorderPane{
	
	private Presenter p;
	
	public void initView() {
		Module pf = new Module("PF", 0, 0.0);
		TreeItem<Module> pfNode = new TreeItem<>(pf);
		Module java = new Module("Grundlagen der Mathematik", 5, 2.0);
		TreeItem<Module> javaItem = new TreeItem<Module>(java);
		pfNode.getChildren().add(javaItem);
		Module wp = new Module("WP", 0, 0.0);
		TreeItem<Module> wpNode = new TreeItem<>(wp);
		Module rethorik = new Module("Rethorik für Informatiker", 5, 1.3);
		TreeItem<Module> rethorikItem = new TreeItem<Module>(rethorik);
		wpNode.getChildren().add(rethorikItem);
		TreeTableView<Module> treeTableView = new TreeTableView<>(pfNode);
		treeTableView.getRoot().getChildren().add(wpNode);
		TreeTableColumn<Module, String> moduleNameCol = 
				new TreeTableColumn<>("Modul Name");
		moduleNameCol.setPrefWidth(200);
		moduleNameCol.setCellValueFactory
		(
				item -> item.getValue().getValue().
				getNameProperty()
		);
		TreeTableColumn<Module, Number> moduleEctsCol = 
				new TreeTableColumn<>("ECTS");
		moduleEctsCol.setPrefWidth(200);
		moduleEctsCol.setCellValueFactory
		(
				item -> item.getValue().getValue().
				getEctsProperty()
		);
		 
		treeTableView.getColumns().addAll(moduleNameCol, moduleEctsCol);
		this.setCenter(treeTableView);
	}	
	
	public View(Presenter p) {
		initView();
		this.p = p;
	}
	
	public Parent getView()	{
		return this;
		
	}

}
