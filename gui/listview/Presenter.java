package gui.listview;

import javafx.scene.Parent;

public class Presenter {

	private Model m;
	private View v;
	
	public void setModel(Model m) {
		this.m = m;
	}

	public void setView(View v) {
		this.v = v;
	}

	public Parent getView() {
		// TODO Auto-generated method stub
		return v;
	}
	
	public void initLV() {
		v.fillList(m.getOl());
	}
}
