import java.util.HashMap;

/**
 * Created by thepnathi on 08/04/2018.
 */
public class BreakCaesar {

    public static void main(String[] args) {

          try {
            String textToDecrypt = args[0];
            shiftString(textToDecrypt);
          } catch (Exception e) {
            System.out.println("Oops, you haven't given enough parameters! \n Usage: java BreakCaesar \"string\"");
          }

    }

    public static void shiftString(String text) {
        int lengthOfArray = text.length(); // find the length of the text
        double lowestFreqValue = 9999999; // stores the lowest value out of all 26 combinations
        String pairText = "";   // stores the corresponding text to that value
        String englishText = "";
        Boolean[] array = new Boolean[text.length()];
        String lowercaseText = text.toLowerCase();

        // print original with shift = 0, produce all the 26 combinations of
        // possible shifts
        for (int shift = 0; shift <= 26; shift++) {
            // NOTE: We do not need shiftedChar variable
            String newText = ""; // stores the shifted de-crypted text

            // Search through the String of text and
            // select and shift individual characters
            for (int i = 0; i < lengthOfArray; i++) {
                char currentChar = lowercaseText.charAt(i);
                // A string version of the single char
                // use for .matches method
                String currentSingleString = currentChar + "";
                // Stores the shifted char
                char shiftedChar;

                // Ignore the special characters, space and numbers
                if (currentSingleString.matches("[^a-zA-Z]")) {
                    newText += currentSingleString;
                } else {
                    // Shift the char, by the current shift number
                    shiftedChar = (char) ((currentChar - 'a' + shift) % 26 + 'a');
                    newText += shiftedChar;
                }
            }
            System.out.println("Shift: " + shift + " - " + newText);
            // Find the lowest Chi square value and store that in variable
            // The combination containing the lowest Chi square value
            // is likely to be the real English string
            if (calcTotalFrequency(newText) < lowestFreqValue) {
                lowestFreqValue = calcTotalFrequency(newText);
                pairText = newText;
            }
        }
        // Compare the new string to the original string
        // Find the index with capital letter and apply to the index of the
        // decrypted string
        for (int i = 0; i < text.length(); i++) {
            char currentTextIndex = text.charAt(i);
            char currentNewTextIndex = pairText.charAt(i);
            if (Character.isUpperCase(currentTextIndex)) {
                String charToStr = currentNewTextIndex + "";
                englishText += (charToStr.toUpperCase() +"");

            } else {
                englishText += currentNewTextIndex;
            }
        }
        // Prints out the original String and the Decrypted String
        System.out.println("==================================");
        System.out.println(text);
        System.out.println("==================================");
        System.out.println(englishText + "\n");
    }

    // This method returns the Chi calculation values of the shifted text
    public static double calcTotalFrequency(String text) {

        HashMap<Character, Double> freq = new HashMap<Character, Double>();
        freq.put('a', 0.0855); freq.put('b', 0.0160); freq.put('c', 0.0316); freq.put('d', 0.0387); freq.put('e', 0.1210);
        freq.put('f', 0.0218); freq.put('g', 0.0209); freq.put('h', 0.0496); freq.put('i', 0.0733); freq.put('j', 0.0022);
        freq.put('k', 0.0081); freq.put('l', 0.0421); freq.put('m', 0.0253); freq.put('n', 0.0717); freq.put('o', 0.0747);
        freq.put('p', 0.0207); freq.put('q', 0.0010); freq.put('r', 0.0633); freq.put('s', 0.0673); freq.put('t', 0.0894);
        freq.put('u', 0.0258); freq.put('v', 0.0106); freq.put('w', 0.0183); freq.put('x', 0.0019);
        freq.put('y', 0.0172); freq.put('z', 0.0011);

        double totalCharFreq; // (a letter freq - english)^2 / english
        double sumOfAllCharFreq = 0; // Sum of all combination of letter from above


        // Stores the quantity of the individual English characters
        HashMap<Character, Integer> charCounter = new HashMap<Character, Integer>();


        for (int i = 0; i < text.length(); i++) {
            // Get the current index char from the String
            char englishChar = text.charAt(i);
            String englishStr = englishChar + "";

            // Ignore special characters, space and numbers
            if (!englishStr.matches("[^a-zA-Z]")) {
                // Otherwise increment the quantity if the key (English character) already exists
                if (charCounter.containsKey(englishChar)) {
                    charCounter.put(englishChar, charCounter.get(englishChar) + 1);
                } else {
                    // Add to the HashTable if an English character appears first time
                    charCounter.put(englishChar, 1);
                }
            }
        }

        // The formula to calculate the chi square score
        // Access the HashMap and pull the individual characters and quantity and
        // calculate with the freq HashMap
        for (Character engChar : charCounter.keySet()) {
            totalCharFreq = (Math.pow((engChar / text.length()) - freq.get(engChar), 2) / freq.get(engChar));
            sumOfAllCharFreq += totalCharFreq;
        }
        return sumOfAllCharFreq;
    }
}
