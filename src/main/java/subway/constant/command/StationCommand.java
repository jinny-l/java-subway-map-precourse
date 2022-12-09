package subway.constant.command;

import java.util.stream.Stream;
import subway.constant.ErrorMessage;

public enum StationCommand {

    STATION_REGISTRATION("역 등록", "1"),
    STATION_DELETION("역 삭제", "2"),
    STATION_LIST("역 조회", "3"),
    BACK("돌아가기", "B");

    private static final String FIELD_DELIMITER = ". ";

    private final String text;
    private final String command;

    StationCommand(String text, String command) {
        this.text = text;
        this.command = command;
    }

    public String getText() {
        return text;
    }

    public String getCommand() {
        return command;
    }

    public static StationCommand from(String input) {
        return Stream.of(StationCommand.values())
                .filter(stationCommand -> stationCommand.command.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.toString()));
    }

    public static boolean isBack(StationCommand stationCommand) {
        return stationCommand.equals(StationCommand.BACK);
    }

    @Override
    public String toString() {
        return getCommand()
                + FIELD_DELIMITER
                + getText()
                + "\n";
    }


}
