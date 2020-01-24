package gui.mvp.draganddropQuiz;

public class QuizData
{
    private int trys, right;

    private String[] results;

    private String question;

    public QuizData(String question, String[] results)
    {
        this.question = question;
        this.results = results;
        trys = 0;
        right = 0;
    }

    public int getTrys()
    {
        return trys;
    }

    public int getRight()
    {
        return right;
    }

    public String[] getResults()
    {
        return results;
    }

    public void trys()
    {
        trys++;
    }

    public void right()
    {
        right++;
    }

    public void reset()
    {
        trys = 0;
        right = 0;
    }

    public String getQuestion()
    {
        return question;
    }
}
