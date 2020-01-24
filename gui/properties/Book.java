package gui.properties;

import javafx.beans.property.*;

public class Book
{
    private StringProperty title;
    private String titleString;
    private ReadOnlyStringWrapper isbn;
    
    public Book(String t, String number)
    {
        titleString = t;
        isbn = new ReadOnlyStringWrapper(this, "ISBN", number);
    }
    
    public String getTitle()
    {
        if(title == null)
        {
            return titleString;
        }
        else
        {
            return title.get();
        }
    }
    
    public void setTitle(String t)
    {
        if(title == null)
        {
            titleString = t;
        }
        else
        {
            title.set(t);
        }
    }
    
    public StringProperty titleProperty()
    {
        if(title == null)
        {
            title = new SimpleStringProperty(this, "title", titleString);
        }
        return title;
    }
    
    public String getIsbn()
    {
        return isbn.get();
    }
    
    public void setIsbn(String number)
    {
        isbn.set(number);
    }
    
    public ReadOnlyStringProperty isbnProperty()
    {
        return isbn.getReadOnlyProperty();
    }
}
