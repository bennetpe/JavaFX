package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author bennet
 * @about Hier prüfen wir das Laufzeitverhalten für ArrayList und LinkedList
 */
public class Laufzeitcheck
{
    // Listen erstellen Objekt Attribute
    static private List<String> linkedList = new LinkedList<>();

    static private List<String> arrayList = new ArrayList<>();

    // Add Methode für beide Listen definieren
    public static void addLListElementVorne(String element)
    {

        linkedList.add(element);

    }

    public static void addAListElementVorne(String element)
    {

        arrayList.add(element);

    }

    public static void addLListElementMitte(String element)
    {

        linkedList.add(linkedList.size() / 2, element);

    }

    public static void addAListElementMitte(String element)
    {

        arrayList.add(arrayList.size() - 1 / 2, element);

    }

    public static void addLListElementEnde(String element)
    {

        linkedList.add(linkedList.size() - 1, element);

    }

    public static void addAListElementEnde(String element)
    {

        arrayList.add(arrayList.size() - 1, element);

    }

    // Methoden zum Löschen von Elementen definieren
    public static void deleteLListFirstElement()
    {

        linkedList.remove(0);

    }

    public static void deleteAListFirstElement()
    {

        arrayList.remove(0);

    }

    public static void deleteLListLastElement()
    {

        linkedList.remove(linkedList.size() - 1);

    }

    public static void deleteAListLastElement()
    {

        arrayList.remove(arrayList.size() - 1);

    }

    // Zugriffsmethoden für die ELemente der Listen / Getter

    public static String getFirstLListElement()
    {

        return linkedList.get(0);

    }

    public static String getFirstAListELement()
    {

        return arrayList.get(0);

    }

    public static String getLastLListElement()
    {
        return linkedList.get(linkedList.size() - 1);

    }

    public static String getLastAListElement()
    {

        return arrayList.get(arrayList.size() - 1);
    }

    public static String getMiddleLListElement()
    {

        return linkedList.get((linkedList.size() - 1) / 2);

    }

    public static String getMiddleAListElement()
    {

        return arrayList.get(arrayList.size() - 1 / 2);
    }

    public static void main(String[] args)
    {
        // Hinzufügen von Elementen
        long start, end, time;
        start = System.currentTimeMillis();
        for (int i = 0; i <= 100000; i++)
        {
            // Hier die verschieden Methoden zur Laufzeitmessung einsetzen
            addAListElementMitte("Element");

        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("gemessene Zeit füllen ArrayList: " + time + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i <= 100000; i++)
        {
            // Hier die verschieden Methoden zur Laufzeitmessung einsetzen
            addLListElementMitte("Element");

        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("gemessene Zeit füllen LinkedList: " + time + "ms");

        // LinkedList zugriff erste Element
        start = System.currentTimeMillis();
        getFirstLListElement();
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("gemessene Zeit zugriff erste Element LL: " + time + "ms");

        // LinkedList zugriff auf das letzte Element
        start = System.currentTimeMillis();
        getLastLListElement();
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("gemessene Zeit zugriff letzte Element LL: " + time + "ms");

        // ArrayList zugriff auf das letzte Element
        start = System.currentTimeMillis();
        getLastAListElement();
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("gemessene Zeit zugriff letze Element AL: " + time + "ms");

        // ArrayList zugriff auf das erste Element
        start = System.currentTimeMillis();
        getFirstAListELement();
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("gemessene Zeit für zugriff erste Element AL: " + time + "ms");

        // löschen des letzten LL Elements
        start = System.currentTimeMillis();
        deleteLListLastElement();
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Löschen des letzten Objekts bei LL: " + time + "ms");

        // löschen des letzten AL Elements
        start = System.currentTimeMillis();
        deleteAListLastElement();
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Löschen des letzten Objekts bei AL: " + time + "ms");

        // löschen des ersten Elements AL
        start = System.currentTimeMillis();
        deleteAListFirstElement();
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Löschen des ersten Objekts bei AL: " + time + "ms");

        // löschen des ersten Elements LL
        start = System.currentTimeMillis();
        deleteLListFirstElement();
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Löschen des ersten Objekts bei LL: " + time + "ms");
        System.err.println(linkedList.size());

    }
}
