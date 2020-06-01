import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Abstract class Team - write a description of the class here
 *
 * @author Ellis Goldman
 * @version 5-21-2020
 */
public abstract class Team {
    private ArrayList<Player> teamRoster;
    private Scanner input;

    /**
     * Constructor for the class Team.
     *
     * @param fileName the file to be read
     */
    public Team(String fileName) throws IOException {
        teamRoster = new ArrayList<Player>();
        input = new Scanner(new File(fileName)).useDelimiter(", ");
        readFile(fileName);
    }

    /**
     * Returns the TeamRoster ArrayList
     *
     * @return the team roster
     */
    public ArrayList<Player> getTeamRoster() {
        return teamRoster;
    }

    /**
     * Reads the file, creates a new Player object and adds the player to
     * the Array List.
     *
     * @param fileName the file to be read
     * @throws IOException
     */
    public void readFile(String fileName) throws IOException 
    {
        while (input.hasNext()) 
        {
            Player p = createPlayer();
            teamRoster.add(p);
        }
    }

    /**
     * Constructs a new player object based on the metrics that define a player's stats.
     */
    public Player createPlayer() {
        String name = input.next();
        String position = input.next();
        int gamesPlayed = input.nextInt();
        int atBats = input.nextInt();
        int runs = input.nextInt();
        int hits = input.nextInt();
        int doubles = input.nextInt();
        int triples = input.nextInt();
        int homeRuns = input.nextInt();
        int rBIS = input.nextInt();
        int strikeOuts = input.nextInt();
        double battingAverage = input.nextDouble();
        double sluggingPercentage = input.nextDouble();

        Player newPlayer = new Player(name, position, gamesPlayed, atBats, runs, hits, doubles, triples,
                homeRuns, rBIS, strikeOuts, battingAverage, sluggingPercentage);
        System.out.println(newPlayer);
        return newPlayer;
    }
}
