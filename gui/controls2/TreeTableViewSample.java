package gui.controls2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TreeTableViewSample extends Application
{
    public void start(Stage stage)
    {
        Person p;
        p = new Person("HS Trier", "", ""); 
        TreeItem<Person> rootNode = new TreeItem<>(p);
        
        p = new Person("FB", "Informatik", 
                       "sekretariat@informatik.hochschule-trier.de"); 
        TreeItem<Person> fbi = new TreeItem<>(p);
        p = new Person("Andreas", "Lux", 
                       "lux@hochschule-trier.de"); 
        fbi.getChildren().add(new TreeItem<Person>(p));
        p = new Person("Andreas", "Künkler",
                       "kuenkler@hochschule-trier.de"); 
        fbi.getChildren().add(new TreeItem<Person>(p));
        p = new Person("Jörg", "Lohscheller", 
                       "lohscheller@hochschule-trier.de"); 
        fbi.getChildren().add(new TreeItem<Person>(p));
        p = new Person("Heinz", "Schmitz", 
                       "heinz.schmitz@hochschule-trier.de");
        rootNode.getChildren().add(fbi);
        
        p = new Person("FB", "Wirtschaft", 
                       "sekretariat@wirtschaft.hochschule-trier.de"); 
        TreeItem<Person> fbw = new TreeItem<>(p);
        p = new Person("Helge", "Rieder", 
                       "rieder@hochschule-trier.de"); 
        fbw.getChildren().add(new TreeItem<Person>(p));
        p = new Person("Dieter", "Steinmann",
                       "steinmann@hochschule-trier.de"); 
        fbw.getChildren().add(new TreeItem<Person>(p));
        p = new Person("Wilhelm", "Steinbuß", 
                       "steinbuss@hochschule-trier.de"); 
        rootNode.getChildren().add(fbw);

        TreeTableView<Person> treeTable = new TreeTableView<>(rootNode);
        TreeTableColumn<Person, String> firstNameCol = new TreeTableColumn<>("First Name");
        firstNameCol.setPrefWidth(200);
        firstNameCol.setCellValueFactory
        (
            item -> item.getValue().getValue().firstNameProperty()
        );
        treeTable.getColumns().add(firstNameCol);

        TreeTableColumn<Person, String> lastNameCol = new TreeTableColumn<>("Last Name");
        lastNameCol.setPrefWidth(200);
        lastNameCol.setCellValueFactory
        (
            item -> item.getValue().getValue().lastNameProperty()
        );
        treeTable.getColumns().add(lastNameCol);
        //treeTable.setTreeColumn(lastNameCol);

        TreeTableColumn<Person, String> emailCol = new TreeTableColumn<>("Email");
        emailCol.setPrefWidth(400);
        emailCol.setCellValueFactory
        (
            item -> item.getValue().getValue().emailProperty()
        );
        treeTable.getColumns().add(emailCol);
        
        Label status = new Label();
        
        treeTable.getSelectionModel().selectedItemProperty().addListener
        (
            (ov, oldValue, newValue) ->
            {
                String fName = newValue.getValue().firstNameProperty().get();
                String lName = newValue.getValue().lastNameProperty().get();
                String email = newValue.getValue().emailProperty().get();
                status.setText("selected: " + fName + " " +
                               lName + " (" + email + ")");
            }
        );

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(treeTable, status);

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