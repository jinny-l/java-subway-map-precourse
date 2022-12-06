package subway.constant.command;

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
        if (!input.equals(STATION_MANAGEMENT.command) && !input.equals(LINE_MANAGEMENT.command)
                && !input.equals(EDGE_MANAGEMENT.command) && !input.equals(VIEW_SUBWAY_MAP.command)
                && !input.equals(QUIT.command)) {
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
