package gui.tutorial.ws20192020.mvp.counter;

public class Presenter
{
    private Model model;
    private View view;
    
    public void setModelAndView(Model m, View v)
    {
        model = m;
        view = v;
    }
    
    public void plus()
    {
        view.update(model.increment());
    }

    public void minus()
    {
        int i = model.decrement();
        view.update(i);
    }
    
    public void setZero()
    {
        view.update(model.reset());
    }
}
