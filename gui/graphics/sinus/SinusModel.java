package gui.graphics.sinus;

public class SinusModel
{
    private double amplitudeModel, frequenzModel, phaseModel, zoomModel;

    public SinusModel()
    {
        this.amplitudeModel = 2;
        this.frequenzModel = 1;
        this.phaseModel = 0;
        this.zoomModel = 10;
    }

    public double getAmplitudeModel()
    {
        return this.amplitudeModel;
    }

    public void setAmplitudeModel(double amplitudeModel)
    {
        this.amplitudeModel = amplitudeModel;
    }

    public double getFrequenzModel()
    {
        return this.frequenzModel;
    }

    public void setFrequenzModel(double frequenzModel)
    {
        this.frequenzModel = frequenzModel;
    }

    public double getPhaseModel()
    {
        return this.phaseModel;
    }

    public void setPhaseModel(double phaseModel)
    {
        this.phaseModel = phaseModel;
    }

    public double getZoomModel()
    {
        // TODO Auto-generated method stub
        return this.zoomModel;
    }

    public void setZoomModel(double zoomModel)
    {
        this.zoomModel = zoomModel;
    }
}
