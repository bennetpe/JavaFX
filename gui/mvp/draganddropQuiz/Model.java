package gui.mvp.draganddropQuiz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model
{
    private ObservableList<QuizData> list = FXCollections.observableArrayList();

    public Model()
    {
        this.setData();
    }

    public void setData()
    {
        this.list.add(new QuizData("Sortiere nach Alphabet", new String[]
        { "Auto", "Bass", "Definition", "Elektronik" }));
        this.list.add(new QuizData("Wie lautet das Sprichwort", new String[]
        { "Der frühe", "Vogel", "fängt den", "Wurm" }));
        this.list.add(new QuizData("Wie lautet das Sprichwort", new String[]
        { "Der Apfel", "fällt nicht", "weit", "vom Stamm" }));
    }

    public QuizData getModel(int index)
    {
        return this.list.get(index);
    }

    public ObservableList<QuizData> getList()
    {
        return this.list;
    }

    public void setList(ObservableList<QuizData> oldValue)
    {
        this.list.clear();
        this.list.addAll(oldValue);
    }

}
