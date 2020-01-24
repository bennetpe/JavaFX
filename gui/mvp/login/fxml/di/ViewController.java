package gui.mvp.login.fxml.di;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ViewController
{
    private Presenter presenter;
    
    @FXML
    private TextField loginName;
    @FXML
    private PasswordField password;
    @FXML
    private Label status;

    public ViewController()
    {
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
