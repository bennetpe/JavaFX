package gui.exam.soccer.fin;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Dialog extends DialogPane
{
    private Presenter presenter;

    private View view;

    public void setView(View view)
    {
        this.view = view;
    }

    private TextField teamHome;

    private TextField teamGuest;

    private TextField goalsHome;

    private TextField goalsGuest;

    private Stage secondaryStage;

    private Label fehler;

    public Dialog()
    {

    }

    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }

    public void showDialog()
    {
        // match = new Match("test", "trier", 1, 0);
        GridPane gridPane = new GridPane();

        Button hinzufuegen = new Button("Hinzufügen");

        Button abbrechen = new Button("Abbrechen");

        fehler = new Label();

        teamHome = new TextField();
        goalsHome = new TextField();
        teamGuest = new TextField();
        goalsGuest = new TextField();

        gridPane.add(new Label("Teams:"), 0, 0);
        gridPane.add(teamHome, 1, 0);
        gridPane.add(new Label("-"), 2, 0);
        gridPane.add(teamGuest, 3, 0);
        gridPane.add(new Label("Ergebnis:"), 0, 1);
        gridPane.add(goalsHome, 1, 1);
        gridPane.add(new Label(":"), 2, 1);
        gridPane.add(goalsGuest, 3, 1);

        gridPane.add(hinzufuegen, 0, 2);
        gridPane.add(abbrechen, 1, 2);
        gridPane.add(fehler, 0, 3);

        hinzufuegen.setOnAction(e -> matchHinzufuegen());
        abbrechen.setOnAction(e -> {

            secondaryStage.close();
        });

        Scene scene2 = new Scene(gridPane, 500, 600);
        secondaryStage = new Stage();
        secondaryStage.setScene(scene2);
        secondaryStage.initModality(Modality.APPLICATION_MODAL);
        secondaryStage.setTitle("Dialog");
        secondaryStage.showAndWait();

    }

    public void matchHinzufuegen()
    {

        try
        {
            int goalsH = Integer.parseInt(goalsHome.getText());
            int goalsG = Integer.parseInt(goalsGuest.getText());
            Match neuesMatch = new Match(teamHome.getText(), teamGuest.getText(), goalsH, goalsG);

            presenter.addMatch(neuesMatch);

            secondaryStage.close();

        }

        catch (IllegalArgumentException e)
        {
            if (e.getMessage().contains("input"))
            {
                fehler.setText("Ergbnis: Ungültige Eingabe");
            }
            else
            {
                fehler.setText(e.getMessage());

            }

        }

    }

}
