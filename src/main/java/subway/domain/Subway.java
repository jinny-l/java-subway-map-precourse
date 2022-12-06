package subway.domain;

public class Subway {

    private final Line line;
    private final Station station;

    public Subway(String line, String station) {
        this.line = new Line(line);
        this.station = new Station(station);
    }

}
