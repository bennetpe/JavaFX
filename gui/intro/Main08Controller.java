package gui.intro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Main08Controller
{
    @FXML
    private void privateButtonClicked(ActionEvent e)
    {
        System.out.println("Hallo Welt (privat)");
    }

    public void publicButtonClicked(ActionEvent e)
    {
        System.out.println("Hallo Welt (öffentlich)");
    }
}