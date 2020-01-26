package gui.mvp.tableview;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

public class View extends BorderPane{
	
	private Presenter p;
	private Button add, delete, undo, redo;
	private ToolBar toolbar;
	private TextField input;
	private TableView<String> tableView;
	private TableColumn<String, String> userNameCol;
	private SimpleStringProperty sp;
	private SelectionModel<String> selectionModel = null;


	public void initView() {
		toolbar = new ToolBar();
		tableView = new TableView<String>();
		selectionModel =  tableView.getSelectionModel();
	    userNameCol  = new TableColumn<String, String>("User Name");
        userNameCol.setCellValueFactory(new Callback<CellDataFeatures<String, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<String, String> e) {
				 SimpleStringProperty s = new SimpleStringProperty(e.getValue());
				return s;
			}
		});
	    tableView.getColumns().add(userNameCol);
		p.initDummyData();
		p.fillStudentList();
		add = new Button("add");
		delete = new Button("delete");
		undo = new Button("undo");
		redo = new Button("redo");
		input = new TextField();
		input.setPromptText("Please enter Student name..");
		input.setPrefWidth(200);
		toolbar.getItems().addAll(undo, delete, input, add, redo);
		addToRootContainer();
		handleDelte();
		handleAdd();
		undo.setOnAction(e -> p.undo());
	}
	
	public void addToRootContainer() {
		this.setTop(toolbar);
		this.setCenter(tableView);
	}
	
	public void fillTableView(ObservableList<String> students) {
		tableView.setItems(students);
		
	}
	
	public void handleDelte() {
		delete.setOnAction(e -> onDelete());
	}
	
	public void onDelete() {
		p.delete(selectionModel.getSelectedIndex());
	}

	public Parent getView() {
		return this;
	}

	public void handleAdd() {
		add.setOnAction(e -> onAdd());
	}
	
	public void onAdd() {
		if(input.getText()!= null && input.getText() != "") {
			p.add(input.getText());
		}
		else {
			return;
		}
	}
	
	public void setPresenter(Presenter p) {
		this.p = p;
	}
}
