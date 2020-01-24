package gui.mvp.contact.overview;

import java.util.List;
import gui.mvp.contact.main.MainPresenter;
import gui.mvp.contact.model.Contact;
import gui.mvp.contact.model.ContactModel;

public class OverviewPresenter
{
    private OverviewView view;
    private MainPresenter mainPresenter;
    private ContactModel contactModel;

    public OverviewPresenter()
    {
    }
    
    public void setView(OverviewView view)
    {
        this.view = view;
    }
    
    public OverviewView getView()
    {
        return view;
    }

    public void setMainPresenter(MainPresenter mainPresenter)
    {
        this.mainPresenter = mainPresenter;
    }

    public void setContactModel(ContactModel contactModel)
    {
        this.contactModel = contactModel;
    }

    public void search()
    {
        String searchPhrase = view.getSearchPhrase();
        final String[] keywords = searchPhrase.split("\\s+");
        List<Contact> hits = contactModel.searchContacts(keywords);
        view.showSearchResults(hits);
    }

    public void contactSelected(Contact contact)
    {
        mainPresenter.showDetailView(contact);
    }
}
