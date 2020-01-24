package gui.mvp.login.fxml.di;

public class Presenter
{
    private ViewController view;
    private Model model;

    public Presenter()
    {
    }

    public void setView(ViewController view)
    {
        this.view = view;
    }

    public void setModel(Model model)
    {
        this.model = model;
    }

    public void login(String loginName, String password)
    {
        if(loginName.isEmpty())
        {
            view.showInputError();
        }
        else if(model.isOkay(loginName, password))
        {
            view.resetInput();
            view.showOkayMessage();
        }
        else
        {
            view.showLoginError();
        }
    }
}
