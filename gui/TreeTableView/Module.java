package gui.TreeTableView;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Module {
	private SimpleStringProperty nameProperty = new SimpleStringProperty();
	private SimpleIntegerProperty ectsProperty = new SimpleIntegerProperty();
	private SimpleDoubleProperty noteProperty = new SimpleDoubleProperty();
	
	public SimpleStringProperty getNameProperty() {
		return nameProperty;
	}

	public void setNameProperty(SimpleStringProperty name) {
		this.nameProperty = name;
	}

	public SimpleIntegerProperty getEctsProperty() {
		return ectsProperty;
	}

	public void setEctsProperty(SimpleIntegerProperty ects) {
		this.ectsProperty = ects;
	}

	public SimpleDoubleProperty getNoteProperty() {
		return noteProperty;
	}

	public void setNoteProperty(SimpleDoubleProperty note) {
		this.noteProperty = note;
	}

	public Module(String name, Integer ects, Double note) {
		super();
		this.nameProperty = new SimpleStringProperty(name);
		this.ectsProperty= new SimpleIntegerProperty(ects);
		this.noteProperty = new SimpleDoubleProperty(note);
	}
	
	@Override
	public String toString() {
		return "Module [name=" + nameProperty + ", ects=" + ectsProperty + ", note=" + noteProperty + "]";
	}
	
}
