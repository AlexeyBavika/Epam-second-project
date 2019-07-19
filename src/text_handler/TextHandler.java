package text_handler;

import comparators.FindWordComparator;
import comparators.SentenceComparator;
import text_parts.Letter;
import text_parts.Sentence;
import text_parts.Word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler {
    private String text;
    private List<Sentence> sentences = new ArrayList<>();
    private List<Sentence> findWordsSentences = new ArrayList<>();

    public TextHandler(String textPath) {
        loadText(textPath);
    }

    private void loadText(String textPath) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(textPath));
            String text = "";
            String line = bufferedReader.readLine();

            while (line != null) {
                text += line;
                line = bufferedReader.readLine();
            }
            this.text = text;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Sentence> getSentences() {
        Pattern pattern = Pattern.compile("([A-Za-z,()_\\s/]+)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String currentSentence = matcher.group();
            Sentence sentence = new Sentence(currentSentence);
            sentences.add(sentence);
        }
        return sentences;
    }

    public void getFindWordsInText(String findWord) {
        for (Sentence sentence : sentences) {
            sentence.setFindWord(findWord);
            Sentence newSentence = new Sentence(sentence.getSentenceFindWords().toString());
            newSentence.setFindWord(findWord);
            findWordsSentences.add(newSentence);
        }
    }

//    public void getTextWords() {
//        List<Word> words = new ArrayList<>();
//        for (Sentence sentence : sentences) {
//            words.addAll(sentence.getSentenceWords());
//        }
//        System.out.println(words);
//    }

    public List<Sentence> sortSentencesByWordNumber() {
        sentences.sort(new SentenceComparator());
        return sentences;
    }

    public List<Sentence> sortSentencesByFindWordNumber() {
        findWordsSentences.sort(new FindWordComparator());
        return findWordsSentences;
    }
}
