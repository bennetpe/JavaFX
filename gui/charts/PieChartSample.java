package gui.charts;

import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Side;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.control.Label;

public class PieChartSample extends Application
{
    public void start(Stage stage)
    {
        ObservableList<PieChart.Data> pieChartData = 
            FXCollections.observableArrayList
            (
                new PieChart.Data("Grapefruit", 13), 
                new PieChart.Data("Orangen", 25), 
                new PieChart.Data("Pflaumen", 10), 
                new PieChart.Data("Birnen", 22), 
                new PieChart.Data("Äpfel", 30)
            );

        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Importiertes Obst");
        pieChart.setLegendSide(Side.BOTTOM);
        Label caption = new Label("");
        for(PieChart.Data data: pieChart.getData())
        {
            data.getNode().setOnMouseMoved
            (
                e ->
                {
                    caption.setTranslateX(e.getSceneX());
                    caption.setTranslateY(e.getSceneY()-15);
                    caption.setText(data.getPieValue() + "%");
                }
            );
        }

        Group root = new Group();
        root.getChildren().addAll(pieChart, caption);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Tortendiagramm");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}