package subway.controller;

import java.util.Scanner;
import subway.Service.StationService;
import subway.constant.command.StationCommand;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {

    private static final String STATION = "역";

    private final InputView inputView;
    private final StationService stationService;

    public StationController(Scanner scanner) {
        inputView = new InputView(scanner);
        stationService = new StationService();
    }

    public void run() {
        OutputView.printStationCommand();
        StationCommand stationCommand = readStationCommand();
        try {
            if (stationCommand.equals(StationCommand.BACK)) {
                return;
            }
            if (stationCommand.equals(StationCommand.STATION_REGISTRATION)) {
                registerStation();
            }
            if (stationCommand.equals(StationCommand.STATION_DELETION)) {
                deleteStation();
            }
            if (stationCommand.equals(StationCommand.STATION_LIST)) {
                OutputView.printStations();
            }
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            run();
        }
    }

    private StationCommand readStationCommand() {
        try {
            return StationCommand.from(inputView.readCommand());
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            return readStationCommand();
        }
    }

    private void registerStation() {
        stationService.registerStation(inputView.readObjectToRegister(STATION));
        OutputView.printRegisteredInfo(STATION);
    }

    private void deleteStation() {
        stationService.deleteStation(inputView.readObjectToDelete(STATION));
        OutputView.printDeletedInfo(STATION);
    }

}
