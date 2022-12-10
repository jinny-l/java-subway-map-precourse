package subway.Service;

import subway.domain.Line;
import subway.domain.LineRepository;

public class LineService {

    public void registerLine(String name, String firstStation, String lastStation) {
        Line line = new Line(name);
        line.addStation(firstStation);
        line.addStation(lastStation);
        LineRepository.addLine(line);
    }

    public void deleteLine(String name) {
        LineRepository.deleteLineByName(name);
    }

}
