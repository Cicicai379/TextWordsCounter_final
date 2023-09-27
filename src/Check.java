import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Check {
    private ArrayList<String> newWords;

    private ArrayList<String> commonWords;

    private ArrayList<String> words;

    public ArrayList<String> read(String[] args) throws Exception
    {


        return commonWords;
    }

    public Check(ArrayList<String> w) {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> commonWords = new ArrayList<>();
        this.words = w;
        this.commonWords = commonWords;
        try {
            File file = new File("src/commonWords.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String e = sc.nextLine();
                e = e.toLowerCase();
                commonWords.add(e);
//                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            // Handle the exception appropriately, such as displaying an error message
            System.out.println("File not found: " + e.getMessage());
        }
//
//        for (int i = 0; i < commonWords.size(); i++) {
//            for (int j = 0; j < words.size(); j++) {
//                if (!commonWords.get(i).equals(words.get(i))) {
//                    words.remove(j);
//                }
//            }
//        }
    }
    public void storeEveryNewWord() {
        ArrayList<String> newWords = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if (!commonWords.contains(words.get(i))) {
                newWords.add(words.get(i));
            }
        }
        this.newWords = newWords;
    }

    public ArrayList<String> getNewWords(){
        return newWords;
    }

}