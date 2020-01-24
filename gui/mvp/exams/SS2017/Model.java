package gui.mvp.exams.SS2017;

public class Model
{
    private int countKreis = 0;
    private int countLinie = 0;
    private int countRechteck = 0;
    private int summe = 0;
    
   
    public int getCountKreis()
    {
        return countKreis;
    }
    public void setCountKreis(int countKreis)
    {
        this.countKreis = countKreis;
    }
    public int getCountLinie()
    {
        return countLinie;
    }
    public void setCountLinie(int countLinie)
    {
        this.countLinie = countLinie;
    }
    public int getCountRechteck()
    {
        return countRechteck;
    }
    public int getSumme() {
        return summe;
    }
    public void setSumme(int summe) {
        this.summe  = summe;
    }
    public void setCountRechteck(int countRechteck)
    {
        this.countRechteck = countRechteck;
    }
    
    @Override
    public String toString()
    {
        // TODO Auto-generated method stub
        return "Linie:" + getCountLinie() + " Kreise:" + getCountKreis() + " Rechtecke:" + getCountRechteck() + " insgesamt:" + getSumme();
    }
}
