import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Check {
    private String commonWords;
    private ArrayList<String> newWords;
    private ArrayList<String> words;

    public Check(ArrayList<String> w){
        ArrayList<String> words = new ArrayList<>();
        this.words = w;
        try (Scanner scanner = new Scanner(new File("src/commonWords.txt"))) {
            while (scanner.hasNextLine()) {
                commonWords+=scanner.nextLine();
                commonWords+=" "; // Add a space between words
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public void storeEveryNewWord() {
        ArrayList<String> newWords = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if (!commonWords.contains(words.get(i))) {
                newWords.add(words.get(i));
//                System.out.println(words.get(i));
            }
        }
        this.newWords = newWords;
    }

    public ArrayList<String> getNewWords(){
        return newWords;
    }

}