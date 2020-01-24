package gui.graphics.sinus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    private SinusView v;

    private SinusModel m;

    private SinusPresenter p;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // object initialize
        this.m = new SinusModel();
        this.p = new SinusPresenter();
        this.v = new SinusView();

        // verketten
        this.initMVP();

        Scene scene = new Scene(this.v, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Sinus");
        this.v.drawSinus();
    }

    public void initMVP()
    {
        // mvp setter calls for relations
        this.v.setPresenter(this.p);
        this.p.setModel(this.m);
        this.p.setView(this.v);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
