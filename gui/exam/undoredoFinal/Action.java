package gui.exam.undoredoFinal;

import javafx.scene.shape.Shape;

public class Action implements UndoRedoAction{

	private Shape shape;
	private Exam main;
	
	public Action(Shape shape, Exam main) {
		this.shape = shape;
		this.main = main;
	}

	@Override
	public void undo() {
		main.deleteShape(shape);
	}

	@Override
	public void redo() {
		main.addShape(shape);
	}

}
