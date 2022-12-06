package subway.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubwayRepository {

    private static final Map<Line, List<Station>> subway = new HashMap<>();

    public static Map<Line, List<Station>> subway() {
        return Collections.unmodifiableMap(subway);
    }

    public static void addSubway(Subway subway) {

    }

//    public static boolean deleteSubway(String name) {
//
//    }

    public static void reset() {
        subway.clear();
    }


}
