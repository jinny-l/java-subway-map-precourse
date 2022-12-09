package subway.domain;

import subway.constant.ErrorMessage;

public class Station {

    private static final int NAME_MIN_LENGTH = 2;

    private final String name;

    public Station(String name) {
        validateName(name);
        this.name = name;
    }

    public static int nameMinLength() {
        return NAME_MIN_LENGTH;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        validateDuplication(name);
        validateNameLength(name);
    }

    private void validateDuplication(String name) {
        if (StationRepository.contains(name)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_STATION_NAME.toString());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_STATION_NAME_LENGTH.toString());
        }
    }

}
