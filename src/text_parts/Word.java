package text_parts;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
    private String word;

    private List<Letter> letters = new ArrayList<>();

    Word(String word) {
        this.word = word;
        addWordLetters(word);
    }

    private void addWordLetters(String word) {
        Pattern pattern = Pattern.compile("[A-Za-z]+");
        Matcher matcher = pattern.matcher(word);
        while(matcher.find()) {
            letters.add(new Letter(matcher.group()));
        }
    }

    @Override
    public String toString() {
        return word;
    }
}
