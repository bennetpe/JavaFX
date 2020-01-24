package gui.properties;

import javafx.beans.property.*;
import javafx.beans.value.*;

@SuppressWarnings("rawtypes")
class MySimpleChangeListenerXyz implements ChangeListener
{
    public void changed(ObservableValue observable,
                        Object oldValue, Object newValue)
    {
        System.out.println(">>>changed from " + oldValue + " to " + newValue);
    }
}

public class PropertyWithListenersWithoutGenerics
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        SimpleIntegerProperty prop = new SimpleIntegerProperty();
        MySimpleChangeListenerXyz listener = new MySimpleChangeListenerXyz();
        prop.addListener(listener);

        for(int i = 1; i <= 10; i++)
        {
            int newValue = (int)(Math.random()*100) - 50;
            prop.set(newValue);            
        }
    }
}
