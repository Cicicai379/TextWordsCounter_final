import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> words2 = new ArrayList<>();

        TextToWords textToWord = new TextToWords("src/1984.txt");
        TextToWords textToWord2 = new TextToWords("src/textTwo.txt");

        textToWord.convertWordsToList();
        textToWord2.convertWordsToList();

        words = textToWord.getWords();
        words2 = textToWord2.getWords();

        Check check = new Check(words);
        check.storeEveryNewWord();
        words = check.getNewWords();

        Check check2 = new Check(words2);
        check2.storeEveryNewWord();
        words2 = check2.getNewWords();


        Count counter = new Count(words);
        counter.calculateCnt();
        String[] topOccurrences = counter.topFive();
        if(counter.topOne().equals("its")) {
            System.out.println("top one word: " + "it's" + ", occurrence: " + counter.getCntByWord(counter.topOne()));
        }else{
            System.out.println("top one word: " + counter.topOne() + ", occurrence: " + counter.getCntByWord(counter.topOne()));
        }

        for(int i=0; i<5; i++){
            if(topOccurrences[i].equals("its")){
                System.out.println("top "+(i+1)+" word: "+"it's"+ ", occurrence: " +
                        counter.getCntByWord(topOccurrences[i]));
            }else{
                System.out.println("top "+(i+1)+" word: "+topOccurrences[i]+ ", occurrence: " +
                        counter.getCntByWord(topOccurrences[i]));
            }
        }

        System.out.println("___________ text 2___________");
        Count counter2 = new Count(words2);
        counter2.calculateCnt();
        String[] topOccurrences2 = counter2.topFive();
        if(counter2.topOne().equals("its")) {
            System.out.println("top one word: " + "it's" + ", occurrence: " + counter2.getCntByWord(counter2.topOne()));
        }else{
            System.out.println("top one word: " + counter2.topOne() + ", occurrence: " + counter2.getCntByWord(counter2.topOne()));
        }

        for(int i=0; i<5; i++){
            if(topOccurrences2[i].equals("its")){
                System.out.println("top "+(i+1)+" word: "+"it's"+ ", occurrence: " +
                counter2.getCntByWord(topOccurrences2[i]));
            }else{
                System.out.println("top "+(i+1)+" word: "+topOccurrences2[i]+ ", occurrence: " +
                counter2.getCntByWord(topOccurrences2[i]));
            }
        }

    }
}