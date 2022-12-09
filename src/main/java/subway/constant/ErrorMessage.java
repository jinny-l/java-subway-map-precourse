package subway.constant;

public enum ErrorMessage {

    EMPTY_INPUT("입력 값이 없습니다. 다시 입력해주세요."),
    INVALID_COMMAND("유효한 명령어를 입력해주세요.");

    private static final String ERROR = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR + message;
    }

}
