package gui.country.combo;

import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UI extends Application
{
    private GridPane root = new GridPane();

    private GridPane labels = new GridPane();

    private HBox field = new HBox();

    private GridPane showTable = new GridPane();

    private CheckBox box = new CheckBox("exakte Angaben");

    private DecimalFormat df = new DecimalFormat(",### ");

    private ObservableList<Country> list = FXCollections.observableArrayList();

    private Button add = new Button("Hinzufügen");

    private Button delete = new Button("Löschen");

    @Override
    public void start(Stage primaryStage)
    {

        this.list.add(new Country("Schweden", "Stockholm", 9747355, 447420));
        this.list.add(new Country("Spanien", "Madrid", 46439864, 505970));
        this.list.add(new Country("Somalia", "Mogadischu", 12900000, 637657));

        ComboBox<Country> cb = new ComboBox<>(this.list);
        cb.getSelectionModel().selectFirst();
        this.root.add(cb, 0, 0);
        this.root.add(this.showTable, 0, 1);
        this.root.add(this.box, 0, 2);
        this.root.add(this.labels, 0, 4);
        this.root.add(this.field, 0, 8);
        this.root.add(this.delete, 0, 9);
        this.root.setPadding(new Insets(10));

        this.labels.add(new Label("Land:"), 0, 0);
        this.labels.add(new Label("Hauptstadt:"), 0, 1);
        this.labels.add(new Label("Einwohner:"), 0, 2);
        this.labels.add(new Label("Fläche (in qkm):"), 0, 3);
        this.labels.add(new Label("Bevölkerungsdichte (in Personen pro qkm):"), 0, 4);

        Label name = new Label(cb.getValue().getName());
        Label capital = new Label(cb.getValue().getCapital());
        Label people = new Label(cb.getValue().getRoundPeople());
        Label area = new Label(cb.getValue().getRoundArea());
        Label bd = new Label(cb.getValue().getDichte());

        this.labels.add(name, 1, 0);
        this.labels.add(capital, 1, 1);
        this.labels.add(people, 1, 2);
        this.labels.add(area, 1, 3);
        this.labels.add(bd, 1, 4);
        this.labels.setHgap(10);

        // Listener für cbBox
        cb.valueProperty().addListener(new ChangeListener<Country>()
        {
            @Override
            public void changed(ObservableValue<? extends Country> observable, Country oldValue, Country newValue)
            {
                try
                {
                    if (UI.this.box.isSelected())
                    {
                        name.setText(newValue.getName());
                        capital.setText(newValue.getCapital());
                        people.setText(UI.this.df.format(cb.getValue().getPeople()) + "");
                        area.setText(UI.this.df.format(cb.getValue().getArea()) + "");
                        bd.setText(newValue.getDichte());

                    }
                    else
                    {
                        name.setText(newValue.getName());
                        capital.setText(newValue.getCapital());
                        people.setText(newValue.getRoundPeople() + "");
                        area.setText(newValue.getRoundArea());
                        bd.setText(newValue.getDichte());
                    }
                }
                catch (Exception nullPointer)
                {

                }
            }

        });

        this.box.selectedProperty().addListener((ChangeListener<Boolean>) (combo, oldValue, newValue) ->
        {
            if (newValue)
            {
                people.setText(this.df.format(cb.getValue().getPeople()) + "");
                area.setText(this.df.format(cb.getValue().getArea()) + "");
            }
            else
            {
                people.setText(cb.getValue().getRoundPeople() + "");
                area.setText(cb.getValue().getRoundArea() + "");
            }
        });

        // Erzeuge Textfeld Objekte
        TextField countryField = new TextField();
        TextField capitalField = new TextField();
        TextField peopleField = new TextField();
        TextField areaField = new TextField();
        // setze Start text
        countryField.setPromptText("Land");
        capitalField.setPromptText("Hauptstadt");
        peopleField.setPromptText("Einwohner");
        areaField.setPromptText("Fläche");

        this.field.getChildren().addAll(countryField, capitalField, peopleField, areaField, this.add);

        this.add.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                if (countryField.getText().matches("[^0-9][A-Za-z \t-ÄÖÜäöü]+") && capitalField.getText().matches("[^0-9][A-Za-z \t-ÄÖÜäöü]+") && peopleField.getText().matches("[0-9]+") && areaField.getText().matches("[0-9]+") && countryField.getText() != null && capitalField.getText() != null && peopleField.getText() != null && areaField.getText() != null)
                {
                    try
                    {
                        UI.this.list.add(new Country(countryField.getText(), capitalField.getText(), Long.valueOf(peopleField.getText()), Long.valueOf(areaField.getText())));
                        countryField.clear();
                        capitalField.clear();
                        peopleField.clear();
                        areaField.clear();
                        cb.getSelectionModel().select(0);
                    }
                    catch (Exception wrongInput)
                    {
                    }
                }
                else
                {
                    // Fenster
                    GridPane fehler = new GridPane();
                    fehler.setVgap(5);
                    fehler.setPadding(new Insets(10));

                    Label head = new Label("Bitte überprüfen Sie ihre Eingabe!");
                    Label info = new Label("Folgende Zeichen sind erlaubt:");
                    Label luc = new Label("Land und Hauptstadt:");
                    Label luckrit = new Label("[A-Z,a-z,-,Leerzeichen]");
                    Label pua = new Label("Bewohner und Fläche");
                    Label puakrit = new Label("[0-9]");

                    head.setTextFill(Color.RED);
                    luckrit.setTextFill(Color.BLUE);
                    puakrit.setTextFill(Color.BLUE);

                    fehler.add(head, 0, 0);
                    fehler.add(info, 0, 1);
                    fehler.add(luc, 0, 2);
                    fehler.add(luckrit, 1, 2);
                    fehler.add(pua, 0, 3);
                    fehler.add(puakrit, 1, 3);

                    Stage secondStage = new Stage();
                    Scene neu = new Scene(fehler);
                    secondStage.setScene(neu);
                    secondStage.setTitle("Falsche Eingabe");
                    secondStage.show();

                }
            }
        });
        // Delete Button
        this.delete.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {

                UI.this.list.remove(cb.getValue());
                cb.getSelectionModel().select(0);

                if (cb.getValue() == null)
                {
                    name.setText("");
                    capital.setText("");
                    people.setText("");
                    area.setText("");
                    bd.setText("");
                    cb.setPromptText("Keine Länder vorhanden");
                }
            }
        });
        // table button

        Scene scene = new Scene(this.root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Länder Information");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);

    }
}
