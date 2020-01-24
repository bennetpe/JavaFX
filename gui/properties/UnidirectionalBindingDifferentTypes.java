package gui.properties;

import javafx.beans.property.*;

public class UnidirectionalBindingDifferentTypes
{
    public static void main(String[] args)
    {
        SimpleIntegerProperty prop1 = new SimpleIntegerProperty();
        SimpleDoubleProperty prop2 = new SimpleDoubleProperty();
        prop1.bind(prop2);
        
        System.out.println("Änderungen von prop2:");
        for(int i = 1; i <= 10; i++)
        {
            double newValue = Math.random()*100 - 50;
            prop2.set(newValue);
            System.out.println("   " + prop1.get() + 
                               " / " + prop2.get());
        }
    }
}
