package gui.mvp.tableview;

public class Presenter {

	private View v;
	private Model m;
	private UndoRedoManager undoRedoManager = new UndoRedoManager();
	
	public void setView(View v) {
		this.v = v;
	}

	public void setModel(Model m) {
		this.m = m;
	}
	
	public void fillStudentList() {
		v.fillTableView(m.getObservableStudentenL());
	}
	
	public void initDummyData() {
		m.initModel();
	}
	
	public void delete(int index) {
		if(index >= 0) {
			m.getObservableStudentenL().remove(index);
		}
		else {
			return;
		}
	}
	
	public void add(String student) {
			m.getObservableStudentenL().add(student);
	}
	
	public void undo() {
		undoRedoManager.undo();
	}
}
