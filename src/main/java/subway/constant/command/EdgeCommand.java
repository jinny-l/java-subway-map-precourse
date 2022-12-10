package subway.constant.command;

import java.util.stream.Stream;
import subway.constant.ErrorMessage;

public enum EdgeCommand {

    EDGE_REGISTRATION("구간 등록", "1"),
    EDGE_DELETION("구간 삭제", "2"),
    BACK("돌아가기", "B");

    private static final String FIELD_DELIMITER = ". ";

    private final String text;
    private final String command;

    EdgeCommand(String text, String command) {
        this.text = text;
        this.command = command;
    }

    public String getText() {
        return text;
    }

    public String getCommand() {
        return command;
    }

    public static EdgeCommand from(String input) {
        return Stream.of(EdgeCommand.values())
                .filter(edgeCommand -> edgeCommand.command.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.toString()));
    }

    @Override
    public String toString() {
        return getCommand()
                + FIELD_DELIMITER
                + getText()
                + "\n";
    }

}
