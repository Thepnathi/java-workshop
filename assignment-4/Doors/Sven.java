/**
 * Created by thepnathi on 07/05/2018.
 */
public class Sven extends Players {

    public Sven(String name, int numberOfDoors) {
        super(name, numberOfDoors);

        begin();
    }

    @Override
    protected void begin() {
        int doors = getNumberOfDoors();
        createDoors(doors);
        perfectSquare(doors);
        printResults();
    }

    // Returns index for the array to toggle the door
    private void perfectSquare(int numOfDoors) {
        int smallerPerfectSquare;
        int largerPerfectSquare;
        int currDoor = 0;

        // Loop to get all the perfect square
        for (int i = 1; i <= numOfDoors; i++) {
            smallerPerfectSquare = i * i;
            if (smallerPerfectSquare > numOfDoors) {
                break;
            }
            for (int j = i+1; j <= numOfDoors; j++) {
                largerPerfectSquare = j * j;
                if (largerPerfectSquare > numOfDoors) {
                    break;
                } else if ((smallerPerfectSquare + largerPerfectSquare) < numOfDoors) {
                    tongleDoors(1, smallerPerfectSquare);
                    tongleDoors(1, smallerPerfectSquare + largerPerfectSquare);
//                    System.out.println("Combo (" + smallerPerfectSquare + ", " + largerPerfectSquare + ")" );
                }
            }
        }
    }
}
