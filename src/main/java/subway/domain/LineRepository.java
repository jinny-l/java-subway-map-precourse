package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static boolean containsStation(String name) {
        return lines.stream()
                .anyMatch(line -> line.getStationsName().contains(name));
    }

    public static boolean containsLine(String name) {
        return lines.stream()
                .anyMatch(line -> line.getName().equals(name));
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void deleteLineByName(String name) {
        lines.remove(findLineOf(name));
    }

    public static Line findLineOf(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

}
