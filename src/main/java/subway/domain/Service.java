package subway.domain;

public class Service {

    public static void reset() {
        LineRepository.reset();
        StationRepository.reset();
        SubwayRepository.reset();
    }

    public static void addStation(String name) {
        Station station = new Station(name);
        StationRepository.addStation(station);
    }


}
