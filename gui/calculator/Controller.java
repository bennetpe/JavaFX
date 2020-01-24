package gui.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.script.ScriptException;

public class Controller
{
    @FXML
    private Label label;

    @FXML
    private Button punkt;

    @FXML
    private TextField display;

    @FXML
    private Button kZU;

    @FXML
    private Button delete;

    @FXML
    private Button kAUF;

    @FXML
    private Button div;

    @FXML
    private Button add;

    @FXML
    private Button sub;

    @FXML
    private Button clear;

    @FXML
    private Button ergb;

    @FXML
    private Button mul;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b4;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    private Button b0;

    public void buttonClicked(ActionEvent a)
    {
        Button pressed = (Button) a.getSource();
        this.display.setText(this.display.getText() + pressed.getText());
    }

    public void buttonClear(ActionEvent b)
    {
        this.display.clear();
    }

    public void buttonDelete(ActionEvent c)
    {
        if (this.display.getText().length() > 0)
        {
            String tmp = this.display.getText();
            this.display.setText(tmp.substring(0, tmp.length() - 1));
        }
    }

    public void buttonCompute(ActionEvent d)
    {
        Computation com = new Computation();
        try
        {
            this.display.setText(this.display.getText() + "=" + com.evaluate(this.display.getText()));
        }
        catch (ScriptException ex)
        {
            this.display.setText(this.display.getText() + "=>FEHLER");
        }
    }

}
