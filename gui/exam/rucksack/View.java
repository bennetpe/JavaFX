package gui.exam.rucksack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class View extends BorderPane{

	private ListView<Rucksack> lv;
	private Presenter p;
	private SplitPane sp;
	private Pane drawingPane;
	private VBox leftControl;
    private VBox rightControl;
    private Rectangle emptyBar = new Rectangle(200, 400, null);
    private Rectangle fullBar = new Rectangle(200, 0, Color.GREEN);
    
    private ObservableList<Rucksack> obList = FXCollections.observableArrayList();
	

	public void setPresenter(Presenter p) {
		this.p = p;
	}

	@SuppressWarnings("unchecked")
	public void initView() {
		sp = new SplitPane();
		drawingPane = new Pane();
		emptyBar.setStroke(Color.BLACK);
		emptyBar.setStrokeWidth(2);
		fullBar.maxHeight(-400);
		fullBar.setX(emptyBar.getX());
		fullBar.setY(emptyBar.getHeight()-fullBar.getHeight());
		drawingPane.getChildren().addAll(emptyBar,fullBar);
		 rightControl = new VBox();
		 leftControl = new VBox();
		 lv = new ListView<>(obList);
		 p.fillBackpack();
		 leftControl.getChildren().add(lv);
		 rightControl.getChildren().add(drawingPane);
		 sp.getItems().addAll(leftControl, rightControl);
		 this.setCenter(sp);
		 handleCellFactory();
		
	}
	
	public void setProgressBar(int value, int maxLoad) {
		fullBar.setHeight((value * (400 / maxLoad)));
		fullBar.setY(emptyBar.getHeight()-fullBar.getHeight());
		System.out.println(value * 400 / maxLoad);
		
	}
	
	public void handleCellFactory() {
		lv.setCellFactory(CheckBoxListCell.forListView(rucksack -> ((Rucksack) rucksack).getIsSelected()));
	}
	
	public Parent getView() {
		return this;
	}

	public ObservableList<Rucksack> getObList() {
		return obList;
	}
	
	public void setObList(ObservableList<Rucksack> obList) {
		this.obList = obList;
	}
}
