package uebung3;

import javafx.beans.property.SimpleIntegerProperty;

public class Aufgabe1d
{

    public static void main(String[] args)
    {
        SimpleIntegerProperty prop1 = new SimpleIntegerProperty();
        SimpleIntegerProperty prop2 = new SimpleIntegerProperty();
        SimpleIntegerProperty prop3 = new SimpleIntegerProperty();
        SimpleIntegerProperty prop4 = new SimpleIntegerProperty();

        prop1.bind(prop2);
        prop2.bind(prop3);
        prop3.bind(prop4);
        prop4.bind(prop1);

        for (int i = 1; i <= 10; i++)
        {
            int newValue = (int) (Math.random() * 100) - 50;

            prop4.set(newValue);

            System.out.println("   " + prop1.get() + " / " + prop2.get() + " / " + prop3.get());
            // Kein Rekursionsanker
        }
    }
}