package gui.exam.soccer.fin;

class ScoreEntry
{
    private String team;

    private int score;

    // neu
    private int gegentore;

    private int gesamtTore = 0;

    private int siege;

    private int niederlagen;

    private int unetschieden;

    public ScoreEntry(String team, int goalsActive, int goalsPassive)
    {
        if (team == null || team.length() == 0)
        {
            throw new IllegalArgumentException("Ungültige Team-Kennung");
        }
        if (goalsActive < 0 || goalsPassive < 0)
        {
            throw new IllegalArgumentException("Negative Torezahl");
        }
        this.team = team;
        update(goalsActive, goalsPassive);
    }

    private void update(int gA, int gP)
    {
        if (gA > gP)
        {
            score += 3;
            this.siege += 1;
        }
        else if (gA == gP)
        {
            score += 1;
            this.unetschieden += 1;

        }

        else
        {
            this.niederlagen += 1;
        }

        this.gesamtTore = gA;
        this.gegentore = gP;
    }

    public void add(ScoreEntry se)
    {
        if (!team.equals(se.team))
        {
            return;
        }
        score += se.score;
        this.gesamtTore += se.gesamtTore;
        this.gegentore += se.gegentore;
        this.niederlagen += se.niederlagen;
        this.siege += se.siege;
        this.unetschieden += se.unetschieden;
    }

    public void subtract(ScoreEntry se)
    {
        if (!team.equals(se.team))
        {
            return;
        }
        score -= se.score;
        this.gesamtTore -= se.gesamtTore;
        this.gegentore -= se.gegentore;
        this.niederlagen -= se.niederlagen;
        this.siege -= se.siege;
        this.unetschieden -= se.unetschieden;
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
        if (!(o instanceof ScoreEntry))
        {
            return false;
        }
        return team.equals(((ScoreEntry) o).team);
    }

    public String toString()
    {
        return team + ": " + score + "(" + gesamtTore + ":" + gegentore + " " + siege + "/" + unetschieden + "/" + niederlagen + ")";
    }

}
