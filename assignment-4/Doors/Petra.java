/**
 * Created by thepnathi on 07/05/2018.
 */
public class Petra extends Players {

    public Petra(String name, int numberOfDoors) {
        super(name, numberOfDoors);

        begin();
    }

    @Override
    protected void begin() {
        int doors = getNumberOfDoors();
        createDoors(doors);

        for (int i = 0; i <= doors; i++) {
            if (isPrime(i)) {
                for (int j = 0; j <= doors; j++) {
                    if ((j * i) <= doors) {
                        tongleDoors(1, j * i);
                    }
                }
            }
        }
        printResults();
    }

    private static boolean isPrime(int num) {

        if (num == 0 || num == 1) {
            return false;
        } else if(num == 2 || num == 3) {
            return true;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }


}
