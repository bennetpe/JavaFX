package gui.mvp.draganddropQuiz;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class OverView extends BorderPane
{
    private OverViewPresenter presenter;

    private TableView<QuizData> table = new TableView<>();

    public OverView(OverViewPresenter overViewPresenter, ObservableList<QuizData> list)
    {
        this.presenter = overViewPresenter;
        this.initView();
        this.table.setItems(list);
    }

    private void initView()
    {
        Label head = new Label("Überblick");
        Button next = new Button("Ergebnisse löschen!");

        this.setTable();

        this.setTop(head);
        this.setBottom(next);

        next.setOnAction(e -> this.presenter.clear());

    }

    public void setTable()
    {
        this.table.setEditable(false);
        this.table.setPrefSize(480, 220);

        TableColumn<QuizData, String> frage = new TableColumn<>("Frage");
        frage.setCellValueFactory(new PropertyValueFactory<>("question"));
        frage.setPrefWidth(378);
        this.table.getColumns().add(frage);

        TableColumn<QuizData, Number> antworten = new TableColumn<>("Antworten");
        antworten.setCellValueFactory(new PropertyValueFactory<>("trys"));
        antworten.setPrefWidth(100);
        this.table.getColumns().add(antworten);

        TableColumn<QuizData, Number> richtige = new TableColumn<>("davon richtig");
        richtige.setCellValueFactory(new PropertyValueFactory<>("right"));
        richtige.setPrefWidth(100);
        this.table.getColumns().add(richtige);

        this.setCenter(this.table);
    }

}
