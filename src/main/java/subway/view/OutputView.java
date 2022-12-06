package subway.view;

import subway.constant.MainCommand;

public class OutputView {

    private static final String OUTPUT_VIEW_PREFIX = "## ";
    private static final String MAIN = OUTPUT_VIEW_PREFIX + "메인 화면%n%s%n";

    public static void printMain() {
        StringBuilder commandView = new StringBuilder();
        for (int i = 0; i < MainCommand.values().length; i++) {
            commandView.append(MainCommand.values()[i].toString());
        }
        System.out.printf(MAIN, commandView);
    }

}
