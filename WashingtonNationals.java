import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class WashingtonNationals here.
 * 
 * @author Ellis Goldman 
 * @version 5-19-2020
 */
public class WashingtonNationals extends Team
{
    

    /**
     * Constructor for objects of class WashingtonNationals
     */
    public WashingtonNationals() throws IOException
    {
       super("WashingtonNationals.txt");
    }

   
     /**
     * Calculates and returns the maximum batting average on the team.
     * 
     * @return the max batting average
     */
    public double findMaxBattingAverage()
    {
        double max = 0.0;
        ArrayList<Player> teamRoster = getTeamRoster();
        for(int i = 0; i<teamRoster.size(); i++)
        {
            if(teamRoster.get(i).getBattingAverage() > max)
            {
                max = teamRoster.get(i).getBattingAverage();
            }
        }
        return max;
    }

    /**
     * Returns the name of the player with the highest batting average.
     * 
     * @return the player with the max AVG
     */
    public String findMaxBattingAveragePlayer()
    {
        double max = 0.0;
        String pl = "";
        ArrayList<Player> teamRoster = getTeamRoster();
        for(int i = 0; i<teamRoster.size(); i++)
        {
            if(teamRoster.get(i).getBattingAverage() > max)
            {
                pl = teamRoster.get(i).getName();
            }
        }
        return pl;
    }

    /**
     * Calculates and returns the maximum slugging percentage on the team.
     * 
     * @return the max slugging percentage
     */
    public double findMaxSluggingPercentage()
    {
        double max = 0.0;
        ArrayList<Player> teamRoster = getTeamRoster();
        for(int i = 0; i<teamRoster.size(); i++)
        {
            if(teamRoster.get(i).getSluggingPercentage() > max)
            {
                max = teamRoster.get(i).getSluggingPercentage();
            }
        }
        return max;
    }

    /**
     * Returns the name of the player with the highest slugging percentage.
     * 
     * @return the player with the highest SLG
     */
    public String findMaxSluggingPercentagePlayer()
    {
        double max = 0.0;
        String play = "";
        ArrayList<Player> teamRoster = getTeamRoster();
        for(int i = 0; i<teamRoster.size(); i++)
        {
            if(teamRoster.get(i).getSluggingPercentage() > max)
            {
                play = teamRoster.get(i).getName();
            }
        }
        return play;
    }

    /**
     * Calculates and returns the average batting average for the team.
     * 
     * @return the average batting average
     */
    public double calculateTeamBattingAverage()
    {
        double sum = 0.0;
        ArrayList<Player> teamRoster = getTeamRoster();
        int length = teamRoster.size();
        for(int i = 0; i< teamRoster.size(); i++)
        {
            sum += teamRoster.get(i).getBattingAverage();
        }
        return (double)sum/length;
    }

    /**
     * Calculates and returns the the average slugging percentage for the team.
     * 
     * @return the average slugging percentage 
     */
    public double calculateTeamSluggingPercentage()
    {
        ArrayList<Player> teamRoster = getTeamRoster();
        int length = teamRoster.size();
        double sum = 0.0;
        for(int i = 0; i< teamRoster.size(); i++)
        {
            sum += teamRoster.get(i).getSluggingPercentage();
        }
        return (double)sum/length;
    }

    /**
     * Sorts the last names of the players in alphabetical order
     * using insertion sort.
     */
    public void sortPlayerNames()
    {
        ArrayList<Player> teamRoster = getTeamRoster();
        for(int outer =1; outer< teamRoster.size(); outer++)
        {
            Player temp = teamRoster.get(outer);
            int index = outer-1;
            while(index >= 0 && teamRoster.get(index).compareNameTo(temp) < 0)
            {
                teamRoster.set(index +1, teamRoster.get(index));
                index--;
            }
            teamRoster.set(index+1, temp);
        }
    }

    /**
     * Sorts the team batting averages from highest to lowest
     * using selection sort.
     * 
     */
    public void sortBattingAverages()
    {
        int mindex;
        ArrayList<Player> teamRoster = getTeamRoster();
        for(int outer =0; outer<teamRoster.size()-1; outer++)
        {
            mindex = outer;
            for(int inner = outer+1; inner<teamRoster.size(); inner++)
            {
                if(teamRoster.get(mindex).compareBattingAverageTo(teamRoster.get(inner)) < 0)
                {
                    mindex = inner;
                }
            }
            Player temp = teamRoster.get(outer);
            teamRoster.set(outer, teamRoster.get(mindex));
            teamRoster.set(mindex, temp);
        }

    }

    /**
     * Sorts the team slugging percentages from highest to lowest
     * using insertion sort.
     */
    public void sortSluggingPercentages()
    {
        ArrayList<Player> teamRoster = getTeamRoster();
        for(int outer = 1; outer <teamRoster.size(); outer++)
        {
            Player temp = teamRoster.get(outer);
            int index = outer-1;
            while(index >= 0 && teamRoster.get(index).compareSluggingPercentageTo(temp) < 0)
            {
                teamRoster.set(index+1, teamRoster.get(index));
                index--;
            }
            teamRoster.set(index+1, temp);
        }
    }

    /**
     * Sorts hits descending using non-recursive merge sort.
     */
    public void sortHits()
    {
        ArrayList<Player> teamRoster = getTeamRoster();
        int size = teamRoster.size();
        int mid = size/2;
        ArrayList <Player> merged  = new ArrayList<Player>(size);
        int findex = 0;
        int sindex = mid;
        sortHitsHelper(0, mid);
        sortHitsHelper(0, mid);
        sortHitsHelper(mid, size);
        for(int i= 0; i<size; i++)
        {
            if (findex>=mid)
            {
                merged.add(teamRoster.get(sindex));
                sindex++;
            }
            else if(sindex >= size)
            {
                merged.add(teamRoster.get(findex));
                findex++;
            }
            else if(teamRoster.get(findex).compareHitsTo(teamRoster.get(sindex)) > 0)
            {
                merged.add(teamRoster.get(findex));
                findex++;
            }
            else
            {
                merged.add(teamRoster.get(sindex));
                sindex++;
            }
        }
        teamRoster = merged;
    }

    /**
     * Sorts a descending portion of the array list based upon number of hits,
     * using selection sort.
     * 
     * @param start the first index to start the sort
     * @param end   one past the last index to sort
     */
    private void sortHitsHelper(int start, int end)
    {
        ArrayList<Player> teamRoster = getTeamRoster();
        int mindex = 0;
        for(int outer = start; outer< end-1; outer++)
        {
            mindex = outer;
            for(int inner = outer+1; inner<end; inner++)
            {
                if(teamRoster.get(mindex).compareHitsTo(teamRoster.get(inner)) < 0)
                {
                    mindex = inner;
                }
            }
            Player temp = teamRoster.get(outer);
            teamRoster.set(outer, teamRoster.get(mindex));
            teamRoster.set(mindex, temp);
        }
    }

    /**
     * Sorts the number of home runs in a descending manner using selection sort.
     */
    public void sortHomeRuns()
    {
        int mindex;
        ArrayList<Player> teamRoster = getTeamRoster();
        for(int outer = 0; outer<teamRoster.size()-1; outer++)
        {
            mindex = outer;
            for(int inner = outer+1; inner<teamRoster.size(); inner++)
            {
                if(teamRoster.get(mindex).compareHomeRunsTo(teamRoster.get(inner)) < 0)
                {
                    mindex = inner;
                }
            }
            Player temp = teamRoster.get(outer);
            teamRoster.set(outer, teamRoster.get(mindex));
            teamRoster.set(mindex, temp);
        }
    }

    /**
     * Binary search for a player name. 
     * 
     * @param name  the name being searched for
     * @return an arraylist of names that occured on the roster
     *         returns null if there are no matches
     */
    public ArrayList<Player> searchTeamRosterName(String name)
    {
        ArrayList<Player> teamRoster = getTeamRoster();
        sortPlayerNames();
        return searchTeamRosterNameHelper(name, 0, teamRoster.size()-1);
    }

    /**
     * Recursive binary search for a player's name. This is a helper for 
     * searchTeamRosterName
     * 
     * @precondition    the arraylist must be presorted by the player's names
     * 
     * @param name  the player name to search for
     * @param low   the smallest index that needs to be checked
     * @param high  the highest index that needs to be checked
     * 
     * @return a Player arraylist of all Player objects with a specified name.
     *              returns null if there are no matches
     */
    private ArrayList<Player> searchTeamRosterNameHelper(String name, int low, int high)
    {
        ArrayList<Player> teamRoster = getTeamRoster();
        if(low > high) //base case 1
        {
            return null;
        }
        int mid = (low+high)/2;
        int compare = teamRoster.get(mid).getName().compareTo(name);

        if(compare == 0) //base case 2
        {
            return retrieveMatchedNames(name, mid);
        }
        if(compare > 0)
        {
            return searchTeamRosterNameHelper(name, low, mid-1);
        }
        return searchTeamRosterNameHelper(name, mid+1, high);
    }

    /**
     * Supports Binary Search method to get the full range of matches.
     * 
     * @precondition the arraylist must be presorted by the player's names
     * 
     * @param name  the name of the player being searched for
     * @param index the index where a match was found
     * 
     * @return A Player arraylist with objects from players with a specified name.
     *                  returns null if there are no matches
     */
    private ArrayList <Player> retrieveMatchedNames(String name, int index)
    {
        ArrayList<Player> teamRoster = getTeamRoster();
        int findex = index -1;
        while(findex>= 0 && teamRoster.get(findex).getName().equals(name))
        {
            findex--;
        }
        findex++;
        int lindex = index+1;
        while(lindex<teamRoster.size() && teamRoster.get(lindex).getName().equals(name))
        {
            lindex ++;
        }
        lindex--;

        ArrayList <Player> matches = new ArrayList<Player>();
        int length = lindex-findex+1;
        for(int i = 0; i<length; i++)
        {
            matches.add(teamRoster.get(findex+i));
        }
        return matches;
    }

    /**
     * Prints and formats the headers for name, position, games played, runs, hits,
     * doubles, triples, home runs, RBI's, strike outs, batting average, and slugging percentage.
     */
    public void printHeader()
    {
        System.out.println("\n\n");
        System.out.printf("%-12s %-9s %-15s %-5s %-5s %-5s %-5s %-5s %-5s %-5s %-5s %-5s \n", 
            "Player Name", "Position", "Games Played", "Runs", "Hits", "2B", "3B",
            "HR", "RBI's", "SO", "AVG", "SLG");
    }

    /**
     * Prints a formatted list of all the info regarding the team roster.
     */
    public void printRoster()
    {
        ArrayList<Player> teamRoster = getTeamRoster();
        printRoster(teamRoster);
    }

    /**
     * Prints all of the team roster.
     * 
     * @param plays the arraylist of player data
     */
    public void printRoster(ArrayList<Player> plays)
    {
        if(plays==null || plays.size()==0)
        {
            System.out.println("\nVoid of team data.");
            return;
        }
        printHeader();
        for(Player p: plays)
        {
            System.out.println(p);
        }
    }

    /**
     * Prints a menu for the user who can then use the various options.
     */
    public void printMenu()
    {
        System.out.println("\n\nEnter option: ");
        System.out.println("\t 1 - Print all Nationals data \n" +
            "\t 2 - Print highest batting average \n" +
            "\t 3 - Print highest slugging percentage \n" +
            "\t 4 - Print Astros overall batting average \n" +
            "\t 5 - Print Astros overall slugging percentage \n" +
            "\t 6 - Sort players by name \n" +
            "\t 7 - Sort by batting average, descending \n" +
            "\t 8 - Sort by slugging percentage, descending \n" +
            "\t 9 - Sort by hits, descending \n" + 
            "\t 10 - Sort by number of home runs, descending \n" +
            "\t 11 - Search for a given player's name \n" +
            "\t 12 - Quit \n");
    }

    /**
     * Prints the max batting average with the player's name.
     */
    public void printBattingAverageMax()
    {
        System.out.println(findMaxBattingAveragePlayer() + 
            " has the highest AVG on the Nationals with a batting average of " + 
            findMaxBattingAverage( ) + ".");

    }

    /**
     * Prints the max slugging percentage with the player's name.
     */
    public void printSluggingPercentageMax()
    {
        System.out.println(findMaxSluggingPercentagePlayer() + 
            " has the highest SLG on the Nationals with a slugging percentage of " + 
            findMaxSluggingPercentage( ) + ".");
    }

    /**
     * Prints the team batting average.
     */
    public void printTeamAverage()
    {
        System.out.printf("Nationals overall team batting average is is %5.2f \n" , 
            calculateTeamBattingAverage());
    }

    /**
     * Prints the team slugging percentage.
     */
    public void printTeamSluggingPercentage()
    {
        System.out.printf("Nationals overall team slugging percentage is is %5.2f \n" , 
            calculateTeamSluggingPercentage());
    }

    /**
     * Interacts with the user based on their input values.
     * 
     * @return the completed printed output
     */
    public boolean interactWithUser()
    {
        Scanner in = new Scanner(System.in);
        boolean complete = false;
        printMenu();
        int choice = in.nextInt();
        in.nextLine();

        if(choice == 1)
        {
            printRoster();
        }
        else if(choice == 2)
        {
            printBattingAverageMax();
        }
        else if(choice == 3)
        {
            printSluggingPercentageMax();
        }
        else if(choice == 4)
        {
            printTeamAverage();
        }
        else if(choice == 5)
        {
            printTeamSluggingPercentage();
        }
        else if(choice == 6)
        {
            sortPlayerNames();
            printRoster();
        }
        else if(choice == 7)
        {
            sortBattingAverages();
            printRoster();
        }
        else if(choice == 8)
        {
            sortSluggingPercentages();
            printRoster();
        }
        else if(choice == 9)
        {
            sortHits();
            printRoster();
        }
        else if(choice == 10)
        {
            sortHomeRuns();
            printRoster();
        }
        else if(choice == 11)
        {
            System.out.print("\n\tWhich last name do you want to search for?\n\t");
            String name = in.next();
            printRoster(searchTeamRosterName(name));
        }
        else if(choice == 12)
        {
            complete = true;
        }
        return complete;
    }

    /**
     * Runs the main method which interacts with the user based on the information
     * they desire to attain.
     * 
     * @param args  user's information from the command line
     * 
     * @throws IOException  if file with the player information cannot be found
     */
    public static void main (String [] args) throws IOException
    {
        WashingtonNationals base = new WashingtonNationals();
        boolean over = false;
        while(! over)
        {
            over = base.interactWithUser();
        }
    }
}
