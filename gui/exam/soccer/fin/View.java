package gui.exam.soccer.fin;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View extends VBox
{
    private Presenter presenter;

    private Dialog dialog;

    private ListView<Match> matchesListView;

    private ListView<ScoreEntry> scoreEntryListView;

    private HBox listen;

    private HBox buttons;

    public View()
    {
        initView();
    }

    public void initView()
    {
        listen = new HBox();
        buttons = new HBox();

        matchesListView = new ListView<Match>();
        scoreEntryListView = new ListView<ScoreEntry>();

        Button neuesSpielergebnis = new Button("Neues Spielergebnis");
        Button loeschenSpielergebnis = new Button("Spielergebnis löschen");

        neuesSpielergebnis.setOnAction(e -> dialog.showDialog());
        loeschenSpielergebnis.setOnAction(e -> {
            if (matchesListView.getSelectionModel().getSelectedItem() != null)
            {

                presenter.deleteMatch(matchesListView.getSelectionModel().getSelectedItem());
            }

        });

        listen.getChildren().add(matchesListView);
        listen.getChildren().add(scoreEntryListView);

        buttons.getChildren().add(neuesSpielergebnis);
        buttons.getChildren().add(loeschenSpielergebnis);

        getChildren().add(listen);
        getChildren().add(buttons);

    }

    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }

    public void setDialog(Dialog dialog)
    {
        this.dialog = dialog;
    }

    public void addMatch(Match match)
    {
        matchesListView.getItems().add(match);
    }

    public void deleteMatch(Match match)
    {
        matchesListView.getItems().remove(match);
    }

    public void updateScores(ScoreEntry[] scoreEntry)
    {

        scoreEntryListView.getItems().clear();

        scoreEntryListView.getItems().addAll(scoreEntry);
    }

}
