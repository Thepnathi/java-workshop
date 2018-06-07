import java.util.Arrays;

/**
 * Created by thepnathi on 07/05/2018.
 */
public abstract class Players {

    protected String name;
    protected boolean[] arrayDoors; // holds the Nth number of doors
    protected int numberOfDoors;
    protected int openedDoors = 0;
    protected String resultDoors = "";

    protected abstract void begin();

    public Players(String name, int numberOfDoors) {
        this.name = name;
        this.numberOfDoors = numberOfDoors;
    }

    // Stores number of door in an array
    // Set all array/door to false
    // false = door closed
    // true = door opened
    public void createDoors(int numberOfDoors) {
        arrayDoors = new boolean[numberOfDoors + 1];
        Arrays.fill(arrayDoors, false);
    }

    // Update the array with true -
    // - when the player opens a door at a given index (door)
    public void tongleDoors(int oneAndZero, int arrayIndex) {
        if (oneAndZero == 1) {
            // If the door is already opened, we closed it
            if (arrayDoors[arrayIndex]) {
                arrayDoors[arrayIndex] = false;
            } else {
                arrayDoors[arrayIndex] = true;
            }
        } else {
            arrayDoors[arrayIndex] = false;
        }
    }

    // Print the player information
    public void printResults() {
        for (boolean door : arrayDoors) {
            if (door == true) {
                resultDoors += "1";
                openedDoors++;
            } else {
                resultDoors += "0";
            }
        }
        System.out.println(getName());
        System.out.println(getResultDoors());
        System.out.println(getOpenedDoors() + " doors open\n");
    }

    public String getName() {
        return name;
    }

    public boolean[] getArrayDoors() {
        return arrayDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public int getOpenedDoors() {
        return openedDoors;
    }

    public String getResultDoors() {
        return resultDoors;
    }
}
