package gui.mvp.quiz.dragdrop;

public class MainViewPresenter
{
    private MainView mainView;
    private OverviewPresenter op;
    
    
    public MainViewPresenter()
    {
        op = new OverviewPresenter();
       
    }
    
  
    public Model  getModel() {
        return op.getModel();
        
    }
    
}
