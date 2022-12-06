package subway.view;

import subway.constant.command.MainCommand;
import subway.constant.command.StationManagementCommand;
import subway.domain.Station;
import subway.domain.StationRepository;

public class OutputView {

    private static final String OUTPUT_VIEW_PREFIX = "## ";
    private static final String INFORMATION_PREFIX = "[INFO] ";
    private static final String MAIN = OUTPUT_VIEW_PREFIX + "메인 화면%n%s%n";
    private static final String STATION_MANAGEMENT = OUTPUT_VIEW_PREFIX + "%s 화면%n%s%n";
    private static final String STATION_LIST = OUTPUT_VIEW_PREFIX + "%s 화면%n%s%n";

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printMain() {
        StringBuilder commandView = new StringBuilder();
        for (int i = 0; i < MainCommand.values().length; i++) {
            commandView.append(MainCommand.values()[i].toString());
        }
        System.out.printf(MAIN, commandView);
    }

    public static void printStationManagement() {
        StringBuilder StationManagementCommandView = new StringBuilder();
        for (int i = 0; i < StationManagementCommand.values().length; i++) {
            StationManagementCommandView.append(StationManagementCommand.values()[i].toString());
        }
        System.out.printf(STATION_MANAGEMENT, MainCommand.STATION_MANAGEMENT.getText(), StationManagementCommandView);
    }

    public static void printStations() {
        StationRepository.stations().stream()
                .map(Station::getName)
                .forEach(name -> System.out.println(INFORMATION_PREFIX + name));
        System.out.println();
    }

}
