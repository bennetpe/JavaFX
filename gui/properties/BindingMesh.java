package gui.properties;

import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.beans.value.*;

public class BindingMesh
{
    public static void main(String[] args)
    {
        SimpleIntegerProperty num1 = new SimpleIntegerProperty(1);
        SimpleIntegerProperty num2 = new SimpleIntegerProperty(2);
        SimpleIntegerProperty num3 = new SimpleIntegerProperty(3);
        SimpleIntegerProperty num4 = new SimpleIntegerProperty(4);
        
        NumberBinding total = 
            num1.add(num2).multiply(num3.add(num4));
//        NumberBinding total =
//            Bindings.multiply(Bindings.add(num1, num2), Bindings.add(num3, num4));
//        NumberBinding total =
//            Bindings.multiply(num1.add(num2),num3.add(num4));
        BooleanBinding bb = total.isEqualTo(0);
        total.addListener(new ChangeListener<Number>()
        {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                System.out.println(">>>total changed from " + oldValue + " to " + newValue);
            }
        }
        );
        bb.addListener(new ChangeListener<Boolean>()
        {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                System.out.println(">>>boolean changed from " + oldValue + " to " + newValue);
            }
        }
        );

        System.out.println("Start:");
        System.out.println("total = " + total.getValue() +
                           ", equals(0) = " + bb.getValue());
        System.out.println("==============");
        
        System.out.println("Setting num1 to 10:");
        num1.setValue(10);
        System.out.println("total = " + total.getValue() +
                           ", equals(0) = " + bb.getValue());
        System.out.println("==============");
        
        System.out.println("Setting num2 to 20:");
        num2.setValue(20);
        System.out.println("total = " + total.getValue() +
                           ", equals(0) = " + bb.getValue());
        System.out.println("==============");

        System.out.println("Setting num3 to 30:");
        num3.setValue(30);
        System.out.println("total = " + total.getValue() +
                           ", equals(0) = " + bb.getValue());
        System.out.println("==============");

        System.out.println("Setting num4 to -30:");
        num4.setValue(-30);
        System.out.println("total = " + total.getValue() +
                           ", equals(0) = " + bb.getValue());
        System.out.println("==============");
    }
}
