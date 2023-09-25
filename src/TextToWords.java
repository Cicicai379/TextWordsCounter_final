import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TextToWords {
    private ArrayList<String> words;
    private String text;

    public TextToWords(String filename) {
        text = ""; // Initialize the text variable

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                text += scanner.nextLine();
                text += " "; // Add a space between words
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void convertWordsToList() {
        words = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(text, " .,:;?!-()\n\t\"\'");

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();
            words.add(word);
        }
    }

}