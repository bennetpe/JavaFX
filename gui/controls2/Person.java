package gui.controls2;

import javafx.beans.property.SimpleStringProperty;

public class Person
{
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty email;

    public Person(String fName, String lName, String email)
    {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.email = new SimpleStringProperty(email);
    }
    
    public SimpleStringProperty firstNameProperty()
    {
        return firstName;
    }

    public SimpleStringProperty lastNameProperty()
    {
        return lastName;
    }
    
    public SimpleStringProperty emailProperty()
    {
        return email;
    }
    
    public String toString()
    {
        return firstNameProperty().get() + " " +
               lastNameProperty().get();
    }
}

