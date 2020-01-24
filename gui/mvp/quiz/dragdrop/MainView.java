package gui.mvp.quiz.dragdrop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView extends BorderPane
{
    private MainViewPresenter mp;

    private Label questionL;

    private Button startBtn, overviewBtn, returnBtn, nextBtn;

    private HBox buttonGroup;

    private VBox vbox;

    private GridPane sourceGrid;

    private GridPane targetGrid;

    private ArrayList<HashMap<Integer, String>> answerArrayList;

    private ArrayList<String> randValueList;

    private String swapString;

    private ArrayList<Label> targetListLabels = new ArrayList<>();

    public MainView()
    {
        mp = new MainViewPresenter();
        initPosAnswer();
        initMainView();
        this.buttonGroup.getChildren().addAll(startBtn, returnBtn, overviewBtn);
        this.setTop(buttonGroup);
        this.setCenter(vbox);
    }

    public void initMainView()
    {
        this.buttonGroup = new HBox(5);
        this.vbox = new VBox(10);
        questionL = new Label("frage");
        startBtn = new Button("Quiz starten!");
        returnBtn = new Button("Quiz fortsetzen");
        overviewBtn = new Button("‹berblick");
        nextBtn = new Button("=>");
        questionL.setText("Bringen Sie die Auswahl in die Richtige Reihenfolge");
        sourceGrid = new GridPane();
        targetGrid = new GridPane();
        for (int i = 0; i < randValueList.size(); i++)
        {
            Label source = new Label(randValueList.get(i));
            sourceGrid.addRow(1, source);
            sourceGrid.setGridLinesVisible(true);

            source.setOnDragDetected(e ->
            {
                OnDragDetected(e);
            });
            source.setOnDragDropped(e ->
            {
                OnDragDroped(e);
            });
            source.setOnDragDone(e ->
            {
                onDragDone(e);
            });
            source.setOnDragOver(e ->
            {
                OnDragOver(e);
            });
        }

        for (int y = 0; y < answerArrayList.get(0).size(); y++)
        {
            Label targetLabel = new Label("              ");
            targetGrid.addColumn(0, new Label(String.valueOf(y + 1).concat(".")));
            targetGrid.addColumn(1, targetLabel);
            targetListLabels.add(targetLabel);
            targetGrid.setGridLinesVisible(true);
            targetLabel.setOnDragDetected(e ->
            {
                OnDragDetected(e);
            });
            targetLabel.setOnDragDropped(e ->
            {
                OnDragDroped(e);
            });
            targetLabel.setOnDragDone(e ->
            {
                onDragDone(e);
            });
            targetLabel.setOnDragOver(e ->
            {
                OnDragOver(e);
            });
        }

        vbox.getChildren().addAll(questionL, sourceGrid, targetGrid, nextBtn);

        startBtn.setOnAction(e ->
        {
            GridPane tmpSourceGrid = new GridPane();
            randomValues();
            vbox.getChildren().clear();
            
            for (int i = 0; i < randValueList.size(); i++)
            {
                Label source = new Label(randValueList.get(i));
                tmpSourceGrid.addRow(0, source);
                tmpSourceGrid.setGridLinesVisible(true);
                
                source.setOnDragDetected(d ->
                {
                    OnDragDetected(d);
                });
                source.setOnDragDropped(f ->
                {
                    OnDragDroped(f);
                });
                source.setOnDragDone(s ->
                {
                    onDragDone(s);
                });
                source.setOnDragOver(y ->
                {
                    OnDragOver(y);
                });
            }
            
            vbox.getChildren().addAll(questionL, tmpSourceGrid, targetGrid, nextBtn);
            this.setCenter(vbox);
           
        });

        nextBtn.setOnAction(e ->
        {
            for (int i = 0; i < answerArrayList.get(0).size(); i++)
            {
                String tmp = answerArrayList.get(0).get(i + 1);
                if (!tmp.equals(targetListLabels.get(i).getText()))
                {
                    System.out.println("Antwort war falsch");
                    return;
                }
            }
            System.out.println("Antwort war richtig :)");

        });

    }

    public void OnDragDetected(MouseEvent e)
    {
        System.out.println("On Drag detected!");
        Label source = (Label) e.getSource();
        if (source.getText().equals("              "))
        {
            return;
        }
        Dragboard db = source.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString(source.getText());
        db.setContent(content);
    }

    public void OnDragOver(DragEvent d)
    {
        System.out.println("On DragOver");
        if (d.getDragboard().hasString())
        {
            d.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
    }

    public void OnDragDroped(DragEvent d)
    {
        System.out.println("On Drag Dropped");
        Label target = (Label) d.getSource();
        Dragboard db = d.getDragboard();
        swapString = target.getText();
        target.setText(db.getString());
        d.setDropCompleted(true);
    }

    public void onDragDone(DragEvent d)
    {
        System.out.println("On Drag Done");
        Label source = (Label) d.getSource();
        if (d.getTransferMode() == TransferMode.MOVE)
        {
            source.setText(swapString);
        }
    }

    /**
     * Methode zum vergleichen ob die target key value labels gleich dem linken
     * index sind
     */
    public void compareIndex()
    {

        // wenn der Wert key gleich dem target grid 0 ist dann ist alles ok
        // sonst rot

    }

    // grid lines sind da random funktioniert nicht also erst drag and drop
    public void initPosAnswer()
    {
        // #############Erste Auswahl#################
        isNull(answerArrayList);
        answerArrayList = new ArrayList<>();
        answerArrayList.add(mp.getModel().createHashMap());
        answerArrayList.get(0).put(1, "Schwarz");
        answerArrayList.get(0).put(2, "Rot");
        answerArrayList.get(0).put(3, "Gold");
        // #############Zweite Auswahl################
        answerArrayList.add(mp.getModel().createHashMap());
        answerArrayList.get(1).put(1, "klein");
        answerArrayList.get(1).put(2, "mittel");
        answerArrayList.get(1).put(3, "groﬂ");
        randomValues();
        // ############Dritte Auswahl#################
    }

    public Parent getMainView()
    {
        return this;
    }

    public void randomValues()
    {
        randValueList = new ArrayList<>();
        for (int i = 1; i <= answerArrayList.get(0).size(); i++)
        {
            randValueList.add(answerArrayList.get(0).get(i));
        }
        Collections.shuffle(randValueList);
        for (String s : randValueList)
        {
            System.out.print(s);
        }

    }
    
    public HBox getButtonGroup() {
        return buttonGroup;
    }

    /**
     * Simple Way to check null objects, for debugging
     * 
     * @param oj
     */
    public void isNull(Object oj)
    {
        System.out.println(oj == null);
    }
}
