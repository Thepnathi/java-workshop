
/**
 * Created by thepnathi on 28/02/2018.
 */

public class Average {

    // attributes and array to store all possible combinations of three dice

    private double fairTotal, unfairTotal;
    private int counter = 0;
    private ThreeDiceScorer[] fairDiceArray = new ThreeDiceScorer[216];
    private ThreeDiceScorer[] unfairDiceArray = new ThreeDiceScorer[216];

    public static void main(String[] args) {
        Average findAverage = new Average();
    }

    // Object to run the methods
    public Average() {
        fairThreeDiceAverage();
        unfairThreeDiceAverage();
        // There are 216 combinations for three dice, 6^3
        System.out.println("The average for three fair dice is " + fairTotal / 216);
        System.out.println("The average for two fair dice and one unfair is " + unfairTotal / 216);
    }

    // Generate all possible combination between three dice
    // Push the sum of the three dice values + extra points into a fairTotal variable
    public void fairThreeDiceAverage() {
        for (int i = 1; i <= 6; i++) {
            for (int j=1;j<=6;j++) {
                for (int k=1;k<=6; k++) {
                    fairDiceArray[counter] = new ThreeDiceScorer(i, j, k);
                    fairDiceArray[counter].calcTotalScore();
                    fairTotal += fairDiceArray[counter].getTotalScore();
                    counter++;
                }
            }
        }
        // reset counter;
        counter = 0;
    }

    // Generate all possible combination between two fair dice and one unfair
    // Push the sum of the three dice values + extra points into a unfairTotal variable
    public void unfairThreeDiceAverage() {
        for (int i = 1; i <= 6; i++) {
            for (int j=1;j<=6;j++) {
                for (int k=2;k<=7; k++) {
                    // unfair value die holds the val - 2,3,4,5,6,6
                    if (k == 7) {
                        unfairDiceArray[counter] = new ThreeDiceScorer(i, j, k-1);
                    } else {
                        unfairDiceArray[counter] = new ThreeDiceScorer(i, j, k);
                    }
                    unfairDiceArray[counter].calcTotalScore();
                    unfairTotal += unfairDiceArray[counter].getTotalScore();
                    counter++;
                }
            }
        }
        // reset counter
        counter = 0;
    }
}
