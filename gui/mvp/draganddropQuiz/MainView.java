package gui.mvp.draganddropQuiz;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MainView extends BorderPane
{
    private MainPresenter presenter;

    public MainView()
    {
        this.initView();
        this.presenter = new MainPresenter(this);
    }

    private void initView()
    {
        Button start = new Button("Quiz starten!");
        Button continues = new Button("Quiz fortsezten!");
        Button overview = new Button("Überblick");
        HBox buttons = new HBox();

        buttons.getChildren().addAll(start, continues, overview);
        buttons.setSpacing(5);

        this.setTop(buttons);
        this.setPadding(new Insets(10));

        start.setOnAction(e -> this.presenter.setDetailView());
        continues.setOnAction(e -> this.presenter.continues());
        overview.setOnAction(e -> this.presenter.setOverView());

    }
}
