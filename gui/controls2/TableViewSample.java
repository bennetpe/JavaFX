package gui.controls2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableViewSample extends Application
{
    public void start(Stage stage)
    {
        Label label = new Label("Staff List");
        label.setFont(new Font("Arial", 20));

        ObservableList<Person> data = 
           FXCollections.observableArrayList
           (
               new Person("Karl-Hans", "Bläsius", "blaesius@hochschule-trier.de"), 
               new Person("Andreas", "Lux", "lux@hochschule-trier.de"), 
               new Person("Andreas", "Künkler", "kuenkler@hochschule-trier.de"), 
               new Person("Jörg", "Lohscheller", "lohscheller@hochschule-trier.de"), 
               new Person("Heinz", "Schmitz", "heinz.schmitz@hochschule-trier.de")
           );
        TableView<Person> table = new TableView<>(data);
        table.setTableMenuButtonVisible(true);

        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setPrefWidth(200);
        firstNameCol.setCellValueFactory
        (
            item -> item.getValue().firstNameProperty()
        );
        table.getColumns().add(firstNameCol);

        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setPrefWidth(200);
        lastNameCol.setCellValueFactory
        (
            item -> item.getValue().lastNameProperty()
        );
        table.getColumns().add(lastNameCol);

        TableColumn<Person, String> emailCol = new TableColumn<>("Email");
        emailCol.setPrefWidth(400);
        emailCol.setCellValueFactory
        (
            item -> item.getValue().emailProperty()
        );
        table.getColumns().add(emailCol);

        TextField addFirstName = new TextField();
        addFirstName.setPromptText("First Name");
        TextField addLastName = new TextField();
        addLastName.setPromptText("Last Name");
        TextField addEmail = new TextField();
        addEmail.setPromptText("Email");

        Button addButton = new Button("Add");
        addButton.setOnAction
        (
            (ActionEvent e) -> 
            {
                data.add(new Person(addFirstName.getText(), addLastName.getText(), addEmail.getText()));
                addFirstName.clear();
                addLastName.clear();
                addEmail.clear();
            }
        );

        HBox hb = new HBox();
        hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton);
        hb.setSpacing(3);

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction
        (
            (ActionEvent e) -> 
            {
                Person p = table.getSelectionModel().getSelectedItem();
                if(p != null)
                {
                    table.getItems().remove(p);
                }
            }
        );

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb, deleteButton);

        Scene scene = new Scene(vbox, 820, 500);
        stage.setTitle("Table View Sample");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}