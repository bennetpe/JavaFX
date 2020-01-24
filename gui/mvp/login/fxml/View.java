package gui.mvp.login.fxml;

import java.io.IOException;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class View
{
    private Presenter presenter;
    
    private GridPane pane;
    private TextField loginName;
    private PasswordField password;
    private Label status;
    
    public View(Presenter presenter)
    {
        this.presenter = presenter;
    }
        
    public void initView()
    {
        try
        {
            pane = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        }
        catch(IOException e)
        {
            return;
        }
        
        loginName = (TextField)pane.lookup("#loginName");
        password = (PasswordField)pane.lookup("#password");
        Button b = (Button)pane.lookup("#button");
        status = (Label)pane.lookup("#status");

        EventHandler<ActionEvent> h = e -> handle();
        loginName.setOnAction(h);
        password.setOnAction(h);
        b.setOnAction(h);
    }
    
    private void handle()
    {
        String name = loginName.getText();
        String pw = password.getText();
        name = name.trim();
        pw = pw.trim();
        presenter.login(name, pw);
    }

    public Pane getUI()
    {
        return pane;
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
