package gui.mvp.draganddropQuiz;

import javafx.scene.layout.Pane;

public class OverViewPresenter
{
    private Model model;

    private OverView view;

    public OverViewPresenter(Model model)
    {
        this.model = model;
        this.view = new OverView(this, model.getList());
    }

    public Pane getView()
    {
        return this.view;
    }

    public void clear()
    {
        for (int i = 0; i < this.model.getList().size(); i++)
        {
            this.model.getList().get(i).reset();
        }
        this.view.setTable();
    }
}
