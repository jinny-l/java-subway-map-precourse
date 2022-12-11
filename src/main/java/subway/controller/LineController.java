package subway.controller;

import java.util.Scanner;
import subway.Service.LineService;
import subway.constant.command.LineCommand;
import subway.domain.Line;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {

    private static final String LINE = "노선";

    private final InputView inputView;
    private final LineService lineService;

    public LineController(Scanner scanner) {
        inputView = new InputView(scanner);
        lineService = new LineService();
    }

    public void run() {
        OutputView.printLineCommand();
        LineCommand lineCommand = readLineCommand();
        try {
            if (lineCommand.equals(LineCommand.BACK)) {
                return;
            }
            if (lineCommand.equals(LineCommand.LINE_REGISTRATION)) {
                registerLine();
            }
            if (lineCommand.equals(LineCommand.LINE_DELETION)) {
                deleteLine();
            }
            if (lineCommand.equals(LineCommand.LINE_LIST)) {
                OutputView.printLines();
            }
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            run();
        }
    }

    private LineCommand readLineCommand() {
        try {
            return LineCommand.from(inputView.readCommand());
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            return readLineCommand();
        }
    }

    private void registerLine() {
        Line line = lineService.registerLine(inputView.readObjectToRegister(LINE));
        lineService.registerStation(line, inputView.readStationToRegisterLine("상행"));
        lineService.registerStation(line, inputView.readStationToRegisterLine("하행"));
        lineService.addLineToRepository(line);
        OutputView.printRegisteredInfo(LINE);
    }

    private void deleteLine() {
        lineService.deleteLine(inputView.readObjectToDelete(LINE));
        OutputView.printDeletedInfo(LINE);
    }

}
