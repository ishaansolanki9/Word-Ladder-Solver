import java.io.IOException;
import java.util.*;

/**
 * WordLadder is the main class that interacts with the user and
 * allows them to generate a word ladder between two 5-letter words.
 */
public class WordLadder {

    /**
     * The main method that runs the Word Ladder program.
     * It loads the dictionary and prompts users to input start and end words.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> dictionary;

        // Load the dictionary from file
        try {
            dictionary = DictionaryLoader.loadDictionary("words.txt");
            System.out.println("Dictionary loaded successfully! " + dictionary.size() + " words found.");
        } catch (IOException e) {
            System.err.println("Error loading dictionary: " + e.getMessage());
            return;
        }

        // Loop for user input and ladder computation
        while (true) {
            System.out.print("\nEnter start word (or Q to quit): ");
            String start = scanner.nextLine().trim().toLowerCase();
            if (start.equals("q")) break;

            System.out.print("Enter end word: ");
            String end = scanner.nextLine().trim().toLowerCase();

            // Validate input lengths
            if (start.length() != 5 || end.length() != 5) {
                System.out.println("Error: Words must be exactly 5 letters long.");
                continue;
            }

            // Solve word ladder
            List<String> wordLadder = WordLadderSolver.findWordLadder(start, end, dictionary);

            if (wordLadder.isEmpty()) {
                System.out.println("No word ladder found.");
            } else {
                System.out.println("Word Ladder found: " + String.join(" → ", wordLadder));
            }
        }

        scanner.close();
        System.out.println("Program exited.");
    }
}
