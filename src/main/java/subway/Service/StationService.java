package subway.Service;

import subway.constant.ErrorMessage;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    public void registerStation(String input) {
        Station station = new Station(input);
        StationRepository.addStation(station);
    }

    public void deleteStation(String input) {
        if (LineRepository.containStation(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_STATION_DELETION.toString());
        }
        StationRepository.deleteStation(input);
    }

}
