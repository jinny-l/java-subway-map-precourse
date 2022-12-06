package subway.domain;

public class Station {

    private final String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void validate(String name) {
        if (StationRepository.contains(name)) {
            throw new IllegalArgumentException();
        }
    }

}
