package gui.exam.SS2016;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class View extends BorderPane
{
    private HBox listViewHBoxes;

    private ObservableList<ScoreEntry> observableListScore;

    private ObservableList<Match> observableMatchList;

    private ListView<ScoreEntry> listViewScore;

    private ListView<Match> listViewMatch;

    private Button neuesSpielErgebnis;

    private Button spielErgebnisL�schen;

    private HBox buttonGroup;

    private Presenter p;

    public void setP(Presenter p)
    {
        this.p = p;
    }

    public View()
    {
    }

    public void deleteMatch(Match m)
    {
        if (observableMatchList.size() > 0 && m != null)
        {
            p.deleteMatch(m);
            observableMatchList.remove(listViewMatch.getSelectionModel().getSelectedItem());
        }
    }

    public void addMatch(Match m)
    {
        listViewMatch.getItems().add(m);
    }

    public void updateScores(ScoreEntry[] allScores)
    {
    	listViewScore.getItems().clear();
    	listViewScore.getItems().addAll(allScores);
    }

    public void initView()
    {
        buttonGroup = new HBox(10);
        listViewScore = new ListView<ScoreEntry>();
        p.fillScoreList();
        listViewMatch = new ListView<Match>();
        p.fillMatchList();
        listViewHBoxes = new HBox(10);
        neuesSpielErgebnis = new Button("Neues Spielergebnis");
        spielErgebnisL�schen = new Button("Spiel Ergebnis L�schen");
        listViewScore.setItems(observableListScore);
        listViewMatch.setItems(observableMatchList);
        listViewHBoxes.getChildren().addAll(listViewMatch, listViewScore);
        this.setCenter(listViewHBoxes);
        buttonGroup.getChildren().addAll(neuesSpielErgebnis, spielErgebnisL�schen);
        this.setBottom(buttonGroup);
        neuesSpielErgebnis.setOnAction(e ->
        {
            p.showDialog();
        });
        spielErgebnisL�schen.setOnAction(e -> deleteMatch(listViewMatch.getSelectionModel().getSelectedItem()));
    }

    public Parent getView()
    {
        return this;
    }

    public void setScoreList(ScoreEntry[] allScores)
    {
        observableListScore = FXCollections.observableArrayList(allScores);
    }

    public void setMatchList(Match[] allMatches)
    {
        observableMatchList = FXCollections.observableArrayList(allMatches);
    }

    public void setPresenter(Presenter p)
    {
        this.p = p;
    }

}
