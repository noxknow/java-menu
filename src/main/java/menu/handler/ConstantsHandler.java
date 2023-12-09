package menu.handler;

public enum ConstantsHandler {

    MONDAY(1, ""),
    FRIDAY(5, ""),
    MIN_CATEGORY(1, ""),
    MAX_CATEGORY(5, ""),
    ZERO_INDEX(0, "");

    private final int value;
    private final String word;

    ConstantsHandler(int value, String word) {
        this.value = value;
        this.word = word;
    }

    public int getValue() {
        return value;
    }

    public String getWord() {
        return word;
    }
}
