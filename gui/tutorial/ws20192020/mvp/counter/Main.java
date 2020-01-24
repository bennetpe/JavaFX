package gui.tutorial.ws20192020.mvp.counter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    private static final int START_VALUE = 10;
    
    public void start(Stage primaryStage)
    {
        Model m = new Model(START_VALUE);
        View v = new View();
        Presenter p = new Presenter();
        p.setModelAndView(m, v);
        v.initView(p, START_VALUE);
        
        Scene scene = new Scene(v.getUI());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Zähler");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
