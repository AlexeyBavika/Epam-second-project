package comparators;

import text_parts.Sentence;

import java.util.Comparator;

public class FindWordComparator implements Comparator<Sentence> {

    @Override
    public int compare(Sentence firstSentence, Sentence secondSentence) {
        Integer firstSentenceSize = firstSentence.getSentenceFindWords().size();
        Integer secondSentenceSize = secondSentence.getSentenceFindWords().size();
        return secondSentenceSize.compareTo(firstSentenceSize);
    }
}
