package gui.charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

public class BubbleChartSample extends Application
{
    public void start(Stage stage)
    {
        NumberAxis xAxis = new NumberAxis(1, 53, 4);
        xAxis.setLabel("Woche");
        NumberAxis yAxis = new NumberAxis(0, 80, 10);
        yAxis.setLabel("Produzierte Waren");

        BubbleChart<Number, Number> bubbleChart = new BubbleChart<>(xAxis, yAxis);
        bubbleChart.setTitle("Produzierte Waren und Stromverbrauch");

        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        series1.setName("Produkt 1");
        series1.getData().add(new XYChart.Data<Number, Number>(3, 35, 2));
        series1.getData().add(new XYChart.Data<Number, Number>(12, 60, 1.8));
        series1.getData().add(new XYChart.Data<Number, Number>(15, 15, 7));
        series1.getData().add(new XYChart.Data<Number, Number>(22, 30, 2.5));
        series1.getData().add(new XYChart.Data<Number, Number>(28, 20, 1));
        series1.getData().add(new XYChart.Data<Number, Number>(35, 41, 5.5));
        series1.getData().add(new XYChart.Data<Number, Number>(42, 17, 9));
        series1.getData().add(new XYChart.Data<Number, Number>(49, 30, 1.8));
        bubbleChart.getData().add(series1);

        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
        series2.setName("Produkt 2");
        series2.getData().add(new XYChart.Data<Number, Number>(8, 15, 2));
        series2.getData().add(new XYChart.Data<Number, Number>(13, 23, 1));
        series2.getData().add(new XYChart.Data<Number, Number>(15, 45, 3));
        series2.getData().add(new XYChart.Data<Number, Number>(24, 30, 4.5));
        series2.getData().add(new XYChart.Data<Number, Number>(38, 78, 1));
        series2.getData().add(new XYChart.Data<Number, Number>(40, 41, 7.5));
        series2.getData().add(new XYChart.Data<Number, Number>(45, 57, 2));
        series2.getData().add(new XYChart.Data<Number, Number>(47, 23, 3.8));
        bubbleChart.getData().add(series2);

        Scene scene = new Scene(bubbleChart);
        stage.setScene(scene);
        stage.setTitle("Blasendiagramm");
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}