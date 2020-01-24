package gui.mvp.quiz.dragdrop;

import gui.mvp.contact.main.MainPresenter;

public class OverviewPresenter
{
  
    private MainPresenter mp;
    private Model model;
    
    public OverviewPresenter()
    {
        mp = new MainPresenter();
        model = new Model();
    }

    public Model getModel() {
        return model;
    }
}
