package text_parts;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
    private String sentence;
    private String findWord;
    private List<SeparateMark> separateMarks = new ArrayList<>();

    public Sentence(String sentence) {
        this.sentence = sentence;
        addSeparateMark(sentence);
    }

    private void addSeparateMark(String sentence) {
        Pattern pattern = Pattern.compile("[,]");
        Matcher matcher = pattern.matcher(sentence);
        while(matcher.find()) {
            SeparateMark separateMark = new SeparateMark(matcher.group());
            separateMarks.add(separateMark);
        }
    }

    public void setFindWord(String findWord) {
        this.findWord = findWord;
    }

    public List<Word> getSentenceWords() {
        Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я,/]+");
        Matcher matcher = pattern.matcher(sentence);
        List<Word> words = new ArrayList<>();
        while(matcher.find()) {
            words.add(new Word(matcher.group()));
        }
        return words;
    }

    public List<Word> getSentenceFindWords() {
        Pattern pattern = Pattern.compile("\\b" + findWord + "\\b");
        Matcher matcher = pattern.matcher(sentence);
        List<Word> findWords = new ArrayList<>();
        while(matcher.find()) {
            findWords.add(new Word(matcher.group()));
        }
        return findWords;
    }

    @Override
    public String toString() {
        return sentence;
    }
}
