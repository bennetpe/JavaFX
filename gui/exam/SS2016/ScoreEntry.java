package gui.exam.SS2016;

class ScoreEntry
{
    private String team;
    private int score;
    
    public ScoreEntry(String team, int goalsActive, int goalsPassive)
    {
        if(team == null || team.length() == 0)
        {
            throw new IllegalArgumentException("Ungültige Team-Kennung");
        }
        if(goalsActive < 0 || goalsPassive < 0)
        {
            throw new IllegalArgumentException("Negative Torezahl");
        }
        this.team = team;
        update(goalsActive, goalsPassive);
    }

    private void update(int gA, int gP)
    {
        if(gA > gP)
        {
            score += 3;
        }
        else if(gA == gP)
        {
            score += 1;
        }
    }
    
    public void add(ScoreEntry se)
    {
        if(!team.equals(se.team))
        {
            return;
        }
        score += se.score;
    }
    
    public void subtract(ScoreEntry se)
    {
        if(!team.equals(se.team))
        {
            return;
        }
        score -= se.score;
    }

    public String getTeam()
    {
        return team;
    }

    public int getScore()
    {
        return score;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof ScoreEntry))
        {
            return false;
        }
        return team.equals(((ScoreEntry)o).team);
    }
    
    public String toString()
    {
        return team + ": " + score;
    }
}
