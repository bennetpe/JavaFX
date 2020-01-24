package mvp.bla;

//import java.awt.Button; // awt Button!!! in Klausur auf AWT achten

import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import jdk.nashorn.internal.codegen.Label;

public class View extends BorderPane
{
    private Label l;

    public View(Presenter p)
    {
        // TODO Auto-generated constructor stub
    }

    public void initView()
    {
        // hier View mit Nodes/Container fuellen 
        l = new Label("Simple MVP Construct");
        
    }
    
    public Parent getView() {
        return this;
    }

}
