package gui.controls2;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;

public class MenuExample extends Application
{
    public void start(Stage primaryStage)
    {
        VBox root = new VBox();
        MenuBar menuBar = new MenuBar();
        
        Menu file = new Menu("File");
        MenuItem open = new MenuItem("Open");
        open.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        open.setOnAction(e->System.out.println("Open"));
        MenuItem save = new MenuItem("Save");
        save.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        save.setOnAction(e->System.out.println("Save"));
        MenuItem close = new MenuItem("Close");
        close.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        close.setOnAction(e->System.out.println("Close"));
        SeparatorMenuItem sep = new SeparatorMenuItem();
        MenuItem exit = new MenuItem("Exit");
        exit.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        exit.setOnAction(e->System.exit(0));        
        file.getItems().addAll(open, save, close, sep, exit);
        menuBar.getMenus().add(file);

        Menu edit = new Menu("Edit");
        MenuItem select = new MenuItem("Select");
        select.setOnAction(e->System.out.println("Select"));
        Menu undoRedo = new Menu("Undo/Redo");
        MenuItem undo = new MenuItem("Undo");
        undo.setAccelerator(KeyCombination.keyCombination("Ctrl+U"));
        undo.setOnAction(e->System.out.println("Undo"));
        MenuItem redo = new MenuItem("Redo");
        redo.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
        redo.setOnAction(e->System.out.println("Redo"));
        undoRedo.getItems().addAll(undo, redo);
        edit.getItems().addAll(select, undoRedo);
        menuBar.getMenus().add(edit);

        Menu options = new Menu("Options");
        CheckMenuItem grid = new CheckMenuItem("Draw grid");
        grid.setAccelerator(KeyCombination.keyCombination("Alt+G"));
        grid.setOnAction(e->System.out.println("Draw grid"));
        CheckMenuItem highlighting = new CheckMenuItem("Use highlighting");
        highlighting.setAccelerator(KeyCombination.keyCombination("Alt+H"));
        highlighting.setOnAction(e->System.out.println("Use highlighting"));
        sep = new SeparatorMenuItem();
        RadioMenuItem small = new RadioMenuItem("Small");
        small.setAccelerator(KeyCombination.keyCombination("Alt+S"));
        small.setOnAction(e->System.out.println("Small"));
        RadioMenuItem large = new RadioMenuItem("Large");
        large.setAccelerator(KeyCombination.keyCombination("Alt+L"));
        large.setOnAction(e->System.out.println("Large"));
        ToggleGroup tg = new ToggleGroup();
        small.setToggleGroup(tg);
        large.setToggleGroup(tg);
        options.getItems().addAll(grid, highlighting, sep, small, large);
        menuBar.getMenus().add(options);
        root.getChildren().add(menuBar);

        ContextMenu contextMenu = new ContextMenu();
        contextMenu.setOnShowing(e->System.out.println("Showing"));
        contextMenu.setOnShown(e->System.out.println("Shown"));

        MenuItem item1 = new MenuItem("About");
        item1.setOnAction(e->System.out.println("About"));
        MenuItem item2 = new MenuItem("Preferences");
        item2.setOnAction(e->System.out.println("Preferences"));
        CustomMenuItem customMenuItem = new CustomMenuItem(new Slider());
        customMenuItem.setHideOnClick(false);
        contextMenu.getItems().addAll(item1, item2, customMenuItem);
        Label l = new Label("Label");
        l.setContextMenu(contextMenu);
        root.getChildren().add(l);
                
        Scene scene = new Scene(root, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Menu");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
