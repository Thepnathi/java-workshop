

/**
 * Created by thepnathi on 19/04/2018.
 */
public class Bella extends Cockroach {
    private int floor = 1;
    private int steps = 0;
    private boolean observeFloor86 = false;

    @Override
    protected String name() {
        return "Bella";
    }

    @Override
    protected void takeStep() {
        walk();
    }

    // If the cockroach goes beyoung floor 102
    // It drops back to 102
    public boolean reachTopFloor() {
        if (getFloor() == 102) {
            return true;
        } else {
            return false;
        }
    }

    public int getSteps() {
        return steps;
    }

    @Override
    protected void reachMaxFloor() {
        if (getFloor() > getMaxFloor()) {
//            System.out.println(name() + " has reach the top floor!");
            floor = getMaxFloor();
        }
    }

    // Allows the cockroach to move depending on die value
    @Override
    protected void walk() {
        // incre how many steps they are taking
        steps++;
        int dice = diceRoll();
        // since Bella stops for a turn when she goes to floor 86 or beyond
        // we will put a flag here and stop here at floor 86
        // The condition returns back to false after the next turn
        if (observeFloor86 == false) {
            if (toObserve(dice)) {
                observeFloor86 = true;
                floor = 86;
                // Below moves depending on the value of die
            } else if (dice == 1 || dice == 2 || dice == 3) {
                if (floor > 1) {
                    floor--;
                }
            } else if (dice == 4) {
                floor += 2;
            } else if (dice == 5) {
                floor += 3;
            } else if (dice == 6) {
                floor += 0;
            } else {
                // do nothing
            }
        }
        // After observing the floor
        if (observeFloor86) {
            observeFloor86 = false;
        }
        reachMaxFloor();
    }

    // Takes in a die value and tell if
    // she will observe floor 86
    public boolean toObserve(int dieValue) {

        if (getFloor() == 80 && dieValue == 6) {
            return true;
        } else if (getFloor() == 81 && dieValue >= 5) {
            return true;
        } else if (getFloor() == 82 && dieValue >= 4) {
            return true;
        } else if (getFloor() == 83 && dieValue >= 3) {
            return true;
        } else if (getFloor() == 84 && dieValue >= 2) {
            return true;
        } else if (getFloor() == 85 && dieValue >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int getFloor() {
        return floor;
    }
}
