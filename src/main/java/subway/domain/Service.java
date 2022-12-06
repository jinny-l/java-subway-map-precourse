package subway.domain;

import subway.constant.SubwayInitializer;

public class Service {

    public Service() {
        reset();
        SubwayInitializer.setData();
    }

    public void reset() {
        LineRepository.reset();
        StationRepository.reset();
        SubwayRepository.reset();
    }

}
