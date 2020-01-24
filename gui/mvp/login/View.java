package gui.mvp.login;

import javafx.event.*;
import javafx.geometry.Insets;
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
        pane = new GridPane();
        Insets insets = new Insets(5);
        pane.setPadding(insets);
        pane.setHgap(2);
        pane.setVgap(5);
        pane.add(new Label("Login-Kennung:"), 0, 0);
        loginName = new TextField();
        pane.add(loginName, 1, 0);
        pane.add(new Label("Passwort:"), 0, 1);
        password = new PasswordField();
        pane.add(password, 1, 1);
        Button b = new Button("Login");
        pane.add(b, 0, 2, 2, 1);
        status = new Label();
        pane.add(status, 0, 3, 2, 1);
        
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
