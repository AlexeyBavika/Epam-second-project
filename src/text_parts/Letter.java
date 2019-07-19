package text_parts;

public class Letter {
    private String letter;

    Letter(String letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        return letter;
    }
}
