package subway.constant.command;

import java.util.stream.Stream;
import subway.constant.ErrorMessage;

public enum LineCommand {

    LINE_REGISTRATION("노선 등록", "1"),
    LINE_DELETION("노선 삭제", "2"),
    LINE_LIST("노선 조회", "3"),
    BACK("돌아가기", "B");

    private static final String FIELD_DELIMITER = ". ";

    private final String text;
    private final String command;

    LineCommand(String text, String command) {
        this.text = text;
        this.command = command;
    }

    public String getText() {
        return text;
    }

    public String getCommand() {
        return command;
    }

    public static LineCommand from(String input) {
        return Stream.of(LineCommand.values())
                .filter(lineCommand -> lineCommand.command.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.toString()));
    }

    public static boolean isBack(LineCommand lineCommand) {
        return lineCommand.equals(LineCommand.BACK);
    }

    @Override
    public String toString() {
        return getCommand()
                + FIELD_DELIMITER
                + getText()
                + "\n";
    }

}
