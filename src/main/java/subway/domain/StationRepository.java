package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.constant.ErrorMessage;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static boolean contains(String name) {
        return stations.stream()
                .anyMatch(station -> station.getName().equals(name));
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station findByName(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        ErrorMessage.UNABLE_TO_REGISTER_STATION_TO_LINE.toString()
                ));
    }

}
