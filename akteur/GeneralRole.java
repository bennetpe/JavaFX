package akteur;

public class GeneralRole implements Role1
{
    private String message;

    public GeneralRole(String message)
    {
        this.message = message;

    }

    @Override
    public String play()
    {
        return this.message;
    }
}
