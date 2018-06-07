
/**
 * Created by thepnathi on 27/02/2018.
 */
public class ThreeDiceScorer extends ThreeDice {
    private int d1, d2, d3, totalScore;

    // constructor for ThreeDice
    public ThreeDiceScorer(int die1, int die2, int die3) {
        super(die1, die2, die3);
        this.d1 = die1;
        this.d2 = die2;
        this.d3 = die3;
    }

    // Calc the sum of three dice value and the extra points
    public void calcTotalScore() {
        int sumOfDie = d1 + d2 + d3;
        int total = 0;

        if (threeSame())
            total = sumOfDie + 60;
        else if (runOfThree())
            total = sumOfDie + 40;
        else if (pair())
            total = sumOfDie + 20;
        else if (allDifferent())
            total = sumOfDie;

        setTotalScore(total);
    }

    // Set totalScore
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    // Getter for the total score of the three dice + extra
    public int getTotalScore() {
        return totalScore;
    }

    // Override printResult()
//    public void printResult() {
//        super.printResult();
//
//        int sumOfDie = d1 + d2 + d3;
//        int total = 0;
//
//        if (threeSame())
//            total = sumOfDie + 60;
//        else if (runOfThree())
//            total = sumOfDie + 40;
//        else if (pair())
//            total = sumOfDie + 20;
//        else if (allDifferent())
//            total = sumOfDie;
//
//        setTotalScore(total);
//        System.out.println("Points: " + total);
//
//    }

}
