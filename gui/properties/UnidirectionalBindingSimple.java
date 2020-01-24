package gui.properties;

import javafx.beans.property.*;

public class UnidirectionalBindingSimple
{
    public static void main(String[] args)
    {
        SimpleIntegerProperty prop1 = new SimpleIntegerProperty();
        SimpleIntegerProperty prop2 = new SimpleIntegerProperty();
        prop1.bind(prop2);
        
        System.out.println("Änderungen von prop1:");
        try
        {
            for(int i = 1; i <= 10; i++)
            {
                int newValue = (int)(Math.random()*100) - 50;
                prop1.set(newValue);
                System.out.println("   " + prop1.get() + 
                                   " / " + prop2.get());
            }
        }
        catch(Exception e)
        {
            System.out.println("   scheint nicht zu funktionieren");
        }

        System.out.println("Änderungen von prop2:");
        for(int i = 1; i <= 10; i++)
        {
            int newValue = (int)(Math.random()*100) - 50;
            prop2.set(newValue);
            System.out.println("   " + prop1.get() + 
                               " / " + prop2.get());
        }
    }
}
