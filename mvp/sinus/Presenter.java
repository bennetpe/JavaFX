package mvp.sinus;

public class Presenter
{
    private View v;

    private Model m;

    public Presenter(View view)
    {
        this.v = view;
    }

    public void setModel(Model model)
    {
        this.m = model;
    }

    public Model getModel()
    {
        return this.m;
    }

    public View getView()
    {
        return this.v;
    }

    public double getYWert(int i)
    {
        return ((this.v.getAmplitude() * Math.sin(this.v.getFrequenz() * -((i - this.v.getCanvas().getWidth() / 2) / this.v.getZoom()) + this.v.getPhase())) * this.v.getZoom() + this.v.getCanvas().getHeight() / 2);
    }

    @Override
    public String toString()
    {
        return (Math.round(this.v.getAmplitude() * 100) / 100.00 + " sin(" + Math.round(this.v.getFrequenz() * 100) / 100.00 + "* x + " + Math.round(this.v.getPhase() * 100) / 100.00 + ")");
    }
}