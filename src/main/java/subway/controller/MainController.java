package subway.controller;

import java.util.Scanner;
import subway.constant.SubwayInitializer;
import subway.constant.command.MainCommand;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {

    private final InputView inputView;

    private final StationController stationController;
    private final LineController lineController;
    private final EdgeController edgeController;

    public MainController(Scanner scanner) {
        SubwayInitializer.setData();
        inputView = new InputView(scanner);
        stationController = new StationController(scanner);
        lineController = new LineController(scanner);
        edgeController = new EdgeController(scanner);
    }

    public void run() {
        OutputView.printMainCommand();
        MainCommand mainCommand = readMainCommand();
        if (mainCommand.equals(MainCommand.QUIT)) {
            return;
        }
        if (mainCommand.equals(MainCommand.STATION_MANAGEMENT)) {
            stationController.run();
        }
        if (mainCommand.equals(MainCommand.LINE_MANAGEMENT)) {
            lineController.run();
        }
        if (mainCommand.equals(MainCommand.EDGE_MANAGEMENT)) {
            edgeController.run();
        }
        if (mainCommand.equals(MainCommand.VIEW_SUBWAY_MAP)) {
            OutputView.printMap();
        }
        run();
    }

    private MainCommand readMainCommand() {
        try {
            return MainCommand.from(inputView.readCommand());
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            return readMainCommand();
        }
    }

}
