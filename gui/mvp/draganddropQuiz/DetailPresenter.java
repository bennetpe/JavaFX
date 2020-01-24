package gui.mvp.draganddropQuiz;

import javafx.scene.layout.Pane;

public class DetailPresenter
{
    private DetailView view;

    private Model model;

    private int index = 0;

    public DetailPresenter(Model model)
    {
        this.model = model;
        this.view = new DetailView(this);
        this.view.setQuestion(model.getModel(this.index).getQuestion());
        this.view.setAnswer(model.getModel(this.index).getResults());
    }

    public Pane getView()
    {
        return this.view;
    }

    public boolean compare(String[] result)
    {
        boolean statement = false;
        String[] string = this.model.getList().get(this.index).getResults();
        int trueCompare = 0;

        for (int j = 0; j < this.model.getList().get(this.index).getResults().length; j++)
        {
            if (string[j] == result[j])
            {
                trueCompare++;
            }
        }

        if (trueCompare == string.length)
        {
            this.model.getModel(this.index).right();
            statement = true;
        }
        else
        {
            this.model.getModel(this.index).trys();
        }
        return statement;
    }

    public void next()
    {
        this.model.getModel(this.index).trys();
        this.index++;
        if (this.last())
        {
            this.view.setQuestion(this.model.getModel(this.index).getQuestion());
            this.view.setAnswer(this.model.getModel(this.index).getResults());
        }
        else
        {
            this.view.setEnd();
        }
    }

    public boolean last()
    {
        boolean notLast = true;
        if (this.index == this.model.getList().size())
        {
            notLast = false;
        }
        return notLast;
    }

}
