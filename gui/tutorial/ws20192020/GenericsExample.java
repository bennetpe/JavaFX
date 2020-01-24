package gui.tutorial.ws20192020;

class Swapping
{
    public static <T> void exchange(GenericClass<T> obj1, GenericClass<T> obj2)
    {
        T t1 = obj1.getContent();
        T t2 = obj2.getContent();
        obj1.setContent(t2);
        obj2.setContent(t1);
    }
}

class GenericClass<T>
{
    private T o;

    public GenericClass(T o)
    {
        super();
        this.o = o;
    }

    public T getContent()
    {
        return o;
    }

    public void setContent(T o)
    {
        this.o = o;
    }
}

public class GenericsExample
{
    public static void main(String[] args)
    {
        GenericClass<String> gc = new GenericClass<>("huhu");
        gc.setContent("hallo");
        String s = gc.getContent();
        System.out.println(s);
        
        GenericClass<X> gc2 = new GenericClass<>(new X());
        X x = gc2.getContent();
        gc2.setContent(new Y());
        Y y = (Y)gc2.getContent();
        System.out.println(y);
        
        x = new Y();
        System.out.println(x instanceof X);
        System.out.println(x instanceof I);
        System.out.println(x instanceof Y);
        System.out.println(x instanceof Object);
        
        I i = (I) x;
        System.out.println(i);
        
        GenericClass<Y> gcy = new GenericClass<Y>(null);
        GenericClass<?> gc3 = gcy;
        System.out.println(gc3);
        //gc3.setO("hallo");
        //y = gcy.getO();
        m(gcy);
        
        GenericClass<String> o1 = new GenericClass<>("hallo"); 
        GenericClass<String> o2 = new GenericClass<>("huhu");
        Swapping.exchange(o1, o2);

        GenericClass<Integer> o3 = new GenericClass<>(17); 
        GenericClass<Integer> o4 = new GenericClass<>(23);
        Swapping.exchange(o3, o4);
        
    }
    
    private static void m(GenericClass<?> param ) {}
}

class X implements I {}
class Y extends X {}

interface I {}

class Z {}