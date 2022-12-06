package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public static void deleteStation(String name) {
        if (!contains(name)) {
            throw new IllegalArgumentException();
        }
        stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void reset() {
        stations.clear();
    }
}
