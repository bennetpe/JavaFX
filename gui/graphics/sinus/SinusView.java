package gui.graphics.sinus;

import java.text.DecimalFormat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

public class SinusView extends VBox
{
    private SinusPresenter presenter;

    private Slider amplitude;

    private Slider frequenz;

    private Slider phase;

    private Slider zoom;

    private Label function;

    private Canvas canvas = new Canvas(700, 400);

    private GraphicsContext gc;

    private Label ampL;

    private Label freqL;

    private Label phaseL;

    private Label zoomL;

    private Pane zeichenflaeche = new Pane();

    private Line l;

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public void setPresenter(SinusPresenter p)
    {
        this.presenter = p;
    }

    public SinusView()
    {
        this.initView();

    }

    public void initView()
    {

        this.setWidth(500);
        this.setHeight(250);
        this.ampL = new Label("Amplitude:");
        this.freqL = new Label("Frequenz:");
        this.phaseL = new Label("Phase:");
        this.zoomL = new Label("Zoom");

        this.amplitude = new Slider(-6.0, 6.0, 0.0);
        this.amplitude.setShowTickLabels(true);
        this.amplitude.setShowTickMarks(true);
        this.amplitude.setMinorTickCount(1);
        this.amplitude.setMajorTickUnit(2);
        this.amplitude.setPrefSize(400, 6);
        this.amplitude.setId("amplitude");

        this.frequenz = new Slider(0.0, 40.0, 0.0);
        this.frequenz.setShowTickLabels(true);
        this.frequenz.setShowTickMarks(true);
        this.frequenz.setMinorTickCount(5);
        this.frequenz.setMajorTickUnit(10);
        this.frequenz.setPrefSize(400, 6);
        this.frequenz.setId("frequency");

        this.phase = new Slider(-10.0, 10.0, 0.0);
        this.phase.setShowTickLabels(true);
        this.phase.setShowTickMarks(true);
        this.phase.setMinorTickCount(2);
        this.phase.setMajorTickUnit(5);
        this.phase.setPrefSize(400, 6);
        this.phase.setId("phase");

        this.zoom = new Slider(10, 210, 110);
        this.zoom.setShowTickMarks(true);
        this.zoom.setShowTickLabels(true);
        this.zoom.setMinorTickCount(50);
        this.zoom.setMajorTickUnit(100);
        this.zoom.setPrefSize(400, 6);
        this.zoom.setId("zoom");

        this.function = new Label("0.57 * sin(2.09*x)");
        HBox hb1 = new HBox(10);
        HBox hb2 = new HBox(10);
        HBox hb3 = new HBox(10);
        HBox hb4 = new HBox(10);
        hb1.getChildren().addAll(this.ampL, this.amplitude);
        hb2.getChildren().addAll(this.freqL, this.frequenz);
        hb3.getChildren().addAll(this.phaseL, this.phase);
        hb4.getChildren().addAll(this.zoomL, this.zoom);

        this.gc = this.canvas.getGraphicsContext2D();
        this.gc.strokeLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());
        this.gc.strokeLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);

        this.zeichenflaeche.getChildren().addAll(this.canvas);
        this.getChildren().addAll(this.function, this.zeichenflaeche, hb1, hb2, hb3, hb4);

        this.amplitude.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number newV)
            {
                SinusView.this.gc.clearRect(0, 0, 700, 400);
                gui.graphics.sinus.SinusView.this.presenter.setAmplitude((double) newV);
                SinusView.this.function.setText(String.valueOf(df2.format(SinusView.this.presenter.getAmplitude())) + "* sin(" + String.valueOf(df2.format(SinusView.this.presenter.getFrequenz())) + "*x + " + String.valueOf(df2.format(SinusView.this.presenter.getPhase())) + ")");
                SinusView.this.drawSinus();
            }
        });

        this.frequenz.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number newV)
            {
                SinusView.this.gc.clearRect(0, 0, 700, 400);
                gui.graphics.sinus.SinusView.this.presenter.setFrequenz((double) newV);
                SinusView.this.function.setText(String.valueOf(df2.format(SinusView.this.presenter.getAmplitude())) + "* sin(" + String.valueOf(df2.format(SinusView.this.presenter.getFrequenz())) + "*x + " + String.valueOf(df2.format(SinusView.this.presenter.getPhase())) + ")");
                SinusView.this.drawSinus();
            }
        });

        this.phase.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number newV)
            {
                gui.graphics.sinus.SinusView.this.presenter.setPhase((double) newV);
                if (SinusView.this.presenter.getPhase() == 0)
                {
                    SinusView.this.gc.clearRect(0, 0, 700, 400);
                    SinusView.this.function.setText(String.valueOf(df2.format(SinusView.this.presenter.getAmplitude())) + "* sin(" + String.valueOf(df2.format(SinusView.this.presenter.getFrequenz())) + "*x)");
                    SinusView.this.drawSinus();
                }
                else
                {
                    SinusView.this.gc.clearRect(0, 0, 700, 400);
                    SinusView.this.function.setText(String.valueOf(df2.format(SinusView.this.presenter.getAmplitude())) + "* sin(" + String.valueOf(df2.format(SinusView.this.presenter.getFrequenz())) + "*x + " + String.valueOf(df2.format(SinusView.this.presenter.getPhase())) + ")");
                    SinusView.this.drawSinus();
                }
            }
        });

        this.zoom.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                gui.graphics.sinus.SinusView.this.presenter.setZoom((Double) newValue);
                SinusView.this.gc.clearRect(0, 0, 700, 400);
                SinusView.this.function.setText(String.valueOf(df2.format(SinusView.this.presenter.getAmplitude())) + "* sin(" + String.valueOf(df2.format(SinusView.this.presenter.getFrequenz())) + "*x + " + String.valueOf(df2.format(SinusView.this.presenter.getPhase())) + ")");
                SinusView.this.drawSinus();
            }
        });
    }

    public void drawSinus()
    {

        this.gc.clearRect(0, 0, 700, 400);

        double yWert, neuerYWERT;

        this.gc.strokeLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());
        this.gc.strokeLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);

        for (int i = 0; i < this.getWidth(); i++)
        {
            yWert = this.presenter.getYWert(i);
            neuerYWERT = this.presenter.getYWert(i + 1);
            this.gc.strokeLine(i, yWert, i + 1, neuerYWERT);
            yWert = neuerYWERT;
        }
    }
}
