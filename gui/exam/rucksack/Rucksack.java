package gui.exam.rucksack;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Rucksack {

	private SimpleIntegerProperty gewicht = new SimpleIntegerProperty() ;
	private SimpleStringProperty gegenstand = new SimpleStringProperty(); 
	private SimpleBooleanProperty isSelected = new SimpleBooleanProperty();
	private static int maxGewicht = 24;
	private static int aktuellesGewichte = 0;
	
	public static int getAktuellesGewichte() {
		return aktuellesGewichte;
	}

	public static void setAktuellesGewichte(int aktuellesGewichte) {
		Rucksack.aktuellesGewichte = aktuellesGewichte;
	}

	public static int getMaxGewicht() {
		return maxGewicht;
	}

	public static void setMaxGewicht(int maxGewicht) {
		Rucksack.maxGewicht = maxGewicht;
	}

	public SimpleBooleanProperty getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(SimpleBooleanProperty isSelected) {
		this.isSelected = isSelected;
	}

	public IntegerProperty getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht.set(gewicht);
	}

	public StringProperty getGegenstand() {
		return gegenstand;
	}

	public void setGegenstand(String gegenstand) {
		this.gegenstand.set(gegenstand);
	}

	public Rucksack(int gewicht, String gegenstand, boolean isSelected) {
		super();
		this.gewicht.set(gewicht);;
		this.gegenstand.set(gegenstand);;
		this.isSelected.set(isSelected);
	}

	public Rucksack() {
	}
	
	@Override
	public String toString() { // wie in ListView angezeigt: Merke .getValue für Properties
		return "Gegenstand: "+ getGegenstand().getValue() +  " ,Gewicht: " + getGewicht().getValue();
	}
}
