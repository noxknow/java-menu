package menu.handler;

public enum ConstantsHandler {

    MONDAY(1, ""),
    FRIDAY(5, ""),
    MIN_CATEGORY(1, ""),
    MAX_CATEGORY(5, ""),
    ZERO_INDEX(0, ""),

    COMMA_DELIMITER(0, ","),
    MIN_COACH_NAME(2, ""),
    MAX_COACH_NAME(4, ""),
    MIN_COACH(2, ""),
    MAX_COACH(5, ""),

    MIN_MENU_RANGE(0, ""),
    MAX_MENU_RANGE(2, ""),


    MAX_DUPLICATE(3, ""),

    MENU_RECOMMENDER_SIZE(5, "");

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
