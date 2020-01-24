package gui.exam.SS2016;

import java.util.*;

public class Model
{
    private List<Match> matches;
    private List<ScoreEntry> scores;
    
    public List<Match> getMatches()
    {
        return matches;
    }

    public void setMatches(List<Match> matches)
    {
        this.matches = matches;
    }

    public List<ScoreEntry> getScores()
    {
        return scores;
    }

    public void setScores(List<ScoreEntry> scores)
    {
        this.scores = scores;
    }

    public Model()
    {
        matches = new ArrayList<>();
        scores = new ArrayList<>();
    }
    
    public void addMatch(Match m)
    {
        matches.add(m);
        addScores(m.getTeamHome(), m.getGoalsHome(), m.getGoalsGuest());
        addScores(m.getTeamGuest(), m.getGoalsGuest(), m.getGoalsHome());
        scores.sort(Comparator.comparingInt((p)->-p.getScore()));
    }

    private void addScores(String team, int goalsTeam, int goalsOpponent)
    {
        ScoreEntry newSe = new ScoreEntry(team, goalsTeam, goalsOpponent);
        int index = scores.indexOf(newSe);
        if(index == -1)
        {
            scores.add(newSe);
        }
        else
        {
            ScoreEntry oldSe = scores.get(index);
            oldSe.add(newSe);
        }
    }
    
    public void deleteMatch(Match m)
    {
        matches.remove(m);
        subtractScores(m.getTeamHome(), m.getGoalsHome(), m.getGoalsGuest());
        subtractScores(m.getTeamGuest(), m.getGoalsGuest(), m.getGoalsHome());
        scores.sort(Comparator.comparingInt((p)->-p.getScore()));
    }

    private void subtractScores(String team, int goalsTeam, int goalsOpponent)
    {
        ScoreEntry newSe = new ScoreEntry(team, goalsTeam, goalsOpponent);
        int index = scores.indexOf(newSe);
        if(index >= 0)
        {
            ScoreEntry oldSe = scores.get(index);
            oldSe.subtract(newSe);
        }
    }

    public Match[] getAllMatches()
    {
        return matches.toArray(new Match[0]);
    }

    public ScoreEntry[] getAllScores()
    {
        return scores.toArray(new ScoreEntry[0]);
    }
}
