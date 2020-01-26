package gui.mvp.tableview;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionModel;

public class Model {
	/**
	 * <strong>LinkedList</strong> is better vor <strong> manipulating</strong> data, such as making 
	 * <strong>multiple inserts and deletes, performance of delete (O(1)), while ArrayList gives(O(n))
	 */
	private List<String> studenten = new LinkedList<>(); 
	private ObservableList<String> observableStudentenL = FXCollections.observableArrayList(studenten);
	
	public Model() {
	}

	public ObservableList<String> getObservableStudentenL() {
		return observableStudentenL;
	}
	public void addDummyData(String s) {
		studenten.add(s);
	}
	public List<String> getDummyDate() {
		return studenten;
	}

	public void setDummyDate(List<String> dummyDate) {
		this.studenten = dummyDate;
	}
	
	public void initModel() {
		addDummyData("Bennet");
		addDummyData("Nadir");
		addDummyData("Gwenny");
		addDummyData("Lisa");
		addDummyData("Leo");
		addDummyData("Tim");
		addDummyData("Sophia");
		observableStudentenL.addAll(studenten);
	}
}
