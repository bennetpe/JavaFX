package gui.mvp.draganddropQuiz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage stage)
    {
        MainView mainView = new MainView();
        Scene scene = new Scene(mainView, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Quiz");
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
