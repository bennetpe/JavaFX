package gui.mvp.contact.detail;

import gui.mvp.contact.main.MainPresenter;
import gui.mvp.contact.model.Contact;
import gui.mvp.contact.model.ContactModel;

public class DetailPresenter
{
    private DetailView view;
    private MainPresenter mainPresenter;
    private ContactModel contactModel;

    public DetailPresenter()
    {
    }

    public void setView(DetailView view)
    {
        this.view = view;
    }
    
    public DetailView getView()
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

    public void setContact(Contact contact)
    {
        view.showContact(contact);
    }

    public void save()
    {
        Contact updatedContact = view.getContact();
        contactModel.updateContact(updatedContact);
        mainPresenter.showOverviewView();
    }

    public void cancel()
    {
        mainPresenter.showOverviewView();
    }
}
