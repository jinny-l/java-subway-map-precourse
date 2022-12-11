package subway.Service;

import subway.domain.Line;
import subway.domain.LineRepository;

public class LineService {

    public Line registerLine(String name) {
        return new Line(name);
    }

    public void registerStation(Line line, String station) {
        line.addStation(station);
    }

    public void addLineToRepository(Line line) {
        LineRepository.addLine(line);
    }

    public void deleteLine(String name) {
        LineRepository.deleteLineByName(name);
    }

}
