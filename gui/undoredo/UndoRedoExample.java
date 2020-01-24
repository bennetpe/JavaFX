package gui.undoredo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

class UndoRedoModel
{
    private float f;
    private int i;
    private String s;
    
    public UndoRedoModel(float f, int i, String s)
    {
        this.f = f;
        this.i = i;
        this.s = s;
    }

    public float getF()
    {
        return f;
    }

    public void setF(float f)
    {
        this.f = f;
    }
    
    public int getI()
    {
        return i;
    }
    
    public void setI(int i)
    {
        this.i = i;
    }
    
    public String getS()
    {
        return s;
    }
    
    public void setS(String s)
    {
        this.s = s;
    }
}

class UndoRedoView
{
    private UndoRedoPresenter presenter;
    private BorderPane pane;
    private Label fLabel, iLabel, sLabel;
    private TextField fTf, iTf, sTf;
    private Label status;
    
    public UndoRedoView()
    {
        presenter = new UndoRedoPresenter(this);
        initView();
    }
    
    private void initView()
    {
        Font font = Font.font(24);
        pane = new BorderPane();
        
        VBox vbox = new VBox();
        MenuBar menuBar = new MenuBar();
        vbox.getChildren().add(menuBar);
        Menu edit = new Menu("Edit");
        MenuItem undo = new MenuItem("Undo");
        undo.setAccelerator(KeyCombination.keyCombination("Ctrl+U"));
        undo.setOnAction(e->presenter.undo());
        MenuItem redo = new MenuItem("Redo");
        redo.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
        redo.setOnAction(e->presenter.redo());
        edit.getItems().addAll(undo, redo);
        menuBar.getMenus().add(edit);
        pane.setTop(vbox);
                
        GridPane mainPane = new GridPane();
        FlowPane fp;
        Label l;
        
        fp = new FlowPane(10, 10);
        l = new Label("f:");
        l.setFont(font);
        fp.getChildren().add(l);
        fTf = new TextField();
        fTf.setFont(font);
        fTf.setOnAction(e->presenter.inputF(fTf.getText()));
        fp.getChildren().add(fTf);
        mainPane.add(fp, 0, 0);
        fLabel = new Label();
        fLabel.setFont(font);
        mainPane.add(fLabel, 1, 0);
        
        fp = new FlowPane();
        l = new Label("i:");
        l.setFont(font);
        fp.getChildren().add(l);
        iTf = new TextField();
        iTf.setFont(font);
        iTf.setOnAction(e->presenter.inputI(iTf.getText()));
        fp.getChildren().add(iTf);
        mainPane.add(fp, 0, 1);
        iLabel = new Label();
        iLabel.setFont(font);
        mainPane.add(iLabel, 1, 1);
        
        fp = new FlowPane();
        l = new Label("s:");
        l.setFont(font);
        fp.getChildren().add(l);
        sTf = new TextField();
        sTf.setFont(font);
        sTf.setOnAction(e->presenter.inputS(sTf.getText()));
        fp.getChildren().add(sTf);
        mainPane.add(fp, 0, 2);
        sLabel = new Label();
        sLabel.setFont(font);
        mainPane.add(sLabel, 1, 2);
        
        status = new Label();
        status.setFont(font);
        mainPane.add(status, 0, 3, 2, 1);
        
        pane.setCenter(mainPane);
    }
    
    public Pane getUI()
    {
        return pane;
    }
    
    public UndoRedoPresenter getPresenter()
    {
        return presenter;
    }
    
    public void showF(float f)
    {
        fLabel.setText("f = " + f);
        clearInputAndStatus();
    }
    
    public void showI(int i)
    {
        iLabel.setText("i = " + i);
        clearInputAndStatus();
    }
    
    public void showS(String s)
    {
        sLabel.setText("s = " + s);
        clearInputAndStatus();
    }
    
    private void clearInputAndStatus()
    {
        fTf.setText("");
        iTf.setText("");
        sTf.setText("");
        status.setText("");
    }
    
    public void showError(String message)
    {
        status.setText(message);
    }
}

class UndoRedoPresenter
{
    private UndoRedoView view;
    private UndoRedoModel model;
    private UndoRedoManager manager;

    public UndoRedoPresenter(UndoRedoView view)
    {
        this.view = view;
        this.manager = new UndoRedoManager();
    }

    public void setModel(UndoRedoModel model)
    {
        this.model = model;
    }

    public void inputF(String text)
    {
        float newValue;
        try
        {
            newValue = Float.parseFloat(text);
        }
        catch(NumberFormatException e)
        {
            view.showError("Formatierungsfehler in " + text);
            return;
        }
        float oldValue = model.getF();
        UndoRedoF action = new UndoRedoF(model, view, oldValue, newValue);
        manager.addAction(action);
        action.redo();
    }

    public void inputI(String text)
    {
        int newValue;
        try
        {
            newValue = Integer.parseInt(text);
        }
        catch(NumberFormatException e)
        {
            view.showError("Formatierungsfehler in " + text);
            return;
        }
        int oldValue = model.getI();
        UndoRedoI action = new UndoRedoI(model, view, oldValue, newValue);
        manager.addAction(action);
        action.redo();
    }

    public void inputS(String text)
    {
        String oldValue = model.getS();
        UndoRedoS action = new UndoRedoS(model, view, oldValue, text);
        manager.addAction(action);
        action.redo();
    }
    
    public void undo()
    {
        manager.undo();
    }
        
    public void redo()
    {
        manager.redo();
    }

    public void initialize()
    {
        view.showF(model.getF());
        view.showI(model.getI());
        view.showS(model.getS());
    }
}

abstract class UndoRedoBase implements UndoableRedoableAction
{
    protected UndoRedoModel model;
    protected UndoRedoView view;
    
    public UndoRedoBase(UndoRedoModel model, UndoRedoView view)
    {
        this.model = model;
        this.view = view;
    }
}

class UndoRedoF extends UndoRedoBase
{
    private float oldValue;
    private float newValue;
    
    public UndoRedoF(UndoRedoModel model, UndoRedoView view, float oldValue, float newValue)
    {
        super(model, view);
        this.oldValue = oldValue;
        this.newValue = newValue;
    }
    public void undo()
    {
        model.setF(oldValue);
        view.showF(oldValue);
    }

    public void redo()
    {
        model.setF(newValue);
        view.showF(newValue);
    }
}

class UndoRedoI extends UndoRedoBase
{
    private int oldValue;
    private int newValue;
    
    public UndoRedoI(UndoRedoModel model, UndoRedoView view, int oldValue, int newValue)
    {
        super(model, view);
        this.oldValue = oldValue;
        this.newValue = newValue;
    }
    public void undo()
    {
        model.setI(oldValue);
        view.showI(oldValue);
    }

    public void redo()
    {
        model.setI(newValue);
        view.showI(newValue);
    }
}

class UndoRedoS extends UndoRedoBase
{
    private String oldValue;
    private String newValue;
    
    public UndoRedoS(UndoRedoModel model, UndoRedoView view, String oldValue, String newValue)
    {
        super(model, view);
        this.oldValue = oldValue;
        this.newValue = newValue;
    }
    public void undo()
    {
        model.setS(oldValue);
        view.showS(oldValue);
    }

    public void redo()
    {
        model.setS(newValue);
        view.showS(newValue);
    }
}

public class UndoRedoExample extends Application
{
    public void start(Stage primaryStage)
    {
        UndoRedoView v = new UndoRedoView();
        UndoRedoPresenter p = v.getPresenter();
        UndoRedoModel m = new UndoRedoModel(0, 0, "...");
        p.setModel(m);
        p.initialize();
        
        Scene scene = new Scene(v.getUI(), 500, 240);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Undo-Redo");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
