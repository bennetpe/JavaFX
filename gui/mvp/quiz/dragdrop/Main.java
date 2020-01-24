package gui.mvp.quiz.dragdrop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        
//        MainPresenter mp = new MainPresenter();
//        Model m = new Model();
//        OverviewPresenter ov = new OverviewPresenter();
        MainView mv = new MainView();
        mv.initMainView();
        primaryStage.setScene(new Scene(mv.getMainView(), 800, 600));;
        primaryStage.setTitle("Quiz");
        primaryStage.show();

    }
    
   public static void main(String[] args) {
       launch(args);
   }

}
