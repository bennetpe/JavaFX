package gui.tutorial.ws20192020;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

class Country
{
    private SimpleStringProperty name, capital;
    private SimpleIntegerProperty people, area;
    
    public Country(String n, String c, int p, int a)
    {
        name = new SimpleStringProperty(n);
        capital = new SimpleStringProperty(c);
        people = new SimpleIntegerProperty(p);
        area = new SimpleIntegerProperty(a);
    }

    public SimpleStringProperty getName()
    {
        return name;
    }

    public SimpleStringProperty getCapital()
    {
        return capital;
    }

    public SimpleIntegerProperty getPeople()
    {
        return people;
    }

    public SimpleIntegerProperty getArea()
    {
        return area;
    }
}

public class CountryTableView extends Application
{
    public void start(Stage stage)
    {
        ObservableList<Country> data = FXCollections.observableArrayList();
        data.add(new Country("Deutschland", "Berlin", 83019000, 357578));
        data.add(new Country("Frankreich", "Paris", 66993000, 543965));
        data.add(new Country("Italien", "Rom", 60360000, 301338));
        data.add(new Country("Spanien", "Madrid", 46723000, 505970));
        data.add(new Country("Belgien", "Brüssel", 11376000, 30688));
        data.add(new Country("Niederlande", "Amsterdam", 17291000, 41543));
        
        TableView<Country> tv = new TableView<>(data);

        TableColumn<Country, String> nameCol = new TableColumn<>("Land");
        nameCol.setCellValueFactory(cdf -> cdf.getValue().getName());
        tv.getColumns().add(nameCol);
        
        TableColumn<Country, String> capitalCol = new TableColumn<>("Hauptstadt");
        capitalCol.setCellValueFactory(cdf -> cdf.getValue().getCapital());
        tv.getColumns().add(capitalCol);
        
        TableColumn<Country, Number> peopleCol = new TableColumn<>("Einwohner");
        peopleCol.setCellValueFactory(cdf -> cdf.getValue().getPeople());
        tv.getColumns().add(peopleCol);
        
        TableColumn<Country, Number> areaCol = new TableColumn<>("Fläche");
        areaCol.setCellValueFactory(cdf -> cdf.getValue().getArea());
        tv.getColumns().add(areaCol);
        
        TableColumn<Country, Number> densityCol = new TableColumn<>("Dichte");
        densityCol.setCellValueFactory(cdf -> cdf.getValue().getPeople().divide(cdf.getValue().getArea()));
        tv.getColumns().add(densityCol);
        
        Scene scene = new Scene(tv);
        stage.setTitle("Länder");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
