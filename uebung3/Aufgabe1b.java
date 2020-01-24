package uebung3;

import javafx.beans.property.SimpleIntegerProperty;

public class Aufgabe1b
{
    public static void main(String[] args)
    {
        SimpleIntegerProperty prop1 = new SimpleIntegerProperty();
        SimpleIntegerProperty prop2 = new SimpleIntegerProperty();
        SimpleIntegerProperty prop3 = new SimpleIntegerProperty();

        prop1.bind(prop2);
        prop1.bind(prop3);// Wird ueberschrieben

        for (int i = 1; i <= 10; i++)
        {
            int newValue = (int) (Math.random() * 100) - 50;
            if (i % 2 == 0)
            {
                prop2.set(newValue);
            }
            else
            {
                prop3.set(newValue);
            }
            System.out.println("   " + prop1.get() + " / " + prop2.get() + " / " + prop3.get());

        }
    }
}
