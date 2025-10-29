import java.io.IOException;
import java.util.*;

/**
 * WordLadderTest contains test cases to verify the functionality of
 * DictionaryLoader and WordLadderSolver classes.
 */
public class WordLadderTest {

    /**
     * The main method runs a series of test cases to verify correct behavior.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Set<String> dictionary;

        // Test Case 1: Dictionary file doesn't exist
        try {
            dictionary = DictionaryLoader.loadDictionary("nonexistent.txt");
            System.out.println("Test Case 1: File not found - FAIL (Should have thrown exception)");
        } catch (IOException e) {
            System.out.println("Test Case 1: File not found - PASS (Exception thrown correctly)");
        }

        // Test Case 2: Valid dictionary load
        try {
            dictionary = DictionaryLoader.loadDictionary("words.txt");
            if (dictionary.isEmpty()) {
                System.out.println("Test Case 2: Dictionary loaded but empty - FAIL");
            } else {
                System.out.println("Test Case 2: Dictionary loaded successfully - PASS");
            }
        } catch (IOException e) {
            System.out.println("Test Case 2: Dictionary load failed - FAIL");
            return;
        }

        // Further tests assuming dictionary loaded successfully
        try {
            dictionary = DictionaryLoader.loadDictionary("words.txt");

            // Test Case 3: Valid word ladder from "tears" to "smile"
            List<String> ladder3 = WordLadderSolver.findWordLadder("tears", "smile", dictionary);
            if (!ladder3.isEmpty() && ladder3.get(0).equals("tears") && ladder3.get(ladder3.size() - 1).equals("smile")) {
                System.out.println("Test Case 3: Ladder from tears to smile found - PASS");
            } else {
                System.out.println("Test Case 3: Ladder from tears to smile NOT found - FAIL");
            }

            // Test Case 4: Start and end are same
            List<String> ladder4 = WordLadderSolver.findWordLadder("apple", "apple", dictionary);
            if (ladder4.size() == 1 && ladder4.get(0).equals("apple")) {
                System.out.println("Test Case 4: Same start and end handled correctly - PASS");
            } else {
                System.out.println("Test Case 4: Same start and end not handled correctly - FAIL");
            }

            // Test Case 5: No ladder exists for invalid end word
            List<String> ladder5 = WordLadderSolver.findWordLadder("apple", "zzzzz", dictionary);
            if (ladder5.isEmpty()) {
                System.out.println("Test Case 5: No ladder exists - PASS");
            } else {
                System.out.println("Test Case 5: Incorrectly found ladder - FAIL");
            }

            // Test Case 6: Input length invalid (4-letter word)
            List<String> ladder6 = WordLadderSolver.findWordLadder("abcd", "smile", dictionary);
            if (ladder6.isEmpty()) {
                System.out.println("Test Case 6: Invalid input length handled - PASS");
            } else {
                System.out.println("Test Case 6: Invalid input accepted - FAIL");
            }

        } catch (IOException e) {
            System.out.println("Unexpected IOException in test block.");
        }
    }
}
