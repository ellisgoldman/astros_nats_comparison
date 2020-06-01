
/**
 * Player takes into account multiple types of baseball analytics and provides the 
 * skeleton for the variables being used in other classes.
 * 
 * @author Ellis Goldman
 * @version 5-21-2020
 */
public class Player 
{
    private String name;
    private String position;
    private int gamesPlayed;
    private int atBats;
    private int runs;
    private int hits;
    private int doubles;
    private int triples;
    private int homeRuns;
    private int rBIS;
    private int strikeOuts;
    private double battingAverage;
    private double sluggingPercentage;
    /**
     * Constructor for objects of class Player.
     * 
     * @param n the name of the player
     * @param pos   the player's position
     * @param games the number of games played
     * @param bats  the number of at bats
     * @param r     the number of runs
     * @param h     the number of hits
     * @param dbs   the number of doubles
     * @param trp   the number of triples
     * @param hR    the number of home runs 
     * @param rb    the number of RBI's produced
     * @param so    the number of strike outs
     * @param batting   the player's batting average
     * @param slugging  the player's slugging percentage
     */
    public Player(String n, String pos, int games, int bats, int r, int h, int dbs, int trp, int hR,
    int rb, int so, double batting, double slugging)
    {
        name = n;
        position = pos;
        gamesPlayed = games;
        atBats = bats;
        runs = r;
        hits = h;
        doubles = dbs;
        triples = trp;
        homeRuns = hR;
        rBIS = rb;
        strikeOuts = so;
        battingAverage = batting;
        sluggingPercentage = slugging;
    }

    /**
     * Returns the player's name.
     * 
     * @return the player's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the player's position
     * 
     * @return the player's position
     */
    public String getPosition()
    {
        return position;
    }

    /**
     * Returns the number of games played
     * 
     * @return the number of games played
     */
    public int getGamesPlayed()
    {
        return gamesPlayed;
    }

    public int getAtBats()
    {
        return atBats;
    }

    /**
     * Returns the number of runs generated
     * 
     * @return  the number of runs
     */
    public int getRuns()
    {
        return runs;
    }

    /**
     * Returns the number of hits
     * 
     * @return the number of hits
     */
    public int getHits()
    {
        return hits;
    }

    /**
     * Returns the number of doubles hit
     * 
     * @return the number of doubles
     */
    public int getDoubles()
    {
        return doubles;
    }

    /**
     * Returns the number of triples hit
     * 
     * @return the number of triples
     */
    public int getTriples()
    {
        return triples;
    }

    /**
     * Returns the number of home runs hit
     * 
     * @return the number of home runs
     */
    public int getHomeRuns()
    {
        return homeRuns;
    }

    /**
     * Returns the number of runs batted in
     * 
     * @return the number of RBI's
     */
    public int getRBIS()
    {
        return rBIS;
    }

    /**
     * Returns the number of strike outs
     * 
     * @return the number of strike outs
     */
    public int getStrikeOuts()
    {
        return strikeOuts;
    }

    /**
     * Returns the player's batting average
     * 
     * @return the player's batting average
     */
    public double getBattingAverage()
    {
        return battingAverage;
    }

    /**
     * Return the player's slugging percentage
     * 
     * @return the player's slugging percentage
     */
    public double getSluggingPercentage()
    {
        return sluggingPercentage;
    }

    /**
     * Returns a formatted string with the player's name, position, and batting average.
     * 
     * @return a formatted string with player info
     */
    @Override
    public String toString()
    {
        String str = getName() + ", " + getPosition() + ", " +  getGamesPlayed()  + ", " +
        getAtBats() + ", " + getRuns() + ", " + getHits() + ", " + getDoubles() + ", " + getTriples() +
        ", " + getHomeRuns() + ", " + getRBIS() + ", " + getStrikeOuts() + ", " + getBattingAverage() +
        ", " + getSluggingPercentage();
        return str;
    }

    /**
     * Prints out the formatted data from the toString method.
     */
    public void print()
    {
        System.out.println(toString());
    }

    public int compareNameTo(Player p)
    {
        return this.name.toLowerCase().compareTo(p.getName().toLowerCase());
    }

    public double compareBattingAverageTo(Player p)
    {
        return (battingAverage - p.getBattingAverage());
    }

    public double compareSluggingPercentageTo(Player p)
    {
        return (sluggingPercentage - p.getSluggingPercentage());
    }

    public int compareHitsTo(Player p)
    {
        return (hits - p.getHits());
    }

    public int compareHomeRunsTo(Player p)
    {
        return (homeRuns - p.getHomeRuns());
    }
}
