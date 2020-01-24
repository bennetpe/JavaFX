package gui.mvp.login.fxml.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application
{
    public void start(Stage primaryStage)
    {
        Presenter p = new Presenter();
        Pane pane;
        ViewController v;
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
            pane = (Pane)loader.load();
            v = (ViewController)loader.getController();
            v.initView(pane);
            v.setPresenter(p);
        }
        catch (Exception e)
        {
            return;
        }
        Model m = new Model();
        p.setView(v);
        p.setModel(m);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
