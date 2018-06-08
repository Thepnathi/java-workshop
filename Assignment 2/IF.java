import java.io.*;
import java.util.*;
import java.nio.file.*;

public class IF {
    protected String fileName;
    protected HashMap<String, Integer> wordOccurrence;

    public IF(String fileName) {

        this.fileName = fileName;
        this.wordOccurrence = new HashMap<String, Integer>();

        try {
          List<String> lines = Files.readAllLines(Paths.get(fileName));

          for (String line : lines) {
            line = line.toLowerCase();

            String[] wordList = line.split("[^\\p{L}0-9]+");

            for (String word : wordList) {
                if (word != null && !word.isEmpty()) {
                    if ( wordOccurrence.containsKey(word) )
                    { wordOccurrence.put(word, wordOccurrence.get(word) + 1); }
                    else { wordOccurrence.put(word, 1); }
                }
            }
          }
        } catch ( FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException e) {
          System.out.println(e);
        }
    }

    // most issue here
    public HashMap<String, Integer> getWordCount() {
        return wordOccurrence;
    }

    public String getFileName() {
        return fileName;
    }

    public String toString() {
        return "Word counts for file: " + fileName + "\n" + wordOccurrence.toString();
    }

    // For encapsulation of data
    public int getValue(String key) {
        if (wordOccurrence.containsKey(key)) {
            return wordOccurrence.get(key);
        } else {
            return 0;
        }
    }

    // returns an array of keys of the HashMap
    public String[] getKeys() {
//        keyset method returns Java set. We want an array
//        We can create an array of appropriate size
//        then we can iterate over the sey of keys to add them to the String array that we will return

        String[] keys = new String[wordOccurrence.keySet().size()]; // get size of set
        int i = 0;
        for (String k : wordOccurrence.keySet()) { // where k is keys in the set
            keys[i++] = k;
        }
        return keys;
    }

    // Returns size of the wordCount HashMap
    // Or how many different terms in a document
    public int size() {
        return wordOccurrence.size();
    }

    // Returns total words in a text file
    public int totalWords() {
        int total = 0;
        for (String key : wordOccurrence.keySet()) {
            total += wordOccurrence.get(key);
        }
        return total;
    }

    // Method to create TF HashMap for each file
    public HashMap<String, Double> createTermFrequencyHashMap() {
        // The HashMap to store TF data
        HashMap<String, Double> docIDF = new HashMap<String, Double> ();

        // Generate the new TF HashMap
        // Takes the word, and the value - (total word occurence / total words in the file)
        for (String word : wordOccurrence.keySet()) {
            docIDF.put(word, (double) wordOccurrence.get(word) / (double) this.totalWords() );
        }
        return docIDF;
    }

}
