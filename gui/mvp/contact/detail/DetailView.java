package gui.mvp.contact.detail;

import gui.mvp.contact.model.Contact;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class DetailView extends GridPane
{
    private DetailPresenter presenter;
    private Long contactId;
    private Label firstNameLabel;
    private Label lastNameLabel;
    private TextField mailAddressField;

    public DetailView()
    {
        initView();
    }

    private void initView()
    {
        setHgap(10);
        setVgap(10);

        add(new Label("First name:"), 0, 0);
        firstNameLabel = new Label();
        add(firstNameLabel, 1, 0);

        add(new Label("Last name:"), 0, 1);
        lastNameLabel = new Label();
        add(lastNameLabel, 1, 1);

        add(new Label("Mail Address:"), 0, 2);
        mailAddressField = new TextField();
        mailAddressField.setPrefColumnCount(30);
        add(mailAddressField, 1, 2);

        HBox buttonBar = new HBox(10);

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> presenter.save());
        buttonBar.getChildren().add(saveButton);

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> presenter.cancel());
        buttonBar.getChildren().add(cancelButton);

        add(buttonBar, 0, 3, 1, 2);
    }

    public void setPresenter(DetailPresenter presenter)
    {
        this.presenter = presenter;
    }

    public Contact getContact()
    {
        return new Contact
        (
            contactId,
            firstNameLabel.getText(),
            lastNameLabel.getText(),
            mailAddressField.getText().trim()
        );
    }

    public void showContact(Contact contact)
    {
        if(contact != null)
        {
            contactId = contact.getId();
            firstNameLabel.setText(contact.getFirstName());
            lastNameLabel.setText(contact.getLastName());
            mailAddressField.setText(contact.getMailAddress());
        }
        else
        {
            contactId = null;
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            mailAddressField.setText("");
        }
    }
}
