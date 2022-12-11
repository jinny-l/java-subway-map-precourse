package subway.domain;

import subway.constant.ErrorMessage;

public class Station {

    private static final int NAME_MIN_LENGTH = 2;
    private static final char STATION_TEXT = '역';

    private final String name;

    public Station(String name) {
        validateName(name);
        this.name = name;
    }

    public static int nameMinLength() {
        return NAME_MIN_LENGTH;
    }

    public static char stationText() {
        return STATION_TEXT;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        validateDuplication(name);
        validateNameLength(name);
        validateText(name);
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

    private void validateText(String name) {
        if (name.charAt(name.length() - 1) != STATION_TEXT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_STATION_TEXT.toString());
        }
    }

}
