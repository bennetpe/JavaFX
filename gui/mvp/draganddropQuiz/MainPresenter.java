package gui.mvp.draganddropQuiz;


public class MainPresenter
{
    private MainView view;

    private Model model;

    private DetailPresenter detailPresenter;

    private OverViewPresenter overViewPresenter;

    public MainPresenter(MainView view)
    {
        this.view = view;
        this.model = new Model();
        this.detailPresenter = new DetailPresenter(this.model);
        this.overViewPresenter = new OverViewPresenter(this.model);
    }

    public void setDetailView()
    {
        this.detailPresenter = new DetailPresenter(this.model);
        this.view.setCenter(this.detailPresenter.getView());
    }

    public void continues()
    {
        this.view.setCenter(this.detailPresenter.getView());
    }

    public void setOverView()
    {
        this.view.setCenter(this.overViewPresenter.getView());
    }

}
