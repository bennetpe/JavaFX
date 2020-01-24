package gui.mvp.contact.main;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MainView extends BorderPane
{
    public MainView()
    {
        initView();
    }

    private void initView()
    {
        VBox topArea = new VBox(5);

        Label titleLabel = new Label("Kontaktsystem der HS Trier");
        topArea.getChildren().add(titleLabel);
        Label tagLine = new Label("Implementiert mit JavaFX");
        topArea.getChildren().add(tagLine);

        setTop(topArea);
    }

    public void setContent(Pane content)
    {
        setCenter(content);
        setMargin(content, new Insets(20, 20, 20, 20));
    }
}

