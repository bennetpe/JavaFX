package gui.exam.undoredoFinal;

import javafx.scene.shape.Shape;

public class Action implements UndoRedoAction{ // action implementiert Schnittstelle

	private Shape shape; // hat den Ober Typ den wir undo redo wollen (mit cast in View) (Shape) line---
	private Exam main; // hat die View / Main
	
	public Action(Shape shape, Exam main) { // Constructor Arugmented
		this.shape = shape;
		this.main = main;
	}
//undoRedoManager.add(new Action((Shape)rectangleShape, this)); Liste Füllen in Main
	@Override
	public void undo() { // ruft in der main die spezifische undo methode auf
		main.deleteShape(shape);
	}

	@Override
	public void redo() { // ruft in der Main die redo auf
		main.addShape(shape);
	}

}
