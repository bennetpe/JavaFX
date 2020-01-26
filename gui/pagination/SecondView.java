package gui.pagination;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SecondView extends GridPane{

	private Presenter p;
	private Stage stage;
	private ToggleButton toggleBtn;
	
	public void initView() {
		toggleBtn = new ToggleButton("show gridline");
		this.getChildren().add(new Label("Second Stage"));
		GridPane.setColumnIndex(toggleBtn, 1);
		GridPane.setRowIndex(toggleBtn, 0);
		GridPane.setConstraints(toggleBtn, 2, 0);
		this.getChildren().add(toggleBtn);
		initSecondStage();
		onToggleBtn();
	}
	
	public void initSecondStage() {
		
		stage = new Stage();
		Modality modality = Modality.NONE;
		stage.initModality(modality);
		stage.setTitle("Second Stage");
		stage.setScene(new Scene(this, 300,200));
	}


	public void setPressed(Presenter p) {
		this.p = p;
	}
	
	public void showGridLine() {
		onToggleBtn();
	}
	
	public void onToggleBtn() {
		toggleBtn.setOnAction(e -> {
			this.setGridLinesVisible(toggleBtn.isSelected());	
		});
		toggleBtn.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				System.out.println("Toggle Old: " + oldValue + " => " +"Toggle New: " + newValue);
				
			}
		});
	}
	
	public Stage getStage() {
		return stage;
	}
}
