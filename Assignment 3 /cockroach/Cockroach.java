
/**
 * Created by thepnathi on 17/04/2018.
 */
public abstract class Cockroach {

    private int maxFloor = 102;
    private String name;

    protected abstract String name();
    protected abstract void walk();
    protected abstract void takeStep();
    protected abstract int getFloor();

    // This can be a proper method here
    protected abstract void reachMaxFloor();

    public int getMaxFloor() {
        return maxFloor;
    }

    public int diceRoll() {
        // returns a random die value
        return ((int) (Math.random() * 6) + 1);
    }


}
