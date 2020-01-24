package gui.mvp.quiz.dragdrop;

import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class OverviewView extends BorderPane
{
    private OverviewPresenter op = new OverviewPresenter();
    private Model model;
    private HBox bg;
    private ListView<String> listView;
    
    public OverviewView()
    {
        initOverview();
        this.model = new Model();
    }
    
    public void initOverview() {
     bg = new HBox();
     this.setTop(bg);
     listView = new ListView<String>();
     this.setCenter(listView);
    }
    
    public Parent getOverview() {
        return this;
    }
    
}
