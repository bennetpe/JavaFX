package gui.exam.undoredoFinal;

import java.util.ArrayList;
import java.util.List;

public class UndoRedoManager {

	private List<UndoRedoAction> actionsList; // 1. Liste Typ UndoRedoAction Interface -> actionsListe
	private int pointer; // 2. Pointer um Redo Undo Position in Action Liste festzuhalten
 
	public UndoRedoManager() { // 3. No Argument Constructor zum initalisieren beider Attribute
		this.actionsList = new ArrayList<>();
		this.pointer = 0;
	}

	//4. Add Methode nur zum hinzuf�gen von parameter(Actionen) an der Richtigen stelle
	public void add(Action action) {
		for (int i = actionsList.size()-1; pointer < i ; i--) { // von hinten �ber das Array solange i > pointer
			actionsList.remove(i); // alle Actionen aus ActionList die vor der Pointer Position sind l�schen damit es direkt danach weiter geht
		} // schliesse schleife
		actionsList.add(action); //f�ge neue action hinzu
		pointer++;	//z�hler Pointer eins hoch f�r neue Action
		action.redo(); // rufe redo auf;
	}
	
	public void undo() {
		if (pointer > 0) { // wenn der pointer > 0 
			pointer--; // pointer um eins nach links (letzte action)
			actionsList.get(pointer).undo(); // rufe undo auf der letzten action auf
		}
	}
	
	public void redo() {
		if (pointer < actionsList.size()) { // wenn der Pointer echt kleiner als ActionList l�nge
			actionsList.get(pointer).redo(); //rufe redo auf und schiebe eins nach rechts, auf leeres feld
			pointer++; // schieben
		}
	}
}
