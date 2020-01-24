package gui.exam.soccer.fin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Presenter presenter = initApplication();

        Scene scene = new Scene(presenter.getView(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ergebnisse");
        primaryStage.show();

    }

    public Presenter initApplication()
    {
        Presenter presenter = new Presenter();
        Dialog dialog = new Dialog();
        Model model = new Model();
        View view = new View();

        presenter.setModel(model);
        presenter.setView(view);
        presenter.setDialog(dialog);
        dialog.setPresenter(presenter);
        dialog.setView(view);
        view.setPresenter(presenter);
        view.setDialog(dialog);

        return presenter;
    }

}
