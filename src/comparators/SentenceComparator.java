package comparators;

import text_parts.Sentence;

import java.util.Comparator;

public class SentenceComparator implements Comparator<Sentence> {

    @Override
    public int compare(Sentence firstSentence, Sentence secondSentence) {
        Integer sizeOfFirstSentence = firstSentence.getSentenceWords().size();
        Integer sizeOfSecondSentence = secondSentence.getSentenceWords().size();
        return sizeOfFirstSentence.compareTo(sizeOfSecondSentence);
    }
}
