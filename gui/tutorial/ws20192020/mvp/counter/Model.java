package gui.tutorial.ws20192020.mvp.counter;

public class Model
{
    private int counter;

    public Model(int initValue)
    {
        counter = initValue;
    }
    
    public Model()
    {
        this(0);
    }
    
    public int increment()
    {
        counter++;
        return counter;
    }
    
    public int decrement()
    {
        counter--;
        return counter;
    }
    
    public int reset()
    {
        counter = 0;
        return counter;
    }
}
