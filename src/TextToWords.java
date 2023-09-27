import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
        String cleanedText = text.replaceAll("[^a-zA-Z' ]", "");
        String[] wordArray = cleanedText.split("\\s+");
        ArrayList<String> words = new ArrayList<>(Arrays.asList(wordArray));
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            words.set(i, word.toLowerCase());
        }
        this.words = words;
    }

}