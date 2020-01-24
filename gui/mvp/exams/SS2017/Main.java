package gui.mvp.exams.SS2017;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    private Presenter p = new Presenter(); 
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Model m = new Model();
        View v = new View(p);
        Presenter p = new Presenter(m, v);
        v.initView();
        primaryStage.setScene(new Scene(v.getView(), 500, 600));
        primaryStage.setTitle("Zeichnen von Formen");
        primaryStage.show();
    }
    
   public static void main(String[] args)
{
    launch(args);
}

}
