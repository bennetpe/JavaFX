package gui.tutorial.ws20192020;

class A {}
class B {}

public class GenericsMethod
{
    @SuppressWarnings("unchecked")
    public static <T> T load(int i)
    {
        switch(i)
        {
            case 1: 
                return (T) new String("hallo");
            case 2:
                return (T) new A();
            case 3:
                return (T) new B();
            default:
                return null;
        }
    }

    public static void main(String[] args)
    {
        A a = load(2);
        System.out.println(a);
        String s = load(1);
        System.out.println(s);
    }
}
