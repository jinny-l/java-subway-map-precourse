package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name, Station station) {
        this.name = name;
        stations.add(station);
    }

    public String getName() {
        return name;
    }

}
