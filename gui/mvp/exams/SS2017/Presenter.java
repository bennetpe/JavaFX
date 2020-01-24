package gui.mvp.exams.SS2017;

import javafx.scene.control.Label;

public class Presenter
{
    private Model m = new Model();
    private View v = new View();
    public Presenter()
    {
        // TODO Auto-generated constructor stub
    }
    
    public Presenter(Model m, View v) {
        this.v = v;
        this.m = m;
    }
    
    public void incrementKreis() {
        m.setCountKreis(m.getCountKreis()+1);
    }
   
    public void incrementRechteck() {
        m.setCountRechteck(m.getCountRechteck()+1);
    }
 
    public void incrementLine() {
        m.setCountLinie(m.getCountLinie() + 1);
    }
    
    public void incrementSumme() {
        m.setSumme(m.getSumme()+1);
    }
    
    // soll jetzt den text aus model in das kack label in der View klatschen
    public void Statistic () {
        v.setStatistic(m.toString());
    }
    
    public void resetAllCounter() {
        m.setCountKreis(0);
        m.setCountLinie(0);
        m.setCountRechteck(0);
        m.setSumme(0);
    }
    
    public boolean checkNull(Object ob) {
        return  ob == null ? true : false;
    }
    
    
}
