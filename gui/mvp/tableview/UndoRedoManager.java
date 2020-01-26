package gui.mvp.tableview;

import java.util.ArrayList;
import java.util.List;

import gui.undoredo.UndoableRedoableAction;

public class UndoRedoManager {
	private List<UndoableRedoableAction> actions;
	private int currentPosition;

	public UndoRedoManager() {
		actions = new ArrayList<>();
		currentPosition = 0;
	}

	public void addAction(UndoableRedoableAction action) {
		for (int i = actions.size() - 1; i >= currentPosition; i--) {
			actions.remove(i);
		}
		actions.add(action);
		currentPosition++;
	}

	void undo() {
		if (currentPosition > 0) {
			currentPosition--;
			actions.get(currentPosition).undo();
		}
	}

	public void redo() {
		if (currentPosition < actions.size()) {
			actions.get(currentPosition).redo();
			currentPosition++;
		}
	}
}
