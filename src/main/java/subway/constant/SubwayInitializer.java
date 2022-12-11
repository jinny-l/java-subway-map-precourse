package subway.constant;

import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

// TODO: 좀 더 스마트한 초기 세팅 방법이 있을지?
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

    private static final List<String> LINE_FACTORY = Arrays.asList("2호선", "3호선", "신분당선");

    private static final List<Station> LINE_TWO = Arrays.asList(
            new Station("교대역"),
            new Station("강남역"),
            new Station("역삼역")
    );

    private static final List<Station> LINE_THREE = Arrays.asList(
            new Station("교대역"),
            new Station("남부터미널역"),
            new Station("양재역"),
            new Station("매봉역")
    );
    private static final List<Station> SIN_BUN_DANG = Arrays.asList(
            new Station("강남역"),
            new Station("양재역"),
            new Station("양재시민의숲역")
    );

    public static void setData() {
        setStationFactory();
        setLineFactory();
    }

    private static void setStationFactory() {
        STATION_FACTORY.forEach(StationRepository::addStation);
    }

    private static void setLineFactory() {
        Line line2 = new Line(LINE_FACTORY.get(0));
        line2.initStations(LINE_TWO);
        Line line3 = new Line(LINE_FACTORY.get(1));
        line3.initStations(LINE_THREE);
        Line sinBunDang = new Line(LINE_FACTORY.get(2));
        sinBunDang.initStations(SIN_BUN_DANG);
        LineRepository.addLine(line2);
        LineRepository.addLine(line3);
        LineRepository.addLine(sinBunDang);
    }

}
