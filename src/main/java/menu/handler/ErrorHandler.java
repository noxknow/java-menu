package menu.handler;

public enum ErrorHandler {

    INVALID_NAME_FORMAT("이름 입력 형식이 올바르지 않습니다."),
    INVALID_NAME_LENGTH("코치 이름은 최소 2글자 이상, 최대 4글자 입니다.");

    private final String errorMessage;

    ErrorHandler(String message) {
        this.errorMessage = "[ERROR] " + message;
    }

    public RuntimeException getException() {
        return new IllegalArgumentException(errorMessage);
    }
}
