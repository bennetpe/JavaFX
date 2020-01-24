package gui.country.combo;

import java.text.DecimalFormat;

public class Country
{
    private String name;

    private String capital;

    private long people;

    private long area;

    private String rndPeople;

    private String rndArea;

    private String dichte;

    private String exactPeople;

    private String exactArea;

    public Country(String name, String capital, long people, long area)
    {
        this.name = name;
        this.capital = capital;
        this.people = people;
        this.area = area;
    }

    public String getName()
    {
        return this.name;
    }

    public String getCapital()
    {
        return this.capital;
    }

    public long getPeople()
    {
        return this.people;
    }

    public long getArea()
    {
        return this.area;
    }

    // getter Exakte Angabe für Fläche
    public String getAreaExact()
    {
        DecimalFormat df = new DecimalFormat(",### ");
        this.exactArea = df.format(this.area) + "";
        return this.exactArea;
    }

    // getter Exakte Angabe für Einwohner
    public String getPeopleExact()
    {
        DecimalFormat df = new DecimalFormat(",### ");
        this.exactPeople = df.format(this.people) + "";
        return this.exactPeople;
    }

    // Methode returnt Bevölkerungsdichte
    public String getDichte()
    {
        this.dichte = (this.people / this.area) + "";
        return this.dichte;
    }

    // getter für gerundete Einwohnerzahl
    public String getRoundPeople()
    {
        long pRound = this.people;

        DecimalFormat df = new DecimalFormat(",### ");

        if (this.people >= 1000000)
        {
            if (this.people % 1000000 >= 500000)// Aufrunden ab 5
            {
                pRound = (this.people / 1000000 + 1);
            }
            else
            {
                pRound = (this.people / 1000000);// Abrunden
            }
            this.rndPeople = (pRound + " Mill.");

        }
        else
        {
            if (this.people % 1000 >= 500)
            {
                pRound = (this.people / 1000 + 1) * 1000;

            }
            this.rndPeople = df.format(pRound) + "";
        }
        return this.rndPeople;
    }

    // Runde Fläche
    public String getRoundArea()
    {
        long aRound = this.area;
        DecimalFormat df = new DecimalFormat(",###");

        if (this.area >= 1000000)
        {
            if (this.area % 1000000 >= 500000)
            {
                aRound = (this.area / 1000000 + 1);
            }
            else
            {
                aRound = (this.area / 1000000);
            }
            this.rndArea = aRound + " Mille";
        }
        else
        {
            if (this.area % 1000 >= 500)
            {
                aRound = (this.area / 1000 + 1) * 1000;
            }
            this.rndArea = df.format(aRound) + "";
        }

        return this.rndArea;
    }

    @Override
    public String toString()
    {
        return this.name;
    }

}
