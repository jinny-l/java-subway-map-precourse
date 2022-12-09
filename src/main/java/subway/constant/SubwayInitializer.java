package subway.constant;

import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayInitializer {

    private static final List<Station> STATION_FACTORY = Arrays.asList(
            new Station("교대역"),
            new Station("강남역"),
            new Station("역삼역"),
            new Station("남부터미널역"),
            new Station("양재역"),
            new Station("매봉역"),
            new Station("양재시민의숲역")
    );

    private static final List<Line> LINE_FACTORY = Arrays.asList(
            new Line("2호선", new Station("교대역")),
            new Line("2호선", new Station("강남역")),
            new Line("2호선", new Station("역삼역")),
            new Line("3호선", new Station("교대역")),
            new Line("3호선", new Station("남부터미널역")),
            new Line("3호선", new Station ("양재역")),
            new Line("3호선", new Station("매봉역")),
            new Line("신분당선", new Station("강남역")),
            new Line("신분당선", new Station("양재역")),
            new Line("신분당선", new Station("양재시민의숲역"))
    );

    public static void setData() {
        setStationFactory();
        setLineFactory();
    }

    private static void setStationFactory() {
        STATION_FACTORY.forEach(StationRepository::addStation);
    }

    private static void setLineFactory() {
        LINE_FACTORY.forEach(LineRepository::addLine);
    }

}
