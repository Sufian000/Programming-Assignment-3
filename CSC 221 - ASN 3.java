import java.util.Scanner;

public class BaseballStats {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int teamCount = 0;
        double bestWinningAverage = 0;
        int bestTeamID = 0;
        
        while (true) {
            
            System.out.print("Enter team ID number: ");
            int teamID = input.nextInt();
            
            if (teamID == 0) {
                break; // exit loop if team ID is 0
            }
            
            System.out.print("Enter number of wins: ");
            int wins = input.nextInt();
            
            System.out.print("Enter number of losses: ");
            int losses = input.nextInt();
            
            int gamesPlayed = wins + losses;
            int gamesRemaining = 25 - gamesPlayed;
            
            System.out.println("Team " + teamID + ":");
            System.out.println(wins + " wins   " + losses + " losses");
            System.out.println("Total number of games played is " + gamesPlayed + "\t" + gamesRemaining + " games remaining");
            
            if (gamesPlayed == 25) {
                System.out.println("The season is finished.");
            } else {
                System.out.println("The season is not finished.");
            }
            
            double winningAverage = (double) wins / gamesPlayed;
            System.out.printf("The winning average is %.4f\n", winningAverage);
            
            if (gamesRemaining >= wins) {
                System.out.println("Number of games remaining is greater than or equal to number won.");
            } else {
                System.out.println("Number of games remaining is not greater than number lost.");
            }
            
            if (gamesRemaining > losses) {
                System.out.println("Number of games remaining is greater than number lost.");
            } else {
                System.out.println("Number of games remaining is not greater than number lost.");
            }
            
            System.out.println();
            teamCount++;
            
            if (gamesPlayed > 25) {
                System.out.println("Error: Too many games played. Please enter new data.");
                continue; // skip to next iteration of loop
            }
            
            if (wins == gamesRemaining) {
                System.out.println("Team has won all of its remaining games.");
            } else if (losses == gamesRemaining) {
                System.out.println("Team has lost all of its remaining games.");
            } else {
                double potentialWinningAverage = (double) (wins + gamesRemaining) / 25;
                System.out.printf("If the team wins all of its remaining games, the new record would be %d-%d, with a winning average of %.4f\n", wins + gamesRemaining, losses, potentialWinningAverage);
                
                double potentialLosingAverage = (double) wins / 25;
                System.out.printf("If the team loses all of its remaining games, the new record would be %d-%d, with a winning average of %.4f\n", wins, losses + gamesRemaining, potentialLosingAverage);
            }
            
            if (gamesPlayed == 25) {
                if (winningAverage > bestWinningAverage && winningAverage != 1) {
                    bestWinningAverage = winningAverage;
                    bestTeamID = teamID;
                }
            }
        }
        
        System.out.println("Total number of teams in the league: " + teamCount);
        System.out.println("Team with the best winning average that is not exactly 1: " + bestTeamID);
        
    }

}