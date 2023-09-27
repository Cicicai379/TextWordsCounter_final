import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TextToWords {
    private ArrayList<String> words;
    private String text;

    public TextToWords(String filename) {
        text = "";
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                text += scanner.nextLine();
                text += " ";
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void convertWordsToList() {
        ArrayList<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isWord = false;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(c);
                isWord = true;
            } else if (isWord && c == '\'') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    words.add(sb.toString());
                    sb.setLength(0);
                }
                isWord = false;
            }
        }

        if (sb.length() > 0) {
            words.add(sb.toString());
        }

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            System.out.println(word);
            words.set(i, word.toLowerCase());
        }

        this.words = words;
    }
}