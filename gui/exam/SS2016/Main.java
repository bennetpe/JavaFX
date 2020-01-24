package gui.exam.SS2016;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    
    private Presenter p;
    private Model m;
    private View v;
    private Dialog d;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        initMVP();
        primaryStage.setScene(new Scene(v.getView()));
        primaryStage.setTitle("Ergebnisse");
        primaryStage.show();
    }
    
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    public void initMVP() {
      //initialize
        m = new Model();
        p = new Presenter();
        v = new View();
        d = new Dialog();
        // mvp setter chain
        this.v.setPresenter(p);
        this.p.setModel(m);
        this.p.setView(v);
        this.p.setView(d);
        this.d.setPresenter(p);
        // init method
        v.initView();
        d.initDialog();
    }
}
