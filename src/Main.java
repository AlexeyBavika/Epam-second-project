import text_handler.TextHandler;
import text_parts.Sentence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] wordsToFindArray = {"the", "is", "regex", "a"};
        TextHandler textHandler = new TextHandler("C:\\EpamProjects\\EpamSecondProject\\resources\\text.txt");
        System.out.println(textHandler.getSentences());

        System.out.println("\n=============================\n");

        List<Sentence> sortedSentences = textHandler.sortSentencesByWordNumber();
        for (Sentence sentence : sortedSentences) {
            System.out.println(sentence);
        }

        System.out.println("\n====================\n");

        for (String findWord : wordsToFindArray) {
            textHandler.getFindWordsInText(findWord);
        }

        List<Sentence> sentences = textHandler.sortSentencesByFindWordNumber();

        for (Sentence sentence : sentences) {
            System.out.println(sentence);
        }
    }
}

