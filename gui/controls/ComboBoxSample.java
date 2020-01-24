package gui.controls;

import javafx.application.Application;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ComboBoxSample extends Application
{
    public void start(Stage stage)
    {
        ObservableList<String> data1 = FXCollections.observableArrayList
        (
            "Option 1", "Option 2", "Option 3", "Option 4"
        );
        ComboBox<String> comboBox1 = new ComboBox<>(data1);
        /*
        ComboBox<String> comboBox1 = new ComboBox<>();
        comboBox1.getItems().addAll
        (
            "Option 1", "Option 2", "Option 3", "Option 4"
        );
        */
        comboBox1.setPromptText("Select a string option!");
        comboBox1.setEditable(false);

        ObservableList<Integer> data2 = FXCollections.observableArrayList
        (
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
        );
        ComboBox<Integer> comboBox2 = new ComboBox<>(data2);
        comboBox2.setPromptText("Select an integer!");
        comboBox2.setEditable(false);
        
        Label status1 = new Label();
        Label status2 = new Label();
        Label binding = new Label();
        Button b = new Button("Add integer!");

        VBox box = new VBox();
        box.getChildren().addAll(comboBox1, comboBox2,
                                 status1, status2,
                                 binding, b);
        Scene scene = new Scene(box, 240, 240);
        stage.setScene(scene);
        stage.setTitle("ComboBoxDemo");

        comboBox1.setOnAction
        (
            (ev) -> 
            {
                //String option = comboBox1.getSelectionModel().getSelectedItem();
                String option = comboBox1.getValue();
                int index = comboBox1.getSelectionModel().getSelectedIndex();
                status1.setText("selected " + option +
                                " (index " + index + ")");
            }
        );
        comboBox1.valueProperty().addListener
        (
            (ov, oldValue, newValue) ->
            {
                status2.setText(oldValue + " => " + newValue);
            }
        );
        comboBox2.setOnAction
        (
            (ev) -> 
            {
                //Integer i = comboBox2.getSelectionModel().getSelectedItem();
                Integer i = comboBox2.getValue();
                int index = comboBox2.getSelectionModel().getSelectedIndex();
                status1.setText("selected " + i +
                                " (index " + index + ")");
            }
        );
        comboBox2.valueProperty().addListener
        (
            (ov, oldValue, newValue) ->
            {
                status2.setText(oldValue + " => " + newValue);
            }
        );
        comboBox2.setValue(1);
        binding.textProperty().bind(comboBox1.valueProperty());
        b.setOnAction
        (
            e -> data2.add(data2.size()+1)
        );
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}