package uebung3;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Created by Bennet Pieper
 * */
public class Aufgabe2
{

    public static void main(String[] args)
    {
        SimpleIntegerProperty num1 = new SimpleIntegerProperty(1);
        SimpleIntegerProperty num2 = new SimpleIntegerProperty(2);
        NumberBinding total = num1.multiply(num1).add(num2.multiply(num2));

        num2.addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {

                System.out.println("Num2 Value Changed from " + newValue + " to " + (num2.intValue() * num2.intValue()));

            }
        });

        num1.addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                System.out.println("Num1 Value Changed from " + newValue + " to " + (num1.intValue() * num1.intValue()));

            }
        });

        num1.set(5);
        num2.set(10);
        System.out.println("a²+b² = " + total.getValue());
        num1.set(2);
        num2.set(11);
        System.out.println("a²+b² = " + total.getValue());
        num1.set(52);
        num2.set(80);
        System.out.println("a²+b² = " + total.getValue());

    }
}
