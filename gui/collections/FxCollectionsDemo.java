package gui.collections;

import java.util.*;
import javafx.collections.*;

public class FxCollectionsDemo
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        list.add("d");
        list.add("b");
        list.add("a");
        list.add("c");

        ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener
        (
            new ListChangeListener<String>()
            {
                public void onChanged(ListChangeListener.Change<? extends String> change)
                {
                    System.out.println("Change:");
                    while (change.next())
                    {
                        System.out.println("   added? " + change.wasAdded());
                        System.out.println("   removed? " + change.wasRemoved());
                        System.out.println("   replaced? " + change.wasReplaced());
                        System.out.println("   permutated? " + change.wasPermutated());
                    }
                }
            }
        );
        FXCollections.sort(observableList);
        FXCollections.reverse(observableList);
    }
}
