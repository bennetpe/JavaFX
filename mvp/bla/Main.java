package mvp.bla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    private Presenter p = new Presenter();
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        
        View v = new View(p);
        v.initView();
        Model m = new Model();
        Presenter p = new Presenter(m,v);
        primaryStage.setScene(new Scene(v.getView()));
        primaryStage.show();
        
    }

   public static void main(String[] args)
{
    launch(args);
}
}
