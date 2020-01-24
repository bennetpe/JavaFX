package gui.properties;

import java.io.*;
import java.text.NumberFormat;

import javafx.beans.property.*;

public class BidirectionalBindingDifferentTypes
{
    public static void main(String[] args) throws IOException
    {
        SimpleStringProperty prop1 = new SimpleStringProperty();
        SimpleIntegerProperty prop2 = new SimpleIntegerProperty();
        prop1.bindBidirectional(prop2, NumberFormat.getNumberInstance());
        
        System.out.println("Änderungen von prop1:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 1; i <= 10; i++)
        {
            System.out.print("> ");
            String newValue = br.readLine();
            prop1.set(newValue);
            System.out.println("   " + prop1.get() + 
                               " / " + prop2.get());
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
