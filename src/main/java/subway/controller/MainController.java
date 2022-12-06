package subway.controller;

import java.util.Scanner;
import subway.constant.command.MainCommand;
import subway.constant.command.StationManagementCommand;
import subway.domain.Service;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {

    private static final String BACK = StationManagementCommand.BACK.getCommand();

    private final InputView inputView;

    Service service;

    public MainController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void run() {
        initialize();
        String mainCommand = readMainCommand();
        if (mainCommand.equals(MainCommand.QUIT.getCommand())) {
            return;
        }
        executeCommand(mainCommand);
    }

    private void initialize() {
        service = new Service();
    }

    private String readMainCommand() {
        OutputView.printMain();
        try {
            return MainCommand.from(inputView.readCommand());
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            return readMainCommand();
        }
    }

    private void executeCommand(String mainCommand) {
        if (mainCommand.equals(MainCommand.STATION_MANAGEMENT.getCommand())) {
            manageStation();
            run();
        }

    }

    private void manageStation() {
        OutputView.printStationManagement();
        String command = readStationManagementCommand();
        if (command.equals(StationManagementCommand.BACK.getCommand())) {
            readMainCommand();
        }
        StationManagementController stationManagementController = new StationManagementController(inputView, command);
        stationManagementController.run();
    }

    private String readStationManagementCommand() {
        try {
            return StationManagementCommand.from(inputView.readCommand());
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            return readStationManagementCommand();
        }
    }

}
