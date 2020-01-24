package mvp.sinus;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class View
{
    private GridPane root = new GridPane();

    private GridPane settings = new GridPane();

    private Label wert = new Label("Sinus");

    private Canvas canvas = new Canvas(700, 400);

    private GraphicsContext gc;

    private Slider amplitude = new Slider(-6, 6, 0);

    private Slider frequenz = new Slider(0, 40, 1);

    private Slider phase = new Slider(-10, 10, 0);

    private Slider zoom = new Slider(10, 210, 50);

    private Presenter presenter;

    public View()
    {
        this.presenter = new Presenter(this);
        this.initView();
    }

    public void initView()
    {
        this.root.add(this.wert, 0, 0);
        this.root.add(this.canvas, 0, 1);
        this.root.add(this.settings, 0, 2);
        this.root.setHgap(5);
        this.root.setVgap(5);
        this.root.setPadding(new Insets(10));

        Label lab1 = new Label("Amplitude:");
        Label lab2 = new Label("Frequenz:");
        Label lab3 = new Label("Phase:");
        Label lab4 = new Label("Zoom");

        this.settings.add(lab1, 0, 0);
        this.settings.add(this.amplitude, 1, 0);
        this.settings.add(lab2, 0, 1);
        this.settings.add(this.frequenz, 1, 1);
        this.settings.add(lab3, 0, 2);
        this.settings.add(this.phase, 1, 2);
        this.settings.add(lab4, 0, 3);
        this.settings.add(this.zoom, 1, 3);
        this.settings.setHgap(10);

        this.amplitude.setShowTickLabels(true);
        this.amplitude.setShowTickMarks(true);
        this.amplitude.setMajorTickUnit(2);
        this.amplitude.setMinorTickCount(1);

        this.frequenz.setShowTickLabels(true);
        this.frequenz.setShowTickMarks(true);
        this.frequenz.setMajorTickUnit(10);
        this.frequenz.setMinorTickCount(5);

        this.phase.setShowTickLabels(true);
        this.phase.setShowTickMarks(true);
        this.phase.setMajorTickUnit(5);
        this.phase.setMinorTickCount(1);

        this.zoom.setShowTickLabels(true);
        this.zoom.setShowTickMarks(true);
        this.zoom.setMajorTickUnit(50);
        this.zoom.setMinorTickCount(0);

        this.gc = this.canvas.getGraphicsContext2D();
        this.gc.strokeLine(this.canvas.getWidth() / 2, 0, this.canvas.getWidth() / 2, this.canvas.getHeight());
        this.gc.strokeLine(0, this.canvas.getHeight() / 2, this.canvas.getWidth(), this.canvas.getHeight() / 2);

        this.amplitude.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2)
            {
                View.this.gc.clearRect(0, 0, 700, 400);
                View.this.drawSinus();
            }
        });

        this.phase.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2)
            {
                View.this.gc.clearRect(0, 0, 700, 400);
                View.this.drawSinus();
            }
        });

        this.zoom.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2)
            {
                View.this.gc.clearRect(0, 0, 700, 400);
                View.this.drawSinus();
            }
        });

        this.frequenz.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2)
            {
                View.this.gc.clearRect(0, 0, 700, 400);
                View.this.drawSinus();
            }
        });
    }

    public GridPane getUI()
    {
        return this.root;
    }

    public Presenter getPresenter()
    {
        return this.presenter;
    }

    public void setLabelText()
    {
        this.wert.setText(this.presenter.toString());
    }

    public double getAmplitude()
    {
        return this.amplitude.getValue();
    }

    public double getPhase()
    {
        return this.phase.getValue();
    }

    public double getFrequenz()
    {
        return this.frequenz.getValue();
    }

    public double getZoom()
    {
        return this.zoom.getValue();
    }

    public Canvas getCanvas()
    {
        return this.canvas;
    }

    public void drawSinus()
    {
        this.gc.clearRect(0, 0, 700, 400);

        double yWert;
        double neuerYWert;

        this.gc.strokeLine(this.canvas.getWidth() / 2, 0, this.canvas.getWidth() / 2, this.canvas.getHeight());
        this.gc.strokeLine(0, this.canvas.getHeight() / 2, this.canvas.getWidth(), this.canvas.getHeight() / 2);

        for (int i = 0; i <= this.canvas.getWidth(); i++)
        {
            yWert = this.presenter.getYWert(i);
            neuerYWert = this.presenter.getYWert(i + 1);
            this.gc.strokeLine(i, yWert, i + 1, neuerYWert);
            yWert = neuerYWert;
        }
        this.wert.setText(this.presenter.toString());
    }

}
