package gui.mvp.vocab;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

//Nur zum anzeigen, kennt das Model nicht
public class View
{
    private Presenter presenter;

    private GridPane root, action, textPane;

    private TextField englisch;

    private Button controle, next;

    private Label head, german, text;

    public View()
    {
        this.presenter = new Presenter(this);
        this.initView();
    }

    private void initView()
    {
        this.root = new GridPane();
        this.action = new GridPane();
        this.textPane = new GridPane();
        this.german = new Label("Wohnheim");
        this.head = new Label("Bitte übersetzen Sie:");
        this.englisch = new TextField();
        this.controle = new Button("Überprüfen");
        this.next = new Button("Weiter");
        this.text = new Label("");

        this.head.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
        this.german.setFont(Font.font("Calibri", 18));

        this.root.add(this.head, 0, 0);
        this.root.add(this.textPane, 0, 1);
        this.textPane.add(this.german, 0, 0);
        this.textPane.add(this.englisch, 1, 2);

        this.root.add(this.action, 0, 2);
        this.root.setPadding(new Insets(10));
        this.root.setVgap(5);
        this.action.add(this.controle, 0, 0);
        this.action.add(this.next, 1, 0);
        this.action.setHgap(10);
        this.root.add(this.text, 0, 3);

        this.controle.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                View.this.presenter.compare(View.this.englisch.getText());
            }
        });

        this.next.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                View.this.presenter.nextVocab();
                View.this.text.setText("");
                View.this.englisch.clear();
                View.this.setGerman();
            }
        });

    }

    public Pane getUI()
    {
        return this.root;
    }

    public Presenter getPresenter()
    {
        return this.presenter;
    }

    public void setGerman()
    {
        this.german.setText(this.presenter.aktVocab());
    }

    public void showOkayMessage()
    {
        this.text.setText("Die Lösung ist richtig.");
        this.text.setTextFill(Color.GREEN);
        this.text.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
    }

    public void showEmptyError()
    {
        this.text.setText("Sie müssen eine Lösung eintragen.");
        this.text.setTextFill(Color.BLACK);
        this.text.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
    }

    public void showLoginError()
    {
        this.text.setText("Die Lösung ist falsch." + "\nSie können es nochmals versuchen.");
        this.text.setTextFill(Color.RED);
        this.text.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
    }
}
