/**
 * Created by thepnathi on 07/05/2018.
 */
public class Ginny extends Players {

    public Ginny(String name, int numberOfDoors) {
        super(name, numberOfDoors);

        begin();
    }

    @Override
    protected void begin() {
        int doors = getNumberOfDoors();
        createDoors(doors);
        for (int i = 0; i <= doors; i++) {
            tongleDoors(gcd(doors, i), i);
        }
        printResults();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
