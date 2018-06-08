/**
 * Created by thepnathi on 03/04/2018.
 */
import java.util.HashMap;
import java.util.ArrayList;

public class TFIDF {
    // NOTE: RE-NAME YOUR Variables

    public static void main(String args[]) {
        // stores each document TF values for all words
        ArrayList<HashMap<String, Double>> termFrequencyArrayList = new ArrayList<HashMap<String, Double>> ();
        ArrayList<String> fileNameArrayList = new ArrayList<String>();
        int totalFiles = args.length;
        // ArrayList<String> fileNameArrayList = new ArrayList<String>();

        if (totalFiles == 0) {
            // Exit if user doesn't input file
            System.out.println("Error! Please input a filename");
            System.exit(1);
        } else {
            // Generates TF values which is stored in a HashMap for each documents
            // The HashMap stores the word and correspinding value
            // All of this is send to the IF class
            // In the TF class it will split the documents into words only.
            // It will also generate and return the TF value
            // Then it pushes into an ArrayList - each index represent different
            // index of the array
            for (int i = 0; i < totalFiles; i++) {
                // Create new object for each file
                // Object returns the TF HashMap
                IF file = new IF(args[i]);
                termFrequencyArrayList.add(file.createTermFrequencyHashMap());
                // add file name to ArrayList
                fileNameArrayList.add(file.getFileName());
            }
        }

        // This part counts how many times a word appears at least once in each files
        // Then stores the word and corresponding value inside a HashMap
        HashMap<String, Integer> wordOccurrenceHashMap = new HashMap<String, Integer>();

        for (int i = 0; i < termFrequencyArrayList.size(); i++) {
            for (String key : termFrequencyArrayList.get(i).keySet()) {
                // check if the current word already exist in our tracking HashMap
                // If exists, add 1 to the value
                if (wordOccurrenceHashMap.containsKey(key) == false) {
                    wordOccurrenceHashMap.put(key, 1);
                } else {
                    wordOccurrenceHashMap.put(key, wordOccurrenceHashMap.get(key) + 1);
                }
            }
        }

        // Generate the IDF values
        HashMap<String, Double> inverseDocumentFrequencyHashMap = new HashMap<String, Double>();
        for (String word : wordOccurrenceHashMap.keySet()) {
            inverseDocumentFrequencyHashMap.put(word, Math.log10((double) totalFiles / (double) wordOccurrenceHashMap.get(word)));
        }
        System.out.println("");
        // Calls the the method to make TFIDF for each file - stores in HashMap
        // Takes in TF ArrayList, IDF HashMap and Arraylist containing file name
        printTFIDF(termFrequencyArrayList, inverseDocumentFrequencyHashMap, fileNameArrayList);



    }

    // Generates TFIDF value
    public static void printTFIDF(ArrayList<HashMap<String, Double>> tfArrayList, HashMap<String, Double> inverseDocumentFrequencyHashMap, ArrayList fileNameArrayList) {

        // ArrayList to store each file/HashMap with the word and correspinding TFIDF value
        ArrayList<HashMap<String, Double>> fileTFIDFarrayList = new ArrayList<HashMap<String, Double>> ();

        // Variable to hold word with highest TFIDF value
        String importantWord = "";
        double importantTFIDFvalue = 0.0;

        System.out.println("TFIDF for each files \n \n=========");

        // If one file is inputted
        // We simply take the word with highest TF value and ignore
        // TFIDF values
        if (fileNameArrayList.size() == 1) {
            for (String word : tfArrayList.get(0).keySet()) {
                if (tfArrayList.get(0).get(word) > importantTFIDFvalue) {
                    importantTFIDFvalue = tfArrayList.get(0).get(word);
                    importantWord = word;
                }
            }
            // Print out the result for user
            System.out.println(fileNameArrayList.get(0));
            System.out.println("=========");
            System.out.println(importantWord + " " + importantTFIDFvalue + "\n");
        } else {
            // Else loop through TF and compare it to IDF
            // to see if both contains same key/ word.
            // then take corresponding word - (IF value * IDF value)
            for (int i = 0; i < tfArrayList.size(); i++) {
                HashMap<String, Double> storesCurrentTFIDFhashmap = new HashMap<String, Double> ();
                // Search HashMap inside list, or document
                for (String word : tfArrayList.get(i).keySet()) {
                    if (inverseDocumentFrequencyHashMap.containsKey(word)) {
                        storesCurrentTFIDFhashmap.put(word, tfArrayList.get(i).get(word) * inverseDocumentFrequencyHashMap.get(word));
                    } else {
                        storesCurrentTFIDFhashmap.put(word, 0.0);
                    }
                }
                fileTFIDFarrayList.add(storesCurrentTFIDFhashmap);
                // END of creating TFIDF
            }

            // loop through TFIDF ArrayList to find the most
            // important word in each HashMap / file
            for (int i = 0; i < fileTFIDFarrayList.size(); i++) {
                for (String currentWord : fileTFIDFarrayList.get(i).keySet()) {
                    if (fileTFIDFarrayList.get(i).get(currentWord) > importantTFIDFvalue) {
                        importantTFIDFvalue = fileTFIDFarrayList.get(i).get(currentWord);
                        importantWord = currentWord;
                    }
                }
                // Display result to user
                 System.out.println(fileNameArrayList.get(i));
                 System.out.println("=========");
                 System.out.println(importantWord + " " + importantTFIDFvalue + "\n");
                 importantWord = "";
                 importantTFIDFvalue = 0.0;
            }
        }

    }

    // NOTE: For Testing purposes
    // Prints the TF values for each documents
    public static void printTFvalues(ArrayList<HashMap<String, Double>> allTFdata, ArrayList<String> documentName, int totalDocuments) {
        for (int i = 0; i < totalDocuments; i++) {
            System.out.println(documentName.get(i));
            System.out.println("================================================");
            System.out.println(allTFdata.get(i) + "\n");
        }
    }
}
