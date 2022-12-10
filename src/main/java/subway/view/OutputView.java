package subway.view;

import java.util.List;
import java.util.stream.Stream;
import subway.constant.command.EdgeCommand;
import subway.constant.command.LineCommand;
import subway.constant.command.MainCommand;
import subway.constant.command.StationCommand;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class OutputView {

    private static final String OUTPUT_VIEW_PREFIX = "## ";
    private static final String INFORMATION_PREFIX = "[INFO] ";

    public static void printError(String message) {
        System.out.println();
        System.out.println(message);
    }

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
        System.out.printf("%n%s역 관리 화면%n%s%n", OUTPUT_VIEW_PREFIX, stringBuilder);
    }

    public static void printLineCommand() {
        StringBuilder stringBuilder = new StringBuilder();
        Stream.of(LineCommand.values())
                .forEach(lineCommand -> stringBuilder.append(lineCommand.toString()));
        System.out.printf("%n%s노선 관리 화면%n%s%n", OUTPUT_VIEW_PREFIX, stringBuilder);
    }

    public static void printEdgeCommand() {
        StringBuilder stringBuilder = new StringBuilder();
        Stream.of(EdgeCommand.values())
                .forEach(edgeCommand -> stringBuilder.append(edgeCommand.toString()));
        System.out.printf("%n%s구간 관리 화면%n%s%n", OUTPUT_VIEW_PREFIX, stringBuilder);
    }

    public static void printRegisteredInfo(String object) {
        System.out.printf("%n%s지하철 %s이 등록되었습니다.%n%n", INFORMATION_PREFIX, object);
    }

    public static void printDeletedInfo(String object) {
        System.out.printf("%n%s지하철 %s이 삭제되었습니다.%n%n", INFORMATION_PREFIX, object);
    }

    public static void printStations() {
        System.out.printf("%n%s역 목록%n", OUTPUT_VIEW_PREFIX);
        StationRepository.stations().stream()
                .map(Station::getName)
                .forEach(name -> System.out.println(INFORMATION_PREFIX + name));
        System.out.println();
    }

    public static void printLines() {
        System.out.printf("%n%s노선 목록%n", OUTPUT_VIEW_PREFIX);
        LineRepository.lines().stream()
                .map(Line::getName)
                .forEach(name -> System.out.println(INFORMATION_PREFIX + name));
        System.out.println();
    }

    public static void printMap() {
        System.out.printf("%n%s지하철 노선도%n", OUTPUT_VIEW_PREFIX);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            List<String> stations = line.getStationsName();
            System.out.println(INFORMATION_PREFIX + line.getName());
            System.out.println(INFORMATION_PREFIX + "---");
            for (String station : stations) {
                System.out.println(INFORMATION_PREFIX + station);
            }
            System.out.println();
        }
    }

}
