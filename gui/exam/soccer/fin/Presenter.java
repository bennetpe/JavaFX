package gui.exam.soccer.fin;

public class Presenter
{

    private View view;

    private Model model;

    private Dialog dialog;

    public View getView()
    {
        return view;
    }

    public void setView(View view)
    {
        this.view = view;
    }

    public void setModel(Model model)
    {
        this.model = model;
    }

    public void setDialog(Dialog dialog)
    {
        this.dialog = dialog;
    }

    public void addMatch(Match match)
    {
        model.addMatch(match);
        view.addMatch(match);
        view.updateScores(model.getAllScores());
    }

    public void deleteMatch(Match match)
    {
        model.deleteMatch(match);

        view.deleteMatch(match);

        view.updateScores(model.getAllScores());
    }

    public void showDialog()
    {
        dialog.showDialog();
    }

    public void test()
    {
        System.out.println("Test");
    }

}
