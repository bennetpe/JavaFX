package gui.animation;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class TransitionAnimation extends Application
{
    public void start(Stage stage)
    {
        Pane pane = new Pane();

        Rectangle rectFade = new Rectangle(10, 10, 100, 100);
        rectFade.setArcHeight(20);
        rectFade.setArcWidth(20);
        rectFade.setFill(Color.RED);
        
        Rectangle rectFill = new Rectangle(10, 150, 100, 50);
        rectFill.setStroke(Color.BLACK);
        rectFill.setStrokeWidth(4);
        rectFill.setFill(Color.RED);
        
        Rectangle rectStroke = new Rectangle(150, 150, 100, 50);
        rectStroke.setStroke(Color.RED);
        rectStroke.setStrokeWidth(4);
        rectStroke.setFill(Color.WHITE);

        Rectangle rectPath = new Rectangle(30, 300, 40, 40);
        rectPath.setArcHeight(10);
        rectPath.setArcWidth(10);
        rectPath.setFill(Color.ORANGE);

        Rectangle rectSeq = new Rectangle(10, 600, 50, 50);
        rectSeq.setArcHeight(15);
        rectSeq.setArcWidth(15);
        rectSeq.setFill(Color.DARKBLUE);

        Rectangle rectParallel = new Rectangle(10, 750, 50, 50);
        rectParallel.setArcHeight(15);
        rectParallel.setArcWidth(15);
        rectParallel.setFill(Color.DARKBLUE);

        pane.getChildren().addAll(rectFade, rectFill, rectStroke,
                                  rectPath, rectSeq, rectParallel);

        stage.setTitle("Transitions Animation");
        Scene scene = new Scene(pane, 500, 850);
        scene.setFill(Color.WHITE);
        stage.setScene(scene);
        stage.show();
        
        createAnim1(rectFade);
        createAnim2(rectFill);
        createAnim3(rectStroke);
        createAnim4(rectPath);
        createAnim5(rectSeq);
        createAnim6(rectParallel);
    }

    private void createAnim1(Rectangle r)
    {
        FadeTransition ft = new FadeTransition(Duration.millis(3000), r);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
    }

    private void createAnim2(Rectangle r)
    {
        FillTransition ft = new FillTransition(Duration.millis(5000), r);
        ft.setFromValue(Color.RED);
        ft.setToValue(Color.GREEN);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
    }

    private void createAnim3(Rectangle r)
    {
        StrokeTransition st = new StrokeTransition(Duration.millis(5000), r);
        st.setFromValue(Color.RED);
        st.setToValue(Color.GREEN);
        st.setCycleCount(Timeline.INDEFINITE);
        st.setAutoReverse(true);
        st.play();
    }

    private void createAnim4(Rectangle r)
    {
        Path path = new Path();
        path.getElements().add(new MoveTo(30, 300));
        path.getElements().add(new CubicCurveTo(400, 280, 400, 400, 220, 400));
        path.getElements().add(new CubicCurveTo(20, 400, 20, 520, 400, 520));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setPath(path);
        pathTransition.setNode(r);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
    }

    private List<Transition> createTransitions(Rectangle r)
    {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), r);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.3f);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), r);
        translateTransition.setFromX(10);
        translateTransition.setToX(375);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);

        RotateTransition rotateTransition = new RotateTransition(Duration.millis(2000), r);
        rotateTransition.setByAngle(180f);
        rotateTransition.setCycleCount(4);
        rotateTransition.setAutoReverse(true);
    
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), r);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(2);
        scaleTransition.setToY(2);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);
        
        List<Transition> result = new ArrayList<>();
        result.add(fadeTransition);
        result.add(translateTransition);
        result.add(rotateTransition);
        result.add(scaleTransition);
        return result;
    }

    private void createAnim5(Rectangle r)
    {
        List<Transition> list = createTransitions(r);
        SequentialTransition seqTrans = new SequentialTransition();
        seqTrans.getChildren().addAll(list);
        seqTrans.setCycleCount(Timeline.INDEFINITE);
        seqTrans.setAutoReverse(true);
        seqTrans.play();
    }

    private void createAnim6(Rectangle r)
    {
        List<Transition> list = createTransitions(r);
        ParallelTransition parTrans = new ParallelTransition();
        parTrans.getChildren().addAll(list);
        parTrans.setCycleCount(Timeline.INDEFINITE);
        parTrans.setAutoReverse(true);
        parTrans.play();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
