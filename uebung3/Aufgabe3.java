package uebung3;

import java.util.ArrayList;
import java.util.LinkedList;

public final class Aufgabe3
{

    private int[] count = new int[5000000];

    private LinkedList<Integer> llist = new LinkedList<>();

    private ArrayList<Integer> alist = new ArrayList<>();

    public void start()
    {
        long start, end, time;
        start = System.currentTimeMillis();
        // Aktion, die gemessen werden soll: ...
        for (int i = 0; i < this.count.length; i++)
        {
            this.llist.add(0, 1);

        }
        end = System.currentTimeMillis();
        time = end - start; // time: gemessene Zeit
        System.out.println(time + "LinkedList");// print time

    }

    public void start2()
    {
        long start, end, time2 = 0;
        start = System.currentTimeMillis();
        // Aktion, die gemessen werden soll: ...
        for (int i = 0; i < this.count.length; i++)
        {
            this.alist.add(0);

        }
        end = System.currentTimeMillis();

        time2 = end - start; // time: gemessene Zeit
        System.out.println(time2 + "ArrayList");// print time

    }

    public void loeschen()
    {

    }

    public static void main(String[] args)
    {
        Aufgabe3 test = new Aufgabe3();
        test.start();
        test.start2();
    }
}
