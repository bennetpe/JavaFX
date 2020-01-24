package gui.shapes;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class CenteredText extends Application
{
    public void start(Stage primaryStage)
    {
        Pane root = new Pane();
        primaryStage.setTitle("Textzentrierung");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        drawTexts(root);
    }

    private void drawTexts(Pane root)
    {
        Text t= new Text(0, 0, "Hoffentlich genau zentrierter Text");
        t.setFont(Font.font(null, FontWeight.BOLD, 40));
        t.setFill(Color.BLUE);
        t.setTextOrigin(VPos.TOP);
        root.getChildren().add(t);
        t.xProperty().bind(root.widthProperty().
                           subtract(t.layoutBoundsProperty().get().getWidth()).
                           divide(2));
        t.yProperty().bind(root.heightProperty().
                           subtract(t.layoutBoundsProperty().get().getHeight()).
                           divide(2));
        
        Rectangle r = new Rectangle();
        r.setWidth(t.layoutBoundsProperty().get().getWidth());
        r.setHeight(t.layoutBoundsProperty().get().getHeight());
        r.xProperty().bind(t.xProperty());
        r.yProperty().bind(t.yProperty());
        r.setFill(null);
        r.setStroke(t.getFill());
        root.getChildren().add(r);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}