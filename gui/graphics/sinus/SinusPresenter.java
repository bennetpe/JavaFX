package gui.graphics.sinus;

public class SinusPresenter
{
    private SinusView view;

    private SinusModel model;

    public void setView(SinusView v)
    {
        this.view = v;
    }

    public void setModel(SinusModel m)
    {
        this.model = m;
    }

    public void setAmplitude(double i)
    {
        this.model.setAmplitudeModel(i);
    }

    public Double getAmplitude()
    {
        return this.model.getAmplitudeModel();
    }

    public Double getFrequenz()
    {
        return this.model.getFrequenzModel();
    }

    public void setFrequenz(double i)
    {
        this.model.setFrequenzModel(i);
    }

    public Double getPhase()
    {
        return this.model.getPhaseModel();
    }

    public void setPhase(double i)
    {
        this.model.setPhaseModel(i);
    }

    public void setZoom(double i)
    {
        this.model.setZoomModel(i);
    }

    public Double getZoom()
    {
        return this.model.getZoomModel();
    }

    public double getYWert(int i)
    {

        return ((this.model.getAmplitudeModel() * Math.sin(this.model.getFrequenzModel() * -((i - this.view.getWidth() / 2) / this.model.getZoomModel()) + this.model.getPhaseModel())) * this.model.getZoomModel() + this.view.getHeight() / 2);

    }

}
