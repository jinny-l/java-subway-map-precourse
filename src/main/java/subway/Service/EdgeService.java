package subway.Service;

import subway.domain.Line;
import subway.domain.Station;

public class EdgeService {

    public void registerEdge(Line line, int index, Station station) {
        line.addStation(index, station);
    }

    public void deleteEdge(Line line, Station station) {
        line.deleteStation(station);
    }

}
