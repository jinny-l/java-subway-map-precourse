package subway.constant;

import subway.domain.Line;
import subway.domain.Station;

public enum ErrorMessage {

    EMPTY_INPUT("입력 값이 없습니다."),
    INVALID_COMMAND("유효한 명령어가 아닙니다."),
    INVALID_STATION_NAME("이미 존재하는 역입니다."),
    INVALID_STATION_NAME_LENGTH(String.format("이름은 %d글자 이상 입력해주세요.", Station.nameMinLength())),
    INVALID_STATION_TEXT(String.format("역 이름은 '%s'을 포함하여 입력해주세요.", Station.stationText())),
    INVALID_STATION_DELETION("노선에 등록된 역은 삭제할 수 없습니다."),
    INVALID_LINE_NAME("이미 존재하는 노선입니다."),
    INVALID_LINE_TEXT(String.format("노선 이름은 '%s'을 포함하여 입력해주세요.", Line.lineText())),
    INVALID_LINE_NAME_LENGTH(String.format("이름은 %d글자 이상 입력해주세요.", Line.nameMinLength())),
    UNABLE_TO_REGISTER_STATION_TO_LINE("존재하지 않는 역입니다."),
    UNABLE_TO_DELETE_LINE("존재하지 않는 노선입니다."),
    INVALID_EDGE_INDEX_TYPE("숫자만 입력 가능합니다.");

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
