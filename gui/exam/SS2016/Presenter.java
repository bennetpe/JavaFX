package gui.exam.SS2016;

public class Presenter
{
    private Model m;
    private View v;
    private Dialog d;

    public Presenter(Model m, View v)
    {
         this.m = m;
         this.v = v;
    }

    public Presenter()
    {
        // TODO Auto-generated constructor stub
    }

    public void addMatch(Match match)
    {
        v.addMatch(match);
        v.updateScores(m.getAllScores());
    }


    public void deleteMatch(Match match)
    {
        m.deleteMatch(match);
        v.updateScores(m.getAllScores());
    }

    public void fillScoreList() {
       v.setScoreList( m.getAllScores() );
    }

    public void fillMatchList()
    {
       v.setMatchList (m .getAllMatches());     
    }

    public void setModel(Model m)
    {
        this.m = m;
    }

    public void setView(View v)
    {
        this.v = v;
    }  
    
    public void updateAllScores() {
        v.updateScores(m.getAllScores());
    }
   
    public void showDialog() {
        d.onShowDialog();
    }

    public void setView(Dialog d)
    {
        this.d = d;
    }
    
    public void onCancelDialog() {
        d.cancelFuntion(); 
    }

    public void onAddScore(String teamA, String teamB, int scoreA, int scoreB)
    {
        Match match = new Match(teamA, teamB, scoreA, scoreB);
        m.addMatch(match);
    }
    
}
