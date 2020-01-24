package gui.List;

/**
 * 
 * @author bennet
 *
 */
public class Liste
{
    /**
     * Instanz Variablen
     */
    private static String[] list = new String[5];

    private static String[] list2 = new String[15];

    private static int cnt = 0;

    /**
     * Konstruktor nimmt ein E entgegen
     * 
     * @param list
     */
    public Liste(String[] list)
    {
        Liste.list = list;
    }

    public void add(String[] msg, String message)
    {
        try
        {
            msg[cnt] = message;
            cnt++;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {

        }

    }

    public static void main(String[] args)
    {
        Liste test = new Liste(list2);
        test.add(list2, "hallo");
        test.add(list2, "hallo");
        test.add(list2, "hallo");
        test.add(list2, "hallo");
        test.add(list2, "hallo");
        test.add(list2, "hallo");
        test.add(list2, "hallo");

        // test.forEach((e -> System.out.println(e)));

        for (String e : list)
        {
            if (e == null)
                break;
            else
                System.out.println(e);
        }

    }

}
