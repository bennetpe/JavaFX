package gui.animation;

import javafx.animation.*;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class TimelineAnimation extends Application
{
    public void start(Stage stage)
    {
        Pane pane = new Pane();
        
        Rectangle rectBasicTimeline = new Rectangle(10, 10, 100, 50);
        rectBasicTimeline.setFill(Color.BROWN);

        pane.getChildren().add(rectBasicTimeline);

        stage.setTitle("Timeline Animation");
        Scene scene = new Scene(pane, 450, 360);
        scene.setFill(Color.WHITE);
        stage.setScene(scene);
        stage.show();
        
        createAnim(rectBasicTimeline);
    }

    private void createAnim(Rectangle r)
    {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        KeyValue kv1 = new KeyValue(r.xProperty(), 300, Interpolator.EASE_BOTH);
        KeyFrame kf1 = new KeyFrame(Duration.millis(3000), e->System.out.println("1"), kv1);
        timeline.getKeyFrames().add(kf1);
        KeyValue kv2 = new KeyValue(r.yProperty(), 300, new MyInterpolator());
        KeyFrame kf2 = new KeyFrame(Duration.millis(6000), e->System.out.println("2"), kv2);
        timeline.getKeyFrames().add(kf2);
        timeline.play();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

class MyInterpolator extends Interpolator
{
    protected double curve(double t)
    {
        if(t <= 0.5)
        {
            return 0;
        }
        return (t-0.5)*2;
    }    
}