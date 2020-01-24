package uebung3;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

@SuppressWarnings("rawtypes")
class MySimpleChangeListenerX implements ChangeListener
{
    private SimpleIntegerProperty prop3;

    private SimpleIntegerProperty prop2;

    public MySimpleChangeListenerX(SimpleIntegerProperty prop2, SimpleIntegerProperty prop3)
    {
        this.prop2 = prop2;
        this.prop3 = prop3;
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue)
    {
        this.prop2.setValue((Number) newValue);
        this.prop3.setValue((Number) newValue);
    }
}

public class Aufgabe1c
{
    public static void main(String[] args)
    {
        SimpleIntegerProperty property1 = new SimpleIntegerProperty();
        SimpleIntegerProperty property2 = new SimpleIntegerProperty();
        SimpleIntegerProperty property3 = new SimpleIntegerProperty();

        MySimpleChangeListenerX listener = new MySimpleChangeListenerX(property2, property3);
        property1.addListener(listener);

        for (int i = 1; i <= 10; i++)
        {
            int newValue = (int) (Math.random() * 100) - 50;
            property1.set(newValue);
            System.out.println("   " + property1.get() + " / " + property2.get() + " / " + property3.get());

        }
    }
}
