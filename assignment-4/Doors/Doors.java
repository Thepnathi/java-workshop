/**
 * Created by thepnathi on 07/05/2018.
 */
public class Doors {
    public static void main(String[] args) {
        int numOfDoors = 30;
        Ginny ginny = new Ginny("Ginny", numOfDoors);
        Petra petra = new Petra("Petra", numOfDoors);
        Sven sven = new Sven("Sven", numOfDoors);
//
//        try {
//            int numOfDoors = Integer.parseInt(args[0]);
//            String text = args[1];
//            if (numOfDoors < 1 || numOfDoors > 1000000) {
//                System.out.println("You must input 1 to 1000000 numbers of doors");
//                System.exit(0);
//            } else if (text == null) {
//                Ginny ginny = new Ginny("Ginny", numOfDoors);
//                Petra petra = new Petra("Petra", numOfDoors);
//                Sven sven = new Sven("Sven", numOfDoors);
//            } else if (text.length() >= 1) {
//                checkPlayerLetter(text, numOfDoors);
//            }
//
//        } catch (NullPointerException error) {
//            System.out.println("NullpointerException " + error.getMessage());
//        } catch (NumberFormatException error) {
//            System.out.println("NumberFormatException " + error.getMessage());
//        } catch (ArrayIndexOutOfBoundsException error) {
//            System.out.println("ArrayIndexOutOfBoundsException " + error.getMessage());
//        }

    }

    public static void checkPlayerLetter(String text, int test) {
        char[] playerInitial = {'g', 'p', 's'};
        boolean[] plauerInitFound = {false, false, false};
        text = text.toLowerCase();

        if (text.length() == 1) {
            char currentChar = text.charAt(0);

            switch (currentChar) {
                case 'g':
                    Ginny ginny = new Ginny("Ginny", test);
                    break;
                case 'p':
                    Petra petra = new Petra("Petra", test);
                    break;
                case 's':
                    Sven sven = new Sven("Sven", test);
                    break;
                default:
                    System.out.println("The letter contains no 'g', 'p' or 's'");
            }
        } else {
            // Loop throught the text
            for (int i = 0; i < text.length(); i++) {
                char currentChar = text.charAt(i);

                if (text.charAt(i) == playerInitial[0] && plauerInitFound[0] == false) {
                    Ginny ginny = new Ginny("Ginny", test);
                    plauerInitFound[0] = true;
                } else if (text.charAt(i) == playerInitial[1] && plauerInitFound[1] == false) {
                    Petra petra = new Petra("Petra", test);
                    plauerInitFound[1] = true;
                } else if (text.charAt(i) == playerInitial[2] && plauerInitFound[2] == false) {
                    Sven sven = new Sven("Sven", test);
                    plauerInitFound[2] = true;
                }
            }
        }
    }

}
