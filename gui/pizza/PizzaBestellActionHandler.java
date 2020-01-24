package gui.pizza;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

public class PizzaBestellActionHandler implements EventHandler<ActionEvent>
{
    private Configuration config;

    // Felder für Preise anlegen
    private double[] preisZut;

    private TextArea ausgabe;

    private double[] preisGr;

    // Felder für Buttons anlegen
    private CheckBox[] cbox;

    private RadioButton[] rbtn;

    public PizzaBestellActionHandler(double[] preisZut, double[] preisGr, CheckBox[] cbox, TextArea ausgabe, RadioButton[] rbtn, Configuration config)
    {
        this.cbox = cbox;
        this.rbtn = rbtn;
        this.preisGr = preisGr;
        this.preisZut = preisZut;
        this.ausgabe = ausgabe;
        this.config = config;

    }

    @Override
    public void handle(ActionEvent event)
    {
        double preisZ = 0;
        double preisG = 0;
        String groesse2 = "";
        String zut = "";
        // Zutaten Schleife
        for (int i = 0; i < this.cbox.length; i++)
        {
            if (this.cbox[i].isSelected())
            {
                preisZ += this.config.getToppingPrices()[i];
                zut += this.config.getToppingNames()[i] + ", ";

            }
        }
        // Größen Schleife
        for (int a = 0; a < this.rbtn.length; a++)
        {
            if (this.rbtn[a].isSelected())
            {
                preisG += this.config.getSizePrices()[a];
                groesse2 += this.config.getSizeNames()[a];
            }
        }
        this.ausgabe.setText("Sie haben eine Pizza bestellt. " + "\nZutaten: " + zut + "\nDie Größe ist: " + groesse2 + "\nPreis beträgt: " + ((preisZ + preisG) / 100) + "€" + "\nVielen Dank.");

    }

}
