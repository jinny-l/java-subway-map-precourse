package subway.view;

import java.util.stream.Stream;
import subway.constant.command.MainCommand;

public class OutputView {

    private static final String OUTPUT_VIEW_PREFIX = "## ";

    public static void printMain() {
        StringBuilder mainView = new StringBuilder();
        Stream.of(MainCommand.values())
                .forEach(mainCommand -> mainView.append(mainCommand.toString()));
        System.out.printf("%s메인 화면%n%s%n", OUTPUT_VIEW_PREFIX, mainView);
    }

}
