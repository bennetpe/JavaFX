package gui.counter;

public class Incrementer
{
    private int counter;

    public Incrementer(int counter)
    {
        this.counter = counter;
    }

    public void increment()
    {
        this.counter++;
    }

    public int getValue()
    {
        return this.counter;
    }
}
