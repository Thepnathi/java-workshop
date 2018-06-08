
/**
 * Created by thepnathi on 23/04/2018.
 */
public class CoopGame {

    public static void main(String[] args) {

        try {
            int vertices = Integer.parseInt(args[0]);
            int trials = Integer.parseInt(args[1]);

            if (vertices < 3) {
                System.out.println("You must enter a graph size of 3 or greater");
                System.exit(0);
            }

            if (trials < 1 || trials > 5000) {
                System.out.println("Trial has a limit of 1 to 5000");
                System.exit(0);
            }

            CoopGame experiemnt = new CoopGame(vertices, trials);

        } catch (NullPointerException error) {
            System.out.println("NullpointerException :" + error.getMessage());
        } catch (NumberFormatException error) {
            System.out.println("NumberFormatException :" + error.getMessage());
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("You have entered no data. Please input at least 3 Graph size. Error: " + error.getMessage());
          }
    }

    public CoopGame(int vertices, int trials) {
        // Create the graphs for each type and with different number of -1
        System.out.println();
        Cycle x = new Cycle(vertices, 1, trials);
        Cycle xg = new Cycle(vertices, 2, trials);
        System.out.println();
        Path t = new Path(vertices, 1, trials);
        Path j = new Path(vertices, 2, trials);

    }
}
