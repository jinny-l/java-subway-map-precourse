package subway.controller;

import subway.constant.command.StationManagementCommand;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationManagementController {

    private static final String STATION_REGISTER = StationManagementCommand.STATION_REGISTRATION.getCommand();
    private static final String STATION_DELETION = StationManagementCommand.STATION_DELETION.getCommand();
    private static final String VIEW_STATION = StationManagementCommand.VIEW_STATION.getCommand();

    private final InputView inputView;
    private final String command;

    public StationManagementController(InputView inputView, String command) {
        this.inputView = inputView;
        this.command = command;
    }

    public void run() {
        if (command.equals(STATION_REGISTER)) {
            registerStation();
        }
        if (command.equals(STATION_DELETION)) {
            deleteStation();
        }
        if (command.equals(VIEW_STATION)) {
            printStations();
        }
    }

    private void registerStation() {
        try {
            Station station = new Station(inputView.readStationToRegister());
            StationRepository.addStation(station);
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            registerStation();
        }
    }

    private void deleteStation() {
        try {
            StationRepository.deleteStation(inputView.readStationToDelete());
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            deleteStation();
        }
    }

    private static void printStations() {
        OutputView.printStations();
    }

}
