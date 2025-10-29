import java.util.*;

/**
 * WordLadderSolver provides the logic to compute the shortest transformation
 * (word ladder) from a start word to an end word using BFS traversal.
 */
public class WordLadderSolver {

    /**
     * Finds the shortest sequence of words (word ladder) from start to end,
     * where each word in the sequence differs by exactly one letter.
     *
     * @param start      The starting 5-letter word.
     * @param end        The target 5-letter word.
     * @param dictionary A Set containing valid 5-letter words.
     * @return A List representing the shortest word ladder. Returns an empty list if no ladder exists.
     */
    public static List<String> findWordLadder(String start, String end, Set<String> dictionary) {
        // If either start or end word is not in dictionary, return empty ladder
        if (!dictionary.contains(start) || !dictionary.contains(end)) {
            return Collections.emptyList();
        }

        Queue<Stack<String>> queue = new LinkedList<>();
        Set<String> usedWords = new HashSet<>();

        // Initialize BFS with start word
        Stack<String> initialStack = new Stack<>();
        initialStack.push(start);
        queue.add(initialStack);
        usedWords.add(start);

        // Perform BFS until ladder is found or all options are exhausted
        while (!queue.isEmpty()) {
            Stack<String> currentStack = queue.poll();
            String topWord = currentStack.peek();

            // Check if the end word has been reached
            if (topWord.equals(end)) {
                return new ArrayList<>(currentStack);
            }

            // Explore all neighboring words differing by one letter
            for (String neighbor : getOneLetterDiffWords(topWord, dictionary)) {
                if (!usedWords.contains(neighbor)) {
                    Stack<String> newStack = (Stack<String>) currentStack.clone();
                    newStack.push(neighbor);
                    queue.add(newStack);
                    usedWords.add(neighbor);
                }
            }
        }

        // No ladder found
        return Collections.emptyList();
    }

    /**
     * Generates all words in the dictionary that differ from the given word by exactly one letter.
     *
     * @param word       The word for which neighbors are to be found.
     * @param dictionary The Set of valid 5-letter words.
     * @return A List of all one-letter-different words from the input word.
     */
    private static List<String> getOneLetterDiffWords(String word, Set<String> dictionary) {
        List<String> neighbors = new ArrayList<>();
        char[] wordArray = word.toCharArray();

        // Replace each letter in the word with all other alphabets and check if it's a valid word
        for (int i = 0; i < wordArray.length; i++) {
            char originalChar = wordArray[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;
                wordArray[i] = c;
                String newWord = new String(wordArray);
                if (dictionary.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }

            // Restore original character before next iteration
            wordArray[i] = originalChar;
        }

        return neighbors;
    }
}
