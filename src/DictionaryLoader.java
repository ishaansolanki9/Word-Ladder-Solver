import java.io.*;
import java.util.*;

/**
 * DictionaryLoader is responsible for loading a dictionary file from the resources folder
 * and storing all valid 5-letter words in a Set.
 */
public class DictionaryLoader {

    /**
     * Loads a dictionary file from the classpath and filters only 5-letter words.
     *
     * @param filePath The relative path to the dictionary file (e.g., "words.txt").
     * @return A Set of all valid 5-letter lowercase words found in the file.
     * @throws IOException If the file is not found or cannot be read.
     */
    public static Set<String> loadDictionary(String filePath) throws IOException {
        Set<String> words = new HashSet<>();
        InputStream input = DictionaryLoader.class.getClassLoader().getResourceAsStream(filePath);

        // Check if the dictionary file was found
        if (input == null) {
            throw new FileNotFoundException("Dictionary file not found: " + filePath);
        }

        Scanner scanner = new Scanner(input);

        // Read each line, convert to lowercase, and add only 5-letter words
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine().trim().toLowerCase();
            if (word.length() == 5) {
                words.add(word);
            }
        }

        scanner.close();
        return words;
    }
}
