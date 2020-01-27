package gui.exam.undoredoFinal;

import java.util.ArrayList;
import java.util.List;

public class UndoRedoManager {

	private List<UndoRedoAction> actionsList;
	private int pointer;
 
	public UndoRedoManager() {
		this.actionsList = new ArrayList<>();
		this.pointer = 0;
	}

	// nur zum hinzufügen
	public void add(Action action) {
		for (int i = actionsList.size()-1; pointer < i ; i--) {
			actionsList.remove(i);
		}
		actionsList.add(action);
		pointer++;
		action.redo();
	}
	
	public void undo() {
		if (pointer > 0) {
			pointer--;
			actionsList.get(pointer).undo();
		}
	}
	
	public void redo() {
		if (pointer < actionsList.size()) {
			actionsList.get(pointer).redo();
			pointer++;
		}
	}
}
