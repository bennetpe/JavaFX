package gui.List;

import java.util.ArrayList;

public class List
{
    public static void main(String[] args)
    {
        final ArrayList<String> liste1 = new ArrayList<String>();
        liste1.add("Hallo ");
        liste1.add("wie ");
        liste1.add("geht ");
        liste1.add("es ");
        liste1.add("dir?");

        liste1.forEach((e -> System.out.print(e)));
    }

}
