
/**
 * Created by thepnathi on 19/04/2018.
 */

//Don has been tested thoroughly and should be working fine
public class Don extends Cockroach {
    private int floor = 1;
    private int steps = 0;

    @Override
    protected String name() {
        return "Don";
    }

    @Override
    protected void takeStep() {
        walk();
    }

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
        if (floor > getMaxFloor()) {
//            System.out.println(name() + " has reach the top floor!");
            floor = getMaxFloor();
        }
    }

    @Override
    public int getMaxFloor() {
        return super.getMaxFloor();
    }

    @Override
    protected void walk() {
        steps++;
        int fallingChance = (int) (Math.random() * 1000) + 1;
        int dice = diceRoll();

        if (fallingChance == 1) {
            floor = 1;
        } else {

            if (dice == 1 || dice == 2) {
                if (floor > 1) {
                    floor--;
                }
            } else if (dice == 3 || dice == 4 || dice == 5) {
                floor++;
            } else {
                dice = diceRoll();
                floor += dice;
            }
        }
        reachMaxFloor();
    }

    @Override
    public int diceRoll() {
        return super.diceRoll();
    }


    @Override
    protected int getFloor() {
        return floor;
    }
}
