package mvp.sinus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        View v = new View();
        v.drawSinus();
        Presenter p = v.getPresenter();
        Model m = new Model();
        p.setModel(m);
        Scene scene = new Scene(v.getUI());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sinus");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
