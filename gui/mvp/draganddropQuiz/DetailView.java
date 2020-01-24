package gui.mvp.draganddropQuiz;

import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

public class DetailView extends GridPane
{
    private DetailPresenter presenter;

    private Label question = new Label("");

    private Button next = new Button("Next");

    private HBox ansBox = new HBox();

    private GridPane pane;

    private ObservableList<String> list = FXCollections.observableArrayList();

    private Label[] labels = new Label[10];

    private int reaction = 0, size = 0;

    public DetailView(DetailPresenter detailPresenter)
    {
        this.presenter = detailPresenter;
        this.initView();
    }

    private void initView()
    {
        this.add(this.question, 0, 0);
        this.add(this.next, 0, 3);

        this.setVgap(5);
        this.setPadding(new Insets(10));
        this.question.setFont(Font.font("Calibri", 18));

        this.add(this.ansBox, 0, 1);

        this.pane = new GridPane();

        this.next.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                if (DetailView.this.reaction == 0)
                {
                    DetailView.this.ansBox.getChildren().clear();
                    DetailView.this.pane.getChildren().clear();
                    DetailView.this.presenter.next();
                }
                else if (DetailView.this.presenter.compare(DetailView.this.getResult()))
                {
                    DetailView.this.ansBox.getChildren().clear();
                    DetailView.this.pane.getChildren().clear();
                    DetailView.this.presenter.next();
                }
            }
        });

        // next.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
        // next.setStyle("-fx-background-color: linear-gradient(#f0ff35, #a9ff00), radial-gradient(center 50.0% -40.0%, radius 200.0%, #b8ee36 45.0%, #80c800 50.0%);-fx-background-radius: 6.0, 5.0;-fx-effect: dropshadow( three-pass-box , rgba(0.0,0.0,0.0,0.4) , 5.0, 0.0 , 0.0 , 1.0 );-fx-text-fill: #395306;");
    }

    public void setQuestion(String question)
    {
        this.question.setText(question);
    }

    public void setAnswer(String[] answ)
    {
        this.pane = new GridPane();
        this.pane.setGridLinesVisible(true);
        this.pane.setPrefSize(500, 350);
        this.add(this.pane, 0, 2);

        this.size = 0;
        for (int j = 0; j < answ.length; j++)
        {
            this.list.add(answ[j]);
        }

        for (int i = 0; i < answ.length; i++)
        {
            this.size++;
            int index = new Random().nextInt(this.list.size());
            Label source = new Label(this.list.get(index));
            source.setStyle("-fx-border-width: 2;-fx-border-style: solid;-fx-border-color: darkgrey;");

            this.list.remove(index);

            this.ansBox.getChildren().add(source);

            Label number = new Label(" " + i + ". ");
            Label target = new Label("                      ");
            this.labels[i] = target;

            number.setFont(Font.font("Calibri", 18));
            target.setFont(Font.font("Calibri", 18));
            source.setFont(Font.font("Calibri", 18));

            this.pane.add(number, 0, i);
            this.pane.add(target, 1, i);
            setHgrow(target, Priority.ALWAYS);

            this.action(source, target);
            this.action(target, source);
        }
    }

    public String[] getResult()
    {
        String[] results = new String[this.size];

        for (int i = 0; i < this.size; i++)
        {
            results[i] = this.labels[i].getText();
        }

        return results;
    }

    public void setEnd()
    {
        this.question.setText("Ende des Quiz");
        this.next.setDisable(true);
        this.pane.getChildren().clear();
    }

    public void action(Label source, Label target)
    {
        source.setOnDragDetected(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                Label firstsource = (Label) e.getSource();
                Dragboard db = firstsource.startDragAndDrop(TransferMode.ANY);
                ClipboardContent content = new ClipboardContent();
                content.putString(firstsource.getText());
                db.setContent(content);
            }
        });

        target.setOnDragOver(new EventHandler<DragEvent>()
        {
            @Override
            public void handle(DragEvent e)
            {
                Label firsttarget = (Label) e.getSource();
                if (e.getGestureSource() != firsttarget && e.getDragboard().hasString())
                {
                    e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            }
        });

        target.setOnDragDropped(new EventHandler<DragEvent>()
        {
            @Override
            public void handle(DragEvent e)
            {
                Label sectarget = (Label) e.getSource();
                Dragboard db = e.getDragboard();
                boolean success = false;
                if (db.hasString())
                {
                    if (sectarget.getText().contains("                      "))
                    {
                        sectarget.setText(db.getString());
                        success = true;
                    }

                }
                e.setDropCompleted(success);
            }
        });

        source.setOnDragDone(new EventHandler<DragEvent>()
        {
            @Override
            public void handle(DragEvent e)
            {
                DetailView.this.reaction++;
                Label secsource = (Label) e.getSource();
                if (e.getTransferMode() == TransferMode.MOVE)
                {
                    secsource.setText("                      ");
                }
            }
        });

    }

}
