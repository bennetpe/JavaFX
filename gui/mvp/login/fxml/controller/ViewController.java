package gui.mvp.login.fxml.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class ViewController
{
    private Presenter presenter;
    
    private TextField loginName;
    private PasswordField password;
    private Label status;

    public ViewController()
    {
    }
    
    public void initView(Pane pane)
    {
        loginName = (TextField)pane.lookup("#loginName");
        password = (PasswordField)pane.lookup("#password");
        status = (Label)pane.lookup("#status");
    }

    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }
    
    public void handle(ActionEvent e)
    {
        String name = loginName.getText();
        String pw = password.getText();
        name = name.trim();
        pw = pw.trim();
        presenter.login(name, pw);
    }
    
    public void resetInput()
    {
        loginName.setText("");
        password.setText("");
    }
    
    public void showOkayMessage()
    {
        status.setText("Login erfolgreich.");
    }

    public void showInputError()
    {
        status.setText("Keine Login-Kennung angegeben.");
    }

    public void showLoginError()
    {
        status.setText("Login-Kennung bzw. Passwort falsch.");
    }
}
