package subway.controller;

import java.util.Scanner;
import subway.Service.EdgeService;
import subway.constant.command.EdgeCommand;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class EdgeController {

    private static final String EDGE = "구간";

    private final InputView inputView;
    private final EdgeService edgeService;

    public EdgeController(Scanner scanner) {
        inputView = new InputView(scanner);
        edgeService = new EdgeService();
    }

    public void run() {
        OutputView.printEdgeCommand();
        EdgeCommand edgeCommand = readEdgeCommand();
        try {
            if (edgeCommand.equals(EdgeCommand.BACK)) {
                return;
            }
            if (edgeCommand.equals(EdgeCommand.EDGE_REGISTRATION)) {
                registerEdge();
            }
            if (edgeCommand.equals(EdgeCommand.EDGE_DELETION)) {
                deleteEdge();
            }
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            run();
        }
    }

    private EdgeCommand readEdgeCommand() {
        try {
            return EdgeCommand.from(inputView.readCommand());
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            return readEdgeCommand();
        }
    }

    private void registerEdge() {
        Line line = LineRepository.findLineOf(inputView.readObjectOfEdge("노선"));
        Station station = line.findStationOf(inputView.readObjectOfEdge("역"));
        int index = inputView.readIndexOfEdge() - 1;
        edgeService.registerEdge(line, index, station);
        OutputView.printRegisteredInfo(EDGE);
    }

    private void deleteEdge() {
        Line line = LineRepository.findLineOf(inputView.readObjectOfEdge("노선"));
        Station station = line.findStationOf(inputView.readObjectOfEdge("역"));
        edgeService.deleteEdge(line, station);
        OutputView.printDeletedInfo(EDGE);
    }

}
