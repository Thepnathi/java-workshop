/**
 * Created by thepnathi on 27/02/2018.
 */
import java.util.*;

public class Game {
    private int rounds;
    private int counter = 0;
    private int currentRounds = 1;
    private int p1RoundsWon, p2RoundsWon, p1TotalPoints, p2TotalPoints;

    public static void main(String[] args) {
        Game firstGame = new Game();
    }

    // Create an instance of a game
    public Game() {
        playGame();
    }

    // Let user set the amount of rounds
    public void setRounds(int rounds) {
        if (rounds == 0) {
            playGame();
        } else if (rounds < 0) {
            System.out.println("You cannot enter values below 0");
            playGame();
        } else {
            this.rounds = rounds;
            System.out.println("Rounds: " + getRounds());
            System.out.println("");
        }
    }

    // Getter for number of rounds
    public int getRounds() {
        return rounds;
    }

    //  Initialise the game
    public void playGame() {
        Scanner input = new Scanner(System.in);

        System.out.print("Input the number of rounds to play (min 0): ");
        int inputRounds = input.nextInt();

        // Setter for rounds
        setRounds(inputRounds);

        gameStarts();

        // Display end result of a game to user
        System.out.println("");
        System.out.println("Total wins:");
        System.out.println("Player 1: " + p1RoundsWon + "     Player 2: " + p2RoundsWon);
        System.out.println("Total points:");
        System.out.println("Player 1: " + p1TotalPoints + "     Player 2: " + p2TotalPoints);
        System.out.println("Average points per round:");
        System.out.println("Player 1: " + (p1TotalPoints / rounds) + "     Player 2: " + (p2TotalPoints / rounds));
        System.out.println("");
        System.out.println("Overall the winner is " + winningPlayer(p1TotalPoints, p2TotalPoints));
        // why does it print twice?
        // System.out.println("Rounds: " + getRounds());
    }

    // Main method to generate the gameplay
    public void gameStarts() {
        while (rounds > counter) {
            // Array to stores player 1 and 2 dice data
            ThreeDiceScorer[] playerOne = new ThreeDiceScorer[rounds];
            ThreeDiceScorer[] playerTwo = new ThreeDiceScorer[rounds];

            // Generate random 3 dice value for both players
            playerOne[counter] = new ThreeDiceScorer(randomDieValue(), randomDieValue(), randomDieValue());
            playerTwo[counter] = new ThreeDiceScorer(randomDieValue(), randomDieValue(), randomDieValue());

            System.out.println("Round: " + currentRounds);

            // Calc the total score - sum of three dice + extra for each player
            // Display the result - 3 dice value + total score
            System.out.print("Player 1: ");
            playerOne[counter].calcTotalScore();
            System.out.print(" " + playerOne[counter].getDie1() + " " + playerOne[counter].getDie2() + " " + playerOne[counter].getDie3() + " Points: ");
            System.out.println(playerOne[counter].getTotalScore());

            System.out.print("Player 2: ");
            playerTwo[counter].calcTotalScore();
            System.out.print(" " + playerTwo[counter].getDie1() + " " + playerTwo[counter].getDie2() + " " + playerTwo[counter].getDie3() + " Points: ");
            System.out.println(playerTwo[counter].getTotalScore());

            int p1Score = playerOne[counter].getTotalScore();
            int p2Score = playerTwo[counter].getTotalScore();

            // Push each round total points into an attribute
            p1TotalPoints += p1Score;
            p2TotalPoints += p2Score;

            // Determines who won the round based on total points
            if (p1Score == p2Score) {
                System.out.println("Round is tied!");
            } else if (p1Score > p2Score){
                System.out.println("Round winner is player 1");
                p1RoundsWon++;
            } else {
                System.out.println("Round winner is player 2");
                p2RoundsWon++;
            }
            System.out.println("");
            counter++;
            currentRounds++;
        }
    }

    // Determines the winner based on rounds won
    public String winningPlayer(int p1, int p2) {
        if (p1 == p2) {
            return "It is a draw";
        } else if (p1 > p2) {
            return "Player 1";
        } else {
            return "Player 2";
        }
    }

    // Method to generate random number between 1 to 6
    public int randomDieValue() {
        int randomNum = 1 + (int) (6 * Math.random());
        return randomNum;
    };


}
