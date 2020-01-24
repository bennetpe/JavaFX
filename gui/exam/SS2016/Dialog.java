package gui.exam.SS2016;

import com.sun.prism.paint.Color;
import com.sun.prism.paint.Paint;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Dialog extends DialogPane // Ist die Parent Klasse aller
                                       // abgeleiteter Dialog Klassen
{
    private static Label teamLabel;

    private static Label scoreL;

    private Button add;

    private Button cancel;

    private Label minus;

    private Label dblquote;

    private TextField teamnameA;

    private TextField teamnameB;

    private TextField scoreA;

    private TextField scoreB;

    private Presenter p;

    private Stage dialogStage;

    private VBox vbox;

    private HBox HBoxTeamRow;

    private HBox HBoxScoreRow;

    private HBox btnGroup;

    private Pane pane;
    
    private Label validLabel;
    // merke Bei DialogPane alles an Interaktionselementen
    // in Pane und am ende Pane dem DialogChildren hinzufuegen

    public void initDialog()
    {
        pane = new Pane();
        this.setMinSize(400, 150);
        vbox = new VBox(20);
        validLabel = new Label("Ergebnis:");
        validLabel.textProperty().addListener(new ChangeListener<String>()
        {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
            {
                System.out.println("Valid Label changed");
                
            }
        });
        HBoxTeamRow = new HBox(10);
        HBoxScoreRow = new HBox(10);
        btnGroup = new HBox(10);
        dialogStage = new Stage();
        teamLabel = new Label("Teams:");
        scoreL = new Label("Ergebnis:");
        minus = new Label("-");
        dblquote = new Label(":");
        teamnameA = new TextField();
        teamnameB = new TextField();
        scoreA = new TextField();
        scoreB = new TextField();
        add = new Button("Hinzufügen");
        cancel = new Button("Abbrechen");
        btnGroup.getChildren().addAll(add, cancel);
        HBoxTeamRow.getChildren().addAll(teamLabel, teamnameA, minus, teamnameB);
        HBoxScoreRow.getChildren().addAll(scoreL, scoreA, dblquote, scoreB);
        vbox.getChildren().add(HBoxTeamRow);
        vbox.getChildren().add(HBoxScoreRow);
        vbox.getChildren().addAll(btnGroup, validLabel);
        pane.getChildren().add(vbox);
        this.getChildren().add(pane);
        dialogStage.setScene(new Scene(this));
        dialogStage.setTitle("Dialog");
        // #########Modality auf dialog initialisieren#####
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        // Action Handling der Hinzufuege und Abbrechen aufrufen
        cancelDialog();
        addScore();

    }

    // action Methoden
    public void cancelDialog()
    {
        cancel.setOnAction(e -> p.onCancelDialog());
    }

    public void addScore()
    {
        add.setOnAction(e ->
        {
            // hier eine validierung auf den Inputdes TextFeldes in JavaFX
            // umsetzen
            if (scoreA.getText().matches("[0-9]*") && scoreB.getText().matches("[0-9]*") && !(teamnameA.getText().equals(teamnameB.getText())) )
            {
                p.onAddScore(teamnameA.getText(), teamnameB.getText(), Integer.valueOf(scoreA.getText()), Integer.valueOf(scoreB.getText()));
                p.updateAllMatches();
                validLabel.setText("Ergebnis: ist erfolgreich.");
            }
            else {
               validLabel.setText("Ergebnis: ungültige Eingabe");
            }
        });
    }

    public void cancelFuntion()
    {
        dialogStage.close();
    }

    /**
     * TODO ShowAndWait fixen damit nichts klickbar ist (DONE)
     * 
     * @see dialog.initModality(Modality.APPLICATION_MODAL)
     */
    public void onShowDialog()
    {
        dialogStage.showAndWait();
    }

    public DialogPane getDialog()
    {
        return this;
    }

    public void setPresenter(Presenter p)
    {
        this.p = p;
    }

}
