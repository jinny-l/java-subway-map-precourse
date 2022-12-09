package subway.constant;

import subway.domain.Station;

public enum ErrorMessage {

    EMPTY_INPUT("입력 값이 없습니다. 다시 입력해주세요."),
    INVALID_COMMAND("유효한 명령어를 입력해주세요."),
    INVALID_STATION_NAME("이미 존재하는 역입니다. 다시 입력해주세요."),
    INVALID_STATION_NAME_LENGTH(String.format("이름은 %d글자 이상 입력해주세요.", Station.nameMinLength())),
    INVALID_STATION_DELETION("노선에 등록된 역은 삭제할 수 없습니다.");

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
