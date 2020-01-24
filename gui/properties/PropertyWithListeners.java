package gui.properties;

import javafx.beans.property.*;
import javafx.beans.value.*;

class MySimpleChangeListener implements ChangeListener<Number>
{
    public void changed(ObservableValue<? extends Number> observable,
                        Number oldValue, Number newValue)
    {
        System.out.println(">>>changed from " + oldValue + " to " + newValue);
    }
}

public class PropertyWithListeners
{
    public static void main(String[] args)
    {
        SimpleIntegerProperty prop = new SimpleIntegerProperty();
        MySimpleChangeListener listener = new MySimpleChangeListener();
        prop.addListener(listener);
        prop.addListener
        ((ObservableValue<? extends Number> observable,
          Number oldValue, Number newValue)
          ->System.out.println("+++changed from " + 
                               oldValue + " to " + 
                               newValue));
        prop.addListener((o, oldValue, newValue)
                         ->System.out.println("***changed from " + 
                                              oldValue + " to " + 
                                              newValue));
        prop.addListener(PropertyWithListeners::changedMethod);

        for(int i = 1; i <= 20; i++)
        {
            int newValue = (int)(Math.random()*10) - 5;
            System.out.println("changing to " + newValue);
            prop.set(newValue);            
        }
    }
    
    private static void changedMethod(ObservableValue<? extends Number> observable,
                                      Number oldValue, Number newValue)
    {
        System.out.println("###changed from " + oldValue + " to " + newValue);
    }
}
