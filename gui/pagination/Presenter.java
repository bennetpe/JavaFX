package gui.pagination;

public class Presenter {
	
	private View v;
	private SecondView sv;
	private Model m;

	public void setView(View v) {
		this.v = v;
	}

	public void setModel(Model m) {
		this.m = m;
	}
	
	public void showSecondStage(){
		if(!sv.getStage().isShowing())
		sv.getStage().showAndWait();
	}

	public void setSecondView(SecondView sv) {
		this.sv = sv;
	}

	public void hide() {
		sv.getStage().hide();
	}

}
