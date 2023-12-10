package menu.handler;

public enum ErrorHandler {

    INVALID_NAME_FORMAT("이름 입력 형식이 올바르지 않습니다."),
    INVALID_NAME_LENGTH("코치 이름은 최소 2글자 이상, 최대 4글자입니다."),
    INVALID_COACH_RANGE("코치는 최소 2명, 최대 5명까지 식사를 함께합니다."),
    DUPLICATE_COACH_NAME("코치의 이름은 중복될 수 없습니다."),
    INVALID_MENU_FORMAT("메뉴 입력 형식이 올바르지 않습니다."),
    NON_EXISTENT_MENU("존재하지 않는 메뉴입니다."),
    INVALID_MENU_RANGE("최소 0개, 최대 2개의 못 먹는 메뉴를 입력해야 합니다."),
    DUPLICATE_MENU("못 먹는 메뉴는 중복될 수 없습니다."),
    DUPLICATE_CATEGORY("한주에 카테고리는 3회 이상 중복될 수 없습니다.");

    private final String errorMessage;

    ErrorHandler(String message) {
        this.errorMessage = "[ERROR] " + message;
    }

    public RuntimeException getException() {
        return new IllegalArgumentException(errorMessage);
    }
}
