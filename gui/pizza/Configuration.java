package gui.pizza;

public class Configuration
{
    private String[] sizeNames; // groesse Namensliste

    private int[] sizePrices; // groesse Preisliste

    private String[] toppingNames =
    { "Käse", "Tomaten", "Schinken", "Bacon", "Spinat", "Ananas", "Mais", "Paprika", "Salami", "Zwiebeln" }; // Belagnamen

    private int[] toppingPrices; // Belagpreise

    private int numberOfDefaultToppings = 2; // voreingestellte Beläge

    public Configuration() // Einstellungen
    {
        if (this.sizeNames.length != this.sizePrices.length)
        {
            throw new IllegalStateException("sizeNames do not match sizePrices");
        }
        if (this.toppingNames.length != this.toppingPrices.length)
        {
            throw new IllegalStateException("toppingNames do not match toppingPrices");
        }
        if (this.numberOfDefaultToppings > this.toppingNames.length)
        {
            throw new IllegalStateException("too many default toppings");
        }
    }

    public Configuration(String[] sizeNames2, int[] sizePrices2, String[] toppingNames2, int[] toppingPrices2, int numberOfDefaultToppings2)
    {
        // TODO Auto-generated constructor stub
    }

    public String[] getSizeNames()
    {
        return this.sizeNames;
    }

    public int[] getSizePrices()
    {
        return this.sizePrices;
    }

    public String[] getToppingNames()
    {
        return this.toppingNames;
    }

    public int[] getToppingPrices()
    {
        return this.toppingPrices;
    }

    public int getNumberOfDefaultToppings()
    {
        return this.numberOfDefaultToppings;
    }

    public static void main(String[] args)
    {
        Configuration test = new Configuration();
        System.out.println(test.getToppingNames());
    }
}
