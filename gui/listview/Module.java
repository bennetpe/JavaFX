package gui.listview;

public class Module {
	private String name;
	private int ects;
	private double note;
	
	public Module(String name, int ects, double note) {
		super();
		this.name = name;
		this.ects = ects;
		this.note = note;
	}
	
	@Override
	public String toString() {
		return "Module [name=" + name + ", ects=" + ects + ", note=" + note + "]";
	}
	
}
