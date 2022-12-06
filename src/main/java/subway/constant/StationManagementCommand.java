package subway.constant;

public enum StationManagementCommand {

    STATION_REGISTRATION("역 등록", "1"),
    STATION_DELETION("역 삭제", "2"),
    VIEW_STATION("역 조회", "3"),
    BACK("돌아가기", "Q");

    private static final String FIELD_DELIMITER = ". ";

    private final String text;
    private final String command;

    StationManagementCommand(String text, String command) {
        this.text = text;
        this.command = command;
    }

    public String getText() {
        return text;
    }

    public String getCommand() {
        return command;
    }

    public static String from(String input) {
        validate(input);
        return input;
    }

    public static void validate(String input) {
        if (!input.equals(STATION_REGISTRATION.command) && !input.equals(STATION_DELETION.command)
                && !input.equals(VIEW_STATION.command) && !input.equals(BACK.command)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return getCommand()
                + FIELD_DELIMITER
                + getText()
                + "\n";
    }

}
