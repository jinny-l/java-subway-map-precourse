package subway.constant.command;

import java.util.Arrays;
import subway.constant.ErrorMessage;

public enum MainCommand {

    STATION_MANAGEMENT("역 관리", "1"),
    LINE_MANAGEMENT("노선 관리", "2"),
    EDGE_MANAGEMENT("구간 관리", "3"),
    VIEW_SUBWAY_MAP("지하철 노선도 출력", "4"),
    QUIT("종료", "Q");

    private static final String FIELD_DELIMITER = ". ";

    private final String text;
    private final String command;

    MainCommand(String text, String command) {
        this.text = text;
        this.command = command;
    }

    public static MainCommand from(String input) {
        return Arrays.stream(MainCommand.values())
                .filter(mainCommand -> mainCommand.command.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.toString()));
    }

    @Override
    public String toString() {
        return command
                + FIELD_DELIMITER
                + text
                + "\n";
    }

}
