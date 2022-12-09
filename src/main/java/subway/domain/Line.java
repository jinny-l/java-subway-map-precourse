package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getStationsName() {
        return stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }

}
