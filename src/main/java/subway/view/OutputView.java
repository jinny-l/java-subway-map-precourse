package subway.view;

import java.util.stream.Stream;
import subway.constant.command.MainCommand;
import subway.constant.command.StationCommand;

public class OutputView {

    private static final String OUTPUT_VIEW_PREFIX = "## ";
    private static final String INFORMATION_PREFIX = "[INFO] ";

    public static void printMainCommand() {
        StringBuilder stringBuilder = new StringBuilder();
        Stream.of(MainCommand.values())
                .forEach(mainCommand -> stringBuilder.append(mainCommand.toString()));
        System.out.printf("%s메인 화면%n%s%n", OUTPUT_VIEW_PREFIX, stringBuilder);
    }

    public static void printStationCommand() {
        StringBuilder stringBuilder = new StringBuilder();
        Stream.of(StationCommand.values())
                .forEach(stationCommand -> stringBuilder.append(stationCommand.toString()));
        System.out.printf("%s역 관리 화면%n%s%n", OUTPUT_VIEW_PREFIX, stringBuilder);
    }

    public static void printRegisteredInfo(String object) {
        System.out.printf("%s%s이 등록되었습니다.%n", INFORMATION_PREFIX, object);
    }

    public static void printDeletedInfo(String object) {
        System.out.printf("%s%s이 삭제되었습니다.%n", INFORMATION_PREFIX, object);
    }

}
