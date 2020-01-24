package gui.tutorial.ws20192020;

import java.util.*;

public class MyIntProperty
{
    private int value;
    private List<MyChangeListener> listeners;

    public MyIntProperty()
    {
        listeners = new ArrayList<MyChangeListener>();
    }
    
    public int getValue()
    {
        return value;
    }

    public void setValue(int newValue)
    {
        if(newValue == this.value)
        {
            return;
        }
        int oldValue = this.value;
        this.value = newValue;
        for(MyChangeListener l: listeners)
        {
            l.changed(this, oldValue, newValue);
        }
    }

    public void addChangeListener(MyChangeListener l)
    {
        listeners.add(l);
    }

    public void removeChangeListener(MyChangeListener l)
    {
        listeners.remove(l);
    }
    
    public static void main(String[] args)
    {
        System.out.println("Länge von args: " + args.length);
        for(String s: args)
        {
            System.out.println("   " + s);
        }
        MyIntProperty prop = new MyIntProperty();
        prop.setValue(11);
        System.out.println("Prop hat den Wert " + prop.getValue());
        MyChangeListener l1 = new ChangeListener1();
        prop.addChangeListener(l1);
        MyChangeListener l2 = new ChangeListener2();
        prop.addChangeListener(l2);
        prop.setValue(12);
        prop.setValue(12);
        MyChangeListener l3 = (MyIntProperty p, int oldValue, int newValue)
          -> System.out.println(oldValue + " wurde geändert zu " + newValue + " (LAMBDA)");
        prop.addChangeListener(l3);
        prop.setValue(13);
        prop.removeChangeListener(l1);
        prop.removeChangeListener(l2);
        prop.removeChangeListener(l3);
        prop.setValue(14);
        System.out.println("Prop hat den Wert " + prop.getValue());
    }
}

class ChangeListener1 implements MyChangeListener
{
    @Override
    public void changed(MyIntProperty prop, int oldValue, int newValue)
    {
        System.out.println(oldValue + " => " + newValue);
    }    
}

class ChangeListener2 implements MyChangeListener
{
    @Override
    public void changed(MyIntProperty prop, int oldValue, int newValue)
    {
        System.out.println(oldValue + " wurde geändert zu " + newValue);
    }    
}