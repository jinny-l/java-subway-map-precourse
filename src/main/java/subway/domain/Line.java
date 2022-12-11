package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import subway.constant.ErrorMessage;

public class Line {

    private static final int LINE_MIN_LENGTH = 2;
    private static final char LINE_TEXT = '선';

    private final String name;
    private final List<Station> stations;

    public Line(String name) {
        validateName(name);
        this.name = name;
        stations = new ArrayList<>();
    }

    public static int nameMinLength() {
        return LINE_MIN_LENGTH;
    }

    public static char lineText() {
        return LINE_TEXT;
    }

    public void initStations(List<Station> stations) {
        this.stations.addAll(stations);
    }

    public void addStation(String name) {
        stations.add(StationRepository.findByName(name));
    }

    public void addStation(int index, Station station) {
        // TODO name, index 일치하는지 검증 / 이미 존재하는 역인지 검증
        stations.add(index, station);
    }

    public void deleteStation(Station station) {
        //TODO: 역이 2개 이하일 때 역을 제거하지 못하는 로직 구현 필요
        stations.remove(station);
    }

    public Station findStationOf(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public String getName() {
        return name;
    }

    public List<String> getStationsName() {
        return stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }

    private void validateName(String name) {
        validateLineDuplication(name);
        validateNameLength(name);
        validateText(name);
    }

    private void validateLineDuplication(String name) {
        if (LineRepository.containsLine(name)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LINE_NAME.toString());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < LINE_MIN_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LINE_NAME_LENGTH.toString());
        }
    }

    private void validateText(String name) {
        if (name.charAt(name.length()-1) != LINE_TEXT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LINE_TEXT.toString());
        }
    }

}
