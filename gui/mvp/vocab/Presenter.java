package gui.mvp.vocab;

//Bindeglied zwischen Model und View
public class Presenter
{
    private View view;

    private Model model;

    public Presenter(View view)
    {
        this.view = view;
    }

    public void setModel(Model model)
    {
        this.model = model;
    }

    public String aktVocab()
    {
        return this.model.getDe();
    }

    public void compare(String eng)
    {
        if (eng.isEmpty())
        {
            this.view.showEmptyError();
        }
        else if (this.model.compare(eng))
        {
            this.view.showOkayMessage();
        }
        else
        {
            this.view.showLoginError();
        }
    }

    public void nextVocab()
    {
        this.model.nextVocab();
    }
}