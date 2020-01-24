package gui.pizza;

import java.util.Map;

/**
 *  Bennet Pieper
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application
{
    // Objektreferenz auf Configuration()
    private Configuration config = new Configuration();

    // Converter
    static private ParameterConverter paramConv;

    // Felder für Preise anlegen
    private double[] preisZut = new double[this.config.getToppingPrices().length];

    private double[] preisGr = new double[this.config.getSizePrices().length];

    // Felder für Buttons anlegen
    private CheckBox[] cbox = new CheckBox[this.config.getToppingNames().length];

    private RadioButton[] rbtn = new RadioButton[this.config.getSizeNames().length];

    @Override
    public void start(Stage primaryStage)
    {
        System.out.println("Starte GUI");
        // Root Pane
        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza");
        primaryStage.show();
        System.out.println("Root Fenster gestartet");
        // Child Pane1
        GridPane zutaten = new GridPane();
        zutaten.setVgap(10);
        zutaten.setHgap(10);
        // ChildPane2
        GridPane groesse = new GridPane();
        groesse.setHgap(10);
        // hinzufügen der Childs zum root mit Spalten/Zeilen Index Position
        root.add(zutaten, 0, 0);
        root.add(groesse, 0, 1);
        System.out.println("Child Objekte hinzugefügt");

        // Checkboxen für Zutaten anlegen
        byte zeile = 0;
        byte spalte = 0;
        for (int i = 0; i < this.config.getToppingNames().length; i++)
        {
            if (i % 2 == 0)
            {
                this.preisZut[i] = this.config.getToppingPrices()[i];
                this.cbox[i] = new CheckBox(this.config.getToppingNames()[i]);
                zutaten.add(this.cbox[i], spalte, zeile);
                System.out.println("CheckBox " + i + " erzeugt gerade" + " Spalte: " + spalte + " Zeile: " + zeile);
                System.out.println("\tPreis an für: " + this.config.getToppingNames()[i] + " beträgt: " + (this.preisZut[i] / 100) + "€");
                spalte++;
            }
            else
            {
                this.preisZut[i] = this.config.getToppingPrices()[i];
                this.cbox[i] = new CheckBox(this.config.getToppingNames()[i]);
                zutaten.add(this.cbox[i], spalte, zeile);
                System.out.println("CheckBox " + i + " erzeugt ungerade" + " Spalte: " + spalte + " Zeile: " + zeile);
                System.out.println("\tPreis an für: " + this.config.getToppingNames()[i] + " beträgt: " + (this.preisZut[i] / 100) + "€");
                spalte--;
                zeile++;
            }
        }
        // Checkbox 0 und Checkbox 1 auf true setzen & sperren
        this.cbox[0].setSelected(true);
        this.cbox[0].setDisable(true);
        this.cbox[1].setSelected(true);
        this.cbox[1].setDisable(true);
        this.cbox[0].setTextFill(Color.DARKTURQUOISE);
        this.cbox[1].setTextFill(Color.DARKTURQUOISE);

        ToggleGroup tg = new ToggleGroup();
        // Radio Buttons fuer die Groessen anlegen
        for (int a = 0; a < this.config.getSizeNames().length; a++)
        {
            this.preisGr[a] = this.config.getSizePrices()[a];
            this.rbtn[a] = new RadioButton(this.config.getSizeNames()[a]);
            this.rbtn[a].setToggleGroup(tg);
            groesse.add(this.rbtn[a], a, 0);
            System.out.println("RadioButton " + a + " Zeile: " + zeile + " erzeugt");
            System.out.println("\tPreis an für: " + this.config.getSizeNames()[a] + " beträgt: " + (this.preisGr[a] / 100) + "€");
        }
        this.rbtn[0].setSelected(true);
        // erzeuge TexArea, nicht editierbar
        TextArea ausgabe = new TextArea();
        ausgabe.setEditable(false);

        Button bestell = new Button(" Bestellen ");
        // Event Handler für button bestell
        bestell.setOnAction(new PizzaBestellActionHandler(this.preisZut, this.preisGr, this.cbox, ausgabe, this.rbtn, this.config));

        root.add(bestell, 0, 3);
        System.out.println("Bestell Button hinzugefügt");

        root.add(ausgabe, 0, 4);
        System.out.println("TexArea hinzugefügt");

    }

    public static void main(String[] args)
    {

        Configuration cnfg = new Configuration();

        for (int i = 0; i < args.length; i++)
        {

        }
        Map<String, String> parameter = null;
        ParameterConverter.createConfiguration(parameter);

        launch(args);
        System.out.println("Fenster geschlossen");
    }

}